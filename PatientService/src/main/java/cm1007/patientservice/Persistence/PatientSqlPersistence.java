package cm1007.patientservice.Persistence;

import cm1007.patientservice.Core.Interfaces.Persistence.IConditionPersistence;
import cm1007.patientservice.Core.Interfaces.Persistence.IEncounterPersistence;
import cm1007.patientservice.Core.Interfaces.Persistence.IObservationPersistence;
import cm1007.patientservice.Core.Interfaces.Persistence.IPatientPersistence;
import cm1007.patientservice.Core.Models.*;
import cm1007.patientservice.Persistence.Repositories.*;
import cm1007.patientservice.Persistence.Tables.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientSqlPersistence implements IPatientPersistence, IConditionPersistence, IEncounterPersistence, IObservationPersistence {

    @Autowired
    private PatientRepository _patientRepository;
    @Autowired
    private NoteRepository _noteRepository;
    @Autowired
    private ConditionRepository _conditionRepository;
    @Autowired
    private EncounterRepository _encounterRepository;
    @Autowired
    private ObservationRepository _observationRepository;


    //PATIENT
    //----------------------
    @Override
    public List<Patient> getAll() {
        List<Patient> result = new ArrayList<>();
        for (Patient_T p : _patientRepository.findAll()) {
            ArrayList<Note> notes = new ArrayList<>();
            for(Note_T n : p.getNotes()){
                notes.add(new Note(n.getNote()));
            }
            Patient patient = new Patient(p.getId(), p.getFullName());
            patient.setNotes(notes);
            result.add(patient);
        }
        return result;
    }

    //Fat eager load
    public Patient get(Long patient_id){
        Patient_T patient = _patientRepository.findPatientEager(patient_id);
        if(patient != null) {
            Patient p = new Patient(patient.getId(), patient.getFullName());
            for(Encounter_T e : patient.getEncounters()){
                Encounter newEncounter = new Encounter(e.getId(), e.getPatient().getId(), e.getEncounterDate());
                for(Observation_T o : e.getObservations()){
                    Observation newObservation = new Observation(o.getId(), e.getId(), o.getObservationDetails());
                    newEncounter.getObservations().add(newObservation);
                }
                p.encounters.add(newEncounter);
            }

            for(Condition_T c : patient.getConditions()){
                Condition newCondition = new Condition(c.getId(), c.getPatient().getId(), c.getConditionType());
                p.conditions.add(newCondition);
            }

            for(Note_T t : patient.getNotes()){
                Note newNote = new Note(t.getNote());
                p.notes.add(newNote);
            }

            return p;
        }
        return null;
    }

    @Transactional
    @Override
    public boolean addNote(Long patientId, String note) {
        if(patientId == null || note == null)
            return false;
        Optional<Patient_T> patient = _patientRepository.findById(patientId);
        if(patient.isPresent()) {
            Note_T newNote = new Note_T(note, patient.get());
            patient.get().getNotes().add(newNote);
            _noteRepository.save(newNote);
            _patientRepository.save(patient.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean addPatient(Patient patient) {
        if(patient != null) {
            Patient_T p = new Patient_T(patient.id, patient.fullName);
            _patientRepository.save(p);
            return true;
        }
        return false;
    }

    //------------------


    //CONDITION
    //----------------------
    @Transactional
    @Override
    public boolean addCondition(Condition condition) {
        if(condition != null) {
            Optional<Patient_T> patient = _patientRepository.findById(condition.getPatientId());
            if(patient.isPresent()) {
                Condition_T c = new Condition_T(patient.get(), condition.getConditionType());
                _conditionRepository.save(c);
                return true;
            }
        }
        return false;
    }
    //----------------------


    //ENCOUNTER
    //----------------------
    @Override
    public List<Encounter> getAllEncounters() {
        List<Encounter> result = new ArrayList<>();
        for (Encounter_T encounter : _encounterRepository.findAll()) {
            Encounter newEncounter = new Encounter(encounter.getId(), encounter.getPatient().getId(), encounter.getEncounterDate());
            result.add(newEncounter);
        }
        return result;
    }
    //Not yet implemented
    @Override
    public Encounter getEncounter(long encounterId) {
        return null;
    }
    @Transactional
    @Override
    public boolean addEncounter(Encounter encounter) {
        if(encounter != null) {
            Optional<Patient_T> patient = _patientRepository.findById(encounter.getPatientId());
            if(patient.isPresent()) {
                Encounter_T e = new Encounter_T(patient.get(), encounter.getEncounterDate());
                _encounterRepository.save(e);
                return true;
            }
        }
        return false;
    }
    //----------------------


    //OBSERVATION
    //----------------------
    @Override
    public boolean addObservation(Observation observation) {
        if(observation != null) {
            Optional<Encounter_T> encounter = _encounterRepository.findById(observation.getEncounterId());
            if(encounter.isPresent()) {
                Observation_T o = new Observation_T(encounter.get(), observation.getObservationDetails());
                _observationRepository.save(o);
                return true;
            }
        }
        return false;
    }
    //----------------------
}

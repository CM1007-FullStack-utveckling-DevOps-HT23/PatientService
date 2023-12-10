package cm1007.patientservice.Controllers;

import cm1007.patientservice.Core.Interfaces.*;
import cm1007.patientservice.Core.Models.*;
import cm1007.patientservice.ViewModels.*;
import cm1007.patientservice.ViewModels.Condition.*;
import cm1007.patientservice.ViewModels.Notes.*;
import cm1007.patientservice.ViewModels.Encounter.*;
import cm1007.patientservice.ViewModels.Observation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private IPatientService _patientService;
    @Autowired
    private IConditionService _conditionService;
    @Autowired
    private IEncounterService _encounterService;
    @Autowired
    private IObservationService _observationService;

    //PATIENT
    //----------------------
    @GetMapping("/list")
    public ResponseEntity<List<PatientVM>> getAllPatients(){
        List<Patient> patients = _patientService.getAll();
        if(patients == null)
            return ResponseEntity.notFound().build();

        List<PatientVM> patientVMs = new ArrayList<>();
        for(Patient p : patients) {
            ArrayList<NoteVM> notes = new ArrayList<>();
            for (Note note : p.notes) {
                notes.add(new NoteVM(note.getNote()));
            }
            patientVMs.add(new PatientVM(p.getId(), p.getFullName()));

        }
        return ResponseEntity.ok(patientVMs);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<PatientDetailsVM> getPatient(@PathVariable Long patientId){
        Patient patient = _patientService.get(patientId);
        if(patient != null) {
            return ResponseEntity.ok(patientDetailsVMMapper(patient));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addNote/{patientId}")
    public ResponseEntity<String> addNote(@PathVariable Long patientId, @Valid @RequestBody CreateNoteVM note){
        if(_patientService.addNote(patientId, note.getNote()))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }


    @PostMapping("/add")
    public ResponseEntity<String> createPatient(@Valid @RequestBody PatientCreateVM patientVM) {
        Patient p = new Patient(patientVM.id, patientVM.fullName);
        boolean isPatientCreated = _patientService.addPatient(p);

        if (isPatientCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created for successful creation
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error for failure
        }
    }

    private PatientDetailsVM patientDetailsVMMapper(Patient patient){
        PatientDetailsVM result = new PatientDetailsVM(patient.id, patient.fullName);

        //Add encounters and observations
        for(Encounter e : patient.encounters){
            EncounterDetailsVM encounterVM = new EncounterDetailsVM(e.getId(), e.getPatientId(), e.getEncounterDate());
            for(Observation o : e.getObservations()){
                ObservationVM observationVM = new ObservationVM(o.getId(), o.getEncounterId(), o.getObservationDetails());
                encounterVM.getObservations().add(observationVM);
            }
            result.encounters.add(encounterVM);
        }

        //Add conditions
        for(Condition c : patient.conditions){
            ConditionVM conditionVM = new ConditionVM(c.getId(), c.getPatientId(), c.getConditionType());
            result.conditions.add(conditionVM);
        }

        for(Note n : patient.getNotes()){
            NoteVM newNoteVM = new NoteVM(n.getNote());
            result.notes.add(newNoteVM);
        }

        return result;
    }

    //----------------------


    // CONDITION
    //----------------------
    @PostMapping("/condition/add")
    public ResponseEntity<String> addCondition(@Valid @RequestBody ConditionCreateVM conditionVM) {
        Condition c = new Condition(conditionVM.patientId, conditionVM.conditionType);
        boolean isConditionCreated = _conditionService.addCondition(c);
        if (isConditionCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created for successful creation
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error for failure
        }
    }
    //----------------------


    // ENCOUNTER
    //----------------------
    @GetMapping("/encounter/list")
    public ResponseEntity<List<EncounterVM>> getAllEncounter(){
        List<Encounter> encounters = _encounterService.getAllEncounters();
        if(encounters == null)
            return ResponseEntity.notFound().build();
        List<EncounterVM> encounterVMS = new ArrayList<>();
        for(Encounter e : encounters){
            encounterVMS.add(new EncounterVM(e.getId(), e.getPatientId(), e.getEncounterDate()));
        }
        return ResponseEntity.ok(encounterVMS);
    }
    @PostMapping("/encounter/add")
    public ResponseEntity<String> addEncounter(@Valid @RequestBody EncounterCreateVM encounterVM) {
        Encounter e = new Encounter(encounterVM.patientId, LocalDateTime.now(), encounterVM.doctorId);
        boolean isEncounterCreated = _encounterService.addEncounter(e);
        if (isEncounterCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created for successful creation
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error for failure
        }
    }
    //----------------------


    //OBSERVATION
    //----------------------
    @PostMapping("/observation/add")
    public ResponseEntity<String> addObservation(@Valid @RequestBody ObservationCreateVM observationVM) {
        Observation o = new Observation(observationVM.getEncounterId(), observationVM.getObservationDetails());
        boolean isObservationCreated = _observationService.addObservation(o);
        if (isObservationCreated) {
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created for successful creation
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500 Internal Server Error for failure
        }
    }
    //----------------------
}

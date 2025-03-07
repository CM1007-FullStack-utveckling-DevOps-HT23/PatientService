package cm1007.patientservice.Core.Services;

import cm1007.patientservice.Core.Interfaces.IPatientService;
import cm1007.patientservice.Core.Interfaces.Persistence.IPatientPersistence;
import cm1007.patientservice.Core.Models.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements IPatientService {

    @Autowired
    private IPatientPersistence _patientPersistence;

    @Override
    public List<Patient> getAll() {
        return _patientPersistence.getAll();
    }

    @Override
    public Patient get(String patient_id) {
        return _patientPersistence.get(patient_id);
    }

    @Override
    public boolean addNote(String patientId, String note) {
        return _patientPersistence.addNote(patientId, note);
    }

    @Override
    public boolean addPatient(Patient patient) {
        return _patientPersistence.addPatient(patient);
    }
}

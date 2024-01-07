package cm1007.patientservice.Core.Interfaces;

import cm1007.patientservice.Core.Models.Patient;

import java.util.List;

public interface IPatientService {
    List<Patient> getAll();
    Patient get(String patient_id);
    boolean addNote(String patientId, String note);
    boolean addPatient(Patient patient);
}

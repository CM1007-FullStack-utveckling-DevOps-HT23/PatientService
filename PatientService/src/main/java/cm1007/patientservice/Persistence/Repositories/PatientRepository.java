package cm1007.patientservice.Persistence.Repositories;

import cm1007.patientservice.Persistence.Tables.Patient_T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient_T, Long> {
    @Query("SELECT p FROM Patient_T p LEFT JOIN p.encounters e LEFT JOIN p.conditions c WHERE p.id = :patient_id")
    Patient_T findPatientEager(@Param("patient_id") long patient_id);
}
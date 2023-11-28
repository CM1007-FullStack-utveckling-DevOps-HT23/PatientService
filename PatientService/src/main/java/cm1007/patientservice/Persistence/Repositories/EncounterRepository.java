package cm1007.patientservice.Persistence.Repositories;

import cm1007.patientservice.Persistence.Tables.Encounter_T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EncounterRepository extends JpaRepository<Encounter_T, Long> {
}

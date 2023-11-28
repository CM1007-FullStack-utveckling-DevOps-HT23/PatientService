package cm1007.patientservice.Persistence.Repositories;

import cm1007.patientservice.Persistence.Tables.Observation_T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObservationRepository extends JpaRepository<Observation_T, Long> {
}

package cm1007.patientservice.Persistence.Repositories;

import cm1007.patientservice.Persistence.Tables.Condition_T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionRepository extends JpaRepository<Condition_T, Long> {
}

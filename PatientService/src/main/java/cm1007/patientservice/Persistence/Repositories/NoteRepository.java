package cm1007.patientservice.Persistence.Repositories;

import cm1007.patientservice.Persistence.Tables.Note_T;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note_T, Long> {
}

package cm1007.patientservice.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "note_t")
public class Note_T {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String note;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private Patient_T patient;

    public Note_T() {
    }

    public Note_T(String note) {
        this.note = note;
    }

    public Note_T(String note, Patient_T patient) {
        this.note = note;
        this.patient = patient;
    }
}

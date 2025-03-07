package cm1007.patientservice.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "condition_t")
public class Condition_T {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "patient_id") // Foreign key referencing Encounter table
    @Getter @Setter
    private Patient_T patient;

    @Column(name = "condition_type")
    @Getter @Setter
    private String conditionType;

    public Condition_T() {
    }

    public Condition_T(Patient_T patient, String conditionType) {
        this.patient = patient;
        this.conditionType = conditionType;
    }
}

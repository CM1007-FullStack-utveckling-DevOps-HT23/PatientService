package cm1007.patientservice.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "encounter_t")
public class Encounter_T {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Column(name = "doctor_id")
    @Getter @Setter
    private String doctorId;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private Patient_T patient;

    @OneToMany(mappedBy = "encounter", cascade = CascadeType.ALL)
    @Getter @Setter
    private List<Observation_T> observations = new ArrayList<>();

    @Column(name = "encounter_date")
    @Getter @Setter
    private LocalDateTime encounterDate;

    public Encounter_T() {
    }

    public Encounter_T(Patient_T patient, LocalDateTime encounterDate, String doctorId) {
        this.patient = patient;
        this.encounterDate = encounterDate;
        this.doctorId = doctorId;
    }
}

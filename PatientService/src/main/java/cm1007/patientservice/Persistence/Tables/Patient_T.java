package cm1007.patientservice.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient_T {
    @Id
    @Getter @Setter
    private long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private User_T user;

    @Getter @Setter
    @Column(name = "full_name")
    private String fullName;

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Note_T> notes = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Encounter_T> encounters = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "patient_id")
    @Getter @Setter
    private List<Condition_T> conditions = new ArrayList<>();

    public Patient_T() {
    }

    public Patient_T(User_T user, String fullName) {
        this.user = user;
        this.fullName = fullName;
    }
}

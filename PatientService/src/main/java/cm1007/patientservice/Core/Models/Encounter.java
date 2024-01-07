package cm1007.patientservice.Core.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import cm1007.patientservice.Persistence.Tables.Patient_T;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Encounter {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String patientId;

    @Getter @Setter
    private String doctorId;

    @Getter @Setter
    private LocalDateTime encounterDate;

    @Getter @Setter
    private List<Observation> observations = new ArrayList<>();

    @Getter @Setter
    private Patient patient;

    public Encounter() {
    }

    //Eager load
    public Encounter(Long id, String patientId, LocalDateTime encounterDate, List<Observation> observations) {
        this.id = id;
        this.patientId = patientId;
        this.encounterDate = encounterDate;
        this.observations = observations;
    }

    //Lazy load
    public Encounter(Long id, String patientId, LocalDateTime encounterDate) {
        this.id = id;
        this.patientId = patientId;
        this.encounterDate = encounterDate;
    }

    //Create encounter
    public Encounter(String patientId, LocalDateTime encounterDate, String doctorId) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.encounterDate = encounterDate;
    }


}

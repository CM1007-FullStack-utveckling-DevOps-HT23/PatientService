package cm1007.patientservice.Core.Models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Condition {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private String patientId;

    @Getter @Setter
    private String conditionType;

    @Getter @Setter
    private Patient patient;

    public Condition() {
    }

    //Lazy loading
    public Condition(Long id, String patientId, String conditionType) {
        this.id = id;
        this.patientId = patientId;
        this.conditionType = conditionType;
    }

    //For creating
    public Condition(String patientId, String conditionType) {
        this.patientId = patientId;
        this.conditionType = conditionType;
    }
}

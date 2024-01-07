package cm1007.patientservice.ViewModels.Condition;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ConditionVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    String patientId;

    @Getter @Setter
    String conditionType;

    public ConditionVM(Long id, String patientId, String conditionType) {
        this.id = id;
        this.patientId = patientId;
        this.conditionType = conditionType;
    }
}

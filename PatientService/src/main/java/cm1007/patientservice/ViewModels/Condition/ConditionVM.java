package cm1007.patientservice.ViewModels.Condition;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class ConditionVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    Long patientId;

    @Getter @Setter
    String conditionType;

    public ConditionVM(Long id, Long patientId, String conditionType) {
        this.id = id;
        this.patientId = patientId;
        this.conditionType = conditionType;
    }
}

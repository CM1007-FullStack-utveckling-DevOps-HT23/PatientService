package cm1007.patientservice.ViewModels.Condition;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ConditionCreateVM {
    @NotNull(message = "patientId cannot be null")
    @Getter @Setter
    public Long patientId;

    @NotEmpty(message = "conditionType is required")
    @NotNull(message = "conditionType cannot be null")
    @Getter @Setter
    public String conditionType;
}

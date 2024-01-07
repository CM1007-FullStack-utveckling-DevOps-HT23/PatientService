package cm1007.patientservice.ViewModels;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class PatientCreateVM {
    @NotEmpty(message = "id is required")
    @NotNull(message = "id cannot be null")
    @Getter @Setter
    public String id;

    @NotEmpty(message = "Full name is required")
    @NotNull(message = "Full name cannot be null")
    @Getter @Setter
    public String fullName;
}

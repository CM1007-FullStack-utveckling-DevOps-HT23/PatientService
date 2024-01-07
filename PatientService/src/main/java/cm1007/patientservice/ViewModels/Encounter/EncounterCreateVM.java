package cm1007.patientservice.ViewModels.Encounter;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class EncounterCreateVM {
    @NotNull(message = "patientId cannot be null")
    @NotEmpty(message = "patientId is required")
    @Getter @Setter
    public String patientId;

    @NotNull(message = "doctorId cannot be null")
    @NotEmpty(message = "doctorId is required")
    @Getter @Setter
    public String doctorId;

    public EncounterCreateVM() {
    }
}
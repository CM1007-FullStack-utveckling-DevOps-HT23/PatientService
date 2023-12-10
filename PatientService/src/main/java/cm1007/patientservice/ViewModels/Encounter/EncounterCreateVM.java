package cm1007.patientservice.ViewModels.Encounter;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class EncounterCreateVM {
    @NotNull(message = "patientId cannot be null")
    @Getter @Setter
    public Long patientId;

    @NotNull(message = "doctorId cannot be null")
    @Getter @Setter
    public Long doctorId;

    public EncounterCreateVM() {
    }
}
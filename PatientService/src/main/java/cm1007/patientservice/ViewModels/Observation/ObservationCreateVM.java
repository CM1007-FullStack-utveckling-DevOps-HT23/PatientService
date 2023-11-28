package cm1007.patientservice.ViewModels.Observation;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ObservationCreateVM {
    @NotNull(message = "encounterId cannot be null")
    @Getter @Setter
    Long encounterId;

    @NotEmpty(message = "observationDetails cannot be empty")
    @NotNull(message = "observationDetails cannot be null")
    @Getter @Setter
    String observationDetails;
}

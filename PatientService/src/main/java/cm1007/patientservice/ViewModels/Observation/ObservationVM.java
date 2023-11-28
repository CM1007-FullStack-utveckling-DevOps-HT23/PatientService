package cm1007.patientservice.ViewModels.Observation;

import lombok.Getter;
import lombok.Setter;

public class ObservationVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    Long encounterId;

    @Getter @Setter
    String observationDetails;

    public ObservationVM(Long id, Long encounterId, String observationDetails) {
        this.id = id;
        this.encounterId = encounterId;
        this.observationDetails = observationDetails;
    }
}

package cm1007.patientservice.Core.Models;

import lombok.Getter;
import lombok.Setter;

public class Observation {
    @Getter @Setter
    private Long id;

    @Getter @Setter
    private Long encounterId;

    @Getter @Setter
    private String observationDetails;

    @Getter @Setter
    private Encounter encounter;

    public Observation(Long id, Long encounterId, String observationDetails) {
        this.id = id;
        this.encounterId = encounterId;
        this.observationDetails = observationDetails;
    }

    //Create observation
    public Observation(Long encounterId, String observationDetails) {
        this.encounterId = encounterId;
        this.observationDetails = observationDetails;
    }
}

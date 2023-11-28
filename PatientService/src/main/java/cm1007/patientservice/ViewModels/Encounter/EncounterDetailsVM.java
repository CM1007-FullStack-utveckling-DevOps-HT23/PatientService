package cm1007.patientservice.ViewModels.Encounter;

import cm1007.patientservice.ViewModels.Observation.ObservationVM;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EncounterDetailsVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    Long patientId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    LocalDateTime encounterDate;

    @Getter @Setter
    List<ObservationVM> observations = new ArrayList<>();

    public EncounterDetailsVM(Long id, Long patientId, LocalDateTime encounterDate) {
        this.id = id;
        this.patientId = patientId;
        this.encounterDate = encounterDate;
    }
}

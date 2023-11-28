package cm1007.patientservice.ViewModels.Encounter;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

public class EncounterVM {
    @Getter @Setter
    Long id;

    @Getter @Setter
    Long patientId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Getter @Setter
    LocalDateTime encounterDate;

    public EncounterVM(Long id, Long patientId, LocalDateTime encounterDate) {
        this.id = id;
        this.patientId = patientId;
        this.encounterDate = encounterDate;
    }
}

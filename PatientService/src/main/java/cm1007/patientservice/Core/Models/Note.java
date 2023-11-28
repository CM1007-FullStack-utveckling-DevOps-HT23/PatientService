package cm1007.patientservice.Core.Models;

import lombok.Getter;
import lombok.Setter;

public class Note {
    @Getter @Setter
    Long id;

    @Getter @Setter
    String note;

    @Getter @Setter
    Patient patient;

    public Note(String note) {
        this.note = note;
    }
}

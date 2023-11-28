package cm1007.patientservice.ViewModels.Notes;

import lombok.Getter;
import lombok.Setter;

public class NoteVM {
    @Getter @Setter
    String note;

    public NoteVM(String note) {
        this.note = note;
    }
}

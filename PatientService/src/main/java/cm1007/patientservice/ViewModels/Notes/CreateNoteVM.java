package cm1007.patientservice.ViewModels.Notes;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class CreateNoteVM {
    @NotEmpty(message = "note cannot be empty")
    @NotNull(message = "note cannot be null")
    @Getter @Setter
    String note;
}

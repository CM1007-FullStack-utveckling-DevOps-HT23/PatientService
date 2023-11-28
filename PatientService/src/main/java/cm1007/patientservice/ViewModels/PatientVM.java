package cm1007.patientservice.ViewModels;

import lombok.Getter;
import lombok.Setter;

public class PatientVM {
    @Getter @Setter
    public Long patientId;

    @Getter @Setter
    public String patientName;

    public PatientVM(Long patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }
}

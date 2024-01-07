package cm1007.patientservice.ViewModels;

import cm1007.patientservice.ViewModels.Condition.ConditionVM;
import cm1007.patientservice.ViewModels.Encounter.EncounterDetailsVM;
import cm1007.patientservice.ViewModels.Notes.NoteVM;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class PatientDetailsVM {
    @Getter @Setter
    public String patientId;

    @Getter @Setter
    public String patientName;

    @Getter @Setter
    public List<EncounterDetailsVM> encounters = new ArrayList<>();

    @Getter @Setter
    public List<ConditionVM> conditions = new ArrayList<>();

    @Getter @Setter
    public List<NoteVM> notes = new ArrayList<>();

    public PatientDetailsVM(String patientId, String patientName) {
        this.patientId = patientId;
        this.patientName = patientName;
    }
}

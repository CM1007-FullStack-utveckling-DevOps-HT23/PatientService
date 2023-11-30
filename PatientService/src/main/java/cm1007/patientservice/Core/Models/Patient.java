package cm1007.patientservice.Core.Models;

import cm1007.patientservice.Persistence.Tables.Patient_T;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    @Getter @Setter
    public Long id;

    @Getter @Setter
    public String fullName;

    @Getter @Setter
    public List<Note> notes = new ArrayList<>();
    @Getter @Setter
    public List<Encounter> encounters = new ArrayList<>();

    @Getter @Setter
    public List<Condition> conditions = new ArrayList<>();

    public Patient(){
    }

    public Patient(Long id, String fullName){
        this.id = id;
        this.fullName = fullName;
    }


}

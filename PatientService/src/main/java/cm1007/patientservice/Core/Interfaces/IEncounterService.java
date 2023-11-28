package cm1007.patientservice.Core.Interfaces;

import cm1007.patientservice.Core.Models.Encounter;
import java.util.List;

public interface IEncounterService {
    List<Encounter> getAllEncounters();
    Encounter getEncounter(long encounterId);
    boolean addEncounter(Encounter encounter);
}

package cm1007.patientservice.Core.Interfaces.Persistence;

import cm1007.patientservice.Core.Models.Encounter;

import java.util.List;

public interface IEncounterPersistence {
    List<Encounter> getAllEncounters();
    Encounter getEncounter(long encounterId);
    boolean addEncounter(Encounter encounter);
}

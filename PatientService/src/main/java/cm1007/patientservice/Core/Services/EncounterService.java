package cm1007.patientservice.Core.Services;

import cm1007.patientservice.Core.Interfaces.IEncounterService;
import cm1007.patientservice.Core.Interfaces.Persistence.IEncounterPersistence;
import cm1007.patientservice.Core.Models.Encounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncounterService implements IEncounterService {

    @Autowired
    private IEncounterPersistence _encounterPersistence;

    @Override
    public List<Encounter> getAllEncounters() {
        return _encounterPersistence.getAllEncounters();
    }

    @Override
    public Encounter getEncounter(long encounterId) {
        return _encounterPersistence.getEncounter(encounterId);
    }

    @Override
    public boolean addEncounter(Encounter encounter) {
        return _encounterPersistence.addEncounter(encounter);
    }
}

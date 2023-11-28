package cm1007.patientservice.Core.Services;

import cm1007.patientservice.Core.Interfaces.IObservationService;
import cm1007.patientservice.Core.Interfaces.Persistence.IObservationPersistence;
import cm1007.patientservice.Core.Models.Observation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ObservationService implements IObservationService {
    @Autowired
    private IObservationPersistence _observationPersistence;

    @Override
    public boolean addObservation(Observation observation) {
        return _observationPersistence.addObservation(observation);
    }
}

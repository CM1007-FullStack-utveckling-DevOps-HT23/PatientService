package cm1007.patientservice.Core.Interfaces.Persistence;

import cm1007.patientservice.Core.Models.Observation;

public interface IObservationPersistence {
    boolean addObservation(Observation observation);
}

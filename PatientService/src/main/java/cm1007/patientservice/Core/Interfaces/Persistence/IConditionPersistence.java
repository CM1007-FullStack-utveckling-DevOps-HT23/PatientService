package cm1007.patientservice.Core.Interfaces.Persistence;

import cm1007.patientservice.Core.Models.Condition;

public interface IConditionPersistence {
    boolean addCondition(Condition c);
}

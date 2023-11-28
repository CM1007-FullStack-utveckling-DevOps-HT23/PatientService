package cm1007.patientservice.Core.Services;

import cm1007.patientservice.Core.Interfaces.IConditionService;
import cm1007.patientservice.Core.Interfaces.Persistence.IConditionPersistence;
import cm1007.patientservice.Core.Models.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConditionService implements IConditionService {
    @Autowired
    IConditionPersistence _conditionPersistence;

    @Override
    public boolean addCondition(Condition c) {
        return _conditionPersistence.addCondition(c);
    }
}

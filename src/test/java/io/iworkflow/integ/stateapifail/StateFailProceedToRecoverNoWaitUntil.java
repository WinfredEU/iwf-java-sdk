package io.iworkflow.integ.stateapifail;

import io.iworkflow.core.WorkflowStateOptionsExtension;
import io.iworkflow.gen.models.RetryPolicy;
import io.iworkflow.gen.models.WorkflowStateOptions;

public class StateFailProceedToRecoverNoWaitUntil extends StateFailBasic {
    @Override
    public WorkflowStateOptions getStateOptions() {
        return new WorkflowStateOptionsExtension()
                .setProceedOnExecuteFailure(StateRecoverNoWaitUntil.class)
                .executeApiRetryPolicy(
                        new RetryPolicy()
                                .maximumAttempts(1)
                                .backoffCoefficient(2f)
                );
    }
}

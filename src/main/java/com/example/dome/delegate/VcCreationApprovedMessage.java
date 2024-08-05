package com.example.dome.delegate;

import org.camunda.bpm.engine.ProcessEngineServices;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class VcCreationApprovedMessage implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProcessEngineServices processEngineServices = delegateExecution.getProcessEngineServices();

        // Get the runtime service
        RuntimeService runtimeService = processEngineServices.getRuntimeService();

        runtimeService.createMessageCorrelation("VC_creation_approved")
                .processInstanceId(delegateExecution.getProcessInstanceId())
                .correlate();
    }
}

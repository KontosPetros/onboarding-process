package com.example.dome.delegate;

import org.camunda.bpm.engine.ProcessEngineServices;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.FileValue;

public class DocumentationSubmittedMessage implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        ProcessEngineServices processEngineServices = delegateExecution.getProcessEngineServices();

        // Get the runtime service
        RuntimeService runtimeService = processEngineServices.getRuntimeService();


        FileValue uploadedFile = delegateExecution.getVariableTyped("uploadedFile");
        System.out.println(uploadedFile.getFilename());
        System.out.println(uploadedFile.getMimeType());

        runtimeService.createMessageCorrelation("doc_submitted")
                .processInstanceId(delegateExecution.getProcessInstanceId())
                .setVariable("uploadedFile", uploadedFile)
                .correlate();
    }
}

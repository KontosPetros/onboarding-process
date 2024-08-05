package com.example.dome.delegate;

import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.TaskListener;

public class AssigneeTaskListener implements TaskListener {
    @Override
    public void notify(DelegateTask delegateTask) {
        delegateTask.getExecution().setVariable("assignee", delegateTask.getAssignee());
    }
}

package com.ufgov.gk.server.system.workflow;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskListener;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IWorkflowDao;

public class CurrentTaskControlListener implements TaskListener {

  private IWorkflowDao dao = (IWorkflowDao) SpringContext.getBean("workflowDao");

  public void afterExecution(WorkflowContext arg0) throws WorkflowException {
    dao.updateCurrentTaskSendStatus(arg0.getInstanceId(), "0");
  }

  public void afterUntread(WorkflowContext arg0) throws WorkflowException {
  }

  public void beforeExecution(WorkflowContext arg0) throws WorkflowException {
  }

  public void beforeUntread(WorkflowContext arg0) throws WorkflowException {
  }

  public void afterCallback(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  public void beforeCallback(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

}

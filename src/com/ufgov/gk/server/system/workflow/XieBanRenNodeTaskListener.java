package com.ufgov.gk.server.system.workflow;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskListener;

public class XieBanRenNodeTaskListener implements TaskListener {

  public void afterCallback(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
  }

  public void afterExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
  }

  public void afterUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
  }

  public void beforeCallback(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    throw new WorkflowException("已提交领导审批，不允许收回!");
  }

  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
	  System.out.println("hahaha...........");
	  System.out.println(context.getExecutor());
	  System.out.println(context.getNextExecutor());
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
  }

}

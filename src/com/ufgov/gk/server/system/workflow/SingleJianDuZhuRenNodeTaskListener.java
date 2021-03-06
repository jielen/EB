package com.ufgov.gk.server.system.workflow;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskListener;
import com.kingdrive.workflow.model.runtime.CurrentTaskModel;
import com.kingdrive.workflow.service.db.WFRuntimeService;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.util.AsOptionUtil;

public class SingleJianDuZhuRenNodeTaskListener implements TaskListener {

  public void afterExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  public void afterUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    WorkflowContext _context = context;

    _context.setNextNodeId(new Long(-2L));//主管主任退回直接退回经办人
  }

  /**
   * 获取主任posi_code
   * @return
   */
  private String getZrPosiCode() {
    String jbrpocode = AsOptionUtil.getInstance().getOptionVal("AUDIT_CGZX_ZR");//
    if (jbrpocode == null) {
      throw new WorkflowException("在as_option表中未配置AUDIT_CGZX_ZR,主任posi_code!");
    }
    return jbrpocode;
  }

  private String getPosiCodeByUserId(String userId) {
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List pos = runtimeService
      .queryForList(
        "select ps.posi_code POSI_CODE from as_emp_position ps,as_emp emp where ps.emp_code = emp.emp_code and emp.user_id = ?  and ps.nd = to_char(sysdate,'yyyy')",
        new Object[] { userId });
    if (pos != null && pos.size() > 0) {
      Map rt = (Map) pos.get(0);
      return (String) rt.get("POSI_CODE");
    }
    return null;
  }

  public void beforeCallback(WorkflowContext context) throws WorkflowException {
    WorkflowContext _context = context;
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List currTasks = runtimeService.getCurentTaskByInstanceId(_context.getInstanceId());
    String zrPosiCode = getZrPosiCode();
    for (Iterator iterator = currTasks.iterator(); iterator.hasNext();) {
      CurrentTaskModel ctm = (CurrentTaskModel) iterator.next();
      String taskExePosiCode = getPosiCodeByUserId(ctm.getExecutor());
      if (taskExePosiCode != null) {
        if (zrPosiCode.equals(taskExePosiCode)) {//如果是提交给了主任审批
          throw new WorkflowException("已提交领导审批，不允许收回!");
        }
      } else {
        throw new WorkflowException("不能获取下一执行人【" + ctm.getExecutor() + "】的posi_code!");
      }
    }
  }

  public void afterCallback(WorkflowContext context) throws WorkflowException {
  }
}

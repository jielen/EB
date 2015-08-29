package com.ufgov.gk.server.system.workflow;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskListener;
import com.kingdrive.workflow.model.TableData;
import com.kingdrive.workflow.model.runtime.ActionModel;
import com.kingdrive.workflow.service.db.WFRuntimeService;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.util.AsOptionUtil;

public class JingBanRenSendToYsdwnNodeListener implements TaskListener {

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

  }

  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    TableData edata = context.getEntityData();
    if (edata.getFieldValue("IS_GOON_AUDIT") == null) {
      throw new WorkflowException("没有找到IS_GOON_AUDIT标示符的值，不能判断本次是否执行‘办结’操作!");
    }
    Integer auditFlag = (Integer) edata.getFieldValue("IS_GOON_AUDIT");
    if (auditFlag.intValue() != 3) {//如果不是‘办结’，就不用进行下面判断
      return;
    }
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List list = runtimeService.getActionByinsId(context.getInstanceId());
    String ysdwcg = getYsdwcgPosiCode();
    boolean isAudited = false;
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      ActionModel am = (ActionModel) iterator.next();
      if (ysdwcg.equals(getPosiCodeByUserId(am.getExecutor()))) {
        isAudited = true;
        break;
      }
    }
    if (!isAudited) {
      throw new WorkflowException("本数据还未送采购单位审核，不能执行办结!");
    }
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  /**
   * 根据userid获取posicode
   * @param userId
   * @return
   */
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

  /**
   * 获取预算单位采购人posi_code
   * @return
   */
  private String getYsdwcgPosiCode() {
    String jbrPosiCode = AsOptionUtil.getInstance().getOptionVal("AUDIT_YSDW_JB_ROLE_STRING");//经办人posiCode
    if (jbrPosiCode == null) {
      throw new WorkflowException("在as_option表中未配置AUDIT_YSDW_JB_ROLE_STRING,采购单位经办人的posiCode!");
    }
    return jbrPosiCode;
  }
}

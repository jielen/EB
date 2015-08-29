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
      throw new WorkflowException("û���ҵ�IS_GOON_AUDIT��ʾ����ֵ�������жϱ����Ƿ�ִ�С���ᡯ����!");
    }
    Integer auditFlag = (Integer) edata.getFieldValue("IS_GOON_AUDIT");
    if (auditFlag.intValue() != 3) {//������ǡ���ᡯ���Ͳ��ý��������ж�
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
      throw new WorkflowException("�����ݻ�δ�Ͳɹ���λ��ˣ�����ִ�а��!");
    }
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  /**
   * ����userid��ȡposicode
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
   * ��ȡԤ�㵥λ�ɹ���posi_code
   * @return
   */
  private String getYsdwcgPosiCode() {
    String jbrPosiCode = AsOptionUtil.getInstance().getOptionVal("AUDIT_YSDW_JB_ROLE_STRING");//������posiCode
    if (jbrPosiCode == null) {
      throw new WorkflowException("��as_option����δ����AUDIT_YSDW_JB_ROLE_STRING,�ɹ���λ�����˵�posiCode!");
    }
    return jbrPosiCode;
  }
}

package com.ufgov.gk.server.system.workflow;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.exception.WorkflowException;
import com.kingdrive.workflow.listener.TaskListener;
import com.kingdrive.workflow.model.runtime.ActionModel;
import com.kingdrive.workflow.model.runtime.CurrentTaskModel;
import com.kingdrive.workflow.service.db.WFRuntimeService;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.util.AsOptionUtil;

public class TwoFuZhuRenNodeTaskListener implements TaskListener {

  public void afterExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  public void afterUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub

  }

  public void beforeExecution(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    WorkflowContext _context = context;
    if (_context.getExecutor().equals(getJDZRUserId())) {
      return;
    }
    List list = getActionByNodeId(_context.getCurrentNode().getNodeId(), _context.getInstanceId());
    if (list == null || list.size() % 2 == 0) {
      Exception ex = new Exception("���������Ρ������ڡ��ල���Ρ�������֮����ܽ�������!");
      throw new WorkflowException(ex);
    }
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    WorkflowContext _context = context;
    if (_context.getExecutor().equals(getJDZRUserId())) {//����Ǽල���Σ������˻�
      throw new WorkflowException("�˵��������������˻�!");
    }
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List list = runtimeService.getActionByinsId(_context.getInstanceId());
    if (list.size() == 0) {
      throw new WorkflowException("������¼Ϊ�գ������˻�!");
    }
    ActionModel firstAction = (ActionModel) list.get(0);
    String firstZcCoCode = getZcCoCodeByUserId(firstAction.getExecutor());
    if (firstZcCoCode == null) {
      throw new WorkflowException("ϵͳ���ж��Ƿ��˻��׽ڵ�ʱ�����ܻ�ȡ�׽ڵ�ִ���ˡ�" + firstAction.getExecutor() + "����posi_code!");
    }
    String zcCoCode = getZxZcCoCode();
    if (zcCoCode.equals(firstZcCoCode)) {//����׽ڵ��ִ���˾������ĵ��ˣ���϶������ľ����ˣ��˻��׽ڵ㼴��
      _context.setNextNodeId(new Long(-2L));//���������˻�ֱ���˻ؾ�����
    } else {//������̷����˲������ģ�����Ҫ�˻������ľ����˽ڵ�
      Long untreadNodeId = null;
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
        ActionModel am = (ActionModel) iterator.next();
        String tempCode = getZcCoCodeByUserId(am.getExecutor());
        if (zcCoCode.equals(tempCode)) {//����ҵ����ľ����˽ڵ㣬���¼���˳�ѭ��
          untreadNodeId = am.getNodeId();
          break;
        }
      }
      if (untreadNodeId == null) {
        throw new WorkflowException("�ڲ�����¼�У�δ�ҵ����ľ����˲�����¼���˻ؾ�����ʧ��!");
      }
      _context.setNextNodeId(untreadNodeId);//�˻ؾ����˽ڵ�
    }
  }

  private List getActionByNodeId(Long nodeId, Long instanceId) {
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    ActionModel am = new ActionModel();
    am.setNodeId(nodeId);
    am.setInstanceId(instanceId);
    List list = runtimeService.getAction(am);
    return list;
  }

  /**
   * ��ȡ�ɹ����ľ�����posi_code
   * @return
   */
  private String getZxjbrPosiCode() {
    String jbrPosiCode = AsOptionUtil.getInstance().getOptionVal("ZC_CGZX_KY_POSI_CODE");//������posiCode
    if (jbrPosiCode == null) {
      throw new WorkflowException("��as_option����δ����ZC_CGZX_KY_POSI_CODE,�ɹ����ľ����˵�posiCode!");
    }
    return jbrPosiCode;
  }

  /**
   * ��ȡ�ɹ�����zc_co_code
   * @return
   */
  private String getZxZcCoCode() {
    String cgzxCode = AsOptionUtil.getInstance().getOptionVal("ZC_CGZX_CODE");//�ɹ�������֯���
    if (cgzxCode == null) {
      throw new WorkflowException("��as_option����δ����ZC_CGZX_CODE,�ɹ����ĵ�ZC_CO_CODE!");
    }
    return cgzxCode;
  }

  /**
   * ��ȡ��������user_id
   * @return
   */
  private String getJDZRUserId() {
    String jdzrUserId = AsOptionUtil.getInstance().getOptionVal("OPT_JIANDU_ZR");//�ල����user_id
    if (jdzrUserId == null) {
      throw new WorkflowException("��as_option����δ����OPT_JIANDU_ZR,�ල�����û�id!");
    }
    return jdzrUserId;
  }

  /**
   * ��ȡ����posi_code
   * @return
   */
  private String getZrPosiCode() {
    String jbrpocode = AsOptionUtil.getInstance().getOptionVal("AUDIT_CGZX_ZR");//
    if (jbrpocode == null) {
      throw new WorkflowException("��as_option����δ����AUDIT_CGZX_ZR,����posi_code!");
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

  private String getZcCoCodeByUserId(String userId) {
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List pos = runtimeService
      .queryForList(
        "select ps.co_code CO_CODE from as_emp_position ps,as_emp emp where ps.emp_code = emp.emp_code and emp.user_id = ?  and ps.nd = to_char(sysdate,'yyyy')",
        new Object[] { userId });
    if (pos != null && pos.size() > 0) {
      Map rt = (Map) pos.get(0);
      return (String) rt.get("CO_CODE");
    }
    return null;
  }

  public void beforeCallback(WorkflowContext context) throws WorkflowException {
    WorkflowContext _context = context;
    if (!_context.getExecutor().equals(getJDZRUserId())) {//������Ǽල���Σ�������ж��ǲ���������������������������쵼�������������ջ�
      WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
      List currTasks = runtimeService.getCurentTaskByInstanceId(_context.getInstanceId());
      String zrPosiCode = getZrPosiCode();
      for (Iterator iterator = currTasks.iterator(); iterator.hasNext();) {
        CurrentTaskModel ctm = (CurrentTaskModel) iterator.next();
        String posiCode = getPosiCodeByUserId(ctm.getExecutor());
        if (posiCode == null) {
          throw new WorkflowException("���ܻ�ȡ��һִ���ˡ�" + ctm.getExecutor() + "����posi_code!");
        }
        if (zrPosiCode.equals(posiCode)) {//������ύ������������
          throw new WorkflowException("���ύ�쵼�������������ջ�!");
        }
      }
      return;
    }
    List list = getActionByNodeId(_context.getCurrentNode().getNodeId(), _context.getInstanceId());
    if (list != null && list.size() % 2 == 0) {
      throw new WorkflowException("���������Ρ��Ѿ�����ͨ�������ල���Ρ������ջ�!");
    }
  }

  public void afterCallback(WorkflowContext context) throws WorkflowException {
  }
}

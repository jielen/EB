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
      Exception ex = new Exception("【主管主任】必须在【监督主任】审批完之后才能进行审批!");
      throw new WorkflowException(ex);
    }
  }

  public void beforeUntread(WorkflowContext context) throws WorkflowException {
    // TODO Auto-generated method stub
    WorkflowContext _context = context;
    if (_context.getExecutor().equals(getJDZRUserId())) {//如果是监督主任，则不能退回
      throw new WorkflowException("此单据需主管主任退回!");
    }
    WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
    List list = runtimeService.getActionByinsId(_context.getInstanceId());
    if (list.size() == 0) {
      throw new WorkflowException("操作记录为空，不能退回!");
    }
    ActionModel firstAction = (ActionModel) list.get(0);
    String firstZcCoCode = getZcCoCodeByUserId(firstAction.getExecutor());
    if (firstZcCoCode == null) {
      throw new WorkflowException("系统在判断是否退回首节点时，不能获取首节点执行人【" + firstAction.getExecutor() + "】的posi_code!");
    }
    String zcCoCode = getZxZcCoCode();
    if (zcCoCode.equals(firstZcCoCode)) {//如果首节点的执行人就是中心的人，则肯定是中心经办人，退回首节点即可
      _context.setNextNodeId(new Long(-2L));//主管主任退回直接退回经办人
    } else {//如果流程发起人不是中心，则需要退回至中心经办人节点
      Long untreadNodeId = null;
      for (Iterator iterator = list.iterator(); iterator.hasNext();) {
        ActionModel am = (ActionModel) iterator.next();
        String tempCode = getZcCoCodeByUserId(am.getExecutor());
        if (zcCoCode.equals(tempCode)) {//如果找到中心经办人节点，则记录，退出循环
          untreadNodeId = am.getNodeId();
          break;
        }
      }
      if (untreadNodeId == null) {
        throw new WorkflowException("在操作记录中，未找到中心经办人操作记录，退回经办人失败!");
      }
      _context.setNextNodeId(untreadNodeId);//退回经办人节点
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
   * 获取采购中心经办人posi_code
   * @return
   */
  private String getZxjbrPosiCode() {
    String jbrPosiCode = AsOptionUtil.getInstance().getOptionVal("ZC_CGZX_KY_POSI_CODE");//经办人posiCode
    if (jbrPosiCode == null) {
      throw new WorkflowException("在as_option表中未配置ZC_CGZX_KY_POSI_CODE,采购中心经办人的posiCode!");
    }
    return jbrPosiCode;
  }

  /**
   * 获取采购中心zc_co_code
   * @return
   */
  private String getZxZcCoCode() {
    String cgzxCode = AsOptionUtil.getInstance().getOptionVal("ZC_CGZX_CODE");//采购中心组织编号
    if (cgzxCode == null) {
      throw new WorkflowException("在as_option表中未配置ZC_CGZX_CODE,采购中心的ZC_CO_CODE!");
    }
    return cgzxCode;
  }

  /**
   * 获取监审主任user_id
   * @return
   */
  private String getJDZRUserId() {
    String jdzrUserId = AsOptionUtil.getInstance().getOptionVal("OPT_JIANDU_ZR");//监督主任user_id
    if (jdzrUserId == null) {
      throw new WorkflowException("在as_option表中未配置OPT_JIANDU_ZR,监督主任用户id!");
    }
    return jdzrUserId;
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
    if (!_context.getExecutor().equals(getJDZRUserId())) {//如果不是监督主任，则继续判断是不是送往主任审批，如果是送往领导审批，则不允许收回
      WFRuntimeService runtimeService = (WFRuntimeService) SpringContext.getBean("WFRuntimeService");
      List currTasks = runtimeService.getCurentTaskByInstanceId(_context.getInstanceId());
      String zrPosiCode = getZrPosiCode();
      for (Iterator iterator = currTasks.iterator(); iterator.hasNext();) {
        CurrentTaskModel ctm = (CurrentTaskModel) iterator.next();
        String posiCode = getPosiCodeByUserId(ctm.getExecutor());
        if (posiCode == null) {
          throw new WorkflowException("不能获取下一执行人【" + ctm.getExecutor() + "】的posi_code!");
        }
        if (zrPosiCode.equals(posiCode)) {//如果是提交给了主任审批
          throw new WorkflowException("已提交领导审批，不允许收回!");
        }
      }
      return;
    }
    List list = getActionByNodeId(_context.getCurrentNode().getNodeId(), _context.getInstanceId());
    if (list != null && list.size() % 2 == 0) {
      throw new WorkflowException("【主管主任】已经审批通过，【监督主任】不能收回!");
    }
  }

  public void afterCallback(WorkflowContext context) throws WorkflowException {
  }
}

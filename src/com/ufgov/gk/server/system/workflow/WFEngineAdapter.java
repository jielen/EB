package com.ufgov.gk.server.system.workflow;

import com.kingdrive.workflow.WFEngine;
import com.kingdrive.workflow.context.WorkflowContext;
import com.kingdrive.workflow.model.TableData;
import com.kingdrive.workflow.model.runtime.TraceInfoModel;
import com.ufgov.gk.common.commonbiz.model.WfAware;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;
import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.server.system.dao.IAsOptionDao;
import com.ufgov.gk.server.system.dao.ibatis.WorkflowDao;

public class WFEngineAdapter {

  private WFEngine wfEngine;

  private IAsOptionDao asOptionDao;

  private WorkflowDao workflowDao;

  public WFEngine getWfEngine() {
    return wfEngine;
  }

  public void setWfEngine(WFEngine wfEngine) {
    this.wfEngine = wfEngine;
  }

  public WorkflowContext genCommonWFC(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = WorkflowContextUtil.genWorkflowContext();

    workflowContext.setInstanceId(bill.getProcessInstId());

    workflowContext.setComment(wfComment);

    TableData tableData = WFTableDataUtil.genTableData(bill);

    workflowContext.setEntityData(tableData);

    return workflowContext;
  }

  public WorkflowContext genCommonWFC(String wfComment, WfAware bill, String compoId) {
    WorkflowContext workflowContext = WorkflowContextUtil.genWorkflowContext();

    workflowContext.setInstanceId(bill.getProcessInstId());

    workflowContext.setComment(wfComment);

    TableData tableData = WFTableDataUtil.genTableData(bill, compoId);

    workflowContext.setEntityData(tableData);

    return workflowContext;
  }

  public void cancelGrantedTask(String userId) {

    this.wfEngine.cancelGrantedTask(userId);

  }

  /**
   * 工作流审核通过
   * @param wfComment 审核意见
   * @param bill 业务数据对象
   */
  public void commit(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.wfEngine.commit(workflowContext);
  }

  /**
   * 工作流审核通过
   * @param wfComment 审核意见
   * @param bill 业务数据对象
   */
  public void commit(WorkflowContext workflowContext) {
    this.wfEngine.commit(workflowContext);
  }

  /**
   * 工作流退回
   * @param wfComment 审核意见
   * @param bill 业务数据对象
   */
  public void untread(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    //退回上一个结点
    workflowContext.setNextNodeId(new Long(-1));

    this.wfEngine.untread(workflowContext);
  }

  /**
   * 工作流退回
   * @param wfComment 审核意见
   * @param bill 业务数据对象
   */
  public void untreadToFirst(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    //退回第一个结点
    workflowContext.setNextNodeId(new Long(-2));

    this.wfEngine.untread(workflowContext);
  }

  /**
   * 销审
   * @param wfComment
   * @param bill
   */
  public void unAudit(String wfComment, WfAware bill) {
    if (workflowDao.isFinalAudit(bill.getProcessInstId())) {
      this.rework(wfComment, bill);
    } else {
      this.callback(wfComment, bill);
    }
  }

  /**
   * 销审
   * @param wfComment
   * @param bill
   */
  public void unAudit(WorkflowContext workflowContext, WfAware bill) {
    if (workflowDao.isFinalAudit(bill.getProcessInstId())) {
      this.rework(workflowContext.getComment(), bill);
    } else {
      this.callback(workflowContext);
    }
  }

  /**
   * 国库退回，根据系统选项决定是退到第一个节点还是上一个节点
   * @param wfComment
   * @param bill
   */
  public void untreadGk(String wfComment, WfAware bill) {
    AsOption option = asOptionDao.getAsOption(BusinessOptionConstants.OPT_CP_BILL_AUDIT_RTN);
    if (option != null && option.getOptVal().equals("-1")) {
      //      this.untreadToFirst(wfComment, bill);
      this.restart(wfComment, bill);
    } else {
      this.untread(wfComment, bill);

    }
  }

  // 收回
  public void callback(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    //    if (workflowDao.isFinalAudit(bill.getProcessInstId())) {
    //      this.rework(workflowContext.getComment(), bill);
    //    } else {
    this.callback(workflowContext);
    //    }
  }

  // 收回
  public void callback(WorkflowContext workflowContext) {
    this.wfEngine.callback(workflowContext);
  }

  // 跳转
  public void transfer(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.transfer(workflowContext);

  }

  // 冻结
  public void deactivate(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.deactivate(workflowContext);

  }

  // 激活
  public void activate(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.activate(workflowContext);

  }

  public void interruptNotJudge(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.wfEngine.interruptNotJudge(workflowContext);
  }

  public void interruptNotJudge(WorkflowContext workflowContext) {
    this.wfEngine.interruptNotJudge(workflowContext);
  }

  // 终止
  public void interrupt(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.wfEngine.interrupt(workflowContext);

  }

  public void interrupt(WorkflowContext workflowContext) {
    this.wfEngine.interrupt(workflowContext);
  }

  // 重做, 退回最后一个任务节点
  public void rework(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    if (!bill.getAuditorId().equals((String) workflowContext.getVariableMap().get("svUserID"))) {
      throw new RuntimeException("您不是该单据的终审人，不能销审！");
    }
    this.wfEngine.rework(workflowContext);

  }

  // 重做, 退回最后一个任务节点
  public void reworkNoCheck(WorkflowContext workflowContext) {
    this.wfEngine.rework(workflowContext);
  }

  // 重启, 退回到第一个工作节点(必须是终审的数据)
  public void restart(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.restart(workflowContext);
  }

  /**
   * 工作流提交送审,启动工作流
   * @param wfComment 审核意见
   * @param bill 业务数据对象
   */
  public void newCommit(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.newCommit(workflowContext, bill);
  }

  public void newCommit(WorkflowContext workflowContext, WfAware bill) {
    if (bill.getProcessInstId().longValue() < 0) {
      this.wfEngine.newCommit(workflowContext);
    } else {
      this.wfEngine.commit(workflowContext);
    }
  }

  public TraceInfoModel getTraceInfo(Long instanceId) {
    return this.wfEngine.getTraceInfo(instanceId);
  }

  public IAsOptionDao getAsOptionDao() {
    return asOptionDao;
  }

  public void setAsOptionDao(IAsOptionDao asOptionDao) {
    this.asOptionDao = asOptionDao;
  }

  public WorkflowDao getWorkflowDao() {
    return workflowDao;
  }

  public void setWorkflowDao(WorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }

}

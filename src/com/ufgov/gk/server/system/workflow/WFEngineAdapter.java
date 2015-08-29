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
   * ���������ͨ��
   * @param wfComment ������
   * @param bill ҵ�����ݶ���
   */
  public void commit(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.wfEngine.commit(workflowContext);
  }

  /**
   * ���������ͨ��
   * @param wfComment ������
   * @param bill ҵ�����ݶ���
   */
  public void commit(WorkflowContext workflowContext) {
    this.wfEngine.commit(workflowContext);
  }

  /**
   * �������˻�
   * @param wfComment ������
   * @param bill ҵ�����ݶ���
   */
  public void untread(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    //�˻���һ�����
    workflowContext.setNextNodeId(new Long(-1));

    this.wfEngine.untread(workflowContext);
  }

  /**
   * �������˻�
   * @param wfComment ������
   * @param bill ҵ�����ݶ���
   */
  public void untreadToFirst(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    //�˻ص�һ�����
    workflowContext.setNextNodeId(new Long(-2));

    this.wfEngine.untread(workflowContext);
  }

  /**
   * ����
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
   * ����
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
   * �����˻أ�����ϵͳѡ��������˵���һ���ڵ㻹����һ���ڵ�
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

  // �ջ�
  public void callback(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    //    if (workflowDao.isFinalAudit(bill.getProcessInstId())) {
    //      this.rework(workflowContext.getComment(), bill);
    //    } else {
    this.callback(workflowContext);
    //    }
  }

  // �ջ�
  public void callback(WorkflowContext workflowContext) {
    this.wfEngine.callback(workflowContext);
  }

  // ��ת
  public void transfer(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.transfer(workflowContext);

  }

  // ����
  public void deactivate(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.deactivate(workflowContext);

  }

  // ����
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

  // ��ֹ
  public void interrupt(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    this.wfEngine.interrupt(workflowContext);

  }

  public void interrupt(WorkflowContext workflowContext) {
    this.wfEngine.interrupt(workflowContext);
  }

  // ����, �˻����һ������ڵ�
  public void rework(String wfComment, WfAware bill) {
    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);
    if (!bill.getAuditorId().equals((String) workflowContext.getVariableMap().get("svUserID"))) {
      throw new RuntimeException("�����Ǹõ��ݵ������ˣ���������");
    }
    this.wfEngine.rework(workflowContext);

  }

  // ����, �˻����һ������ڵ�
  public void reworkNoCheck(WorkflowContext workflowContext) {
    this.wfEngine.rework(workflowContext);
  }

  // ����, �˻ص���һ�������ڵ�(���������������)
  public void restart(String wfComment, WfAware bill) {

    WorkflowContext workflowContext = this.genCommonWFC(wfComment, bill);

    this.wfEngine.restart(workflowContext);
  }

  /**
   * �������ύ����,����������
   * @param wfComment ������
   * @param bill ҵ�����ݶ���
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

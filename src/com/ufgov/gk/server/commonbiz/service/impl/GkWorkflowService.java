package com.ufgov.gk.server.commonbiz.service.impl;

/**
 * @author ufwangfei
 *  工作流相关方法service
 */

import com.ufgov.gk.server.commonbiz.service.IGkWorkflowService;
import com.ufgov.gk.server.system.dao.IWorkflowDao;

public class GkWorkflowService implements IGkWorkflowService {
  private IWorkflowDao workflowDao;

  public IWorkflowDao getWorkflowDao() {
    return workflowDao;
  }

  public void setWorkflowDao(IWorkflowDao workflowDao) {
    this.workflowDao = workflowDao;
  }

  /**
   * 根据流程实例号判断业务单据是否流程终止;
   */
  public boolean isFinalAudit(Long processInstId) {
    return this.workflowDao.isFinalAudit(processInstId);
  }

  public String getOrgPosiId(String coCode, String orgCode, String posiCode, int nd) {
    return workflowDao.getOrgPosiId(coCode, orgCode, posiCode, nd);
  }
}
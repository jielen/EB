package com.ufgov.gk.server.commonbiz.service.impl;

/**
 * @author ufwangfei
 *  ��������ط���service
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
   * ��������ʵ�����ж�ҵ�񵥾��Ƿ�������ֹ;
   */
  public boolean isFinalAudit(Long processInstId) {
    return this.workflowDao.isFinalAudit(processInstId);
  }

  public String getOrgPosiId(String coCode, String orgCode, String posiCode, int nd) {
    return workflowDao.getOrgPosiId(coCode, orgCode, posiCode, nd);
  }
}
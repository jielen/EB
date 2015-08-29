package com.ufgov.gk.server.commonbiz.service;

public interface IGkWorkflowService {
  boolean isFinalAudit(Long processInstId);
  
  String getOrgPosiId(String coCode,String orgCode,String posiCode,int nd);
}
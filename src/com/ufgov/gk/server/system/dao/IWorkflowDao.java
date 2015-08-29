package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.system.model.AsWfDraft;


public interface IWorkflowDao {
  
  Long createDraftId();
  
  void insertAsWfdraft(AsWfDraft asWfDraft);
  
  void deleteDraft(String compoId,Long wfDraftId);
  
  String getWfInstanceIdStatus(Long instanceId);
  
  
  String getOrgPosiId(String coCode,String orgCode,String posiCode,int nd);
  
  boolean isFinalAudit(Long processInstId);
  
  int getWfTemplateNode(String compoId);
  
  void updateCurrentTaskSendStatus(Long instanceId,String status);
  
  void updateCurrentTaskSendStatus( List instanceIdList,  String status) ;

}

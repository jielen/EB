package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.SendDoc;

public interface ISendDocService {
	
	List getSendDoc( int nd);
	
  void insertSendDoc(SendDoc sendDoc);

  void updateSendDoc(SendDoc sendDoc);

  void deleteSendDoc(SendDoc sendDoc);
  
  boolean codeExist(SendDoc sendDoc);
  
  boolean nameExist(SendDoc sendDoc);
  
  /**
   * 除当前code对应name外的 是否重复
   * @param nd
   * @param currentCode
   * @return
   */
  boolean nameExistSelfExcluded(SendDoc sendDoc);
  
  boolean sendDocUsed(SendDoc sendDoc);
}

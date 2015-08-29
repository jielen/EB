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
   * ����ǰcode��Ӧname��� �Ƿ��ظ�
   * @param nd
   * @param currentCode
   * @return
   */
  boolean nameExistSelfExcluded(SendDoc sendDoc);
  
  boolean sendDocUsed(SendDoc sendDoc);
}

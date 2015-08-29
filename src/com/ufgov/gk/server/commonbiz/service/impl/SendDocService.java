package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.SendDoc;
import com.ufgov.gk.server.commonbiz.dao.ISendDocDao;
import com.ufgov.gk.server.commonbiz.service.ISendDocService;

public class SendDocService implements ISendDocService {
  private ISendDocDao sendDocDao;

  public ISendDocDao getSendDocDao() {
    return sendDocDao;
  }

  public void setSendDocDao(ISendDocDao sendDocDao) {
    this.sendDocDao = sendDocDao;
  }

  public List getSendDoc(int nd) {

    return sendDocDao.getSendDoc(nd);
  }

  public void deleteSendDoc(SendDoc sendDoc) {
    this.sendDocDao.deleteSendDoc(sendDoc);
  }

  public void insertSendDoc(SendDoc sendDoc) {
    this.sendDocDao.insertSendDoc(sendDoc);
  }

  public void updateSendDoc(SendDoc sendDoc) {
    this.sendDocDao.updateSendDoc(sendDoc);
  }

  public boolean codeExist(SendDoc sendDoc) {
    return this.sendDocDao.codeExist(sendDoc);
  }

  public boolean nameExist(SendDoc sendDoc) {
    return this.sendDocDao.nameExist(sendDoc);
  }

  public boolean nameExistSelfExcluded(SendDoc sendDoc) {
    return this.sendDocDao.nameExistSelfExcluded(sendDoc);
  }
  
  public boolean sendDocUsed(SendDoc sendDoc){
    return this.sendDocDao.sendDocUsed(sendDoc);
  }

}

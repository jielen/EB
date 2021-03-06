package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.WfTaskGranter;
import com.ufgov.gk.server.commonbiz.dao.IWfTaskGranterDao;
import com.ufgov.gk.server.commonbiz.service.IWfTaskGranterService;
import com.ufgov.gk.server.system.dao.IAsOptionDao;
import com.ufgov.gk.server.system.workflow.WFEngineAdapter;

public class WfTaskGranterService implements IWfTaskGranterService{
  private IWfTaskGranterDao WfTaskGranterDao;
  private WFEngineAdapter wfEngine;
  private IAsOptionDao asOptionDao;

  public void insertWfTaskGranter(WfTaskGranter wfTaskGranter){
     int level = asOptionDao.getFieldLevel("CO_CODE",wfTaskGranter.getUserCoCode());
     wfTaskGranter.setLevel(level);
     this.WfTaskGranterDao.insertWfTaskGranter(wfTaskGranter);
  }

  public void deleteWfTaskGranter(String userId){
    this.WfTaskGranterDao.deleteWfTaskGranter(userId);
  }

  public void updateWfTaskGranter(List grantList){
    this.WfTaskGranterDao.updateWfTaskGranter(grantList);
  }
  public void updateToRelieveWarrant(List grantList){
    this.WfTaskGranterDao.updateToRelieveWarrant(grantList);
  }

  public List getWfTaskGranter(String userId){
    return WfTaskGranterDao.getWfTaskGranter(userId);
  }

  public IWfTaskGranterDao getWfTaskGranterDao() {
    return WfTaskGranterDao;
  }

  public void setWfTaskGranterDao(IWfTaskGranterDao wfTaskGranterDao) {
    WfTaskGranterDao = wfTaskGranterDao;
  }

  public WFEngineAdapter getWfEngine() {
    return wfEngine;
  }

  public void setWfEngine(WFEngineAdapter wfEngine) {
    this.wfEngine = wfEngine;
  }

  public void  cancelGrantedTask(String userId){
    this.wfEngine.cancelGrantedTask(userId);
  }

  public IAsOptionDao getAsOptionDao() {
    return asOptionDao;
  }

  public void setAsOptionDao(IAsOptionDao asOptionDao) {
    this.asOptionDao = asOptionDao;
  }

}

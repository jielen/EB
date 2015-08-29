package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.GkBusinessLog;
import com.ufgov.gk.server.system.dao.IGkBusinessLogDao;
import com.ufgov.gk.server.system.service.IGkBusinessLogService;

public class GkBusinessLogService implements IGkBusinessLogService {

  private IGkBusinessLogDao gkBusinessLogDao;

  public IGkBusinessLogDao getGkBusinessLogDao() {
    return gkBusinessLogDao;
  }

  public void setGkBusinessLogDao(IGkBusinessLogDao gkBusinessLogDao) {
    this.gkBusinessLogDao = gkBusinessLogDao;
  }

  public List getGkBusinessLog(BaseBill bill) {
    return gkBusinessLogDao.getGkBusinessLog(bill);
  }

  public List getGkBusinessLog(String billid,String tabname){
    return gkBusinessLogDao.getGkBusinessLog(billid,tabname);
  }


  public void saveGkBusinessLog(GkBusinessLog log) {
    gkBusinessLogDao.saveGkBusinessLog(log);
  }

  public void saveGkBusinessLog(List logList) {
    gkBusinessLogDao.saveGkBusinessLog(logList);
  }

}

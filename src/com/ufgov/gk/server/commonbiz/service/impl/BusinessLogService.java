package com.ufgov.gk.server.commonbiz.service.impl;

import com.ufgov.gk.common.system.model.AsLog;
import com.ufgov.gk.server.commonbiz.dao.IBusinessLogDao;
import com.ufgov.gk.server.commonbiz.service.IBusinessLogService;

public class BusinessLogService implements IBusinessLogService {
  
	private IBusinessLogDao businessLogDao ;

  public IBusinessLogDao getBusinessLogDao() {
    return businessLogDao;
  }

  public void setBusinessLogDao(IBusinessLogDao businessLogDao) {
    this.businessLogDao = businessLogDao;
  }

  public void saveLog(AsLog log) {
    this.businessLogDao.saveLog(log);
    
  }

}

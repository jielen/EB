package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.server.system.dao.IAsCompoFuncDao;
import com.ufgov.gk.server.system.service.IAsCompoFuncService;

public class AsCompoFuncService implements IAsCompoFuncService {
  private IAsCompoFuncDao asCompoFuncDao;

  public List getAsCompoFunc(String compoId) {
    return asCompoFuncDao.getAsCompoFunc(compoId);
  }

  public void updateAsCompoFunc(List asCompoFuncList) {
    asCompoFuncDao.updateAsCompoFunc(asCompoFuncList);
  }

  public IAsCompoFuncDao getAsCompoFuncDao() {
    return asCompoFuncDao;
  }

  public void setAsCompoFuncDao(IAsCompoFuncDao asCompoFuncDao) {
    this.asCompoFuncDao = asCompoFuncDao;
  }

}

package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.server.system.dao.IAsCompoDao;
import com.ufgov.gk.server.system.service.IAsCompoService;

public class AsCompoService implements IAsCompoService {
  private IAsCompoDao asCompoDao;

  public List getAllAsCompo() {
    return asCompoDao.getAllAsCompo();
  }

  public void updateAsCompo(AsCompo asCompo) {
    asCompoDao.updateAsCompo(asCompo);
  }

  public IAsCompoDao getAsCompoDao() {
    return asCompoDao;
  }

  public void setAsCompoDao(IAsCompoDao asCompoDao) {
    this.asCompoDao = asCompoDao;
  }

  public List getAsTabColForOrder(String tabName) {
    return asCompoDao.getAsTabColForOrder(tabName);
  }

  public AsCompo getAsCompoById(String compoId) {
    return asCompoDao.getAsCompo(compoId);
  }

  public List getMaGkFuncCompo() {
    return asCompoDao.getMaGkFuncCompo();
  }

}

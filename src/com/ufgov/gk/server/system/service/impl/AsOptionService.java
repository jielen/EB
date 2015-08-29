package com.ufgov.gk.server.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.server.system.dao.IAsOptionDao;
import com.ufgov.gk.server.system.service.IAsOptionService;

public class AsOptionService implements IAsOptionService {
  private IAsOptionDao asOptionDao;

  public IAsOptionDao getAsOptionDao() {
    return asOptionDao;
  }

  public void setAsOptionDao(IAsOptionDao asOptionDao) {
    this.asOptionDao = asOptionDao;
  }

  public AsOption getAsOption(String optId) {
    return asOptionDao.getAsOption(optId);
  }

  public void updateOptionVal(AsOption asOption) {
    asOptionDao.updateOptionVal(asOption);
  }

  public Map getFieldLevelOptions() {
    return asOptionDao.getFieldLevelOptions();
  }

  public List getAllAsOptionById(String optId) {
    return asOptionDao.getAllAsOptionById(optId);
  }

}

package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.IGkCompoNewToOldDao;
import com.ufgov.gk.server.console.service.IGkCompoNewToOldService;

public class GkCompoNewToOldService implements IGkCompoNewToOldService {
  private IGkCompoNewToOldDao gkCompoNewToOldDao;

  public List getGkCompoNewToOld() {
    return gkCompoNewToOldDao.getGkCompoNewToOld();
  }

  public IGkCompoNewToOldDao getGkCompoNewToOldDao() {
    return gkCompoNewToOldDao;
  }

  public void setGkCompoNewToOldDao(IGkCompoNewToOldDao gkCompoNewToOldDao) {
    this.gkCompoNewToOldDao = gkCompoNewToOldDao;
  }

}

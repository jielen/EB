package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.server.console.dao.IComponentDao;
import com.ufgov.gk.server.console.service.IComponentService;


public class ComponentService implements IComponentService {
  
  IComponentDao componentDao;
  
  public IComponentDao getComponentDao() {
    return componentDao;
  }

  public void setComponentDao(IComponentDao componentDao) {
    this.componentDao = componentDao;
  }
  
  public List getFunctionList(String compoId) {
    return componentDao.getFunctionList(compoId);

  }

  public List getCompoList() {
    return componentDao.getCompoList();
  }




}

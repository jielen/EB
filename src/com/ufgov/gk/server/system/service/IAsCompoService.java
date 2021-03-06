package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.system.model.AsCompo;

public interface IAsCompoService {
  public List getAllAsCompo();

  public void updateAsCompo(AsCompo asCompo);

  public List getAsTabColForOrder(String tabName);
  
  
  public AsCompo getAsCompoById(String compoId);
  
  
  public List getMaGkFuncCompo();
}

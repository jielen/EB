package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.system.model.AsCompo;

public interface IAsCompoDao {

  public AsCompo getAsCompo(String compoId);

  public List getAllAsCompo();

  public void updateAsCompo(AsCompo asCompo);

  public List getAsTabColForOrder(String tabName);
  
  public List getMaGkFuncCompo();

}

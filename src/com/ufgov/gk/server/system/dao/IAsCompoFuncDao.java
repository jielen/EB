package com.ufgov.gk.server.system.dao;

import java.util.List;

public interface IAsCompoFuncDao {
  public List getAsCompoFunc(String compoId);

  public void updateAsCompoFunc(List asCompoFuncList);
}

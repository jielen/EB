package com.ufgov.gk.server.system.dao;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.model.AsOption;

public interface IAsOptionDao {
  public AsOption getAsOption(String optId);

  public AsOption getAsOptionByCoCode(String optId, String coCode);

  public List getAllAsOptionById(String optId);

  void updateOptionVal(AsOption asOption);

  public Map getFieldLevelOptions();

  public int getFieldLevel(String code, String codeValue);

  public AsOption getAsOptionById(String optId);
}

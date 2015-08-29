package com.ufgov.gk.server.system.service;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.model.AsOption;

public interface IAsOptionService {
  AsOption getAsOption(String optId);

  void updateOptionVal(AsOption asOption);

  Map getFieldLevelOptions();

  public List getAllAsOptionById(String optId);
}

package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IBalModeDao {
  List getBalMode(ElementConditionDto dto);

}

package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IForeignEntityDao {

  List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto);

}

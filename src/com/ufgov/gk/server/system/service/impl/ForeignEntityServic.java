package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.system.dao.IForeignEntityDao;
import com.ufgov.gk.server.system.service.IForeignEntityServic;

public class ForeignEntityServic implements IForeignEntityServic {
  private IForeignEntityDao foreignEntityDao;

  public IForeignEntityDao getForeignEntityDao() {
    return foreignEntityDao;
  }

  public void setForeignEntityDao(IForeignEntityDao foreignEntityDao) {
    this.foreignEntityDao = foreignEntityDao;
  }

  @Override
  public List getForeignEntitySelectedData(String sqlMapSelectedId, ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return foreignEntityDao.getForeignEntitySelectedData(sqlMapSelectedId, elementConditionDto);
  }
}

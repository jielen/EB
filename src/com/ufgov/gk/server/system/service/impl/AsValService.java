package com.ufgov.gk.server.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.server.system.dao.AsValsetDAO;
import com.ufgov.gk.server.system.dao.IAsValDao;
import com.ufgov.gk.server.system.service.IAsValService;
import com.ufgov.zc.common.system.model.AsValset;

public class AsValService implements IAsValService {
  private IAsValDao asValDao;

  private AsValsetDAO asValsetDao;

  public IAsValDao getAsValDao() {
    return asValDao;
  }

  public void setAsValDao(IAsValDao asValDao) {
    this.asValDao = asValDao;
  }

  /*
   * 获取值集，如果as_valset定义了val_sql，则根据sql语句获取值集；
   * 如果没有定义，则从as_val中获取值集
   * @see com.ufgov.gk.server.system.service.IAsValService#getAsVal(java.lang.String)
   */
  public List getAsVal(String valSetId) {
    AsValset valset = this.asValsetDao.selectByPrimaryKey(valSetId);
    if (valset != null) {
      List fromAsValset = this.asValsetDao.getAsValByValSql(valSetId, valset.getValSql());
      if (fromAsValset != null)
        return fromAsValset;
    }

    List fromAsVal = this.asValDao.getAsVal(valSetId);
    return fromAsVal;
  }

  public Map getAsValMap(String valSetId) {
    return this.asValDao.getAsValMap(valSetId);
  }

  public List getCompanyLevel(String sqlId) {
    return this.asValDao.getCompanyLevel(sqlId);
  }

  public AsValsetDAO getAsValsetDao() {
    return asValsetDao;
  }

  public void setAsValsetDao(AsValsetDAO asValsetDao) {
    this.asValsetDao = asValsetDao;
  }
}

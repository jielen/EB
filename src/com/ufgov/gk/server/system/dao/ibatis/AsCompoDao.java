package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.server.system.dao.IAsCompoDao;

public class AsCompoDao extends SqlMapClientDaoSupport implements IAsCompoDao {

  public AsCompo getAsCompo(String compoId) {
    return (AsCompo) this.getSqlMapClientTemplate().queryForObject("AsCompo.getAsCompoById", compoId);
  }

  public List getAllAsCompo() {
    return this.getSqlMapClientTemplate().queryForList("AsCompo.getAllAsCompo");
  }

  public void updateAsCompo(AsCompo asCompo) {
    this.getSqlMapClientTemplate().update("AsCompo.updateOrderField", asCompo);
  }

  public List getAsTabColForOrder(String tabName) {
    return this.getSqlMapClientTemplate().queryForList("AsCompo.getAsTabColForOrder", tabName);
  }
  
  public List getMaGkFuncCompo() {
    return this.getSqlMapClientTemplate().queryForList(
      "AsCompo.getGkFuncCompo");
  }

}

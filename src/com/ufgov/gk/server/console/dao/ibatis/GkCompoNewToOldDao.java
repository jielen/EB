package com.ufgov.gk.server.console.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.IGkCompoNewToOldDao;

public class GkCompoNewToOldDao extends SqlMapClientDaoSupport implements
  IGkCompoNewToOldDao {

  public List getGkCompoNewToOld() {
    return this.getSqlMapClientTemplate().queryForList(
      "GkCompoNewToOld.getGkCompoNewToOld");
  }

}

/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * 修订历史记录：
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  创建。
 * 
 */

package com.ufgov.gk.server.console.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.server.console.dao.IComponentDao;

public class ComponentDao extends SqlMapClientDaoSupport implements IComponentDao {

  public List getCompoList() {
    /*List compoList = this.getSqlMapClientTemplate().queryForList(
      "Compo.selectCompoList");*/
   return this.getSqlMapClientTemplate().queryForList("Component.selectCompoList");
     
  }
  public List getFunctionList(String compoId){
    return this.getSqlMapClientTemplate().queryForList("Component.selectFunctionList",compoId);  
  }
}

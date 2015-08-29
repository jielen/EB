/**
 * 
 */
package com.ufgov.gk.server.commonbiz.dao.ibatis;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.AsLog;
import com.ufgov.gk.server.commonbiz.dao.IBusinessLogDao;

public class BusinessLogDao extends SqlMapClientDaoSupport implements IBusinessLogDao {

  public void saveLog(AsLog log) {
   this.getSqlMapClientTemplate().insert("AsLog.saveLog",log);
    
  }
  
}

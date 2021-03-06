package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.system.Guid;
import com.ufgov.gk.server.commonbiz.dao.IGkTempDao;

public class GkTempDao extends SqlMapClientDaoSupport implements IGkTempDao {

  public String insert( final String[] values) {
    final String identifier=Guid.genID();
    
     this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < values.length; i++) {
          Map gkTemp = new HashMap();
          gkTemp.put("identifier", identifier);
          gkTemp.put("value", values[i]);
          executor.insert("GkTemp.insert", gkTemp);
        }
      executor.executeBatch();
      return  null;
      }
    });
   return identifier;
  }
}

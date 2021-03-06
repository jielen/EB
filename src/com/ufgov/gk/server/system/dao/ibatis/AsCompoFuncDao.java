package com.ufgov.gk.server.system.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.system.model.AsCompoFunc;
import com.ufgov.gk.server.system.dao.IAsCompoFuncDao;

public class AsCompoFuncDao extends SqlMapClientDaoSupport implements
  IAsCompoFuncDao {

  public List getAsCompoFunc(String compoId) {
    Map map = new HashMap();
    map.put("compoId", compoId);
    return this.getSqlMapClientTemplate().queryForList("AsCompoFunc.getAsCompoFunc",
      map);
  }

  public void updateAsCompoFunc(List asCompoFuncList) {
    final List list = asCompoFuncList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          AsCompoFunc as = (AsCompoFunc) list.get(i);
          executor.update("AsCompoFunc.updateAsCompoFunc", as);
        }
        executor.executeBatch();
        return null;
      }
    });
  }
}

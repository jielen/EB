package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.WfTaskGranter;
import com.ufgov.gk.server.commonbiz.dao.IWfTaskGranterDao;

public class WfTaskGranterDao extends SqlMapClientDaoSupport implements IWfTaskGranterDao{
  public List getWfTaskGranter(String userId){
    Map map = new HashMap();
    map.put("userId", userId);
    return this.getSqlMapClientTemplate().queryForList("WfTaskGranter.getWfTaskGranter",map);
  }

  public void insertWfTaskGranter(WfTaskGranter wfTaskGranter){
    this.getSqlMapClientTemplate().insert("WfTaskGranter.insertWfTaskGranter", wfTaskGranter);
  }

  public void deleteWfTaskGranter(String userId){
    Map map = new HashMap();
    map.put("grantedId", userId);
    this.getSqlMapClientTemplate().delete("WfTaskGranter.deleteWfTaskGranter", map);
  }
  public void updateWfTaskGranter(List grantList){
    final List list = grantList;

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          WfTaskGranter wfTaskGranter = (WfTaskGranter) list.get(i);
          executor.update("WfTaskGranter.updateWfTaskGranter", wfTaskGranter);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public void updateToRelieveWarrant(List grantList){
    final List list = grantList;

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          WfTaskGranter wfTaskGranter = (WfTaskGranter) list.get(i);
          executor.update("WfTaskGranter.updateToRelieveWarrant", wfTaskGranter);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

}

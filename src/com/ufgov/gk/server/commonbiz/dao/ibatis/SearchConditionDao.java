package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.model.UserSearchCondition;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.commonbiz.dao.ISearchConditionDao;

public class SearchConditionDao extends SqlMapClientDaoSupport implements ISearchConditionDao {

  public List getSearchCondition(String conditionId) {
    Map map = new HashMap();
    map.put("conditionId", conditionId);
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getSearchCondition", map);
  }

  public List getSearchTypeCondition(String conditionId, String conditionType) {
    Map map = new HashMap();
    map.put("conditionId", conditionId);
    map.put("conditionType", conditionType);
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getSearchCondition", map);
  }

  public List getCompoSearchCondition(String conditionType) {
    Map map = new HashMap();
    map.put("conditionType", conditionType);
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getCompoSearchCondition", map);
  }

  public List getUserSearchCondition(String conditionId, String userId) {
    Map params = new HashMap();
    params.put("conditionId", conditionId);
    params.put("userId", userId);
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getUserSearchCondition", params);
  }

  public List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta) {
    Map params = new HashMap();
    params.put("conditionId", conditionId);
    params.put("userId", userId);
    params.put("nd", new Integer(requestMeta.getSvNd()));
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getRoleSearchCondition", params);
  }

  public List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta) {
    Map params = new HashMap();
    params.put("conditionId", conditionId);
    params.put("userId", userId);
    params.put("nd", new Integer(requestMeta.getSvNd()));
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getUserSearchConditionJoinRole", params);
  }

  public List getUserDefaultValues(String conditionId, String userId) {
    Map params = new HashMap();
    params.put("conditionId", conditionId);
    params.put("userId", userId);
    return this.getSqlMapClientTemplate().queryForList("SearchCodition.getUserDefaultValue", params);
  }

  public void updateSearchCondition(List searchConditionList) {
    final List list = searchConditionList;
    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          SearchCondition searchCodition = (SearchCondition) list.get(i);
          executor.update("SearchCodition.updateSearchCondition", searchCodition);
        }
        executor.executeBatch();
        return null;
      }
    });
  }

  public void delete(String conditionId, String userId) {
    Map params = new HashMap();
    params.put("conditionId", conditionId);
    params.put("userId", userId);
    this.getSqlMapClientTemplate().delete("SearchCodition.deleteUserSearchCondition", params);
  }

  public void insert(List userSearchConditionList) {
    final List list = userSearchConditionList;

    this.getSqlMapClientTemplate().execute(new SqlMapClientCallback() {
      public Object doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
        executor.startBatch();
        for (int i = 0; i < list.size(); i++) {
          UserSearchCondition sc = (UserSearchCondition) list.get(i);
          executor.insert("SearchCodition.insertUserSearchCondition", sc);
        }
        executor.executeBatch();
        return null;
      }
    });

  }

}

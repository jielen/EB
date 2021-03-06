package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.UserSearchStore;
import com.ufgov.gk.server.commonbiz.dao.IMaSearchStoreDao;

public class MaSearchStoreDao extends SqlMapClientDaoSupport implements IMaSearchStoreDao {

  public void deleteSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().delete("UserSearchStore.deleteSearchStore", store);
  }

  public List getUserSearchStore(String userId, String conditionId, int nd) {
    // TODO Auto-generated method stub
    Map params = new HashMap();
    params.put("userId", userId);
    params.put("conditionId", conditionId);
    params.put("nd", new Integer(nd));
    return this.getSqlMapClientTemplate().queryForList("UserSearchStore.getUserSearchStore", params);
  }

  public void insertuserSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().insert("UserSearchStore.insertuserSearchStore", store);
  }

  public void updateUserSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().update("UserSearchStore.updateUserSearchStore", store);
  }

}

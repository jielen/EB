package com.ufgov.gk.server.system.dao.ibatis;

import java.util.HashMap;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.UserPreferences;
import com.ufgov.gk.server.system.dao.IUserPreferencesDao;

public class UserPreferencesDao extends SqlMapClientDaoSupport implements IUserPreferencesDao{

  public UserPreferences getUserPreferences(String userId, String preferId) {
    Map params = new HashMap();
    params.put("userId", userId);
    params.put("preferId", preferId);
    return (UserPreferences)this.getSqlMapClientTemplate().queryForObject("UserPreferences.getUserPreferences",params);
  }

  public void deleteUserPreferences(String userId, String preferId) {
    Map params = new HashMap();
    params.put("userId", userId);
    params.put("preferId", preferId);
    this.getSqlMapClientTemplate().delete("UserPreferences.deleteUserPreferences",params);
  }

  public void insertUserPreferences(UserPreferences userPreferences) {
    this.getSqlMapClientTemplate().insert("UserPreferences.insertUserPreferences",userPreferences);
  }

}

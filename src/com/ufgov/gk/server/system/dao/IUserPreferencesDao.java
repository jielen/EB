package com.ufgov.gk.server.system.dao;

import com.ufgov.gk.common.system.model.UserPreferences;

public interface IUserPreferencesDao {
  public UserPreferences getUserPreferences(String userId,String preferId);
  public void deleteUserPreferences(String userId,String preferId);
  public void insertUserPreferences(UserPreferences userPreferences);
}

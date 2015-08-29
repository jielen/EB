package com.ufgov.gk.server.system.service.impl;

import com.ufgov.gk.common.system.model.UserPreferences;
import com.ufgov.gk.server.system.dao.IUserPreferencesDao;
import com.ufgov.gk.server.system.service.IUserPreferencesService;

public class UserPreferencesService implements IUserPreferencesService{
  private IUserPreferencesDao userPreferencesDao;
  
  public IUserPreferencesDao getUserPreferencesDao() {
    return userPreferencesDao;
  }
  public void setUserPreferencesDao(IUserPreferencesDao userPreferencesDao) {
    this.userPreferencesDao = userPreferencesDao;
  }
  public UserPreferences getUserPreferences(String userId,String preferId){
    return userPreferencesDao.getUserPreferences(userId, preferId);
    
  }
  public void deleteUserPreferences(String userId,String preferId){
    userPreferencesDao.deleteUserPreferences(userId, preferId);
    
  }
  public void putUserPreferences(UserPreferences userPreferences){
    userPreferencesDao.deleteUserPreferences(userPreferences.getUserId(), userPreferences.getPreferId());
    userPreferencesDao.insertUserPreferences(userPreferences);
  }
  public void removeUserPreferences(UserPreferences userPreferences) {
    userPreferencesDao.deleteUserPreferences(userPreferences.getUserId(), userPreferences.getPreferId());
  }
}

package com.ufgov.gk.server.system.service;

import com.ufgov.gk.common.system.model.UserPreferences;

public interface IUserPreferencesService {
  public UserPreferences getUserPreferences(String userId, String preferId);

  public void deleteUserPreferences(String userId, String preferId);

  public void putUserPreferences(UserPreferences userPreferences);

  public void removeUserPreferences(UserPreferences userPreferences);
}

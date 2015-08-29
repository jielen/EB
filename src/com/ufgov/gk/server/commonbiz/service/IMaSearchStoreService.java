package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.model.UserSearchStore;

public interface IMaSearchStoreService {
  public List getUserSearchStore(String userId, String conditionId, int nd);

  public void updateUserSearchStore(UserSearchStore store);

  public void insertuserSearchStore(UserSearchStore store);

  public void deleteSearchStore(UserSearchStore store);
}

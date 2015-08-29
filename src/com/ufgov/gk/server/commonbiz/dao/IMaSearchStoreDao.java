package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.model.UserSearchStore;

public interface IMaSearchStoreDao {
  public List getUserSearchStore(String userId, String conditionId, int nd);

  public void updateUserSearchStore(UserSearchStore store);

  public void insertuserSearchStore(UserSearchStore store);

  public void deleteSearchStore(UserSearchStore store);
}

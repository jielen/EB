package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.model.UserSearchStore;
import com.ufgov.gk.server.commonbiz.dao.IMaSearchStoreDao;
import com.ufgov.gk.server.commonbiz.service.IMaSearchStoreService;

public class MaSearchStoreService implements IMaSearchStoreService {
  private IMaSearchStoreDao storeDao;

  public IMaSearchStoreDao getStoreDao() {
    return storeDao;
  }

  public void setStoreDao(IMaSearchStoreDao storeDao) {
    this.storeDao = storeDao;
  }

  public MaSearchStoreService() {
    super();
  }

  public void deleteSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.storeDao.deleteSearchStore(store);
  }

  public List getUserSearchStore(String userId, String conditionId, int nd) {
    // TODO Auto-generated method stub
    return this.storeDao.getUserSearchStore(userId, conditionId, nd);
  }

  public void insertuserSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.storeDao.insertuserSearchStore(store);
  }

  public void updateUserSearchStore(UserSearchStore store) {
    // TODO Auto-generated method stub
    this.storeDao.updateUserSearchStore(store);
  }

}

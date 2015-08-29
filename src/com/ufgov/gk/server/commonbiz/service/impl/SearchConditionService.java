package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.model.UserSearchCondition;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.commonbiz.dao.ISearchConditionDao;
import com.ufgov.gk.server.commonbiz.service.ISearchConditionService;

public class SearchConditionService implements ISearchConditionService {
  private ISearchConditionDao searchConditionDao;

  public ISearchConditionDao getSearchConditionDao() {
    return searchConditionDao;
  }

  public void setSearchConditionDao(ISearchConditionDao searchConditionDao) {
    this.searchConditionDao = searchConditionDao;
  }

  public List getSearchCondition(String conditionId) {
    return searchConditionDao.getSearchCondition(conditionId);
  }

  public List getSearchTypeCondition(String conditionId, String conditionType) {
    return searchConditionDao.getSearchTypeCondition(conditionId, conditionType);
  }

  public List getCompoSearchCondition(String conditionType) {
    return searchConditionDao.getCompoSearchCondition(conditionType);
  }

  public List getUserSearchCondition(String conditionId, String userId) {
    return searchConditionDao.getUserSearchCondition(conditionId, userId);
  }

  public List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta) {
    return searchConditionDao.getRoleSearchCondition(conditionId, userId, requestMeta);

  }

  public List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta) {
    return searchConditionDao.getUserSearchConditionJoinRole(conditionId, userId, requestMeta);

  }

  public void updateSearchCondition(List searchConditionList) {
    searchConditionDao.updateSearchCondition(searchConditionList);
  }

  public void deleteUserSearchCondition(String conditionId, String userId) {
    searchConditionDao.delete(conditionId, userId);
  }

  public void insertUserSearchCondition(List userSearchConditionList) {
    searchConditionDao.insert(userSearchConditionList);
  }

  public void updateUserSearchCondition(String userId, String conditionId, List searchConditionList) {

    searchConditionDao.delete(conditionId, userId);

    List list = new ArrayList();
    for (int i = 0; i < searchConditionList.size(); i++) {
      SearchCondition sc = (SearchCondition) searchConditionList.get(i);
      UserSearchCondition usc = new UserSearchCondition();
      usc.setUserId(userId);
      usc.setConditionId(sc.getConditionId());
      usc.setConditionFieldCode(sc.getConditionFieldCode());
      usc.setConditionFieldOrder(i);
      list.add(usc);
    }
    searchConditionDao.insert(list);

  }

}

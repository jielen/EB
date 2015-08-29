package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;

public interface ISearchConditionService {
  public List getSearchCondition(String conditionId);

  public List getUserSearchCondition(String conditionId, String userId);

  public List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta);

  public List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta);

  public void deleteUserSearchCondition(String conditionId, String userId);

  public void insertUserSearchCondition(List userSearchConditionList);

  public void updateUserSearchCondition(String userId, String conditionId, List searchConditionList);

  public List getCompoSearchCondition(String conditionType);

  public void updateSearchCondition(List searchConditionList);

  public List getSearchTypeCondition(String conditionId, String conditionType);

}

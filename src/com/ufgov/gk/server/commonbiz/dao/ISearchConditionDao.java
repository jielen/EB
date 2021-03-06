package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.RequestMeta;

public interface ISearchConditionDao {
  public List getSearchCondition(String conditionId);

  public List getSearchTypeCondition(String conditionId, String conditionType);

  public List getUserSearchCondition(String conditionId, String userId);

  public List getUserSearchConditionJoinRole(String conditionId, String userId, RequestMeta requestMeta);

  public List getUserDefaultValues(String conditionId, String userId);

  public void delete(String conditionId, String userId);

  public void insert(List userSearchConditionList);

  public List getCompoSearchCondition(String conditionType);

  public void updateSearchCondition(List searchConditionList);

  public List getRoleSearchCondition(String conditionId, String userId, RequestMeta requestMeta);
}

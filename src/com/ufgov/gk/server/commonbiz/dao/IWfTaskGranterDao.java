package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.WfTaskGranter;

public interface IWfTaskGranterDao {
  List getWfTaskGranter(String userId);
  void insertWfTaskGranter(WfTaskGranter wfTaskGranter);
  void deleteWfTaskGranter(String userId);
  void updateWfTaskGranter(List list);
  void updateToRelieveWarrant(List list);
}

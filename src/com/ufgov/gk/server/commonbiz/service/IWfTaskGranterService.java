package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.WfTaskGranter;

public interface IWfTaskGranterService {
  List getWfTaskGranter(String userid);
  void insertWfTaskGranter(WfTaskGranter wfTaskGranter);
  void deleteWfTaskGranter(String userId);
  void updateWfTaskGranter(List list);
  void updateToRelieveWarrant(List list);
  void cancelGrantedTask(String userId);
}

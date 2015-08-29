package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.system.model.AsNoRule;
import com.ufgov.gk.common.system.model.AsNumTool;
import com.ufgov.gk.common.system.model.AsNumToolNo;

public interface INumDao {

  AsNoRule getAsNoRule(String compoId, String noField);

  AsNoRule getAsNoRuleByCompoId(String compoId);

  List getAsNoRuleSeg(String compoId, String ruleCode);

  AsNumTool getAsNumTool(String numToolId);

  List getAsNumToolNo(String numToolId, String altPrefix, String fixPrefix);

  AsNumToolNo insertAsNumToolNo(AsNumToolNo asNumToolNo);

  int incNumNo(String numToolId, String altPrefix, String fixPrefix);

  int updateNumNo(int numNo, String numToolId, String altPrefix, String fixPrefix);

  int updateAsNo(String compoId, String fixPrefix);

  void insertAsNo(String compoId, String fixPrefix);

  Long getAsNoCurIndex(String compoId, String fixPrefix);
}

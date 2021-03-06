package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;

import com.ufgov.gk.common.console.model.GkGetdataRule;

public interface IGkGetdataRuleDao {
  public List getGkGetdataRule();

  public void updateGkGetdataRule(List gkGetdataRuleList);

  public GkGetdataRule getGkGetDataRuleById(String ruleId);
  
  public GkGetdataRule getGkGetDataRule(String ruleId);

}

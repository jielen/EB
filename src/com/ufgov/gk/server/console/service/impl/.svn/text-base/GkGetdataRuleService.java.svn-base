package com.ufgov.gk.server.console.service.impl;

import java.util.List;

import com.ufgov.gk.common.console.model.GkGetdataRule;
import com.ufgov.gk.server.commonbiz.dao.IGkGetdataRuleDao;
import com.ufgov.gk.server.console.service.IGkGetdataRuleService;

public class GkGetdataRuleService implements IGkGetdataRuleService {
  private IGkGetdataRuleDao gkGetdataRuleDao;

  public List getGkGetdataRule() {
    return gkGetdataRuleDao.getGkGetdataRule();
  }

  public GkGetdataRule getGkGetDataRuleById(String ruleId) {
    return gkGetdataRuleDao.getGkGetDataRuleById(ruleId);
  }
  
  public GkGetdataRule getGkGetDataRule(String ruleId) {
    return gkGetdataRuleDao.getGkGetDataRule(ruleId);
  }

  public void updateGkGetdataRule(List gkGetdataRuleList) {
    gkGetdataRuleDao.updateGkGetdataRule(gkGetdataRuleList);
  }

  public IGkGetdataRuleDao getGkGetdataRuleDao() {
    return gkGetdataRuleDao;
  }

  public void setGkGetdataRuleDao(IGkGetdataRuleDao gkGetdataRuleDao) {
    this.gkGetdataRuleDao = gkGetdataRuleDao;
  }

}

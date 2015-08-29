package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.Map;

import com.ufgov.gk.server.commonbiz.service.IMacpRuleDetailService;
import com.ufgov.gk.server.system.dao.IMacpRuleDetailDao;

public class MacpRuleDetailService implements IMacpRuleDetailService {
  private IMacpRuleDetailDao macpRuleDetailDao;
  
  public IMacpRuleDetailDao getMacpRuleDetailDao() {
    return macpRuleDetailDao;
  }

  public void setMacpRuleDetailDao(IMacpRuleDetailDao macpRuleDetailDao) {
    this.macpRuleDetailDao = macpRuleDetailDao;
  }

  public Map getMacpRuleDetail(Map params) {
    // TODO Auto-generated method stub
    return macpRuleDetailDao.getMacpRuleDetail(params);
  }
  
}

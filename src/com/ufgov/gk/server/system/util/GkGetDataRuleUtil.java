package com.ufgov.gk.server.system.util;

import com.ufgov.gk.common.console.model.GkGetdataRule;
import com.ufgov.gk.server.commonbiz.dao.IGkGetdataRuleDao;
import com.ufgov.gk.server.system.SpringContext;

public class GkGetDataRuleUtil {
  private IGkGetdataRuleDao gkGetdataRuleDao = (IGkGetdataRuleDao) SpringContext.getBean("gkGetdataRuleDao");

  private static GkGetDataRuleUtil gkGetDataRuleUtil = new GkGetDataRuleUtil();

  private GkGetDataRuleUtil() {

  }

  public static synchronized GkGetDataRuleUtil getInstance() {
    return gkGetDataRuleUtil;
  }

  public String getDataRuleCondiStr(String ruleId) {
    String result = null;
    if (ruleId != null && ruleId.length() > 0) {
      GkGetdataRule GkGetDataRule = gkGetdataRuleDao.getGkGetDataRuleById(ruleId);
      if (GkGetDataRule != null) {
        String ruleSqlOracle = GkGetDataRule.getRuleSqlOracle();
        if (ruleSqlOracle != null && ruleSqlOracle.trim().length() > 0) {
          result = " ( " + ruleSqlOracle + " ) ";
        }
      }
    }
    return result;
  }
}

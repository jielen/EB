package com.ufgov.gk.server.system.util;

import com.ufgov.gk.common.system.model.AsOption;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IAsOptionDao;

public class AsOptionUtil {

  private IAsOptionDao asOptionDao = (IAsOptionDao) SpringContext.getBean("asOptionDao");

  private static AsOptionUtil asOptionUtil;

  private AsOptionUtil() {
  }

  public AsOption getOption(String optionId) {
    return asOptionDao.getAsOption(optionId);
  }

  public AsOption getOptionById(String optionId) {
    return asOptionDao.getAsOptionById(optionId);
  }

  public String getOptionVal(String optionId) {
    String val = "";
    AsOption asOption = this.getOption(optionId);
    if (asOption != null) {
      val = asOption.getOptVal();
    }
    return val;
  }

  public synchronized static AsOptionUtil getInstance() {
    if (asOptionUtil == null) {
      asOptionUtil = new AsOptionUtil();
    }
    return asOptionUtil;
  }

}

package com.ufgov.gk.server.system.service.impl;

import com.ufgov.gk.server.system.service.INumService;
import com.ufgov.gk.server.system.util.NumUtil;

public class NumService implements INumService{
  public String getNo(String compoId, String noField, Object bill) {
    return NumUtil.getInstance().getNo(compoId, noField, bill);
  }
}

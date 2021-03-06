package com.ufgov.gk.server.system.util;

import java.util.Iterator;
import java.util.List;

import com.ufgov.gk.common.system.model.AsVal;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IAsValDao;

public class AsValDataUtil {
  private IAsValDao asValDao = (IAsValDao) SpringContext.getBean("asValDao");

  private static AsValDataUtil asValDataUtil;

  public List getAsVal(String valSetId) {
    return asValDao.getAsVal(valSetId);
  }

  public String getName(String valSetId, String valId) {
    String name = "";
    List list = getAsVal(valSetId);
    for (Iterator iterator = list.iterator(); iterator.hasNext();) {
      AsVal av = (AsVal) iterator.next();
      if (av.getValId() != null && av.getValId().equals(valId)) {
        name = av.getVal();
      }
    }
    return name;
  }

  public synchronized static AsValDataUtil getInstance() {
    if (asValDataUtil == null) {
      asValDataUtil = new AsValDataUtil();
    }
    return asValDataUtil;
  }

}

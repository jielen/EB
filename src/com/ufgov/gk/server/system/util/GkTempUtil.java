package com.ufgov.gk.server.system.util;

import java.util.List;

import com.ufgov.gk.server.commonbiz.dao.IGkTempDao;
import com.ufgov.gk.server.system.SpringContext;

public class GkTempUtil {

  private IGkTempDao gkTempDao = (IGkTempDao) SpringContext.getBean("gkTempDao");

  private static GkTempUtil util = new GkTempUtil();

  private GkTempUtil() {
  }
  public static synchronized GkTempUtil getInstance() {
    return util;
  }

  public String insert(String[] values){
    return gkTempDao.insert(values);
  }
  /**
   * 
   * @param stringList 必须是String数组
   * 
   * @return
   */
  public String insert(List stringList){
    return gkTempDao.insert((String[])stringList.toArray());
  }

}

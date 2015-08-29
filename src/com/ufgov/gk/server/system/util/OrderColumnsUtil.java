package com.ufgov.gk.server.system.util;

import com.ufgov.gk.common.system.model.AsCompo;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.dao.IAsCompoDao;

public class OrderColumnsUtil {
  
  private IAsCompoDao asCompoDao = (IAsCompoDao) SpringContext.getBean("asCompoDao");

  private static OrderColumnsUtil orderColumnsUtil = new OrderColumnsUtil();
  
  private OrderColumnsUtil(){
    
  }
  public static synchronized OrderColumnsUtil getInstance() {
    return orderColumnsUtil;
  }
  public String getOrderColumns(String compoId){
    
    String orderColumns=null;
    AsCompo asCompo=asCompoDao.getAsCompo(compoId);
    if(asCompo!=null){
      orderColumns=asCompo.getOrderColumns();
    }
    return orderColumns;
  }
}

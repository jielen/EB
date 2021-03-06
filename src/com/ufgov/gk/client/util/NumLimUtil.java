package com.ufgov.gk.client.util;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;

public class NumLimUtil {

  private static NumLimUtil numLimUtil = new NumLimUtil();

  private IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
    IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  private NumLimUtil() {
   
  }

  public static synchronized NumLimUtil getInstance() {
    return numLimUtil;
  }

  /**
   * 根据单位类型返回数值权限信息
   * @param numLimCompoId 数值权限部件id
   * @param funcId 功能id 如fwatch
   * @return
   */
  public String getNumLimCondByCoType(String numLimCompoId, String funcId) {
    return getNumLimCondByCoType(numLimCompoId, funcId, null);
  }

  /**
   * 根据单位类型返回数值权限信息
   * @param numLimCompoId 数值权限部件id
   * @param funcId 功能id 如fwatch
   * @param ctrlField 控制字段 如对co_cod控制
   * @return
   */

  public String getNumLimCondByCoType(String numLimCompoId, String funcId, String ctrlField) {
     RequestMeta requestMeta =WorkEnv.getInstance().getRequestMeta();
    return this.baseDataServiceDelegate.getNumLimCondByCoType(numLimCompoId, funcId, ctrlField, requestMeta);
  }
  public  static void main(String[] args){
    
    System.out.println(NumLimUtil.getInstance().getNumLimCondByCoType("AM_PAFPV","fwatch"));
    System.out.println("|"+NumLimUtil.getInstance().getNumLimCondByCoType("AM_PAFPV","fwatch","CO_CODE")+"|");
    
  }
}

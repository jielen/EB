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
   * ���ݵ�λ���ͷ�����ֵȨ����Ϣ
   * @param numLimCompoId ��ֵȨ�޲���id
   * @param funcId ����id ��fwatch
   * @return
   */
  public String getNumLimCondByCoType(String numLimCompoId, String funcId) {
    return getNumLimCondByCoType(numLimCompoId, funcId, null);
  }

  /**
   * ���ݵ�λ���ͷ�����ֵȨ����Ϣ
   * @param numLimCompoId ��ֵȨ�޲���id
   * @param funcId ����id ��fwatch
   * @param ctrlField �����ֶ� ���co_cod����
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

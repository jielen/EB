package com.ufgov.gk.common.commonbiz.fieldmap;

import java.util.HashMap;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class FieldMapRegister {
  private static Map register = new HashMap();
  static {
    register.put(BaseBill.class.getName(), BaseBillFM.fieldMap);

    ///////////////////////////////////////////////////////////////////////

  }

  public static Map get(Class clazz) {
    Map fieldMap = (Map) register.get(clazz.getName());
    /*    if (fieldMap == null && BaseBill.class.isAssignableFrom(clazz)) {
          fieldMap = (Map) register.get(BaseBill.class.getName());
        }else if(fieldMap == null && ZcBaseBill.class.isAssignableFrom(clazz)){
          fieldMap = (Map) register.get(BaseBill.class.getName());
        }*/
    if (fieldMap == null) {
      throw new RuntimeException("û���ҵ�" + clazz.getName() + "��Ӧ��FieldMap,��FieldMapRegisterû��ע��.");
    }
    return fieldMap;
  }
}

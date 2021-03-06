package com.ufgov.gk.client.common;

import java.math.BigDecimal;
import java.util.List;

import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class ValidateBeforeSave {

  /**
   * 校验要素字段
   * @param notNullField
   * @param obj
   * @return true 校验失败
   */
  public static String validateBillElementNull(String product, List notNullField, BaseBill bill) {
    String elementCode = null;
    StringBuffer returnInfo = new StringBuffer();
    for (int i = 0; i < notNullField.size(); i++) {
      elementCode = (String) notNullField.get(i);
      Object result = null;
      String fieldName = (String) FieldMapRegister.get(bill.getClass()).get(elementCode);
      if(fieldName==null){
        throw new RuntimeException("没有找到"+elementCode+"对应的属性.");
      }
      result = bill.get(fieldName);
      String transId = product + "_FIELD_" + elementCode.replaceAll("_CODE", "_NAME");
      String resName = LangTransMeta.translate(transId);

      if (result == null || result.toString().trim().equals("")) {
        returnInfo.append(resName);
        returnInfo.append("不允许为空！\n");
      } else {
        if (result instanceof BigDecimal) {
          if (((BigDecimal) result).signum() == 0) {
            returnInfo.append(resName);
            returnInfo.append("不能为零！\n");
          }
        } else if (result instanceof Integer) {
          if (((Integer) result).intValue() == 0) {
            returnInfo.append(resName);
            returnInfo.append("不能为零！\n");
          }
        }
      }
    }
    return returnInfo.toString();
  }
}

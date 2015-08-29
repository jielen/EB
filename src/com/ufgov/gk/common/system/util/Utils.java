package com.ufgov.gk.common.system.util;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;

public class Utils {
  /**
   * 
   * @param n
   * @param m ȡ��λ��  1 ȡ������λ��10 ȡ����ʮλ
   */
  public static BigDecimal round(BigDecimal n,int m){
    
     BigDecimal a=n.divide(new BigDecimal(m),0,BigDecimal.ROUND_FLOOR);
   
     return a.multiply(new BigDecimal(m));
  }
  
  public static String getDBColNameByFieldName(Object bill,String fieldName){
    Map fieldMap = FieldMapRegister.get(bill.getClass());
    Iterator it=fieldMap.keySet().iterator();
    String colName=null;
    while(it.hasNext()){
      String key=(String)it.next();
      if(fieldName.equals(fieldMap.get(key))){
        colName= key;
        break;
      }
    }
    if(colName!=null){
      return colName;
    }else{
      return convertFieldToColumn(fieldName);
      //throw new RuntimeException("û���ҵ���"+fieldName+"��Ӧ������");
    }
  }

  public static String convertFieldToColumn(String inField) {
    String field = "";
    for (int i = 0; i < inField.length(); i++) {
      char c = inField.charAt(i);
      if (Character.isUpperCase(c)) {
        field = field.concat("_" + String.valueOf(c));
      } else {
        field = field.concat(String.valueOf(c));
      }
    }
    return field.toUpperCase();
  }
  
}

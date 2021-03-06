package com.ufgov.gk.server.system.print;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.util.DateUtil;

public class PrintDataConverter {

  public static Map toDataMap2(Object bill) {
    Map dataMap = new HashMap();
    if (bill != null) {
      Map fieldMap = FieldMapRegister.get(bill.getClass());
      Set keySet = fieldMap.keySet();
      Iterator it = keySet.iterator();

      while (it.hasNext()) {
        String tableFieldName = (String) it.next();
        String objectFieldName = (String) fieldMap.get(tableFieldName);
        dataMap.put(tableFieldName, objectToString(BeanUtil.get(objectFieldName, bill)));
      }
    }
    return dataMap;
  }

  public static Map toDataMap(HashMap bill) {
    Map dataMap = new HashMap();
    if (bill != null) {
      Set keySet = bill.keySet();
      Iterator it = keySet.iterator();
      while (it.hasNext()) {
        String key = (String) it.next();
        Object v = bill.get(key);
        dataMap.put(key.toUpperCase(), objectToString(v));
      }
    }
    return dataMap;
  }

  public static Map toDataMap(Object bill) {
    if (bill instanceof HashMap) {
      return toDataMap((HashMap) bill);
    } else {
      return toDataMap2(bill);
    }
  }

  public static List toDataList(List billList) {
    ArrayList printRecordList = new ArrayList();
    for (int i = 0; i < billList.size(); i++) {
      Object bill = billList.get(i);
      Map recordMap = toDataMap(bill);
      recordMap.put(PrintConstants.RECORD_ID, "" + i);
      printRecordList.add(recordMap);
    }
    return printRecordList;
  }

  private static NumberFormat nfmt = new DecimalFormat("#.00");

  private static String objectToString(Object value) {
    if (value == null) {
      return null;
    }
    String result = null;
    if (value instanceof java.util.Date) {
      result = DateUtil.dateToDdString((java.util.Date) value);
    } else if (value instanceof BigDecimal) {
      result = nfmt.format(((BigDecimal) value));
    } else {
      result = value + "";
    }
    return result;
  }

}

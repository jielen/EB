package com.ufgov.gk.client.component.ui.conditionitem;

import java.util.HashMap;
import java.util.Map;

public class ConditionFieldConstants {

  public final static String TEXT_0 = "TEXT_0";

  public final static String TEXT_1 = "TEXT_1";

  public final static String TEXT_2 = "TEXT_2";

  public final static String TEXT_3 = "TEXT_3";

  public final static String TEXT_4 = "TEXT_4";

  public static Map<String, String> elementMap = new HashMap<String, String>();

  static {
    elementMap.put("DP_ORIGIN_CODE", "ORIGIN_CODE");
    elementMap.put("DP_MANAGE_CODE", "MANAGE_CODE");
    elementMap.put("DP_PAYTYPE_CODE", "PAYTYPE_CODE");
  }

  public static String getElementCode(String fieldCode) {
    String temp = fieldCode;
    if (elementMap.get(fieldCode) != null) {
      temp = elementMap.get(fieldCode);
    }
    return temp;
  }

}

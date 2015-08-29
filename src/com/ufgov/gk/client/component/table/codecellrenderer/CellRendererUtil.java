package com.ufgov.gk.client.component.table.codecellrenderer;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class CellRendererUtil {
  private static String showType = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_CODE_NAME_SHOW_TYPE);

  public static String getName(String code, String name) {
    if ("1".equals(showType)) {
      return "[" + code + "]" + name;
    } else if ("2".equals(showType)) {
      return name + "[" + code + "]";
    } else {
      return name;
    }
  }
}

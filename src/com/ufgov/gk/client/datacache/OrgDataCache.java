package com.ufgov.gk.client.datacache;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.model.Fund;
import com.ufgov.gk.common.commonbiz.model.Org;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class OrgDataCache {

  private static List dataList;

  private static Map dataMap;

  private static String showType = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_CODE_NAME_SHOW_TYPE);

  private static void getData() {
    if (dataList == null) {
      refreshData();
    }
  }

  public static synchronized void refreshData() {

    int nd = WorkEnv.getInstance().getTransNd();
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    dataList = Collections.unmodifiableList(Util.baseDataServiceDelegate.getZcOrg(nd, requestMeta));

    Map tempMap = new HashMap();
    for (Object o : dataList) {
      Org temp = (Org) o;
      tempMap.put(temp.getCode(), temp);
    }
    dataMap = Collections.unmodifiableMap(tempMap);
  }

  public static List getOrg() {
    getData();
    return dataList;
  }

  public static String getName(String code) {
    getData();
    Org value = (Org) dataMap.get(code);
    if (value != null) {
      return value.getName();
    }
    return code;
  }

  public static Org getBean(String code) {
    getData();
    Org value = (Org) dataMap.get(code);
    return value;
  }

}

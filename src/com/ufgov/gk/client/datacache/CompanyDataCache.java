package com.ufgov.gk.client.datacache;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.model.Company;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class CompanyDataCache {

  private static List dataList;

  private static Map dataMap;

  private static String showType = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_CODE_NAME_SHOW_TYPE);

  public static synchronized void refreshData() {
    int nd = WorkEnv.getInstance().getTransNd();

    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    ElementConditionDto dto = new ElementConditionDto();
    dto.setNd(nd);
    dataList = Collections.unmodifiableList(Util.baseDataServiceDelegate.getCompany(dto, requestMeta));

    Map tempMap = new HashMap();
    for (Object o : dataList) {
      Company company = (Company) o;
      tempMap.put(company.getCode(), company);
    }
    dataMap = Collections.unmodifiableMap(tempMap);
  }

  private static void getData() {
    if (dataList == null) {
      refreshData();
    }
  }

  public static List getCompany() {
    getData();
    return dataList;
  }

  public static String getName(String code) {
    getData();
    Company value = (Company) dataMap.get(code);
    if (value != null) {
      if ("1".equals(showType)) {
        return "[" + code + "]" + value.getName();
      } else if ("2".equals(showType)) {
        return value.getName() + "[" + code + "]";
      } else {
        return value.getName();
      }
    }
    return code;
  }

  public static String getNameByCode(String code) {
    getData();
    Company value = (Company) dataMap.get(code);
    if (value != null) {
      return value.getName();
    }
    return code;
  }

  public static Company getBean(String code) {
    getData();
    Company company = (Company) dataMap.get(code);
    return company;
  }

}

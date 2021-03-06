package com.ufgov.gk.server.system.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.RequestMeta;

public class Util {

  public static Map createKeyListMap(String keyFieldName,List beanList){
    Map subMap = new HashMap();
    for (int i = 0; i < beanList.size(); i++) {
      Object subBill =  beanList.get(i);
      List list = (List) subMap.get(BeanUtil.get(keyFieldName, subBill));
      if (list == null) {
        list = new ArrayList();
        subMap.put(BeanUtil.get(keyFieldName, subBill), list);
      }
      list.add(subBill);
    }
    return subMap;
  }

  public static  String handleSv(String condition) {
    if (condition == null) {
      return null;
    }
    String svNd=RequestMetaUtil.getSvNd()+"";
    String svCoCode=RequestMetaUtil.getSvCoCode();
    String svOrgCode=RequestMetaUtil.getSvOrgCode();
    String svUserID=RequestMetaUtil.getSvUserID();
    String svPoCode=RequestMetaUtil.getSvPoCode();
    String svOrgPoCode=RequestMetaUtil.getSvOrgPoCode();
    String svAccountId=RequestMetaUtil.getSvAccountId();
    String prefix="@@";
    condition = condition.replaceAll(prefix+"[Ss][Vv][Nn][Dd]", svNd);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Cc][Oo][Cc][Oo][Dd][Ee]", svCoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Cc][Oo][Dd][Ee]", svOrgCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Uu][Ss][Ee][Rr][Ii][Dd]", svUserID);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Pp][Oo][Cc][Oo][Dd][Ee]", svPoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Pp][Oo][Cc][Oo][Dd][Ee]", svOrgPoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Aa][Cc][Cc][Oo][Uu][Nn][Tt][Ii][Dd]", svAccountId);

    return condition;
  }
  
  public static  String handleSv(String condition, RequestMeta meta) {
    if (condition == null) {
      return null;
    }
    String svNd=meta.getSvNd()+"";
    String svCoCode=meta.getSvCoCode();
    String svOrgCode=meta.getSvOrgCode();
    String svUserID=meta.getSvUserID();
    String svPoCode=meta.getSvPoCode();
    String svOrgPoCode=meta.getSvOrgPoCode();
    String svAccountId=meta.getAccountId();
    String prefix="@@";
    condition = condition.replaceAll(prefix+"[Ss][Vv][Nn][Dd]", svNd);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Cc][Oo][Cc][Oo][Dd][Ee]", svCoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Cc][Oo][Dd][Ee]", svOrgCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Uu][Ss][Ee][Rr][Ii][Dd]", svUserID);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Pp][Oo][Cc][Oo][Dd][Ee]", svPoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Oo][Rr][Gg][Pp][Oo][Cc][Oo][Dd][Ee]", svOrgPoCode);
    condition = condition.replaceAll(prefix+"[Ss][Vv][Aa][Cc][Cc][Oo][Uu][Nn][Tt][Ii][Dd]", svAccountId);

    return condition;
  }

}

package com.ufgov.gk.client.datacache;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsVal;

public class AsValDataCache {

  private static Map<String,Map> dataMap = new HashMap<String,Map> ();
  
  private static Map<String ,List> dataListMap = new HashMap<String,List>();

  public static List getAsVal(String valSetId){
    List dataList=dataListMap.get(valSetId);
    if(dataList==null){
      RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
      dataList = Collections.unmodifiableList(Util.baseDataServiceDelegate.getAsVal(valSetId,requestMeta));
      dataListMap.put(valSetId, dataList);
      dataMap.put(valSetId,createAsValMap(dataList) );
    }
    return dataList;
  }
  
  private static Map<String,AsVal> createAsValMap(List dataList){
    Map<String,AsVal> dataMap = new HashMap<String,AsVal>();
    for(Object o:dataList){
      AsVal av= (AsVal)o;
      dataMap.put(av.getValId(),av);
    }
    return dataMap;
  }
  
  public static String getName(String valSetId ,String valId){
    getAsVal( valSetId);
    Map<String,AsVal> value=(Map<String,AsVal>)dataMap.get(valSetId);
    String name="";
    if(value!=null){
     AsVal av =value.get(valId);
     if(av!=null){
       name=av.getVal();
     }
    }
    return name;
  }
}

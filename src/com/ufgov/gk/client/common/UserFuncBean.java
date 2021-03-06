package com.ufgov.gk.client.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.common.system.model.UserFunc;

public class UserFuncBean {

  private static List userFuncList = new ArrayList();

  private static Map<String, String> register = new HashMap<String, String>();

  private static IBaseDataServiceDelegate baseDataServiceDelegate;

  public synchronized static boolean isGrant(UserFunc userFunc) {
    
    String key=userFunc.getUserId() + userFunc.getCompoId();
   
    if (register.get(key) == null) {

      baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
        IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
      
      WorkEnv workEnv = WorkEnv.getInstance();
      RequestMeta requestMeta = workEnv.getRequestMeta();

      UserFuncDto userFuncDto = new UserFuncDto();

      userFuncDto.setUserId(workEnv.getCurrUserId());
      userFuncDto.setCompoId(userFunc.getCompoId());
      userFuncDto.setCoCode(workEnv.getCurrCoCode());
      userFuncDto.setOrgCode(workEnv.getOrgCode());
      userFuncDto.setPosiCode(workEnv.getPoCode());

      userFuncList.addAll(baseDataServiceDelegate.getUserGrantFunc(userFuncDto,
        requestMeta));
      
      register.put(key, key);
    }

    if (userFuncList.contains(userFunc)) {
      return true;
    }
    return false;

  }

}

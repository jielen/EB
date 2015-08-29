package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.system.dto.UserFuncDto;

public interface IUserFuncDao {
  
   List getUserGrantFunc(UserFuncDto userFuncDto);
   List getUsedCompoFunc(String compoId);

}

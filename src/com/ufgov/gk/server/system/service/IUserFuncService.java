package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.system.dto.UserFuncDto;

public interface IUserFuncService {
  
  List getUserGrantFunc(UserFuncDto userFuncDto);
  List getUsedCompoFunc(String compoId);

}

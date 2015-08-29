package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.dto.UserFuncDto;
import com.ufgov.gk.server.system.dao.IUserFuncDao;
import com.ufgov.gk.server.system.service.IUserFuncService;

public class UserFuncService implements IUserFuncService {
	private IUserFuncDao userFuncDao ;

  public IUserFuncDao getUserFuncDao() {
    return userFuncDao;
  }

  public void setUserFuncDao(IUserFuncDao userFuncDao) {
    this.userFuncDao = userFuncDao;
  }

  public List getUserGrantFunc(UserFuncDto userFuncDto) {
    return userFuncDao.getUserGrantFunc(userFuncDto);
  }

  public List getUsedCompoFunc(String compoId) {
    return userFuncDao.getUsedCompoFunc(compoId);
  }

}

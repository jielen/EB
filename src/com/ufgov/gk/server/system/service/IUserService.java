package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.Position;
import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.console.model.AsUserGroup;
import com.ufgov.gk.common.console.model.SysEmp;
import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.model.User;

public interface IUserService {

  User getUserById(String userId);

  void addUser(User user, String coCode, String orgCode, String posiCode, String groupId, String nd);

  void addAsEmp(AsEmp asEmp);

  void addAsEmpPosition(Position posi);

  void addAsUserGroup(AsUserGroup ug);

  SysEmp getSysEmp(String userId, String nd);

  void deleteAndInsertSysEmp(SysEmp sysEmp, String nd) throws BusinessException;

  void updateAsEmpLogin(String userId, boolean isAllowLogin) throws BusinessException;

  public List getEmpByCaSerial(AsEmp asEmp);

  public int updateEmpCaSerial(AsEmp asEmp) throws BusinessException;

}

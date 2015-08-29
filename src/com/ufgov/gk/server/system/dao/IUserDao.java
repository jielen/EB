package com.ufgov.gk.server.system.dao;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.Position;
import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.console.model.AsUserGroup;
import com.ufgov.gk.common.system.model.User;

public interface IUserDao {

  User getUserById(String userId);

  void insertUser(User user);

  void deleteUserById(String userId);

  AsEmp getAsEmpByUserId(String userId);

  void insertAsEmp(AsEmp asEmp);

  void insertAsEmpForDataExchange(AsEmp asEmp);

  void deleteAsEmpByUserId(String userId);

  List getAsEmpPosiByEmpCode(Map map);

  void insertAsEmpPosition(Position posi);

  void deleteAsEmpPosiByEmpCode(Map map);

  List getAsUserGroupByUserId(String userId);

  void insertAsUserGroup(AsUserGroup ug);

  void deleteAsUserGroupByUserId(String userId);

  int updateAsEmpLogin(AsEmp asEmp);

  public List getEmpByCaSerial(AsEmp asEmp);

  public int updateEmpCaSerial(AsEmp asEmp);
}

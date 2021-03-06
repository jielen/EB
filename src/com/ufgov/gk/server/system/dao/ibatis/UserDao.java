package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.commonbiz.model.Position;
import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.console.model.AsUserGroup;
import com.ufgov.gk.common.system.model.User;
import com.ufgov.gk.server.system.dao.IUserDao;

public class UserDao extends SqlMapClientDaoSupport implements IUserDao {

  public User getUserById(String userId) {
    return (User) this.getSqlMapClientTemplate().queryForObject("User.getUserById", userId);
  }

  public void insertUser(User user) {
    this.getSqlMapClientTemplate().insert("User.insertUser", user);
  }

  public void deleteUserById(String userId) {
    this.getSqlMapClientTemplate().delete("User.deleteUserById", userId);
  }

  public AsEmp getAsEmpByUserId(String userId) {
    return (AsEmp) this.getSqlMapClientTemplate().queryForObject("User.getAsEmpByUserId", userId);
  }

  public void insertAsEmp(AsEmp asEmp) {
    this.getSqlMapClientTemplate().insert("User.insertAsEmp", asEmp);
  }

  public void insertAsEmpForDataExchange(AsEmp asEmp) {
    this.getSqlMapClientTemplate().insert("User.insertAsEmpForDataExchange", asEmp);
  }

  public int updateAsEmpLogin(AsEmp asEmp) {
    return this.getSqlMapClientTemplate().update("User.updateAsEmpLogin", asEmp);
  }

  public void deleteAsEmpByUserId(String userId) {
    this.getSqlMapClientTemplate().delete("User.deleteAsEmpByUserId", userId);
  }

  public List getAsEmpPosiByEmpCode(Map map) {
    return (List) this.getSqlMapClientTemplate().queryForList("User.getAsEmpPosiByEmpCode", map);
  }

  public void insertAsEmpPosition(Position posi) {
    this.getSqlMapClientTemplate().insert("User.insertAsEmpPosition", posi);
  }

  public void deleteAsEmpPosiByEmpCode(Map map) {
    this.getSqlMapClientTemplate().delete("User.deleteAsEmpPosiByEmpCode", map);
  }

  public List getAsUserGroupByUserId(String userId) {
    return (List) this.getSqlMapClientTemplate().queryForList("User.getAsUserGroupByUserId", userId);
  }

  public void insertAsUserGroup(AsUserGroup ug) {
    this.getSqlMapClientTemplate().insert("User.insertAsUserGroup", ug);
  }

  public void deleteAsUserGroupByUserId(String userId) {
    this.getSqlMapClientTemplate().delete("User.deleteAsUserGroupByUserId", userId);
  }

  public List getEmpByCaSerial(AsEmp asEmp) {
    return this.getSqlMapClientTemplate().queryForList("User.getEmpByCaSerial", asEmp);
  }

  public int updateEmpCaSerial(AsEmp asEmp) {
    return this.getSqlMapClientTemplate().update("User.updateEmpCaSerial", asEmp);
  }

}

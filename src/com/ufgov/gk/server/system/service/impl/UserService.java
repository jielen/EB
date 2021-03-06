package com.ufgov.gk.server.system.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.anyi.gp.pub.GeneralFunc;
import com.ufgov.gk.common.commonbiz.model.Position;
import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.console.model.AsUserGroup;
import com.ufgov.gk.common.console.model.SysEmp;
import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.model.User;
import com.ufgov.gk.server.system.dao.IUserDao;
import com.ufgov.gk.server.system.service.IUserService;

public class UserService implements IUserService {
  private IUserDao userDao;

  public IUserDao getUserDao() {
    return userDao;
  }

  public void setUserDao(IUserDao userDao) {
    this.userDao = userDao;
  }

  public User getUserById(String userId) {
    return userDao.getUserById(userId);
  }

  public void addUser(User user, String coCode, String orgCode, String posiCode, String groupId, String nd) {
    this.userDao.insertUser(user);
    AsEmp asEmp = new AsEmp();
    asEmp.setEmpCode(user.getUserId());
    asEmp.setEmpName(user.getUserName());
    asEmp.setUserId(user.getUserId());
    this.addAsEmp(asEmp);
    Position posi = new Position();
    posi.setEmpCode(asEmp.getEmpCode());
    posi.setCoCode(coCode);
    posi.setOrgCode(orgCode);
    posi.setPosiCode(posiCode);
    posi.setEmpPosiId(asEmp.getEmpCode() + posi.getOrgCode() + posi.getPosiCode());
    posi.setNd(Integer.parseInt(nd));
    this.addAsEmpPosition(posi);
    AsUserGroup ug = new AsUserGroup();
    ug.setUserId(asEmp.getUserId());
    ug.setGroupId(groupId);
    this.addAsUserGroup(ug);
  }

  public void addAsEmp(AsEmp asEmp) {
    this.userDao.insertAsEmp(asEmp);
  }

  public void addAsEmpPosition(Position posi) {
    this.userDao.insertAsEmpPosition(posi);
  }

  public void addAsUserGroup(AsUserGroup ug) {
    this.userDao.insertAsUserGroup(ug);
  }

  public SysEmp getSysEmp(String userId, String nd) {
    SysEmp sysEmp = new SysEmp();
    User user = this.userDao.getUserById(userId);
    user.setPassword(GeneralFunc.recodePwd(user.getPassword()));//解密密码
    sysEmp.setUser(user);
    AsEmp asEmp = this.userDao.getAsEmpByUserId(userId);
    sysEmp.setAsEmp(asEmp);
    String empCode = asEmp.getEmpCode();
    Map param = new HashMap();
    param.put("EMP_CODE", empCode);
    param.put("ND", nd);
    List asEmpPosiList = this.userDao.getAsEmpPosiByEmpCode(param);
    sysEmp.setAsEmpPosiList(asEmpPosiList);
    List asUserGroupList = this.userDao.getAsUserGroupByUserId(userId);
    sysEmp.setAsUserGroupList(asUserGroupList);
    return sysEmp;
  }

  public void deleteAndInsertSysEmp(SysEmp sysEmp, String nd) throws BusinessException {
    User user = sysEmp.getUser();
    if (user == null) {
      throw new BusinessException("导入数据中缺少职员表as_user");
    }
    String userId = sysEmp.getUser().getUserId();
    String empCode = sysEmp.getAsEmp().getEmpCode();
    Map param = new HashMap();
    param.put("EMP_CODE", empCode);
    param.put("ND", nd);
    this.userDao.deleteUserById(userId);
    this.userDao.deleteAsEmpByUserId(userId);
    this.userDao.deleteAsEmpPosiByEmpCode(param);
    this.userDao.deleteAsUserGroupByUserId(userId);
    this.userDao.insertUser(sysEmp.getUser());
    this.userDao.insertAsEmpForDataExchange(sysEmp.getAsEmp());
    List asEmpPosiList = sysEmp.getAsEmpPosiList();
    for (int i = 0, j = asEmpPosiList.size(); i < j; i++) {
      this.userDao.insertAsEmpPosition((Position) asEmpPosiList.get(i));
    }
    List asUserGroupList = sysEmp.getAsUserGroupList();
    for (int i = 0, j = asUserGroupList.size(); i < j; i++) {
      this.userDao.insertAsUserGroup((AsUserGroup) asUserGroupList.get(i));
    }
  }

  public void updateAsEmpLogin(String userId, boolean isAllowLogin) throws BusinessException {
    AsEmp asEmp = this.userDao.getAsEmpByUserId(userId);
    if (asEmp == null) {
      throw new BusinessException("职员表as_emp中未找到供应商代码：" + userId);
    }
    asEmp.setIsLogin(isAllowLogin ? "Y" : "N");
    this.userDao.updateAsEmpLogin(asEmp);
  }

  public List getEmpByCaSerial(AsEmp asEmp) {
    return userDao.getEmpByCaSerial(asEmp);
  }

  public int updateEmpCaSerial(AsEmp asEmp) throws BusinessException {
    List list = this.getEmpByCaSerial(asEmp);
    for (int i = 0; i < list.size(); i++) {
      AsEmp asEmpTemp = (AsEmp) list.get(i);
      if (!asEmpTemp.getEmpCode().equals(asEmp.getEmpCode()))
        throw new BusinessException("证书序列号已经被注册，已注册：" + asEmpTemp.getEmpCode() + "：" + asEmpTemp.getCaSerial() + ",新注册：" + asEmp.getEmpCode() + "："
          + asEmp.getCaSerial());
    }

    return userDao.updateEmpCaSerial(asEmp);
  }
}

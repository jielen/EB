package com.ufgov.gk.common.console.model;

import java.io.Serializable;
import java.util.List;

import com.ufgov.gk.common.console.model.AsEmp;
import com.ufgov.gk.common.system.model.User;

public class SysEmp implements Serializable {

  private static final long serialVersionUID = 1L;

  private User user;

  private AsEmp asEmp;

  private List asEmpPosiList;

  private List asUserGroupList;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public AsEmp getAsEmp() {
    return asEmp;
  }

  public void setAsEmp(AsEmp asEmp) {
    this.asEmp = asEmp;
  }

  public void setAsEmpPosiList(List asEmpPosiList) {
    this.asEmpPosiList = asEmpPosiList;
  }

  public List getAsEmpPosiList() {
    return asEmpPosiList;
  }

  public void setAsUserGroupList(List asUserGroupList) {
    this.asUserGroupList = asUserGroupList;
  }

  public List getAsUserGroupList() {
    return asUserGroupList;
  }

}

package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

import com.ufgov.gk.common.system.util.BeanUtil;

public class Manage  extends BaseElement implements Serializable {

  private String oid;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  /**
   *
   */
  private static final long serialVersionUID = 396074295448356572L;

  public Object get(String name) {
    return BeanUtil.get(name, this);
  }


  public boolean equals(Object ob) {
    if (ob == null) return false;
    Manage m = (Manage)ob;
    if (this.getCode().equals(m.getCode())) {
      return true;
    } else {
      return false;
    }
  }


}

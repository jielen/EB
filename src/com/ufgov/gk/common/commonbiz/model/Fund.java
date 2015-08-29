package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

import com.ufgov.gk.common.system.util.BeanUtil;

public class Fund  extends BaseElement implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private String oid;


  public String getOid() {
    return oid;
  }

  public void setOid(String oid) {
    this.oid = oid;
  }

  public Object get(String name) {
    return BeanUtil.get(name, this);
  }

  public boolean equals(Object ob) {
    if (ob == null) return false;
    Fund f = (Fund)ob;
    if (this.getCode().equals(f.getCode())) {
      return true;
    } else {
      return false;
    }
  }


}

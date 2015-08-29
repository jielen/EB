package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class Emp implements Serializable {
  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private int nd;

  private String coCode;

  private String orgCode;

  private String posiCode;

  private String empCode;

  private String empName;

  private String userId;

  public String toString() {
    return "[" + this.empCode + "]" + this.empName;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }

  public String getEmpCode() {
    return empCode;
  }

  public void setEmpCode(String empCode) {
    this.empCode = empCode;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPosiCode() {
    return posiCode;
  }

  public void setPosiCode(String posiCode) {
    this.posiCode = posiCode;
  }


  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((coCode == null) ? 0 : coCode.hashCode());
    result = prime * result + ((empCode == null) ? 0 : empCode.hashCode());
    result = prime * result + ((empName == null) ? 0 : empName.hashCode());
    result = prime * result + nd;
    result = prime * result + ((orgCode == null) ? 0 : orgCode.hashCode());
    result = prime * result + ((posiCode == null) ? 0 : posiCode.hashCode());
    result = prime * result + ((userId == null) ? 0 : userId.hashCode());
    return result;
  }


  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final Emp other = (Emp) obj;
    if (coCode == null) {
      if (other.coCode != null)
        return false;
    } else if (!coCode.equals(other.coCode))
      return false;
    if (empCode == null) {
      if (other.empCode != null)
        return false;
    } else if (!empCode.equals(other.empCode))
      return false;
    if (empName == null) {
      if (other.empName != null)
        return false;
    } else if (!empName.equals(other.empName))
      return false;
    if (nd != other.nd)
      return false;
    if (orgCode == null) {
      if (other.orgCode != null)
        return false;
    } else if (!orgCode.equals(other.orgCode))
      return false;
    if (posiCode == null) {
      if (other.posiCode != null)
        return false;
    } else if (!posiCode.equals(other.posiCode))
      return false;
    if (userId == null) {
      if (other.userId != null)
        return false;
    } else if (!userId.equals(other.userId))
      return false;
    return true;
  }

}

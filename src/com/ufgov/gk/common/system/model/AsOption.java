package com.ufgov.gk.common.system.model;

import java.io.Serializable;

/**
 * 获取as_option中的数据
 * @author ufwangfei
 *
 */
public class AsOption implements Serializable {
  private static final long serialVersionUID = -5453232554701462375L;

  private String optId;

  private String coCode;

  private String compoId;

  private String transType;

  private String optVal;

  private String isSystOpt;

  public int hashCode() {
    final int PRIME = 31;
    int result = 1;
    result = PRIME * result + ((optId == null) ? 0 : optId.hashCode());
    result = PRIME * result + ((coCode == null) ? 0 : coCode.hashCode());
    result = PRIME * result + ((compoId == null) ? 0 : compoId.hashCode());
    result = PRIME * result + ((transType == null) ? 0 : transType.hashCode());
    result = PRIME * result + ((optVal == null) ? 0 : optVal.hashCode());
    result = PRIME * result + ((isSystOpt == null) ? 0 : isSystOpt.hashCode());
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final AsOption other = (AsOption) obj;
    if (optId == null) {
      if (other.optId != null)
        return false;
    } else if (!optId.equals(other.optId))
      return false;
    if (coCode == null) {
      if (other.coCode != null)
        return false;
    } else if (!coCode.equals(other.coCode))
      return false;
    if (compoId == null) {
      if (other.compoId != null)
        return false;
    } else if (!compoId.equals(other.compoId))
      return false;
    if (transType == null) {
      if (other.transType != null)
        return false;
    } else if (!transType.equals(other.transType))
      return false;
    if (optVal == null) {
      if (other.optVal != null)
        return false;
    } else if (!optVal.equals(other.optVal))
      return false;
    if (isSystOpt == null) {
      if (other.isSystOpt != null)
        return false;
    } else if (!isSystOpt.equals(other.isSystOpt))
      return false;
    return true;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public String getIsSystOpt() {
    return isSystOpt;
  }

  public void setIsSystOpt(String isSystOpt) {
    this.isSystOpt = isSystOpt;
  }

  public String getOptId() {
    return optId;
  }

  public void setOptId(String optId) {
    this.optId = optId;
  }

  public String getOptVal() {
    return optVal;
  }

  public void setOptVal(String optVal) {
    this.optVal = optVal;
  }

  public String getTransType() {
    return transType;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }

}

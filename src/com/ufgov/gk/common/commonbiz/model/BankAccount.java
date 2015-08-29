package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

import com.ufgov.gk.common.system.Digestable;
import com.ufgov.gk.common.system.util.DigestUtil;

public class BankAccount implements Serializable, Digestable {

  private static final long serialVersionUID = 1079610115128615007L;

  private int nd;

  private String bankInfoId;

  private String coCode;

  private String code;

  private String name;

  private String bankName;

  private String bankCode;

  private String bankNodeName;

  private String bankNodeCode;

  private String bankNo;

  private String bankAccCode;

  private String bankAccName;

  private String accName;

  private String accCode;

  private String fundCode;

  private String userId;

  private String remark;

  private String inputorId;

  private String isDefault;

  public String getInputorId() {
    return inputorId;
  }

  public void setInputorId(String inputorId) {
    this.inputorId = inputorId;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public String getFundCode() {
    return fundCode;
  }

  public void setFundCode(String fundCode) {
    this.fundCode = fundCode;
  }

  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public String getBankInfoId() {
    return bankInfoId;
  }

  public void setBankInfoId(String bankInfoId) {
    this.bankInfoId = bankInfoId;
  }

  public int getNd() {
    return nd;
  }

  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public String getBankCode() {
    return bankCode;
  }

  public void setBankCode(String bankCode) {
    this.bankCode = bankCode;
  }

  public String getBankNodeName() {
    return bankNodeName;
  }

  public void setBankNodeName(String bankNodeName) {
    this.bankNodeName = bankNodeName;
  }

  public String getBankNodeCode() {
    return bankNodeCode;
  }

  public void setBankNodeCode(String bankNodeCode) {
    this.bankNodeCode = bankNodeCode;
  }

  public String getBankNo() {
    return bankNo;
  }

  public void setBankNo(String bankNo) {
    this.bankNo = bankNo;
  }

  public String getBankAccCode() {
    return bankAccCode;
  }

  public void setBankAccCode(String bankAcccode) {
    this.bankAccCode = bankAcccode;
  }

  public String getAccName() {
    return accName;
  }

  public void setAccName(String accName) {
    this.accName = accName;
  }

  public String getAccCode() {
    return accCode;
  }

  public void setAccCode(String accCode) {
    this.accCode = accCode;
  }

  public String getIsDefault() {
    return isDefault;
  }

  public void setIsDefault(String isDefault) {
    this.isDefault = isDefault;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((accCode == null) ? 0 : accCode.hashCode());
    result = prime * result + ((accName == null) ? 0 : accName.hashCode());
    result = prime * result + ((bankAccCode == null) ? 0 : bankAccCode.hashCode());
    result = prime * result + ((bankCode == null) ? 0 : bankCode.hashCode());
    result = prime * result + ((bankInfoId == null) ? 0 : bankInfoId.hashCode());
    result = prime * result + ((bankName == null) ? 0 : bankName.hashCode());
    result = prime * result + ((bankNo == null) ? 0 : bankNo.hashCode());
    result = prime * result + ((bankNodeCode == null) ? 0 : bankNodeCode.hashCode());
    result = prime * result + ((bankNodeName == null) ? 0 : bankNodeName.hashCode());
    result = prime * result + ((coCode == null) ? 0 : coCode.hashCode());
    result = prime * result + ((code == null) ? 0 : code.hashCode());
    result = prime * result + ((fundCode == null) ? 0 : fundCode.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + nd;
    return result;
  }

  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    final BankAccount other = (BankAccount) obj;
    if (accCode == null) {
      if (other.accCode != null)
        return false;
    } else if (!accCode.equals(other.accCode))
      return false;
    if (accName == null) {
      if (other.accName != null)
        return false;
    } else if (!accName.equals(other.accName))
      return false;
    if (bankAccCode == null) {
      if (other.bankAccCode != null)
        return false;
    } else if (!bankAccCode.equals(other.bankAccCode))
      return false;
    if (bankCode == null) {
      if (other.bankCode != null)
        return false;
    } else if (!bankCode.equals(other.bankCode))
      return false;
    if (bankInfoId == null) {
      if (other.bankInfoId != null)
        return false;
    } else if (!bankInfoId.equals(other.bankInfoId))
      return false;
    if (bankName == null) {
      if (other.bankName != null)
        return false;
    } else if (!bankName.equals(other.bankName))
      return false;
    if (bankNo == null) {
      if (other.bankNo != null)
        return false;
    } else if (!bankNo.equals(other.bankNo))
      return false;
    if (bankNodeCode == null) {
      if (other.bankNodeCode != null)
        return false;
    } else if (!bankNodeCode.equals(other.bankNodeCode))
      return false;
    if (bankNodeName == null) {
      if (other.bankNodeName != null)
        return false;
    } else if (!bankNodeName.equals(other.bankNodeName))
      return false;
    if (coCode == null) {
      if (other.coCode != null)
        return false;
    } else if (!coCode.equals(other.coCode))
      return false;
    if (code == null) {
      if (other.code != null)
        return false;
    } else if (!code.equals(other.code))
      return false;
    if (fundCode == null) {
      if (other.fundCode != null)
        return false;
    } else if (!fundCode.equals(other.fundCode))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (nd != other.nd)
      return false;
    return true;
  }

  public String getBankAccName() {
    return bankAccName;
  }

  public void setBankAccName(String bankAccName) {
    this.bankAccName = bankAccName;
  }

  public String digest() {
    return DigestUtil.digest(this);
  }

}

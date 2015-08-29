package com.ufgov.gk.common.commonbiz.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class BiCdMoneyCheck extends BaseBill implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  //指标要素
  private BigDecimal biAggregate = BigDecimal.valueOf(0);

  private BigDecimal biSubtotal = BigDecimal.valueOf(0);

  private BigDecimal biLaborage = BigDecimal.valueOf(0);

  private BigDecimal biGov = BigDecimal.valueOf(0);

  private BigDecimal biOther = BigDecimal.valueOf(0);

  private BigDecimal biWarrant = BigDecimal.valueOf(0);

  //支付要素
  private BigDecimal cpAggregate = BigDecimal.valueOf(0);

  private BigDecimal cpSubtotal = BigDecimal.valueOf(0);

  private BigDecimal cpLaborage = BigDecimal.valueOf(0);

  private BigDecimal cpGov = BigDecimal.valueOf(0);

  private BigDecimal cpOther = BigDecimal.valueOf(0);

  private BigDecimal cpWarrant = BigDecimal.valueOf(0);

 //结余
  private BigDecimal baAggregate = BigDecimal.valueOf(0);

  private BigDecimal baSubtotal = BigDecimal.valueOf(0);

  private BigDecimal baLaborage = BigDecimal.valueOf(0);

  private BigDecimal baGov = BigDecimal.valueOf(0);

  private BigDecimal baOther = BigDecimal.valueOf(0);

  private BigDecimal baWarrant = BigDecimal.valueOf(0);

//结转
 private BigDecimal caAggregate = BigDecimal.valueOf(0);

  private BigDecimal caSubtotal = BigDecimal.valueOf(0);

  private BigDecimal caLaborage = BigDecimal.valueOf(0);

  private BigDecimal caGov = BigDecimal.valueOf(0);

  private BigDecimal caOther = BigDecimal.valueOf(0);

  private BigDecimal caWarrant = BigDecimal.valueOf(0);



  public String getCoCode() {
    return coCode;
  }

  public void setCoCode(String coCode) {
    this.coCode = coCode;
  }

  public int getNd() {
    return nd;
  }


  public void setNd(int nd) {
    this.nd = nd;
  }

  public String getOrgCode() {
    return orgCode;
  }

  public void setOrgCode(String orgCode) {
    this.orgCode = orgCode;
  }



  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }



  public BigDecimal getBiSubtotal() {
    return biSubtotal;
  }

  public void setBiSubtotal(BigDecimal biSubtotal) {
    this.biSubtotal = biSubtotal;
  }

  public BigDecimal getBiLaborage() {
    return biLaborage;
  }

  public void setBiLaborage(BigDecimal biLaborage) {
    this.biLaborage = biLaborage;
  }

  public BigDecimal getBiGov() {
    return biGov;
  }

  public String getBaccCode() {
    return baccCode;
  }

  public void setBaccCode(String baccCode) {
    this.baccCode = baccCode;
  }

  public String getBaccName() {
    return baccName;
  }

  public void setBaccName(String baccName) {
    this.baccName = baccName;
  }

  public void setBiGov(BigDecimal biGov) {
    this.biGov = biGov;
  }

  public BigDecimal getBiOther() {
    return biOther;
  }

  public void setBiOther(BigDecimal biOther) {
    this.biOther = biOther;
  }

  public BigDecimal getBiWarrant() {
    return biWarrant;
  }

  public void setBiWarrant(BigDecimal biWarrant) {
    this.biWarrant = biWarrant;
  }

  public BigDecimal getCpSubtotal() {
    return cpSubtotal;
  }

  public void setCpSubtotal(BigDecimal cpSubtotal) {
    this.cpSubtotal = cpSubtotal;
  }

  public BigDecimal getCpLaborage() {
    return cpLaborage;
  }

  public void setCpLaborage(BigDecimal cpLaborage) {
    this.cpLaborage = cpLaborage;
  }

  public BigDecimal getCpGov() {
    return cpGov;
  }

  public void setCpGov(BigDecimal cpGov) {
    this.cpGov = cpGov;
  }

  public BigDecimal getCpOther() {
    return cpOther;
  }

  public void setCpOther(BigDecimal cpOther) {
    this.cpOther = cpOther;
  }

  public BigDecimal getCpWarrant() {
    return cpWarrant;
  }

  public void setCpWarrant(BigDecimal cpWarrant) {
    this.cpWarrant = cpWarrant;
  }

public BigDecimal getBiAggregate() {
  return biAggregate;
}

public void setBiAggregate(BigDecimal biAggregate) {
  this.biAggregate = biAggregate;
}

public BigDecimal getCpAggregate() {
  return cpAggregate;
}

public void setCpAggregate(BigDecimal cpAggregate) {
  this.cpAggregate = cpAggregate;
}

public BigDecimal getBaAggregate() {
  return baAggregate;
}

public void setBaAggregate(BigDecimal baAggregate) {
  this.baAggregate = baAggregate;
}

public BigDecimal getBaSubtotal() {
  return baSubtotal;
}

public void setBaSubtotal(BigDecimal baSubtotal) {
  this.baSubtotal = baSubtotal;
}

public BigDecimal getBaLaborage() {
  return baLaborage;
}

public void setBaLaborage(BigDecimal baLaborage) {
  this.baLaborage = baLaborage;
}

public BigDecimal getBaGov() {
  return baGov;
}

public void setBaGov(BigDecimal baGov) {
  this.baGov = baGov;
}

public BigDecimal getBaOther() {
  return baOther;
}

public void setBaOther(BigDecimal baOther) {
  this.baOther = baOther;
}

public BigDecimal getBaWarrant() {
  return baWarrant;
}

public void setBaWarrant(BigDecimal baWarrant) {
  this.baWarrant = baWarrant;
}

public BigDecimal getCaAggregate() {
  return caAggregate;
}

public void setCaAggregate(BigDecimal caAggregate) {
  this.caAggregate = caAggregate;
}

public BigDecimal getCaSubtotal() {
  return caSubtotal;
}

public void setCaSubtotal(BigDecimal caSubtotal) {
  this.caSubtotal = caSubtotal;
}

public BigDecimal getCaLaborage() {
  return caLaborage;
}

public void setCaLaborage(BigDecimal caLaborage) {
  this.caLaborage = caLaborage;
}

public BigDecimal getCaGov() {
  return caGov;
}

public void setCaGov(BigDecimal caGov) {
  this.caGov = caGov;
}

public BigDecimal getCaOther() {
  return caOther;
}

public void setCaOther(BigDecimal caOther) {
  this.caOther = caOther;
}

public BigDecimal getCaWarrant() {
  return caWarrant;
}

public void setCaWarrant(BigDecimal caWarrant) {
  this.caWarrant = caWarrant;
}

public String getSendDocCode() {
  return sendDocCode;
}

public void setSendDocCode(String sendDocCode) {
  this.sendDocCode = sendDocCode;
}
}

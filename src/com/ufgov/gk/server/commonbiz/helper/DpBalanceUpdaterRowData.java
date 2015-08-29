
package com.ufgov.gk.server.commonbiz.helper;

import java.math.BigDecimal;
import java.util.Date;

public class DpBalanceUpdaterRowData {
  BigDecimal oldCurMoney= BigDecimal.valueOf(0);

  BigDecimal oldOrgMoney= BigDecimal.valueOf(0);

  BigDecimal newCurMoney= BigDecimal.valueOf(0);

  BigDecimal newOrgMoney= BigDecimal.valueOf(0);
  
  BigDecimal oldDpCdUseMoney= BigDecimal.valueOf(0);  

  String astatusCode;

  String action;

  String dpBalanceId;
  
  Date procDate;  

  public String getDpBalanceId() {
    return dpBalanceId;
  }

  public void setDpBalanceId(String dpBalanceId) {
    this.dpBalanceId = dpBalanceId;
  }

  public Date getProcDate() {
    return procDate;
  }

  public void setProcDate(Date procDate) {
    this.procDate = procDate;
  }

  public BigDecimal getOldDpCdUseMoney() {
    return oldDpCdUseMoney;
  }

  public void setOldDpCdUseMoney(BigDecimal oldDpCdUseMoney) {
    this.oldDpCdUseMoney = oldDpCdUseMoney;
  }

  public String getAction() {
    return action;
  }

  public void setAction(String action) {
    this.action = action;
  }

  public BigDecimal getOldCurMoney() {
    return oldCurMoney;
  }

  public void setOldCurMoney(BigDecimal oldCurMoney) {
    this.oldCurMoney = oldCurMoney;
  }

  public BigDecimal getOldOrgMoney() {
    return oldOrgMoney;
  }

  public void setOldOrgMoney(BigDecimal oldOrgMoney) {
    this.oldOrgMoney = oldOrgMoney;
  }

  public BigDecimal getNewCurMoney() {
    return newCurMoney;
  }

  public void setNewCurMoney(BigDecimal newCurMoney) {
    this.newCurMoney = newCurMoney;
  }

  public BigDecimal getNewOrgMoney() {
    return newOrgMoney;
  }

  public void setNewOrgMoney(BigDecimal newOrgMoney) {
    this.newOrgMoney = newOrgMoney;
  }

  public String getAstatusCode() {
    return astatusCode;
  }

  public void setAstatusCode(String astatusCode) {
    this.astatusCode = astatusCode;
  }
}

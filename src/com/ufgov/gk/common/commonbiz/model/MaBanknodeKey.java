package com.ufgov.gk.common.commonbiz.model;

import java.math.BigDecimal;

public class MaBanknodeKey {
    
    private String banknodeCode;
    
    private String bankCode;
  
    private BigDecimal nd;
   
    public String getBanknodeCode() {
        return banknodeCode;
    }
 
    public void setBanknodeCode(String banknodeCode) {
        this.banknodeCode = banknodeCode;
    }

   
    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }


    public BigDecimal getNd() {
        return nd;
    }

    public void setNd(BigDecimal nd) {
        this.nd = nd;
    }
}
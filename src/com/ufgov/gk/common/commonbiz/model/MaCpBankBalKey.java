package com.ufgov.gk.common.commonbiz.model;

import java.math.BigDecimal;

public class MaCpBankBalKey {
    
    private String bankBalId;

    private BigDecimal nd;

    public String getBankBalId() {
        return bankBalId;
    }

    public void setBankBalId(String bankBalId) {
        this.bankBalId = bankBalId;
    }

    
    public BigDecimal getNd() {
        return nd;
    }

    public void setNd(BigDecimal nd) {
        this.nd = nd;
    }
}
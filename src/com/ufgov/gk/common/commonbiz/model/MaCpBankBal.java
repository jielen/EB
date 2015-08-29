package com.ufgov.gk.common.commonbiz.model;

import java.io.Serializable;

public class MaCpBankBal extends MaCpBankBalKey implements Serializable{
    
    private String bankCode;

    private String fundCode;

    private String receAccName;

    private String receAccNo;

    private String receBankCode;

    private String receBankName;

    private String receBankNo;

    private String receBanknodeCode;

    private String receBanknodeName;

    private String receBanknodeNo;

    private String payCode;

    private String payAccCode;

    private String payAcctype;
    
    private String payAccName;

    private String payAccNo;

    private String payBankCode;

    private String payBankName;

    private String payBankNo;

    private String payBanknodeCode;

    private String payBanknodeName;

    private String payBanknodeNo;

    private String isUsed;

    private String isDefault;

    public String getBankCode() {
        return bankCode;
    }

  
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.FUND_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.FUND_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getFundCode() {
        return fundCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.FUND_CODE
     *
     * @param fundCode the value for SJWCZ.MA_CP_BANK_BAL.FUND_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setFundCode(String fundCode) {
        this.fundCode = fundCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceAccName() {
        return receAccName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NAME
     *
     * @param receAccName the value for SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceAccName(String receAccName) {
        this.receAccName = receAccName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceAccNo() {
        return receAccNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NO
     *
     * @param receAccNo the value for SJWCZ.MA_CP_BANK_BAL.RECE_ACC_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceAccNo(String receAccNo) {
        this.receAccNo = receAccNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANK_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBankCode() {
        return receBankCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_CODE
     *
     * @param receBankCode the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANK_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBankCode(String receBankCode) {
        this.receBankCode = receBankCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBankName() {
        return receBankName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NAME
     *
     * @param receBankName the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBankName(String receBankName) {
        this.receBankName = receBankName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBankNo() {
        return receBankNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NO
     *
     * @param receBankNo the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANK_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBankNo(String receBankNo) {
        this.receBankNo = receBankNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBanknodeCode() {
        return receBanknodeCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_CODE
     *
     * @param receBanknodeCode the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBanknodeCode(String receBanknodeCode) {
        this.receBanknodeCode = receBanknodeCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBanknodeName() {
        return receBanknodeName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NAME
     *
     * @param receBanknodeName the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBanknodeName(String receBanknodeName) {
        this.receBanknodeName = receBanknodeName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getReceBanknodeNo() {
        return receBanknodeNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NO
     *
     * @param receBanknodeNo the value for SJWCZ.MA_CP_BANK_BAL.RECE_BANKNODE_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setReceBanknodeNo(String receBanknodeNo) {
        this.receBanknodeNo = receBanknodeNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayCode() {
        return payCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_CODE
     *
     * @param payCode the value for SJWCZ.MA_CP_BANK_BAL.PAY_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayCode(String payCode) {
        this.payCode = payCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_ACC_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayAccCode() {
        return payAccCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_CODE
     *
     * @param payAccCode the value for SJWCZ.MA_CP_BANK_BAL.PAY_ACC_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayAccCode(String payAccCode) {
        this.payAccCode = payAccCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACCTYPE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_ACCTYPE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayAcctype() {
        return payAcctype;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACCTYPE
     *
     * @param payAcctype the value for SJWCZ.MA_CP_BANK_BAL.PAY_ACCTYPE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayAcctype(String payAcctype) {
        this.payAcctype = payAcctype;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayAccName() {
        return payAccName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NAME
     *
     * @param payAccName the value for SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayAccName(String payAccName) {
        this.payAccName = payAccName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayAccNo() {
        return payAccNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NO
     *
     * @param payAccNo the value for SJWCZ.MA_CP_BANK_BAL.PAY_ACC_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayAccNo(String payAccNo) {
        this.payAccNo = payAccNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANK_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBankCode() {
        return payBankCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_CODE
     *
     * @param payBankCode the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANK_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBankCode(String payBankCode) {
        this.payBankCode = payBankCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBankName() {
        return payBankName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NAME
     *
     * @param payBankName the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBankName(String payBankName) {
        this.payBankName = payBankName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBankNo() {
        return payBankNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NO
     *
     * @param payBankNo the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANK_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBankNo(String payBankNo) {
        this.payBankNo = payBankNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_CODE
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBanknodeCode() {
        return payBanknodeCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_CODE
     *
     * @param payBanknodeCode the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_CODE
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBanknodeCode(String payBanknodeCode) {
        this.payBanknodeCode = payBanknodeCode;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NAME
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBanknodeName() {
        return payBanknodeName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NAME
     *
     * @param payBanknodeName the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NAME
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBanknodeName(String payBanknodeName) {
        this.payBanknodeName = payBanknodeName;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NO
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getPayBanknodeNo() {
        return payBanknodeNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NO
     *
     * @param payBanknodeNo the value for SJWCZ.MA_CP_BANK_BAL.PAY_BANKNODE_NO
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setPayBanknodeNo(String payBanknodeNo) {
        this.payBanknodeNo = payBanknodeNo;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.IS_USED
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.IS_USED
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getIsUsed() {
        return isUsed;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.IS_USED
     *
     * @param isUsed the value for SJWCZ.MA_CP_BANK_BAL.IS_USED
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setIsUsed(String isUsed) {
        this.isUsed = isUsed;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method returns the value of the database column SJWCZ.MA_CP_BANK_BAL.IS_DEFAULT
     *
     * @return the value of SJWCZ.MA_CP_BANK_BAL.IS_DEFAULT
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public String getIsDefault() {
        return isDefault;
    }

    /**
     * This method was generated by Abator for iBATIS.
     * This method sets the value of the database column SJWCZ.MA_CP_BANK_BAL.IS_DEFAULT
     *
     * @param isDefault the value for SJWCZ.MA_CP_BANK_BAL.IS_DEFAULT
     *
     * @abatorgenerated Mon Apr 27 15:46:03 CST 2009
     */
    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }
}
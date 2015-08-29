package com.ufgov.gk.common.ebay.model;

import java.math.BigDecimal;

import com.ufgov.gk.common.commonbiz.model.BaseBill;

public class EbCurrency extends BaseBill {
  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_CURRENCY.CURRENCY_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private String currencyId;

  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_CURRENCY.NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private String name;

  /**
   * This field was generated by Abator for iBATIS.
   * This field corresponds to the database column EB_CURRENCY.EXCHANGE_RATE
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  private BigDecimal exchangeRate;

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_CURRENCY.CURRENCY_ID
   *
   * @return the value of EB_CURRENCY.CURRENCY_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getCurrencyId() {
    return currencyId;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_CURRENCY.CURRENCY_ID
   *
   * @param currencyId the value for EB_CURRENCY.CURRENCY_ID
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setCurrencyId(String currencyId) {
    this.currencyId = currencyId;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_CURRENCY.NAME
   *
   * @return the value of EB_CURRENCY.NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public String getName() {
    return name;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_CURRENCY.NAME
   *
   * @param name the value for EB_CURRENCY.NAME
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method returns the value of the database column EB_CURRENCY.EXCHANGE_RATE
   *
   * @return the value of EB_CURRENCY.EXCHANGE_RATE
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public BigDecimal getExchangeRate() {
    return exchangeRate;
  }

  /**
   * This method was generated by Abator for iBATIS.
   * This method sets the value of the database column EB_CURRENCY.EXCHANGE_RATE
   *
   * @param exchangeRate the value for EB_CURRENCY.EXCHANGE_RATE
   *
   * @abatorgenerated Sat Jun 23 08:51:07 CST 2012
   */
  public void setExchangeRate(BigDecimal exchangeRate) {
    this.exchangeRate = exchangeRate;
  }
}
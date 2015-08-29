package com.ufgov.gk.client.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Hashtable;
import java.util.List;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class EbUtil {

  private Hashtable<String, BigDecimal> currencyExchangeRates = null;

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  /**
   * 转变币种金额
   * @param value 原金额
   * @param currencyId 原币种
   * @param siteId 目标站点，
   * @return 将原币种金额转变为目标站点的金额
   * Administrator
   * Aug 17, 2012
   */
  public BigDecimal getCurencyValue(BigDecimal value, String currencyId, String siteId) {
    // TODO Auto-generated method stub

    BigDecimal rmb = getRMBValue(value, currencyId);

    BigDecimal exchangeRate;
    if (siteId.equals(ZcSettingConstants.US)) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_USD);
    } else if (siteId.equals(ZcSettingConstants.UK)) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_GBP);
    } else if (siteId.equals(ZcSettingConstants.CA)) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_CAD);
    } else if (siteId.equals(ZcSettingConstants.AU)) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_AUD);
    } else if (siteId.equals(ZcSettingConstants.FR) || siteId.equals(ZcSettingConstants.DE)) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_EUR);
    } else {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_USD);
    }
    double t = rmb.doubleValue() / exchangeRate.doubleValue();
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(t));
  }

  public BigDecimal getRMBValue(BigDecimal value, String currencyId) {

    if (currencyExchangeRates == null) {
      initCurrencyChangeRates();
    }
    if (value == null) {
      value = new BigDecimal(0);
    }
    BigDecimal exchangeRate = currencyExchangeRates.get(currencyId);
    if (exchangeRate == null) {
      exchangeRate = currencyExchangeRates.get(ZcSettingConstants.CURENCY_USD);
    }
    double t = value.doubleValue() * exchangeRate.doubleValue();
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(t));
  }

  private void initCurrencyChangeRates() {
    List<EbCurrency> curs = this.ebayServiceDelegate.getEbCurrency(new ElementConditionDto(), WorkEnv.getInstance().getRequestMeta());
    currencyExchangeRates = new Hashtable<String, BigDecimal>();
    if (curs != null) {
      for (EbCurrency ebCurrency : curs) {
        currencyExchangeRates.put(ebCurrency.getCurrencyId(), ebCurrency.getExchangeRate());
      }
    }
  }

}

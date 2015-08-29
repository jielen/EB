package com.ufgov.gk.client.ebfee;

import java.math.BigDecimal;

import com.ufgov.gk.common.system.constants.ZcSettingConstants;

public class EbFeeCaculaterFactory {

  private EbFeeCaculaterFactory() {

  }

  public static EbFeeCaculaterFactory getInstance() {
    return new EbFeeCaculaterFactory();
  }

  public IEbFeeCaculate getFeeCaculator(String siteId) {
    if (siteId.equals(ZcSettingConstants.AU)) {
      return new AuFeeCaculator();
    } else if (siteId.equals(ZcSettingConstants.UK)) {
      return new UkFeeCaculator();
    } else if (siteId.equals(ZcSettingConstants.FR)) {
      return new FrFeeCaculator();
    } else if (siteId.equals(ZcSettingConstants.US)) {
      return new UsFeeCaculator();
    } else if (siteId.equals(ZcSettingConstants.CA)) {
      return new CaFeeCaculator();
    } else if (siteId.equals(ZcSettingConstants.DE)) {
      return new DeFeeCaculator();
    }
    return null;
  }

  public BigDecimal getFixInsertFees(String siteId, String storeType, BigDecimal price) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getFixInsertsFee(storeType, price);
  }

  public BigDecimal getFixFVLs(String siteId, String storeType, BigDecimal price, String categoreyType) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getFixFVL(storeType, price, categoreyType);
  }

  public BigDecimal getFixPayPalFees(String siteId, String storeType, BigDecimal price, BigDecimal shippingFees) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getChinesePayPalFee(storeType, price.add(shippingFees == null ? new BigDecimal(0) : shippingFees));
  }

  public BigDecimal getChineseInsertFees(String siteId, String storeType, BigDecimal price) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getChineseInsertsFee(storeType, price);
  }

  public BigDecimal getChineseFVLs(String siteId, String storeType, BigDecimal price, String categoreyType) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getChineseFVL(storeType, price, categoreyType);
  }

  public BigDecimal getChinesePayPalFees(String siteId, String storeType, BigDecimal price, BigDecimal shippingFees) {
    IEbFeeCaculate ca = getFeeCaculator(siteId);
    return ca.getChinesePayPalFee(storeType, price.add(shippingFees == null ? new BigDecimal(0) : shippingFees));
  }
}

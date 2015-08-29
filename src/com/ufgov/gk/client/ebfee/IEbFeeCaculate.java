/**
 * IEbFeeCaculate.java
 * com.ufgov.gk.client.ebfee
 * Administrator
 * Aug 15, 2012
 */
package com.ufgov.gk.client.ebfee;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public interface IEbFeeCaculate {

  public BigDecimal getFixInsertsFee(String storeType, BigDecimal itemPrice);

  public BigDecimal getFixFVL(String storeType, BigDecimal itemPrice, String categoreyType);

  public BigDecimal getFixPayPalFee(String storeType, BigDecimal itemPrice);

  public BigDecimal getChineseInsertsFee(String storeType, BigDecimal itemPrice);

  public BigDecimal getChineseFVL(String storeType, BigDecimal itemPrice, String categoreyType);

  public BigDecimal getChinesePayPalFee(String storeType, BigDecimal itemPrice);
}

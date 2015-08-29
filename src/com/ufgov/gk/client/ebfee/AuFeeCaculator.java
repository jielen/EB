/**
 * AuFeeCaculator.java
 * com.ufgov.gk.client.ebfee
 * Administrator
 * Aug 15, 2012
 */
package com.ufgov.gk.client.ebfee;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import com.ufgov.gk.client.util.EbUtil;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;

/**
 * @author Administrator
 * http://pages.ebay.com.au/help/sell/fees.html
 *
 */
public class AuFeeCaculator implements IEbFeeCaculate {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixInsertsFee(java.lang.String, java.math.BigDecimal)
   * Less than $20.00 $0.50
     $20.00 - 99.99   $1.50
     $100.00 or more  $3.00
   */
  @Override
  public BigDecimal getFixInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = 0.0;
    if (d < 20) {
      r = 0.5;
    } else if (d < 100) {
      r = 1.5;
    } else {
      r = 3;
    }
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(r));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixFVL(java.lang.String, java.math.BigDecimal)
   * 7.90%
   */
  @Override
  public BigDecimal getFixFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = d * 0.079;
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(r));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixPayPalFee(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getFixPayPalFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub 
    EbUtil ebu = new EbUtil();
    //转换为美元
    BigDecimal a = ebu.getCurencyValue(itemPrice, ZcSettingConstants.CURENCY_AUD, ZcSettingConstants.US);
    double d = a.doubleValue();
    double r = 0.3 + d * 0.034;
    //转换为澳元
    BigDecimal b = ebu.getCurencyValue(new BigDecimal(r), ZcSettingConstants.CURENCY_USD, ZcSettingConstants.AU);
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(b.doubleValue()));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseInsertsFee(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getChineseInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    return getFixInsertsFee(storeType, itemPrice);
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseFVL(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getChineseFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    return getFixFVL(storeType, itemPrice, categoreyType);
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChinesePayPalFee(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getChinesePayPalFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    return getFixPayPalFee(storeType, itemPrice);
  }

}

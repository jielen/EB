/**
 * CaFeeCaculator.java
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
 * http://pages.ebay.ca/help/sell/fees.html
 *
 */
public class CaFeeCaculator implements IEbFeeCaculate {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixInsertsFee(java.lang.String, java.math.BigDecimal)
   * 
   */
  @Override
  public BigDecimal getFixInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    return new BigDecimal(0.5);
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixFVL(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getFixFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = 0.0;
    if (d <= 50) {
      r = d * 0.1;
    } else if (d <= 1000) {
      r = 50 * 0.1 + (d - 50) * 0.08;
    } else {
      r = 50 * 0.1 + 1000 * 0.08 + (d - 1000 - 50) * 0.02;
    }
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
    BigDecimal a = ebu.getCurencyValue(itemPrice, ZcSettingConstants.CURENCY_CAD, ZcSettingConstants.US);
    double d = a.doubleValue();
    double r = 0.3 + d * 0.034;
    //转换为加元
    BigDecimal b = ebu.getCurencyValue(new BigDecimal(r), ZcSettingConstants.CURENCY_USD, ZcSettingConstants.CA);
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(b.doubleValue()));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseInsertsFee(java.lang.String, java.math.BigDecimal)
   * Starting or reserve price  Insertion fee* 
   */
  @Override
  public BigDecimal getChineseInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = 0.0;
    if (d < 1) {
      r = 0.1;
    } else if (d < 10) {
      r = 0.25;
    } else if (d < 25) {
      r = 0.5;
    } else if (d < 50) {
      r = 0.75;
    } else if (d < 200) {
      r = 1;
    } else {
      r = 2;
    }
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(r));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseFVL(java.lang.String, java.math.BigDecimal)
   * http://pages.ebay.com/help/sell/storefees.html
   * Based on the total amount of the sale
   * The total amount of the sale equals the cost of the item, shipping charges, and any other amounts you may charge the buyer. Sales tax is not included in the total amount of the sale.
   * $0.01–$50.00 7.5% of the total amount of the sale 
   * $50.01–$1,000.00 7.5% of the initial $50.00, plus 4.0% of the remaining balance ($50.01–$1,000.00) of the total amount of the sale 
   * $1,000.01 or more 7.5% of the initial $50.00, plus 4.0% of the next $50.01–$1,000.00, plus 2.0% of the remaining balance of the total amount of the sale
   */
  @Override
  public BigDecimal getChineseFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = d * 0.09;
    if (r > 250) {
      r = 250;
    }
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(r));
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

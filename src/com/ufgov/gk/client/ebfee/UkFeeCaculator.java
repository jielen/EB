/**
 * UkFeeCaculator.java
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
 * http://pages.ebay.co.uk/help/sell/fees.html
 *
 */
public class UkFeeCaculator implements IEbFeeCaculate {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixInsertsFee(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getFixInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(0.4));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixFVL(java.lang.String, java.math.BigDecimal)
   */
  @Override
  public BigDecimal getFixFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = d * 0.1;
    if (r > 75) {
      r = 75;
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
    BigDecimal a = ebu.getCurencyValue(itemPrice, ZcSettingConstants.CURENCY_GBP, ZcSettingConstants.US);
    double d = a.doubleValue();
    double r = 0.3 + d * 0.034;
    //转换为英镑
    BigDecimal b = ebu.getCurencyValue(new BigDecimal(r), ZcSettingConstants.CURENCY_USD, ZcSettingConstants.UK);
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(b.doubleValue()));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseInsertsFee(java.lang.String, java.math.BigDecimal)
   * Starting or reserve price  Insertion fee*  
     $0.01–$0.99                 free 
     $1.00–$4.99                 $0.15 
     $5.00–$14.99                $0.25  
     $15.00–$29.99               $0.50  
     $30.00–$99.99               $1 
     $100 or more                $1.30
   */
  @Override
  public BigDecimal getChineseInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = 0.0;
    if (d < 1) {
      r = 0;
    } else if (d < 5) {
      r = 0.15;
    } else if (d < 15) {
      r = 0.25;
    } else if (d < 30) {
      r = 0.5;
    } else if (d < 100) {
      r = 1;
    } else {
      r = 1.3;
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

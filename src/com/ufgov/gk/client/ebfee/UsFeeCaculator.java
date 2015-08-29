/**
 * UsFeeCaculator.java
 * com.ufgov.gk.client.ebfee
 * Administrator
 * Aug 15, 2012
 */
package com.ufgov.gk.client.ebfee;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Administrator
 *
 */
public class UsFeeCaculator implements IEbFeeCaculate {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixInsertsFee(java.lang.String, java.math.BigDecimal)
   * BIN Insertion Fees No store  Basic Featured  Anchor
   *                    $0.50     $0.20 $0.05     $0.03
   */
  @Override
  public BigDecimal getFixInsertsFee(String storeType, BigDecimal itemPrice) {
    // TODO Auto-generated method stub
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(0.2));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getFixFVL(java.lang.String, java.math.BigDecimal)
   * http://pages.ebay.com/help/sell/storefees.html
   * BIN Final Value Fees Electronics Clothing  Books Other
     $0.01                7.00%       10.00%    13.00% 11.00%
     $50.01               5.00%       8.00%     5.00%  6.00%
     $1,000.01            2.00%       2.00%     2.00%  2.00%
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
    double d = itemPrice.doubleValue();
    double r = 0.3 + d * 0.034;
    DecimalFormat df = new DecimalFormat("#.00");
    return new BigDecimal(df.format(r));
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebfee.IEbFeeCaculate#getChineseInsertsFee(java.lang.String, java.math.BigDecimal)
   * Starting or reserve price  Insertion fee*  
     $0.01每$0.99                 $0.10 
     $1.00每$9.99                 $0.25  
     $10.00每$24.99               $0.50  
     $25.00每$49.99               $0.75 
     $50.00每$199.99              $1.00 
     $200 or more                $2.00
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
   * $0.01每$50.00 7.5% of the total amount of the sale 
   * $50.01每$1,000.00 7.5% of the initial $50.00, plus 4.0% of the remaining balance ($50.01每$1,000.00) of the total amount of the sale 
   * $1,000.01 or more 7.5% of the initial $50.00, plus 4.0% of the next $50.01每$1,000.00, plus 2.0% of the remaining balance of the total amount of the sale
   */
  @Override
  public BigDecimal getChineseFVL(String storeType, BigDecimal itemPrice, String categoreyType) {
    // TODO Auto-generated method stub
    double d = itemPrice.doubleValue();
    double r = 0.0;
    if (d <= 50) {
      r = d * 0.075;
    } else if (d <= 1000) {
      r = 50 * 0.075 + (d - 50) * 0.04;
    } else {
      r = 50 * 0.075 + 1000 * 0.04 + (d - 1000 - 50) * 0.02;
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

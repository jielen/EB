/**
 * Transport4PX.java
 * com.ufgov.gk.client.ebtransport
 * Administrator
 * Aug 15, 2012
 */
package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public class Transport4PX implements IEbTransportFeeCaculator {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebtransport.IEbTransportFeeCaculator#getTransportFee(java.math.BigDecimal)
   */
  @Override
  public BigDecimal getTransportFee(BigDecimal weight) {
    // TODO Auto-generated method stub
    double d = weight.doubleValue();
    double r = d / 1000 * 90 + 1;
    return new BigDecimal(r);
  }

}

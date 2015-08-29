package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

public class TransportXiaoBaoGuaHao implements IEbTransportFeeCaculator {

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.ebtransport.IEbTransportFeeCaculator#getTransportFee(java.math.BigDecimal)
   */
  @Override
  public BigDecimal getTransportFee(BigDecimal weight) {
    // TODO Auto-generated method stub
    double d = weight.doubleValue();
    double r = d / 1000 * 88 + 8;
    return new BigDecimal(r);
  }

}

package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

public class Transport4PXGuaHao implements IEbTransportFeeCaculator {

  @Override
  public BigDecimal getTransportFee(BigDecimal weight) {
    // TODO Auto-generated method stub
    double d = weight.doubleValue();
    double r = d / 1000 * 90 + 1;
    return new BigDecimal(r);
  }

}

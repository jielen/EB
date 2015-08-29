package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

public interface IEbTransportFeeCaculator {
  public BigDecimal getTransportFee(BigDecimal weight);
}

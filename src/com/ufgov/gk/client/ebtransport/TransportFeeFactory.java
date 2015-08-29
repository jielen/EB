/**
 * TransportFeeFactory.java
 * com.ufgov.gk.client.ebtransport
 * Administrator
 * Aug 15, 2012
 */
package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

import com.ufgov.gk.common.system.constants.ZcSettingConstants;

/**
 * @author Administrator
 *
 */
public class TransportFeeFactory {

  private TransportFeeFactory() {

  }

  public static TransportFeeFactory getInstance() {
    return new TransportFeeFactory();
  }

  public BigDecimal getTransportFee(BigDecimal weight, String transportMode) {
    IEbTransportFeeCaculator t = new TransportXiaoBao();
    if (transportMode.equals(ZcSettingConstants.TRANSPORT_MODE_XIAOBAO)) {
      t = new TransportXiaoBao();
    } else if (transportMode.equals(ZcSettingConstants.TRANSPORT_MODE_XIAOBAO_GUAHAO)) {
      t = new TransportXiaoBaoGuaHao();
    } else if (transportMode.equals(ZcSettingConstants.TRANSPORT_MODE_4PX)) {
      t = new Transport4PX();
    } else if (transportMode.equals(ZcSettingConstants.TRANSPORT_MODE_4PX_GUAHAO)) {
      t = new Transport4PXGuaHao();
    } else if (transportMode.equals(ZcSettingConstants.TRANSPORT_MODE_EMS)) {
      t = new TransportEMS();
    }
    return t.getTransportFee(weight);
  }
}

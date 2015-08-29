package com.ufgov.gk.client.ebtransport;

import java.math.BigDecimal;

public class TransportEMS implements IEbTransportFeeCaculator {

  @Override
  public BigDecimal getTransportFee(BigDecimal weight) {
    // TODO Auto-generated method stub
    double d = weight.doubleValue();
    double r = 0;
    double z = 0.6;//уш©ш;
    if (d <= 500) {
      r = 280;
    } else {
      int k = (int) ((d - 500) % 500);
      int t = (int) ((d - 500) / 500);
      if (k > 0) {
        t++;
      }
      r = (280 + t * 75) * z;
    }
    /*
    if (d <= 500) {
      r = 280;
    } else if (d <= 1000) {
      r = 280 + (d - 1000) * 355;
    } else if (d <= 1500) {
      r = 280 + 355 + (d - 1000) * 430;
    } else if (d <= 2000) {
      r = 280 + 355 + 430 + (d - 1500) * 505;
    } else if (d <= 2500) {
      r = 280 + 355 + 430 + 505 + (d - 2000) * 580;
    } else if (d <= 3000) {
      r = 280 + 355 + 430 + 505 + 580 + (d - 2500) * 655;
    } else if (d <= 3500) {
      r = 280 + 355 + 430 + 505 + 580 + 655 + (d - 3000) * 730;
    } else if (d <= 4000) {
      r = 280 + 355 + 430 + 505 + 580 + 655 + 730 + (d - 3500) * 805;
    } else if (d <= 4500) {
      r = 280 + 355 + 430 + 505 + 580 + 655 + 730 + 805 + (d - 4000) * 880;
    } else if (d <= 5000) {
      r = 280 + 355 + 430 + 505 + 580 + 655 + 730 + 805 + 880 + (d - 4500) * 955;
    } else if (d <= 5500) {
      r = 280 + 355 + 430 + 505 + 580 + 655 + 730 + 805 + 880 + 955 + (d - 5000) * 1030;
    }
    r = r / 100 * z;
    */
    return new BigDecimal(r);
  }

}

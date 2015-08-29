/**
 * EbProfit.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Aug 16, 2012
 */
package com.eb.client.component.ebCandidateItem;

import java.math.BigDecimal;

/**
 * @author Administrator
 *
 */
public class EbProfit {

  private BigDecimal profit;

  private BigDecimal profitRate;

  public BigDecimal getProfit() {
    return profit;
  }

  public void setProfit(BigDecimal profit) {
    this.profit = profit;
  }

  public BigDecimal getProfitRate() {
    return profitRate;
  }

  public void setProfitRate(BigDecimal profitRate) {
    this.profitRate = profitRate;
  }
}

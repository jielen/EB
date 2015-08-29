/**
 * SkuSearchHelper.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Jul 20, 2012
 */
package com.eb.client.component.ebCandidateItem;

/**
 * @author Administrator
 *
 */
public class SkuSearchHelper {

  private String sku;

  /*
   * ÊÇ·ñÄ£ºýËÑË÷
   */
  private boolean illegibility = true;

  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public boolean isIllegibility() {
    return illegibility;
  }

  public void setIllegibility(boolean illegibility) {
    this.illegibility = illegibility;
  }
}

/**
 * EbItemGroup.java
 * com.ufgov.gk.common.ebay.model
 * Administrator
 * Jul 7, 2012
 */
package com.ufgov.gk.common.ebay.model;

/**
 * 同一商品，多次销售，标题一样时，计算成一个产品
 * @author Administrator
 *
 */
public class EbItemGroup extends EbItem {

  private int items;

  public int getItems() {
    return items;
  }

  public void setItems(int items) {
    this.items = items;
  }
}

/**
 * OpenBidButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-22
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class ForceOpenBidButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public ForceOpenBidButton() {
    super();
  }

  protected void init() {
    this.funcId = "fforceOpenBid";
    this.defaultText = "ǿ�п���";
    super.init();
  }
}

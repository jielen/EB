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
public class OpenBidButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 4054640434388046008L;

  public OpenBidButton() {
    super();
  }

  protected void init() {

    this.funcId = "fopenBid";
    this.defaultText = "����";
    super.init();
  }

}

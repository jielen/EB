/**
 * RejectBidButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-22
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class TechnicalBidButton extends FuncButton {
  private static final long serialVersionUID = 4054640434388046008L;

  public TechnicalBidButton() {
    super();
  }

  protected void init() {

    this.funcId = "ftechBid";
    this.defaultText = "����������";
    super.init();
  }

}

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
public class FinishBidButton extends FuncButton {
  private static final long serialVersionUID = 4054640434388046008L;

  public FinishBidButton() {
    super();
  }

  protected void init() {

    this.funcId = "ffinishBid";
    this.defaultText = "��������";
    super.init();
  }

}

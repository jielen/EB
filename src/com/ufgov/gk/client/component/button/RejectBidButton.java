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
public class RejectBidButton extends FuncButton {
  private static final long serialVersionUID = 4054640434388046008L;

  public RejectBidButton() {
    super();
  }

  protected void init() {

    this.funcId = "frejectBid";
    this.defaultText = "�ϱ�";
    super.init();
  }

}

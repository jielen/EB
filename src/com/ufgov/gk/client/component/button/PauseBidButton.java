package com.ufgov.gk.client.component.button;

/**
 * @author LEO
 *
 */
public class PauseBidButton extends FuncButton {
  private static final long serialVersionUID = 4054640434388046008L;

  public PauseBidButton() {
    super();
  }

  protected void init() {
    this.funcId = "fpauseBid";
    this.defaultText = "ÔÝÍ£";
    super.init();
  }
}

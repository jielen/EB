/**
 * SubinsertButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class SubinsertPinPaiButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -4562975339140978995L;

  public SubinsertPinPaiButton() {
    this.init();
  }

  public SubinsertPinPaiButton(boolean funcCtrl) {
    this.funcCtrl = funcCtrl;
    this.init();
  }

  protected void init() {
    this.funcId = "fsubinsertpinpai";
    this.defaultText = "Ôö¼ÓÆ·ÅÆ";
    this.iconName = "subinsert.png";
    super.init();
  }

}

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
public class SubinsertButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -4562975339140978995L;

  public SubinsertButton() {
    this.init();
  }

  public SubinsertButton(boolean funcCtrl) {
    this.funcCtrl = funcCtrl;
    this.init();
  }

  protected void init() {
    this.funcId = "fsubinsert";
    this.defaultText = "≤Â»Î";
    this.iconName = "subinsert.png";
    super.init();
  }

}

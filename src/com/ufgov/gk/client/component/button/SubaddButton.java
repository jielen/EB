/**
 * SubaddButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class SubaddButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -4562975339140978995L;

  public SubaddButton() {
    this.init();
  }

  public SubaddButton(boolean funcCtrl) {
    this.funcCtrl = funcCtrl;
    this.init();
  }

  protected void init() {
    this.funcId = "fsubadd";
    this.defaultText = "����";
    this.iconName = "subadd.png";
    super.init();
  }

}

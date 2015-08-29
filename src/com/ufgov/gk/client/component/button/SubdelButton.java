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
public class SubdelButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = -4562975339140978995L;

  public SubdelButton() {
    this.init();
  }

  public SubdelButton(boolean funcCtrl) {
    this.funcCtrl = funcCtrl;
    this.init();
  }

  protected void init() {
    this.funcId = "fsubdel";
    this.defaultText = "ɾ��";
    this.iconName = "subdel.png";
    super.init();
  }

}
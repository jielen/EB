/**
 * BaoJiaButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-10-24
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class BaoJiaButton extends FuncButton {
  
  public BaoJiaButton(){
    super();
  }
  
  protected void init() {
    this.funcId="fsend";
    this.defaultText="����";
    this.iconName="sendBill.png";
    super.init();
  }

}

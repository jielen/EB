/**
 * UnBaoJiaButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-10-24
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class UnBaoJiaButton extends FuncButton {

public UnBaoJiaButton(){
  super();
}
  protected void init() {
    this.funcId="fcallback";
    this.defaultText="ȡ������";
    this.iconName="callback.jpg";
    super.init();
  }

}

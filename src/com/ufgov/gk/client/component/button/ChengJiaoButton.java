/**
 * ChengJiaoButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-11-11
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class ChengJiaoButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 8173437848437677139L;

  public ChengJiaoButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fchengjiao";
    this.defaultText="�ɽ�";
    this.iconName="commit.jpg";
    super.init();
  }


}

/**
 * useButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * 2010-5-18
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class useButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 1042025020059501761L;
  
  public useButton() {
    super();
  }
  
  protected void init() {
    this.funcId = "fuse";
    this.defaultText="����";
    super.init();
  }
}

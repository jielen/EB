/**
 * CaculatorButton.java
 * com.ufgov.gk.client.component.button
 * Administrator
 * Aug 17, 2012
 */
package com.ufgov.gk.client.component.button;

/**
 * @author Administrator
 *
 */
public class CaculatorButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 5225058365252283470L;

  public CaculatorButton() {
    super();
  }

  protected void init() {
    this.funcId = "fcaculator";
    this.defaultText = "º∆À„";
    super.init();
  }

}

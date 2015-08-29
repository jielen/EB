/**   
* @(#) project: ZC
* @(#) file: FormulaEditButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: FormulaEditButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2010-12-20 下午05:20:49
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class FormulaEditButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public FormulaEditButton() {
    super();
  }

  protected void init() {

    this.funcId = "fformulaEdit";
    this.defaultText = "设置评审指标";
    this.iconName = "edit.jpg";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }
}

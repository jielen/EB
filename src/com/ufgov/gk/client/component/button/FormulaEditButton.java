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
* @Description: TODO(������һ�仰��������������)
* @date: 2010-12-20 ����05:20:49
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
    this.defaultText = "��������ָ��";
    this.iconName = "edit.jpg";
    super.init();

  }

  public void setToolTipText(String text) {
    String tipText = this.getText();
    super.setToolTipText(tipText);
  }
}

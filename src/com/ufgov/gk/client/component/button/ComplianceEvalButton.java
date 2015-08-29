/**   
* @(#) project: ZC
* @(#) file: ComplianceEvalButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ComplianceEvalButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2010-12-3 下午02:10:46
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ComplianceEvalButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public ComplianceEvalButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fcomplianceEval";
    this.defaultText = "符合性评标";
    this.iconName = "commit.jpg";
    super.init();
  }
}

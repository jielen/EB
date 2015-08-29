/**   
* @(#) project: ZC
* @(#) file: CreateEvalReportButton.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: CreateEvalReportButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2010-12-4 下午02:18:08
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class CreateEvalReportButton extends FuncButton {

  public CreateEvalReportButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fevalReport";
    this.defaultText = "生成评审报告";
    this.iconName = "check.jpg";
    super.init();
  }
}

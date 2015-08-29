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
* @Description: TODO(������һ�仰��������������)
* @date: 2010-12-4 ����02:18:08
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ExperMessageButton extends FuncButton {

  /**
   * 
   */
  private static final long serialVersionUID = 4965899958388502676L;

  public ExperMessageButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "expertMessage";
    this.defaultText = "ר�����";
    this.iconName = "subadd.png";
    super.init();
  }
}

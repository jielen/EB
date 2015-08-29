/**   
* @(#) project: ZFCG
* @(#) file: ShowEvalComlResultButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ShowEvalComlResultButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-4-17 上午10:09:40
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ShowEvalComlResultButton extends FuncButton {
  private static final long serialVersionUID = 8176162602374553497L;

  public ShowEvalComlResultButton() {
    super();
  }

  protected void init() {
    this.funcCtrl = false;
    this.funcId = "fShowEvalComlResult";
    this.defaultText = "显示符合性评审汇总表";
    this.iconName = "import.jpg";
    super.init();
  }

}

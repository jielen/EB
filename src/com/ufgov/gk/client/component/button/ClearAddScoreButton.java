/**   
* @(#) project: ZFCG
* @(#) file: ClearAddScoreButton.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.button;

/**
* @ClassName: ClearAddScoreButton
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-4-19 下午07:54:01
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class ClearAddScoreButton extends FuncButton {
  public ClearAddScoreButton() {
    super();
  }

  protected void init() {
    this.funcId = "fclearAddScore";
    this.defaultText = "清除加分项";
    super.init();
  }

}

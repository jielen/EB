/**   
* @(#) project: ZFCG
* @(#) file: JFuncPopupMenu.java
* 
* Copyright 2011 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component;

import java.awt.Component;

import javax.swing.JPopupMenu;

import com.ufgov.gk.client.component.Menu.FuncMenuItem;

/**
* @ClassName: JFuncPopupMenu
* @Description: TODO(这里用一句话描述这个类的作用)
* @date: 2011-6-9 下午01:34:52
* @version: V1.0 
* @since: 1.0
* @author: fanpl
* @modify: 
*/
public class JFuncPopupMenu extends JPopupMenu {

  private String compoId;

  private String moduleCode;

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public JFuncPopupMenu() {
    super();
    initFuncPopupMenu();
  }

  public JFuncPopupMenu(String moduleCode, String compoId) {
    super();
    this.compoId = compoId;
    this.moduleCode = moduleCode;
    initFuncPopupMenu();
  }

  public JFuncPopupMenu(String label) {
    super(label);
    initFuncPopupMenu();
  }

  private void initFuncPopupMenu() {

  }

  public FuncMenuItem add(FuncMenuItem funcMenuItem) {
    this.addSeparator();
    funcMenuItem.setCompoId(this.getCompoId());
    funcMenuItem.setModuleCode(moduleCode);
    super.add(funcMenuItem);
    return funcMenuItem;
  }

  public FuncMenuItem add(FuncMenuItem funcMenuItem, int index) {
    funcMenuItem.setCompoId(this.getCompoId());
    funcMenuItem.setModuleCode(moduleCode);
    super.add(funcMenuItem, index);
    return funcMenuItem;
  }

  @Override
  public Component add(Component comp) {
    super.add(comp);
    return comp;
  }

  public String getModuleCode() {
    return moduleCode;
  }

  public void setModuleCode(String moduleCode) {
    this.moduleCode = moduleCode;
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      c.setEnabled(enabled);
    }
  }

  public FuncMenuItem getButtonByFuncId(String funcId) {
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      if (funcId != null && funcId.equals(((FuncMenuItem) c).getFuncId())) {
        return (FuncMenuItem) c;
      }
    }
    return null;
  }

  public FuncMenuItem getButtonByDefaultText(String defaultText) {
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      if (defaultText != null && defaultText.equals(((FuncMenuItem) c).getDefaultText())) {
        return (FuncMenuItem) c;
      }
    }
    return null;
  }

}

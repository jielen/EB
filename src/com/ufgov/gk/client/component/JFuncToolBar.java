package com.ufgov.gk.client.component;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JToolBar;

import com.ufgov.gk.client.component.button.FuncButton;

public class JFuncToolBar extends JToolBar {

  private String compoId;

  private String moduleCode;

  public String getCompoId() {
    return compoId;
  }

  public void setCompoId(String compoId) {
    this.compoId = compoId;
  }

  public JFuncToolBar() {
    super();
    initFuncToolBar();
  }

  public JFuncToolBar(String compoId) {
    super();
    this.compoId = compoId;
    initFuncToolBar();
  }

  public JFuncToolBar(int orientation) {
    super(orientation);
    initFuncToolBar();
  }

  public JFuncToolBar(String name, int orientation) {
    super(name, orientation);
    initFuncToolBar();
  }

  private void initFuncToolBar() {
    this.setFloatable(false);
    this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
  }

  public FuncButton add(FuncButton funcButton) {
    funcButton.setCompoId(this.getCompoId());
    funcButton.setModuleCode(moduleCode);
    super.add(funcButton);
    return funcButton;
  }

  public FuncButton add(FuncButton funcButton, int index) {
    funcButton.setCompoId(this.getCompoId());
    funcButton.setModuleCode(moduleCode);
    super.add(funcButton, index);
    return funcButton;
  }

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

  public Dimension getPreferredSize() {
    Dimension size = super.getPreferredSize();
    int n = 0;
    int w = getWidth();
    if (w == 0) {
      return size;
    }
    n = size.width / w;
    size.height += size.height * n;
    return size;
  }

  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      c.setEnabled(enabled);
    }
  }

  public FuncButton getButtonByFuncId(String funcId) {
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      if (funcId != null && funcId.equals(((FuncButton) c).getFuncId())) {
        return (FuncButton) c;
      }
    }
    return null;
  }

  public FuncButton getButtonByDefaultText(String defaultText) {
    Component[] compoents = this.getComponents();
    for (Component c : compoents) {
      if (defaultText != null && defaultText.equals(((FuncButton) c).getDefaultText())) {
        return (FuncButton) c;
      }
    }
    return null;
  }
}

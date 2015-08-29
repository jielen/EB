package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class SaveButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public SaveButton() {
    super();
  }

  protected void init() {
    this.funcId = "fsave";
    this.defaultText = "����";
    this.iconName="save.jpg";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
      KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK), "saveAction");
    getActionMap().put("saveAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }

  public void setToolTipText(String text) {
    String tipText = this.getText() + "��Ctrl+S��";
    super.setToolTipText(tipText);
  }

}

package com.ufgov.gk.client.component.button;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

public class AddButton extends FuncButton {
  /**
   * 
   */
  private static final long serialVersionUID = -2564446291342163428L;

  public AddButton() {
    super();
  }

  protected void init() {

    this.funcId = "fnew";
    this.defaultText = "����";
    this.iconName = "add.jpg";
    super.init();

    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK), "newAction");
    getActionMap().put("newAction", new AbstractAction() {
      public void actionPerformed(ActionEvent e) {
        doClick();
      }
    });

  }

  public void setToolTipText(String text) {
    String tipText = this.getText() + "��Ctrl+N��";
    super.setToolTipText(tipText);
  }

}

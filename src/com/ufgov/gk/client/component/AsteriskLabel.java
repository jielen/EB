package com.ufgov.gk.client.component;

import javax.swing.JLabel;

import com.ufgov.gk.client.util.SwingUtil;

public class AsteriskLabel extends JLabel {
  /**
   * 
   */
  private static final long serialVersionUID = 56572664867443457L;

  public AsteriskLabel(String text) {
    super(SwingUtil.processAsteriskLabel(text));
    //this.setText(text);
  }

  //  public void setText(String text) {
  //    super.setText(SwingUtil.processAsteriskLabel(text));
  //  }

}

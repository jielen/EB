package com.ufgov.gk.client.component;

import javax.swing.JTextArea;

public class JTextAreaLabel extends JTextArea {

  /**
   * 
   */
  private static final long serialVersionUID = 6585216070652637746L;

  public JTextAreaLabel() {
    init();
  }

  private void init() {
    setLineWrap(true);
    setEditable(false);
    setOpaque(false);
  }

}

package com.ufgov.gk.client.component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class EbStatusSeparator extends JLabel {

  private ImageIcon imageIcon = EbComponentUtil.getImageIcon("statusbar_separator.png");

  public EbStatusSeparator() {
    init();
  }

  private void init() {
    this.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    this.setOpaque(false);
    this.setIcon(imageIcon);
  }

}

/**
 * EbStatusLabel.java
 * com.ufgov.gk.client.component
 * Administrator
 * Sep 12, 2012
 */
package com.ufgov.gk.client.component;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author Administrator
 *
 */
public class EbStatusLabel extends JLabel {

  public EbStatusLabel() {
    this(null, null);
  }

  public EbStatusLabel(String text) {
    this(text, null);
  }

  public EbStatusLabel(Icon icon) {
    this(null, icon);
  }

  public EbStatusLabel(String text, Icon icon) {
    super(text, icon, SwingConstants.LEADING);
    init();
  }

  protected void init() {
    this.setOpaque(false);
    this.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
    this.setFont(EbComponentUtil.FONT_12_BOLD);
    this.setForeground(EbComponentUtil.DEFAULT_TEXT_COLOR);
    this.setVerticalAlignment(SwingConstants.CENTER);
    this.setVerticalTextPosition(SwingConstants.CENTER);
    this.setIconTextGap(5);
  }

}

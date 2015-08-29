/**
 * EbStatusMessageLabel.java
 * com.ufgov.gk.client.component
 * Administrator
 * Sep 12, 2012
 */
package com.ufgov.gk.client.component;

import javax.swing.ImageIcon;

/**
 * @author Administrator
 *
 */
public class EbStatusMessageLabel extends EbStatusLabel {

  private static final ImageIcon ICON_ORANGE = EbComponentUtil.getImageIcon("statusbar_message_light_orange.png");

  private static final ImageIcon ICON_RED = EbComponentUtil.getImageIcon("statusbar_message_light_red.png");

  private static final ImageIcon ICON_GREEN = EbComponentUtil.getImageIcon("statusbar_message_light_green.png");

  @Override
  protected void init() {
    super.init();
    this.setFont(EbComponentUtil.FONT_14_BOLD);
    this.setGreenLight();
  }

  public void setRedLight() {
    this.setIcon(ICON_RED);
  }

  public void setGreenLight() {
    this.setIcon(ICON_GREEN);
  }

  public void setOrangeLight() {
    this.setIcon(ICON_ORANGE);
  }

}

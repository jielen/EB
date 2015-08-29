/**
 * TopMenuBar.java
 * com.eb.client.component
 * Administrator
 * Jun 22, 2012
 */
package com.eb.client.component;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * 顶部系统按钮
 * @author Administrator
 *
 */
public class TopMenuBarPanel extends JPanel {
  EbMain parent;

  public TopMenuBarPanel(EbMain ebMain) {
    this.parent = ebMain;
  }

  public Dimension getPreferredSize() {
    return new Dimension(super.getPreferredSize().width, 20);
  }
}

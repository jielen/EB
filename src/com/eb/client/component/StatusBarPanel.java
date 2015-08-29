/**
 * StatusBarPanel.java
 * com.eb.client.component
 * Administrator
 * Jun 22, 2012
 */
package com.eb.client.component;

import java.awt.Dimension;

import javax.swing.JPanel;

/**
 * @author Administrator
 *
 */
public class StatusBarPanel extends JPanel {
  private EbMain ebMain;

  public StatusBarPanel(EbMain ebMain) {
    // TODO Auto-generated constructor stub
    this.ebMain = ebMain;
  }

  public Dimension getPreferredSize() {
    return new Dimension(super.getPreferredSize().width, 30);
  }
}

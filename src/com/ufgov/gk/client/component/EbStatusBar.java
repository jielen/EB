/**
 * EbStatusBar.java
 * com.ufgov.gk.client.component
 * Administrator
 * Sep 12, 2012
 */
package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.TexturePaint;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 * @author Administrator
 *
 */
public class EbStatusBar extends JPanel {

  //  private String backgroundImageURL = EbComponentUtil.getImageURL("statusbar_background.png");
  private Image backgroundLeftImage = EbComponentUtil.getImage("statusbar_background_left.png");

  private Image backgroundRightImage = EbComponentUtil.getImage("statusbar_background_right.png");

  private ImageIcon backgroundImageIcon = EbComponentUtil.getImageIcon("statusbar_background.png");

  private TexturePaint paint = EbComponentUtil.createTexturePaint("statusbar_background.png");

  private JPanel leftPane = new JPanel(new BorderLayout());

  private JPanel rightPane = new JPanel(new FlowLayout(FlowLayout.LEADING, 0, 0));

  private Border border = BorderFactory.createEmptyBorder(2, 10, 0, 0);

  public EbStatusBar() {
    init();
  }

  private void init() {
    this.setLayout(new BorderLayout());
    this.add(leftPane, BorderLayout.CENTER);
    this.add(rightPane, BorderLayout.EAST);
    this.setBorder(border);
    leftPane.setOpaque(false);
    rightPane.setOpaque(false);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setPaint(paint);
    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());

    //paint left side image.
    g2d.drawImage(backgroundLeftImage, 0, 0, null);

    //paint right side image.
    g2d.drawImage(backgroundRightImage, this.getWidth() - backgroundRightImage.getWidth(null), 0, null);
  }

  public JPanel getLeftPane() {
    return leftPane;
  }

  public JPanel getRightPane() {
    return rightPane;
  }

  public void addSeparator() {
    rightPane.add(new EbStatusSeparator());
  }

  @Override
  public Dimension getPreferredSize() {
    return new Dimension(super.getPreferredSize().width, backgroundImageIcon.getIconHeight());
  }

}

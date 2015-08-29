package com.ufgov.gk.client.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class EbToolbarButton extends JButton {

  private int buttonSize = EbComponentUtil.DEFAULT_BUTTON_SIZE;

  private Color roverBorderColor = EbComponentUtil.BUTTON_ROVER_COLOR;

  private Border roverBorder = new Border() {

    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      g.setColor(roverBorderColor);
      g.drawRect(x, y, width - 1, height - 1);
    }

    public Insets getBorderInsets(Component c) {
      return new Insets(1, 1, 1, 1);
    }

    public boolean isBorderOpaque() {
      return true;
    }
  };

  private Border emptyBorder = BorderFactory.createEmptyBorder(1, 1, 1, 1);

  public EbToolbarButton() {
    this(null, null);
  }

  public EbToolbarButton(String text) {
    this(text, null);
  }

  public EbToolbarButton(Icon icon) {
    this(null, icon);
  }

  public EbToolbarButton(String text, Icon icon) {
    super(text, icon);
    init();
  }

  private void init() {
    this.setVerticalAlignment(SwingConstants.CENTER);
    this.setFont(EbComponentUtil.FONT_12_BOLD);
    this.setOpaque(false);
    this.setBorder(emptyBorder);
    this.setContentAreaFilled(false);
    this.setFocusPainted(false);
    this.setRolloverEnabled(true);

    this.addMouseListener(new MouseAdapter() {

      @Override
      public void mouseEntered(MouseEvent e) {
        if (isEnabled() && isRolloverEnabled()) {
          setBorder(roverBorder);
        }
      }

      @Override
      public void mouseExited(MouseEvent e) {
        if (isEnabled() && isRolloverEnabled()) {
          setBorder(emptyBorder);
        }
      }
    });
  }

  @Override
  public void setIcon(final Icon icon) {
    super.setIcon(icon);
    //generate rover icon and pressed icon.

    if (icon == null) {
      this.setPressedIcon(null);
      this.setRolloverIcon(null);
    } else {
      Icon pressedIcon = EbComponentUtil.createMovedIcon(icon);
      this.setPressedIcon(pressedIcon);
    }
  }

  @Override
  public Dimension getPreferredSize() {
    int width = super.getPreferredSize().width;
    width = Math.max(width, buttonSize);
    int height = buttonSize;
    return new Dimension(width, height);
  }

  public void setRoverBorder(Border roverBorder) {
    this.roverBorder = roverBorder;
    this.repaint();
  }

}

package com.ufgov.gk.client.component.tablelayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.border.AbstractBorder;

public class CustomBorder extends AbstractBorder {

  @Override
  public Insets getBorderInsets(Component c) {
    return new Insets(0, 0, 0, 0);
  }

  @Override
  public boolean isBorderOpaque() {
    return true;
  }

  @Override
  public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
    g.setColor(Color.GRAY);
    g.drawRect(x - 1, y - 1, width, height);
  }

}
/**   
* @(#) project: zcxa
* @(#) file: JTreeCellRenderer.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.zc.tree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.DefaultTreeCellRenderer;


public class JTreeCellRenderer extends DefaultTreeCellRenderer {

  private static final long serialVersionUID = -1608098219858173735L;

  protected JCheckBox check;

  protected TreeLabel label;

  protected String nodeType;

  public JTreeCellRenderer() {
    setLayout(null);
    add(label = new TreeLabel());
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected,
    boolean expanded, boolean leaf,int row, boolean hasFocus) {
    JTreeNode treeNode = (JTreeNode) value;
    boolean yezi=treeNode.isLeaf();
    
    String stringValue = tree.convertValueToText(value, isSelected, expanded,leaf, row, hasFocus);
    setEnabled(tree.isEnabled());
    label.setFont(tree.getFont());
    label.setText(stringValue);
    label.setSelected(isSelected);
    label.setFocus(hasFocus);
    if (yezi) {
      label.setIcon(getImageIcon("default.gif"));
    } else if (expanded) {
      label.setIcon(UIManager.getIcon("Tree.openIcon"));
    } else {
      label.setIcon(UIManager.getIcon("Tree.closedIcon"));
    }
    return this;

  }
  private  ImageIcon getImageIcon(String imgFileName) {
    String imgFileDir = "com/ufgov/gk/client/zc/formula/img/" + imgFileName;
    URL imgURL = ClassLoader.getSystemResource(imgFileDir);
    if (imgURL == null) {
      return null;
    }
    return new ImageIcon(imgURL);
  }
  public Dimension getPreferredSize() {
    Dimension d_label = label.getPreferredSize();
    return new Dimension(d_label.width, d_label.height);
  }

  public void doLayout() {
    Dimension d_label = label.getPreferredSize();
    label.setLocation(0, 0);
    label.setBounds(0, 0, d_label.width * 2, d_label.height);
  }

  public void setBackground(Color color) {
    if (color instanceof ColorUIResource)
      color = null;
    super.setBackground(color);
  }

  class TreeLabel extends JLabel {

    private static final long serialVersionUID = -4749781856388236035L;

    boolean isSelected;

    boolean hasFocus;

    TreeLabel() {
    }

    public void setBackground(Color color) {
      if (color instanceof ColorUIResource)
        color = null;
      super.setBackground(color);
    }

    public void paint(Graphics g) {
      String str;
      if ((str = getText()) != null) {
        if (0 < str.length()) {
          if (isSelected) {
            g.setColor(UIManager.getColor("Tree.selectionBackground"));
          } else {
            g.setColor(UIManager.getColor("Tree.textBackground"));
          }
          Dimension d = getPreferredSize();
          int imageOffset = 0;
          Icon currentI = getIcon();
          if (currentI != null) {
            imageOffset = currentI.getIconWidth() + Math.max(0, getIconTextGap() - 1);
          }
          g.fillRect(imageOffset, 0, d.width - 1 - imageOffset, d.height);
          if (hasFocus) {
            g.setColor(UIManager.getColor("Tree.selectionBorderColor"));
            g.drawRect(imageOffset, 0, d.width - 1 - imageOffset, d.height - 1);
          }
        }
      }
      super.paint(g);
    }

    public Dimension getPreferredSize() {
      Dimension retDimension = super.getPreferredSize();
      if (retDimension != null) {
        retDimension = new Dimension(retDimension.width + 300, retDimension.height);
      }
      return retDimension;
    }

    void setSelected(boolean isSelected) {
      this.isSelected = isSelected;
    }

    void setFocus(boolean hasFocus) {
      this.hasFocus = hasFocus;
    }
  }
}

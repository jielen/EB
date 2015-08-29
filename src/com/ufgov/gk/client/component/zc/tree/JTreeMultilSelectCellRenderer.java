/**   
* @(#) project: GK
* @(#) file: JTreeMultilSelectCellRenderer.java
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

import javax.swing.Icon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
* @ClassName: JTreeMultilSelectCellRenderer
* @Description: 带多选框的树节点渲染器。
* @date: 2010-4-26 下午04:50:23
* @version: V1.0 
* @since: 1.0
* @author: tianly
* @modify: 
*/
public class JTreeMultilSelectCellRenderer extends DefaultTreeCellRenderer {

  private static final long serialVersionUID = -1608098219858173735L;

  private static final int ADJUST_HEIGHT = 0;

  protected JCheckBox check;

  protected TreeLabel label;

  public JTreeMultilSelectCellRenderer() {
    setLayout(null);
    add(check = new JCheckBox());
    add(label = new TreeLabel());
    check.setBackground(UIManager.getColor("Tree.textBackground"));
  }

  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected,
    boolean expanded, boolean leaf, int row, boolean hasFocus) {
    String stringValue = tree.convertValueToText(value, isSelected, expanded, leaf, row, hasFocus);
    setEnabled(tree.isEnabled());
    check.setSelected(((JTreeNode) value).isSelected());
    label.setFont(tree.getFont());
    label.setText(stringValue);
    label.setSelected(isSelected);
    label.setFocus(hasFocus);
    if (leaf) {
      label.setIcon(UIManager.getIcon("Tree.leafIcon"));
    } else if (expanded) {
      label.setIcon(UIManager.getIcon("Tree.openIcon"));
    } else {
      label.setIcon(UIManager.getIcon("Tree.closedIcon"));
    }
    return this;
  }

  public Dimension getPreferredSize() {
    Dimension d_check = check.getPreferredSize();
    Dimension d_label = label.getPreferredSize();
    return new Dimension(d_check.width + d_label.width, (d_check.height < d_label.height ? d_label.height
      : d_check.height + ADJUST_HEIGHT));
  }

  public void doLayout() {
    Dimension d_check = check.getPreferredSize();
    Dimension d_label = label.getPreferredSize();

    int y_check = 0;
    int y_label = 0;
    if (d_check.height < d_label.height) {
      y_check = (d_label.height - d_check.height) / 2;
    } else {
      y_label = (d_check.height - d_label.height) / 2;
    }
    check.setLocation(0, y_check);
    /**
     * 选择框的位置需要调整，否则下边框看不到
     */
    check.setBounds(0, y_check, d_check.width, d_check.height - ADJUST_HEIGHT);
    label.setLocation(d_check.width, y_label);
    label.setBounds(d_check.width, y_label, d_label.width * 4, d_label.height);
  }

  public void setBackground(Color color) {
    if (color instanceof ColorUIResource)
      color = null;
    super.setBackground(color);
  }

  private class TreeLabel extends JLabel {

    private static final long serialVersionUID = -4749781856388236035L;

    boolean isSelected;

    boolean hasFocus;

    public TreeLabel() {
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
        retDimension = new Dimension(retDimension.width + 3, retDimension.height + ADJUST_HEIGHT);
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


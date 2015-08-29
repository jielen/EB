package com.eb.client.component.test;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EasyGridLayout extends GridBagLayout {
  public void setConstraints(JLabel c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 0, 0, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JButton c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 0, 0, GridBagConstraints.NONE, GridBagConstraints.CENTER);
  }

  public void setConstraints(JTextField c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 100, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JScrollPane c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 100, 100, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JTextArea c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 100, 100, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JList c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 100, 100, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JCheckBox c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JRadioButton c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 0, 0, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST);
  }

  public void setConstraints(JPanel c, int row, int col, int width, int height) {
    finishSet(c, row, col, width, height, 100, 100, GridBagConstraints.BOTH, GridBagConstraints.NORTHWEST);
  }

  private void finishSet(Component c, int y, int x, int w, int h,// gridx,gridwidth4个单位都是网格
    int weightx, int weighty, // 分配额外空间比例给行列 ，以上三种都是如何将网格分配给组件。
    int fill, int anchor) {// 组件大于或小于网格时伸缩或放置位置。 在特定网格区域内设置伸缩，放置，内边距。

    GridBagConstraints gbc = new GridBagConstraints();

    gbc.insets.bottom = 5; //组件与放置它的grix、gridy之间的偏移，单位为px.
    gbc.insets.left = 5;
    gbc.insets.right = 5;
    gbc.insets.top = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;
    gbc.insets.top = 5;

    gbc.weightx = weightx;
    gbc.weighty = weighty;

    gbc.fill = fill;
    gbc.anchor = anchor;

    gbc.gridx = x - 1;
    gbc.gridy = y - 1;

    gbc.gridwidth = w;
    gbc.gridheight = h;
    setConstraints(c, gbc);//
  }
}

package com.ufgov.gk.client.component.tablelayout;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

public class Compound extends JPanel {

  private JLabel left = new JLabel("����");
  private JList list = new JList();
  private String[] rowTexts;
  private JTable table;

  public Compound(JTable table, String leftText, String[] rowTexts) {
    this.table = table;
    this.rowTexts = rowTexts;
    left.setText(leftText);
    left.setPreferredSize(new Dimension(table.getRowHeight(), table.getRowHeight()));
    left.setHorizontalAlignment(JLabel.CENTER);
    left.setVerticalAlignment(JLabel.CENTER);
    setOpaque(true);
    setBackground(table.getBackground());
    init();

  }

  private void init() {
    setLayout(new BorderLayout());
    left.setBorder(new CustomBorder());
    add(left, BorderLayout.WEST);
    add(list, BorderLayout.CENTER);

    list.setFixedCellHeight(table.getRowHeight());

    list.setModel(new AbstractListModel() {

      public Object getElementAt(int index) {
        return rowTexts[index];
      }

      public int getSize() {
        return rowTexts.length;
      }
    });
    DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
      public Component getListCellRendererComponent(JList list, Object value,
        int index, boolean isSelected, boolean cellHasFocus) {
        setHorizontalAlignment(JLabel.CENTER);
        super.getListCellRendererComponent(list, value, index, false, false);
        setBorder(new CustomBorder());
        return this;
      }
    };
    list.setCellRenderer(renderer);
  }
}
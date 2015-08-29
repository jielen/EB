package com.ufgov.gk.client.component.tablelayout;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.AbstractBorder;
import javax.swing.table.AbstractTableModel;

public class Report {

  public static void main(String[] args) throws ClassNotFoundException,
    InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame frame = new JFrame("frame");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(800, 600);
    frame.setLocationRelativeTo(null);
    JTable table = new JTable();
    table.setRowHeight(33);

    table.setModel(new AbstractTableModel() {

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex % 2 != 0;
      }

      public int getColumnCount() {
        return 4;
      }

      public int getRowCount() {
        return 24;
      }

      public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex % 2 == 0)
          return rowIndex + 1;
        return null;
      }
    });
    table.setGridColor(Color.BLACK);
    table.setLayout(new GridCellLayout());

    table.add(new Compound(table, "其中", new String[] { "办公室", "会议室", "车库", "食堂",
      "配电室", "机房" }), new CellConstraints(3, 0, 8, 0));

    table.add(new Compound(table, "<html>经<br>济<br>来<br>源</html>", new String[] {
      "财政性资金", "其他资金" }), new CellConstraints(11, 0, 12, 0));

    table.add(new Compound(table, "<html>使<br>用<br>方<br>向<br>及<br>面<br>积</html>",
      new String[] { "自用", "出借", "出租", "经营", "闲置", "基他" }), new CellConstraints(14,
      0, 19, 0));

    JLabel label = createLabel("备注", table.getBackground());
    table.add(label, new CellConstraints(21, 0, 34, 0));

    JTextArea textArea = new JTextArea();
    textArea.setBorder(new CustomBorder());
    table.add(textArea, new CellConstraints(21, 1, 34, 1));

    label = createLabel("照片序览", table.getBackground());

    table.add(label, new CellConstraints(18, 2, 34, 2));

    label = createLabel("", table.getBackground());
    label.setBorder(new AbstractBorder() {
      @Override
      public void paintBorder(Component c, Graphics g, int x, int y, int width,
        int height) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.BLACK);
        g.drawRect(x - 1, y - 1, width, height);
        float[] dash = { 20.0f, 3.0f };
        g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_ROUND,
          BasicStroke.JOIN_BEVEL, 1.0f, dash, 1.0f));
        g2d.drawRect(x + 8, y + 8, width - 16, height - 16);

      }
    });
    table.add(label, new CellConstraints(18, 3, 34, 3));

    table.add(new JComboBox(new String[] { "a", "b" }), new CellConstraints(0, 1, 0,
      1));

    JPanel panel = new JPanel(new BorderLayout());
    panel.add(table);
    panel.add(new JLabel() {
      {
        setOpaque(true);
        setBackground(Color.WHITE);
      }

      @Override
      public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        preferredSize.width = 40;
        return preferredSize;
      }

      @Override
      public void paint(Graphics g) {
        super.paint(g);
        g.setColor(new Color(0xE7E7D6));
        g.fillRect(0, 20, 20, getHeight());
      }
    }, BorderLayout.EAST);

    frame.getContentPane().add(new JScrollPane(panel));
    frame.setVisible(true);
  }

  private static JLabel createLabel(String text, Color background) {
    JLabel label = new JLabel(text);
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    label.setOpaque(true);
    label.setBackground(background);
    label.setBorder(new CustomBorder());
    label.setForeground(Color.RED);
    return label;
  }
}

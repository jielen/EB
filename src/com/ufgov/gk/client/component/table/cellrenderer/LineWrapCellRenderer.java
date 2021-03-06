package com.ufgov.gk.client.component.table.cellrenderer;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class LineWrapCellRenderer extends JTextArea implements TableCellRenderer {

  private static final long serialVersionUID = 6661718059329644534L;

  protected final DefaultTableCellRenderer defaultCellRenderer = new DefaultTableCellRenderer();

  public LineWrapCellRenderer() {
    /*
     * 为了加快列表显示速度，默认不进行换行 chenjl 2012-7-20
     */
    //    setLineWrap(true);
    setWrapStyleWord(false);
    setEditable(false);
  }

  public Component getTableCellRendererComponent(final JTable table, Object value, boolean isSelected, boolean hasFocus, final int row, int column) {
    defaultCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    setForeground(defaultCellRenderer.getForeground());
    setBackground(defaultCellRenderer.getBackground());
    setBorder(defaultCellRenderer.getBorder());
    setFont(defaultCellRenderer.getFont());
    setText(defaultCellRenderer.getText());

    return this;
  }

  public Component getTableCellRendererComponentWithColor(final JTable table, Object value, boolean isSelected, boolean hasFocus, final int row,
    int column, Color foreground, Color background) {
    defaultCellRenderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    foreground = foreground == null ? defaultCellRenderer.getForeground() : foreground;
    background = background == null ? defaultCellRenderer.getBackground() : background;
    if (isSelected) {
      setForeground(defaultCellRenderer.getForeground());
      setBackground(defaultCellRenderer.getBackground());
    } else {
      setForeground(foreground);
      setBackground(background);
    }
    //    setForeground(foreground == null ? defaultCellRenderer.getForeground() : foreground);
    //    setBackground(background == null ? defaultCellRenderer.getBackground() : background);
    //    defaultCellRenderer.setForeground(foreground);
    //    defaultCellRenderer.setBackground(background);
    setBorder(defaultCellRenderer.getBorder());
    setFont(defaultCellRenderer.getFont());
    setText(defaultCellRenderer.getText());

    return this;
  }
}

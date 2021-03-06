package com.ufgov.gk.client.report;

import java.awt.Color;
import java.awt.Component;
import java.math.BigDecimal;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ReportCellRenderer extends DefaultTableCellRenderer {
  private NumberFormat numberFormat = NumberFormat.getInstance();

  public ReportCellRenderer() {
    this.setVerticalAlignment(JLabel.TOP);
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
  }

  public Object getDisplayValue(JTable table, Object value, int row, int column) {
    return value;
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    boolean hasFocus, int row, int column) {
    if (row % 2 == 0) {// 设置偶数行的背景颜色
      setBackground(new Color(255, 255, 255));
    } else {// 基数行的背景颜色
      setBackground(new Color(220, 231, 255));
    }
    if (value instanceof BigDecimal) {
      value = numberFormat.format(value);
      setHorizontalAlignment(JLabel.RIGHT);
    } else if (value instanceof Double) {
      value = value + "%";
      setHorizontalAlignment(JLabel.RIGHT);
    } else {
      setHorizontalAlignment(JLabel.LEFT);
    }
    Object displayValue = getDisplayValue(table, value, row, column); //转换成显示值
    return super.getTableCellRendererComponent(table, displayValue, isSelected, hasFocus, row, column);
  }

}

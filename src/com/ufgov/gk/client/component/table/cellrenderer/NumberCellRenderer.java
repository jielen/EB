package com.ufgov.gk.client.component.table.cellrenderer;


import java.awt.Component;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;


public class NumberCellRenderer extends DefaultTableCellRenderer {
  
  /**
   * 
   */
  private static final long serialVersionUID = 5739234501200780350L;
  
  
  private NumberFormat numberFormat ;

  public NumberCellRenderer(NumberFormat numberFormat) {
    super();
    setHorizontalAlignment(JLabel.RIGHT);
    this.setVerticalAlignment(JLabel.TOP);
    this.numberFormat = numberFormat;
  }

  /**
   * 创建默认实例，格式为：小数部分保留2为，整数部分以千分位显示，显示位置靠右
   */
  public NumberCellRenderer() {
    super();
    setHorizontalAlignment(JLabel.RIGHT);
    this.setVerticalAlignment(JLabel.TOP);
    this.numberFormat = NumberFormat.getInstance();
    numberFormat.setMinimumFractionDigits(2);
    numberFormat.setMaximumFractionDigits(2);
    
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
    boolean isSelected, boolean hasFocus, int row, int column) {

    try {
      value = numberFormat.format(value);
    } catch (Exception e) {
    }
    return super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
      row, column);
  }
}

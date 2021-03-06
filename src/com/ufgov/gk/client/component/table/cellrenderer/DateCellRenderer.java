package com.ufgov.gk.client.component.table.cellrenderer;

import java.awt.Component;
import java.util.Date;

import javax.swing.JTable;

import com.ufgov.gk.common.system.util.DateUtil;
import com.ufgov.smartclient.component.table.TableCellDisplayValueProvider;

public class DateCellRenderer extends LineWrapCellRenderer implements TableCellDisplayValueProvider {

  /**
   * 
   */
  private static final long serialVersionUID = 3184261311169929819L;

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    String dateString = "";

    if (value instanceof java.util.Date) {
      dateString = DateUtil.dateToDdString((Date) value);
    }

    return super.getTableCellRendererComponent(table, dateString, isSelected, hasFocus, row, column);
  }

  @Override
  public Object getDisplayValue(JTable jtable, Object obj, int i, int j) {
    if (obj instanceof java.util.Date) {
      return DateUtil.dateToDdString((Date) obj);
    }
    return "";
  }

}

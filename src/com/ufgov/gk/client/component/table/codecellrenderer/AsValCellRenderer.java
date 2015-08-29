package com.ufgov.gk.client.component.table.codecellrenderer;

import java.awt.Component;

import javax.swing.JTable;

import com.ufgov.gk.client.component.table.cellrenderer.LineWrapCellRenderer;
import com.ufgov.gk.client.datacache.AsValDataCache;

public class AsValCellRenderer extends LineWrapCellRenderer {

  private String valSetId = null;

  public AsValCellRenderer(String valSetId) {
    this.valSetId = valSetId;
  }

  private static final long serialVersionUID = 3184261311169929819L;

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
    String name = null;
    if (value != null) {
      name = AsValDataCache.getName(valSetId, value.toString());
      this.setToolTipText("[" + value + "]" + name);
    } else {
      this.setToolTipText(null);
    }
    return super.getTableCellRendererComponent(table, name, isSelected, hasFocus, row, column);
  }

}
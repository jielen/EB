package com.ufgov.gk.client.component.tablelayout;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.TableCellRenderer;

public class GridPanel extends JTable {
  class CellRenderer extends JLabel implements TableCellRenderer {

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {
      setBackground(table.getBackground());
      return this;
    }

  }

  private CellRenderer cellRenderer = new CellRenderer();

  public GridPanel() {
    setShowGrid(false);
  }

  @Override
  public TableCellRenderer getCellRenderer(int row, int column) {
    return cellRenderer;
  }

  @Override
  public void updateUI() {
    setUI(new BasicTableUI());
  }
}

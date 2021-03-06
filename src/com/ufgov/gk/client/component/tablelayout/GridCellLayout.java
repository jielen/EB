package com.ufgov.gk.client.component.tablelayout;



import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager2;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JTable;
import javax.swing.SwingUtilities;

public class GridCellLayout implements LayoutManager2 {
  private Map<Component, CellConstraints> cellMap = new HashMap<Component, CellConstraints>();

  public void addLayoutComponent(Component comp, Object constraints) {
    if (!(constraints instanceof CellConstraints)) {
      return;
    }
    cellMap.put(comp, (CellConstraints) constraints);
  }

  public float getLayoutAlignmentX(Container target) {
    return 0;
  }

  public float getLayoutAlignmentY(Container target) {
    return 0;
  }

  public void invalidateLayout(Container target) {

  }

  public Dimension maximumLayoutSize(Container target) {
    return null;
  }

  public void addLayoutComponent(String name, Component comp) {
  }

  public void layoutContainer(Container parent) {
    JTable table = (JTable) parent;
    for (Component c : cellMap.keySet()) {
      CellConstraints cellConstraints = cellMap.get(c);
      Rectangle cellRect = table.getCellRect(cellConstraints.getFromRowIndex(),
        cellConstraints.getFromColumnIndex(), true);
      Rectangle cellRect2 = table.getCellRect(cellConstraints.getToRowIndex(),
        cellConstraints.getToColumnIndex(), true);
      Rectangle rect = SwingUtilities.computeUnion(cellRect.x, cellRect.y,
        cellRect.width, cellRect.height, cellRect2);
      Insets insets = cellConstraints.getInsets();
      rect.y += insets.top;
      rect.x += insets.left;
      rect.height -= (insets.top + insets.bottom);
      rect.width -= (insets.left + insets.right);
      c.setBounds(rect);
    }
  }

  public Dimension minimumLayoutSize(Container parent) {
    return null;
  }

  public Dimension preferredLayoutSize(Container parent) {
    return null;
  }

  public void removeLayoutComponent(Component comp) {

  }

}
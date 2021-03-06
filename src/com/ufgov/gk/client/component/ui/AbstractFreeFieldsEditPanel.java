package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;

import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.tablelayout.CellConstraints;
import com.ufgov.gk.client.component.tablelayout.CustomBorder;
import com.ufgov.gk.client.component.tablelayout.GridCellLayout;
import com.ufgov.gk.client.component.tablelayout.GridPanel;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.util.SwingUtil;

public abstract class AbstractFreeFieldsEditPanel extends JPanel {

  private static final long serialVersionUID = -4293912619075083022L;

  protected final GridPanel dynamicPane = new GridPanel();

  protected List<AbstractFieldEditor> fieldEditors = new ArrayList();

  protected String product;

  protected Object editObject;

  protected void init() {

    fieldEditors = createFieldEditors();

    addFieldEditors();

    JScrollPane scrollPane = new JScrollPane();

    scrollPane.getViewport().add(dynamicPane);

    this.setLayout(new BorderLayout());
    this.add(scrollPane, BorderLayout.CENTER);
  }

  protected abstract List<AbstractFieldEditor> createFieldEditors();

  private void addFieldEditors() {

    //    dynamicPane.setGridColor(Color.BLACK);
    //    dynamicPane.setShowGrid(true);
    dynamicPane.removeAll();
    dynamicPane.setRowHeight(25);
    dynamicPane.setLayout(new GridCellLayout());
    dynamicPane.setBackground(this.getBackground());
    dynamicPane.setModel(new AbstractTableModel() {
      private static final long serialVersionUID = 2745205066889916971L;

      public int getColumnCount() {
        return 4;
      }

      public int getRowCount() {
        return fieldEditors.size() / 2 + 1;
      }

      public String getColumnName(int column) {
        return "";
      }

      public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
      }
    });
    dynamicPane.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(
      (int) (UIConstants.SCREEN_HEIGHT * 0.04));
    dynamicPane.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(
      (int) (UIConstants.SCREEN_HEIGHT * 0.23));
    dynamicPane.getTableHeader().getColumnModel().getColumn(2).setPreferredWidth(
      (int) (UIConstants.SCREEN_HEIGHT * 0.04));
    dynamicPane.getTableHeader().getColumnModel().getColumn(3).setPreferredWidth(
      (int) (UIConstants.SCREEN_HEIGHT * 0.23));
    dynamicPane.getTableHeader().setReorderingAllowed(false);
    dynamicPane.getTableHeader().setVisible(false);
    int row = 0;
    int col = 0;
    for (int i = 0; i < fieldEditors.size(); i++) {
      AbstractFieldEditor e = fieldEditors.get(i);
      
      final JLabel label = new JLabel(SwingUtil.processAsteriskLabel(e.getName()));
      label.setPreferredSize(new Dimension(40, 10));
      e.addPropertyChangeListener("name", new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent evt) {
          label.setText((String) evt.getNewValue());
        }
      });
      label.setBorder(new CustomBorder());

      if (i != 0 && i % 2 == 0) {
        row++;
      }
      if (col % 4 == 0) {
        col = 0;
      }
      dynamicPane.add(label, new CellConstraints(row, col, row, col));
      col++;
      dynamicPane.add(createPanel(e), new CellConstraints(row, col, row, col));
      col++;
    }

  }

  private void updateEditorsEditObject() {
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.setEditObject(editObject);
    }
  }

  public void setEditObject(Object obj) {
    editObject = obj;
    updateEditorsEditObject();
    if (obj == null) {
      setEnabled(false);
    }
  }

  public void setEnabled(boolean enabled) {
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.setEnabled(enabled);
    }
  }

  public List<AbstractFieldEditor> getFieldEditors() {
    return fieldEditors;
  }

  public Object getEditObject() {
    return editObject;
  }

  private static JPanel createPanel(Component putComp) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(putComp, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
      GridBagConstraints.HORIZONTAL, new Insets(5, 5, 5, 5), 0, 0));
    panel.setBorder(new CustomBorder());
    return panel;
  }

}

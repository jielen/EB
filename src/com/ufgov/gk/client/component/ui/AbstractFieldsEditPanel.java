package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Color;
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

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.component.event.EditSyncEvent;
import com.ufgov.gk.client.component.event.EditSyncListener;
import com.ufgov.gk.client.component.tablelayout.CellConstraints;
import com.ufgov.gk.client.component.tablelayout.CustomBorder;
import com.ufgov.gk.client.component.tablelayout.GridCellLayout;
import com.ufgov.gk.client.component.tablelayout.GridPanel;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;

public abstract class AbstractFieldsEditPanel extends JPanel {

  private static final long serialVersionUID = -4293912619075083022L;

  protected final GridPanel dynamicPane = new GridPanel();

  protected List<AbstractFieldEditor> fieldEditors= new ArrayList();;

  protected BillElementMeta billElementMeta;

  protected String product;
  
  protected Object editObject;

  protected void init() {
    
    fieldEditors = createFieldEditors();
    
    addFieldEditors();
    
    updateEditorsEditObject();

    JScrollPane scrollPane = new JScrollPane();
//    scrollPane.setBorder(BorderFactory.createLineBorder(Color.gray));
    scrollPane.getViewport().add(dynamicPane);
    
    this.setLayout(new BorderLayout());
    this.add(scrollPane,BorderLayout.CENTER);
    
    setEnabled(false);
  }
  
  public void refresh (){}
  
  protected  abstract List<AbstractFieldEditor> createFieldEditors();
 
  private void addFieldEditors() {
    
    dynamicPane.setGridColor(Color.red);
    dynamicPane.removeAll();
    dynamicPane.setRowHeight(25);
    dynamicPane.setLayout(new GridCellLayout());
    dynamicPane.setBackground(this.getBackground());
    dynamicPane.setModel(new AbstractTableModel() {
      private static final long serialVersionUID = 2745205066889916971L;
      String[] ColNames={"�ֶ�","�ֶ�ֵ"};
      public int getColumnCount() {
        return 2;
      }
      public int getRowCount() {
        return fieldEditors.size();
      }
      public String getColumnName(int column) {
         if(column>=0&&column<ColNames.length){
           return ColNames[column];
         }else return "";
      }
      
      public Object getValueAt(int rowIndex, int columnIndex) {
        return null;
      }
    });
    dynamicPane.getTableHeader().getColumnModel().getColumn(0).setPreferredWidth(30);
    dynamicPane.getTableHeader().getColumnModel().getColumn(1).setPreferredWidth(100);
    dynamicPane.getTableHeader().setReorderingAllowed(false);
//    dynamicPane.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
    for (int row = 0; row < fieldEditors.size(); row++) {
      AbstractFieldEditor e = fieldEditors.get(row);
      final JLabel label = new JLabel(" " + e.getName());
      label.setPreferredSize(new Dimension(40, 10));
       e.addPropertyChangeListener("name", new PropertyChangeListener() {
        public void propertyChange(PropertyChangeEvent evt) {
          label.setText((String) evt.getNewValue());
        }
      });
      label.setBorder(new CustomBorder());
      dynamicPane.add(label, new CellConstraints(row, 0, row, 0));
      dynamicPane.add(createPanel(e), new CellConstraints(row, 1, row, 1));
    }
    addListener();
  }
  
  private void addListener(){
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.addEditSyncListener( new EditSyncListener(){
        public void sync(EditSyncEvent e) {
          afterEditSync();
        }
      });
    }
  }

  private void updateEditorsEditObject() {
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.setEditObject(editObject);
    }
  }
  
  public void updateEditObject(Object obj){
    editObject=obj;
    updateEditorsEditObject();
  }
  
  public void setEditObject(Object obj){
    editObject=obj;
    updateEditorsEditObject();
    if(obj==null){
      setEnabled(false);
    }else{
      setEnabled(true);
    }
  }
  
  
  public void setEnabled(boolean enabled){
    for (AbstractFieldEditor editor : fieldEditors) {
      editor.setEnabled(enabled);
    }
  }
  
  public Object getEditObject() {
    return editObject;
  }

  public void afterEditSync(){
    
  }

  private static JPanel createPanel(Component putComp) {
    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(putComp, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
      GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
      new Insets(5, 5, 5, 5), 0, 0));
    panel.setBorder(new CustomBorder());
    return panel;
  }

}

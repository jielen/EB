package com.ufgov.gk.client.component.table.celleditor;

import java.awt.Component;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.common.system.util.DateUtil;
import com.ufgov.smartclient.component.JDateTextField;

public class DateCellEditor extends AbstractCellEditor implements TableCellEditor {
  private JDateTextField  editorComponent = new JDateTextField(){
    public void setText(String t) {
      super.setText(t);
      self.newValue=editorComponent.getDate();
    } 
  };

  private DateCellEditor self = this;

  private Object oldValue;

  private Object newValue;

  private JTable table ;

  private int row;

  private int column;

  private CellEditValidator  cellEditValidater;


  public DateCellEditor() {
  }

  public DateCellEditor( CellEditValidator  cellEditValidater) {
    this.cellEditValidater=cellEditValidater;
  }

  public CellEditValidator getCellEditValidater() {
    return cellEditValidater;
  }

  public void setCellEditValidater(CellEditValidator cellEditValidater) {
    this.cellEditValidater = cellEditValidater;
  }

  public Component getTableCellEditorComponent(final JTable table, Object value, boolean isSelected, int row,
    int column) {

    this.table=table;
    this.oldValue=value;
    this.row=row;
    this.column=column;
    String dateString="";

    if(value instanceof java.util.Date){
      dateString = DateUtil.dateToDdString((Date)value);
    }
    editorComponent.setText(dateString);
    return editorComponent;
  }

  public Object getCellEditorValue() {
     return this.newValue ;
  }

  public boolean stopCellEditing() {
   if(this.cellEditValidater!=null){
     if(cellEditValidater.validateCellValue(table, oldValue, newValue, row, column)){
         return super.stopCellEditing();
     }else{
       return false;
     }
   }
   
   return super.stopCellEditing();
}
  }

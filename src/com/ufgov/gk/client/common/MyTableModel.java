package com.ufgov.gk.client.common;

import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel{
  private List list;
  
  

   public MyTableModel() {
    super();
  }

  public MyTableModel(int rowCount, int columnCount) {
    super(rowCount, columnCount);
  }

  public MyTableModel(Object[] columnNames, int rowCount) {
    super(columnNames, rowCount);
  }

  public MyTableModel(Object[][] data, Object[] columnNames) {
    super(data, columnNames);
  }

  public MyTableModel(Vector columnNames, int rowCount) {
    super(columnNames, rowCount);
  }

  public MyTableModel(Vector data, Vector columnNames) {
    super(data, columnNames);
  }

  public List getList() {
    return list;
  }
   
   public void setList(List list) {
    this.list = list;
  }
   
   
}

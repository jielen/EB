package com.ufgov.gk.client.component.table;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class BeanTableModel<T extends Serializable> extends AbstractTableModel implements Serializable {

  public Map<Object, T> getEditedMap() {
    return editedMap;
  }

  private static final long serialVersionUID = 1L;

  protected List<T> originalDataList;

  protected Map<Object, T> originalDataMap = new HashMap<Object, T>();

  protected Map<Object, T> editedMap = new HashMap<Object, T>();

  protected List<T> dataBeanList;

  protected List<ColumnBeanPropertyPair> columnBeanPropertyPairList;

  protected boolean editable = true;

  /*
   * 一直可以编辑的列，不受model编辑状态的影响，主要是文件附件，在非编辑时需要可以下载
   */
  private List<String> everEditableColunms;

  public BeanTableModel() {
  }

  public BeanTableModel(String oidFieldName) {
    this.oidFieldName = oidFieldName;
  }

  public void setDataBean(List<T> dataBeanList, List<ColumnBeanPropertyPair> columnIdentifierPairList) {

    this.dataBeanList = (dataBeanList != null) ? dataBeanList : new ArrayList<T>();

    this.columnBeanPropertyPairList = (columnIdentifierPairList != null) ? columnIdentifierPairList : new ArrayList<ColumnBeanPropertyPair>();

    this.resetEditedData();

    fireTableStructureChanged();
  }

  public int getColumnCount() {
    return columnBeanPropertyPairList.size();
  }

  public synchronized void refreshData(List<T> dataBeanList) {
    dataBeanList = dataBeanList;
    this.resetEditedData();
    fireTableDataChanged();
  }

  public int getRowCount() {
    return dataBeanList.size();
  }

  public Object getValueAt(int rowIndex, int columnIndex) {
    return BeanUtil.get(columnBeanPropertyPairList.get(columnIndex).getBeanPropertyName(), dataBeanList.get(rowIndex));
  }

  public String getColumnName(int column) {
    return columnBeanPropertyPairList.get(column).getColumnIdentifier();
  }

  public String getColumnIdentifier(int column) {
    return columnBeanPropertyPairList.get(column).getColumnIdentifier();
  }

  public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    T bean = dataBeanList.get(rowIndex);
    BeanUtil.set(columnBeanPropertyPairList.get(columnIndex).getBeanPropertyName(), aValue, bean);
    this.putEditedData(bean);
    fireTableCellUpdated(rowIndex, columnIndex);
  }

  public boolean isCellEditable(int row, int column) {
    if (this.editable) {
      return true;
    } else {
      String tempColumnId = this.getColumnIdentifier(column);
      if (tempColumnId.endsWith("_ATTACH") || tempColumnId.endsWith("_FILE")) {
        return true;
      }
      if (this.everEditableColunms != null && this.everEditableColunms.size() > 0) {
        if (this.everEditableColunms.contains(tempColumnId)) {
          return true;
        }
      }
      return false;
    }
  }

  public boolean isDataChanged() {
    boolean changed = false;
    if (getUpdatedData().size() != 0 || getInsertedData().size() != 0) {
      changed = true;
    }
    if (!changed) {
      resetEditedData();
    }
    return changed;
  }

  public synchronized List<T> getUpdatedData() {
    List<T> updatedDataList = new ArrayList<T>();
    Iterator<Object> it = this.editedMap.keySet().iterator();
    while (it.hasNext()) {
      Object key = it.next();
      T newValue = editedMap.get(key);
      T oldValue = originalDataMap.get(key);
      if (oldValue != null && !DigestUtil.digest(oldValue).equals(DigestUtil.digest(newValue))) {
        updatedDataList.add(newValue);
      }
    }
    return updatedDataList;
  }

  public synchronized List<T> getInsertedData() {
    List<T> insertedDataList = new ArrayList<T>();
    Iterator<Object> it = this.editedMap.keySet().iterator();
    while (it.hasNext()) {
      Object key = it.next();
      T newValue = editedMap.get(key);
      T oldValue = originalDataMap.get(key);
      if (oldValue == null) {
        insertedDataList.add(newValue);
      }
    }
    return insertedDataList;
  }

  public synchronized void resetEditedData() {
    editedMap.clear();
    this.originalDataList = (List<T>) ObjectUtil.deepCopy(dataBeanList);
    this.putOriginalDataMap(originalDataList);
  }

  protected void putOriginalDataMap(List<T> dataBeanList) {
    originalDataMap.clear();
    for (T bean : dataBeanList) {
      putBeanToMap(bean, this.originalDataMap);
    }
  }

  public synchronized void putEditedData(T bean) {
    if (bean == null) {
      return;
    }
    putBeanToMap(bean, this.editedMap);
  }

  protected void putBeanToMap(T bean, Map<Object, T> dataMap) {
    dataMap.put(BeanUtil.get(oidFieldName, bean), bean);
  }

  public void insertRow(int row, T bean) {
    this.dataBeanList.add(row, bean);
    putEditedData(bean);
    fireTableRowsInserted(row, row);
  }

  public void insertRows(int row, List<T> beanList) {
    for (int i = beanList.size() - 1; i >= 0; i--) {
      T bean = beanList.get(i);
      this.dataBeanList.add(row, bean);
      putEditedData(bean);
    }
    this.fireTableDataChanged();
  }

  protected String oidFieldName;

  public String getOidFieldName() {
    return oidFieldName;
  }

  public void setOidFieldName(String oidFieldName) {
    this.oidFieldName = oidFieldName;
  }

  public synchronized void deleteRow(int row) {

    Object bean = this.getBean(row);
    Object key = BeanUtil.get(oidFieldName, bean);
    this.dataBeanList.remove(row);
    this.editedMap.remove(key);

    fireTableRowsDeleted(row, row);
  }

  public boolean isEditable() {
    return editable;
  }

  public void setEditable(boolean editable) {
    this.editable = editable;
  }

  public List<T> getDataBeanList() {
    return dataBeanList;
  }

  public T getBean(int modelRowIndex) {
    return dataBeanList.get(modelRowIndex);
  }

  public Class<?> getColumnClass(int columnIndex) {
    if (dataBeanList.size() == 0) {
      return super.getColumnClass(columnIndex);
    }
    return BeanUtil.getPropertyType(this.columnBeanPropertyPairList.get(columnIndex).getBeanPropertyName(), this.dataBeanList.get(0).getClass());
  }

  public List<String> getBeanPropertyNames() {
    List<String> propertyNames = new ArrayList<String>();
    for (ColumnBeanPropertyPair p : columnBeanPropertyPairList) {
      propertyNames.add(p.getBeanPropertyName());
    }
    return propertyNames;
  }

  public String getBeanProperty(int column) {
    return getBeanPropertyNames().get(column);
  }

  public int getBeanPropertyColIndex(String propertyName) {
    int index = -1;
    List<String> pList = getBeanPropertyNames();
    for (int i = 0; i < pList.size(); i++) {
      if (pList.get(i).equals(propertyName)) {
        index = i;
        break;
      }
    }
    if (index == -1) {
      throw new RuntimeException("该" + propertyName + "属性没找到!");
    }
    return index;
  }

  public void setEverEditableColunms(List<String> everEditableColunms) {
    this.everEditableColunms = everEditableColunms;
  }

  public List<String> getEverEditableColunms() {
    return everEditableColunms;
  }

}

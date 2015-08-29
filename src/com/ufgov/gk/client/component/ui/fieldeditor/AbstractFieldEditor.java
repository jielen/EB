package com.ufgov.gk.client.component.ui.fieldeditor;

import java.awt.BorderLayout;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.text.JTextComponent;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.IForeignEntityTreeHandler;
import com.ufgov.gk.client.component.event.EditSyncEvent;
import com.ufgov.gk.client.component.event.EditSyncListener;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public abstract class AbstractFieldEditor extends JPanel {

  private Object editObject;

  protected JComponent editorComponent;

  private Object curData;

  private BillElementMeta preBem;

  protected String FieldEditorCode;

  protected String fieldName;

  protected String sqlMapSelectedId;

  protected IForeignEntityHandler handler;

  protected IForeignEntityTreeHandler treeHandler;

  protected String dialogTitle;

  protected ElementConditionDto elementConditionDto;

  //��ǰ�ؼ�ռgridBag�и������
  protected int occCol = 1;

  //��ǰ�ؼ�ռgridBag�и������
  protected int occRow = 1;

  //����¼�������ַ���
  protected int maxContentSize = 9999;

  public AbstractFieldEditor() {

  }

  public String getFieldEditorCode() {
    return FieldEditorCode;
  }

  public void setFieldEditorCode() {
  }

  public AbstractFieldEditor(String name) {
    super();
    init(name);
  }

  protected void init(String name) {
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    editorComponent = createEditorComponent();
    setFieldEditorCode();
    add(editorComponent);
  }

  public AbstractFieldEditor(String name, Object editObject, BillElementMeta preBem) {
    super();
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    this.setPreBem(preBem);
    editorComponent = createEditorComponent();
    this.setEditObject(editObject);
    setFieldEditorCode();
    add(editorComponent);
  }

  public AbstractFieldEditor(String name, String sqlMapSelectedId, IForeignEntityTreeHandler handler) {
    // TODO Auto-generated constructor stub
    super();
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.treeHandler = handler;
    this.dialogTitle = name;
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    editorComponent = createEditorComponent();
    setFieldEditorCode();
    add(editorComponent);
  }

  public AbstractFieldEditor(String name, String sqlMapSelectedId, IForeignEntityHandler handler) {
    // TODO Auto-generated constructor stub
    super();
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.handler = handler;
    this.dialogTitle = name;
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    editorComponent = createEditorComponent();
    setFieldEditorCode();
    add(editorComponent);
  }

  public AbstractFieldEditor(String name, String sqlMapSelectedId2, ElementConditionDto elementCondtiontDto, IForeignEntityHandler handler2) {
    super();
    this.sqlMapSelectedId = sqlMapSelectedId2;
    this.elementConditionDto = elementCondtiontDto;
    this.handler = handler2;
    this.dialogTitle = name;
    setName(name);
    setBorder(null);
    setLayout(new BorderLayout());
    editorComponent = createEditorComponent();
    setFieldEditorCode();
    add(editorComponent);
  }

  public abstract void setValue(Object value);

  public abstract Object getValue();

  public JComponent getEditorComponent() {
    return editorComponent;
  }

  protected abstract JComponent createEditorComponent();

  public void setEditObject(Object editObject) {
    this.editObject = editObject;
    setValue(editObject);
  }

  public Object getEditObject() {
    return editObject;
  }

  public BillElementMeta getPreBem() {
    return preBem;
  }

  public void setPreBem(BillElementMeta preBem) {
    this.preBem = preBem;
  }

  public void setEnabled(boolean enabled) {
    if (this.editorComponent instanceof JTextComponent) {
      JTextComponent textComponent = (JTextComponent) this.editorComponent;
      textComponent.setEditable(enabled);
    } else {
      editorComponent.setEnabled(enabled);
    }
  }

  public void addEditSyncListener(EditSyncListener l) {
    this.listenerList.add(EditSyncListener.class, l);
  }

  public void removeEditSyncListener(EditSyncListener l) {
    this.listenerList.remove(EditSyncListener.class, l);
  }

  protected void fireEditSynced() {
    EditSyncEvent e = null;
    EditSyncListener[] listeners = listenerList.getListeners(EditSyncListener.class);
    for (EditSyncListener l : listeners) {
      if (e == null) {
        e = new EditSyncEvent(this);
      }
      l.sync(e);
    }
  }

  public String getFieldName() {
    return fieldName;
  }

  public void setFieldName(String fieldName) {
    this.fieldName = fieldName;
  }

  public int getOccCol() {
    return occCol;
  }

  public void setOccCol(int occCol) {
    this.occCol = occCol;
  }

  public int getOccRow() {
    return occRow;
  }

  public void setOccRow(int occRow) {
    this.occRow = occRow;
  }

  public int getMaxContentSize() {
    return maxContentSize;
  }

  public void setMaxContentSize(int maxContentSize) {
    this.maxContentSize = maxContentSize;
  }
}

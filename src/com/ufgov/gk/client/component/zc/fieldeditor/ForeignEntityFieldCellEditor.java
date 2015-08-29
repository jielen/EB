/**
 * ForeignEntityFieldCellEditor.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-5-10
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * 外部部件选择编辑器，用于表格中编辑时使用
 * @author Administrator
 *
 */
public class ForeignEntityFieldCellEditor extends AbstractCellEditor implements TableCellEditor {

  /**
   * 
   */
  private static final long serialVersionUID = 5888930726495085340L;

  private ForeignEntityField editorComponent;

  public ForeignEntityFieldCellEditor(String sqlMapSelectedId, ElementConditionDto elementConditionDto, int col, IForeignEntityHandler handler,
    String[] columNames, String title) {
    super();
    this.editorComponent = new ForeignEntityField(sqlMapSelectedId, elementConditionDto, col, handler, columNames, title);

  }

  /* (non-Javadoc)
   * @see javax.swing.table.TableCellEditor#getTableCellEditorComponent(javax.swing.JTable, java.lang.Object, boolean, int, int)
   */
  @Override
  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    // TODO Auto-generated method stub
    this.editorComponent.setValue(value);
    return this.editorComponent;
  }

  /* (non-Javadoc)
   * @see javax.swing.CellEditor#getCellEditorValue()
   */
  @Override
  public Object getCellEditorValue() {
    // TODO Auto-generated method stub
    return this.editorComponent.getValue();
  }

  public void updateDto(ElementConditionDto dto) {
    // TODO Auto-generated method stub
    this.editorComponent.updateDto(dto);
  }

  public ForeignEntityField getEditor() {
    return this.editorComponent;
  }

}

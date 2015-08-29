package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public class EntrustFieldEditor extends ForeignEntityFieldEditor {

  private static final long serialVersionUID = -6525144448401816196L;

  private int dialogType = ZcSettingConstants.FOREIGNENTITY_NEW_PROMAKE;

  public EntrustFieldEditor(String sqlMapSelectedId, int col, IForeignEntityHandler handler, String[] columNames, String name, String fieldName) {
    super(sqlMapSelectedId, col, handler, columNames, name, fieldName);
  }

  public EntrustFieldEditor(String sqlMapSelectedId, int col, IForeignEntityHandler handler, String[] columNames, String name, String fieldName,
    int dialogType) {
    super(sqlMapSelectedId, col, handler, columNames, name, fieldName);
    this.dialogType = dialogType;
  }

  public EntrustFieldEditor(String sqlMapSelectedId, ElementConditionDto elementCondtiontDto, int col, IForeignEntityHandler handler,
    String[] columNames, String name, String fieldName) {
    super(sqlMapSelectedId, elementCondtiontDto, col, handler, columNames, name, fieldName);
  }

  @Override
  protected JComponent createEditorComponent() {
    this.field = new ForeignEntityField(this.sqlMapSelectedId, this.elementConditionDto, this.col, this.handler, this.columNames, this.dialogTitle,
      this.dialogType);
    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        syncEditObject();
      }
    });
    return this.field;
  }

  public ForeignEntityField getField() {
    return field;
  }
}
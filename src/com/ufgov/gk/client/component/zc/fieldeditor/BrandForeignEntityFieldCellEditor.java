/**
 * ForeignEntityFieldCellEditor.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-5-10
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * 品牌外部部件选择编辑器，用于表格中编辑时使用．选择品牌后，设置element中的品牌代码
 * @author Administrator
 *
 */
public class BrandForeignEntityFieldCellEditor extends ForeignEntityFieldCellEditor {

  private static final long serialVersionUID = 5888930726495085340L;

  private ElementConditionDto dto;

  public ElementConditionDto getDto() {
    return dto;
  }

  public void setDto(ElementConditionDto dto) {
    this.dto = dto;
  }

  public BrandForeignEntityFieldCellEditor(String sqlMapSelectedId, ElementConditionDto elementConditionDto, int col, IForeignEntityHandler handler,
    String[] columNames, String title) {
    super(sqlMapSelectedId, elementConditionDto, col, handler, columNames, title);
    this.setDto(elementConditionDto);
  }

  @Override
  public boolean stopCellEditing() {
    dto.setBrandCode(this.getCellEditorValue().toString());
    fireEditingStopped();
    System.out.println("111===============================" + dto.getPlanNo() + " " + dto.getBrandCode() + "  " + dto.getCatalogueCode());
    return true;
  }

}

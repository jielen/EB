/**
 * ForeignEntityFieldEditor.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-4-30
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import org.apache.commons.beanutils.MethodUtils;

import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.JButtonTextField;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

/**
 * 外部部件选择框
 * @author Administrator
 *
 */
public class ForeignEntityField extends JButtonTextField {

  /**
   * 
   */
  private static final long serialVersionUID = 6486922572479576827L;

  private int nd = WorkEnv.getInstance().getTransNd();

  private String sqlMapSelectedId;

  private IForeignEntityHandler handler;

  private String columNames[];

  private String title;

  private ElementConditionDto elementConditionDto = new ElementConditionDto();

  private int dialogType = ZcSettingConstants.FOREIGNENTITY_BASE;

  /**
   * @return the nd
   */
  public int getNd() {
    return nd;
  }

  /**
   * @param nd the nd to set
   */
  public void setNd(int nd) {
    this.nd = nd;
  }

  /**
   * @return the dataRuleId
   */
  public String getSqlMapSelectedId() {
    return sqlMapSelectedId;
  }

  /**
   * @param dataRuleId the dataRuleId to set
   */
  public void setSqlMapSelectedId(String sqlMapSelectedId) {
    this.sqlMapSelectedId = sqlMapSelectedId;
  }

  public ForeignEntityField(String sqlMapSelectedId, int col, IForeignEntityHandler handler, String[] columNames, String title) {

    super(col);
    this.title = title;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.handler = handler;
    this.setColumNames(columNames);
    this.init();
  }

  public ForeignEntityField(String sqlMapSelectedId, ElementConditionDto elementConditionDto, int col, IForeignEntityHandler handler,
    String[] columNames, String title) {

    super(col);
    this.title = title;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.elementConditionDto = elementConditionDto;
    this.handler = handler;
    this.setColumNames(columNames);
    this.init();
  }

  public ForeignEntityField(String sqlMapSelectedId, ElementConditionDto elementConditionDto, int col, IForeignEntityHandler handler,
    String[] columNames, String dialogTitle, int foreignentityNewSupplier) {
    super(col);
    this.title = title;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.elementConditionDto = elementConditionDto;
    this.handler = handler;
    this.dialogType = foreignentityNewSupplier;
    this.setColumNames(columNames);
    this.init();
  }

  private void init() {
    if (this.dialogType != ZcSettingConstants.FOREIGNENTITY_BASE) {
      selectDialog = new ForeignEntityDialog(owner, true, this, this.handler, this.sqlMapSelectedId, this.elementConditionDto, this.title,
        this.dialogType);
    } else {
      selectDialog = new ForeignEntityDialog(owner, true, this, this.handler, this.sqlMapSelectedId, this.elementConditionDto, this.title);
    }
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.JButtonTextField#handleClick(com.ufgov.gk.client.component.JButtonTextField)
   */
  @Override
  public void handleClick(JButtonTextField jButtonTextField) {
    Boolean isShow = true;
    await();
    try {
      // 反射调用beforeSelect方法
      isShow = (Boolean) MethodUtils.invokeMethod(this.handler, "beforeSelect", new Object[] { this.elementConditionDto });
    } catch (Exception ex) {
    }
    if (isShow) {
      if (selectDialog instanceof ForeignEntityDialog) {
        // 加载数据
        ((ForeignEntityDialog) selectDialog).initDataBufferList();
      }
      selectDialog.setVisible(true);
    }
  }

  public static void main(String[] args) {

  }

  public void setColumNames(String columNames[]) {
    this.columNames = columNames;
  }

  public String[] getColumNames() {
    return columNames;
  }

  public void updateDto(ElementConditionDto dto) {
    // TODO Auto-generated method stub

    ((ForeignEntityDialog) (selectDialog)).updateDto(dto);
    this.elementConditionDto = dto;
  }

}

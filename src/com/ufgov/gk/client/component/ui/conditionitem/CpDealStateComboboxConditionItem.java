package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AsValComboBox;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.model.AsVal;

public class CpDealStateComboboxConditionItem extends AbstractSearchConditionItem {

  private static final long serialVersionUID = -3749506836206565655L;

  public AsValComboBox comboBox;

  public CpDealStateComboboxConditionItem(String displayName) {
    init(displayName);
  }

  public List filterList = new ArrayList();

  private String defaultValue;

  public CpDealStateComboboxConditionItem(String displayName, Object defaultValue) {
    if (defaultValue instanceof String) {
      this.defaultValue = (String) defaultValue;
    } else if (defaultValue instanceof List) {
      this.filterList = (List) defaultValue;
    } else if (defaultValue instanceof Map) {
      Map map = (Map) defaultValue;
      if (map != null) {
        this.filterList = (List) map.get("filterList");
        this.defaultValue = (String) map.get("selectedItem");
      }
    }
    init(displayName);
    if (this.defaultValue != null && !"".equals(this.defaultValue)) {
      setValueByCode(this.defaultValue);
    }
  }

  @Override
  protected JComponent createEditorComponent() {
    if (comboBox == null) {
      comboBox = new AsValComboBox("VS_CP_DEAL_STATE", filterList);
    }

    comboBox.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireSearch();
        fireValueChanged();
      }
    });
    return comboBox;
  }

  @Override
  public Object getValue() {
    return (AsVal) comboBox.getSelectedItem();
  }

  @Override
  public void setValue(Object value) {
    comboBox.setSelectedItem(value);
  }

  public AsValComboBox getAsValComboBox() {
    return this.comboBox;
  }

  public void setValueByCode(String code) {
    comboBox.setSelectedAsValByCode(code);
  }

  @Override
  public void putToElementConditionDto(ElementConditionDto element) {
    AsVal asVal = (AsVal) getValue();
    element.setDealState(asVal == null ? null : asVal.getValId());
  }

}

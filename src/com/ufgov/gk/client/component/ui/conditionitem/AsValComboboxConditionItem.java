package com.ufgov.gk.client.component.ui.conditionitem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.AdjustTypeComboBox;

public class AsValComboboxConditionItem extends AbstractSearchConditionItem {
  private static final long serialVersionUID = -8384617788789351177L;
  private List filterList = null;

  private String adjustCodeSetId;

  public AsValComboboxConditionItem(String displayName) {
    init(displayName);
  }

  public AsValComboboxConditionItem(String displayName, Object defaultValue) {
    if (defaultValue != null) {
      if (defaultValue instanceof ArrayList) {
        ArrayList filterList = (ArrayList) defaultValue;
        this.filterList = filterList;
      }
    }
    init(displayName);
  }

  public AsValComboboxConditionItem(String displayName, List filterList) {
    this.filterList = filterList;
    init(displayName);
  }

  public AsValComboboxConditionItem(String displayName, String adjustCodeSetId) {
    this.adjustCodeSetId = adjustCodeSetId;
    init(displayName);
  }

  private AdjustTypeComboBox cpAdjustComboBox;

  protected JComponent createEditorComponent() {
    if (cpAdjustComboBox == null) {
      if (filterList == null) {
        cpAdjustComboBox = new AdjustTypeComboBox(adjustCodeSetId,false);
      } else {
        cpAdjustComboBox = new AdjustTypeComboBox(filterList);
      }

      cpAdjustComboBox.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          fireSearch();
          fireValueChanged();
        }
      });
    }
    return cpAdjustComboBox;
  }

  public void setValue(Object value) {
    cpAdjustComboBox.setSelectedItem(value);
  }

  @Override
  public Object getValue() {
    return cpAdjustComboBox.getSelectedItem();
  }

}

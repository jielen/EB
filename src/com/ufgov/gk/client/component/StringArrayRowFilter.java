package com.ufgov.gk.client.component;

import javax.swing.RowFilter;

public class StringArrayRowFilter extends RowFilter {
  String filterText[];

  public StringArrayRowFilter(String[] filterText) {
    this.filterText = filterText;
  }

  public boolean include(Entry entry) {
    boolean flag = true;
    for (int j = 0; j < filterText.length; j++) {
      int count = entry.getValueCount();
      boolean exist = false;
      for (int i = 0; i < count; i++) {
        if (entry.getStringValue(i).toLowerCase().indexOf(filterText[j].trim().toLowerCase()) >= 0) {
          exist = true;
          break;
        }
      }
      if (!exist) {
        flag = false;
      }
    }
    return flag;
  }
}

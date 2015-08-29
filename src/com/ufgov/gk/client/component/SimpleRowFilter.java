package com.ufgov.gk.client.component;

import javax.swing.RowFilter;

public class SimpleRowFilter extends RowFilter {
  String filterText = "";

  public SimpleRowFilter(String filterText) {
    this.filterText = filterText;
  }

  public boolean include(Entry entry) {
    int count = entry.getValueCount();
    for (int i = 0; i < count; i++) {
      if (entry.getStringValue(i).indexOf(filterText) >= 0) {
        return true;
      }
    }
    return false;
  }
}

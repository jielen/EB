package com.ufgov.gk.client.component.event;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;

public abstract class TableColumnModelAdapter implements TableColumnModelListener{

  public void columnAdded(TableColumnModelEvent e) {
  }

  public void columnMarginChanged(ChangeEvent e) {
  }

  public void columnMoved(TableColumnModelEvent e) {
  }

  public void columnRemoved(TableColumnModelEvent e) {
  }

  public void columnSelectionChanged(ListSelectionEvent e) {
  }

}

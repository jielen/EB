package com.ufgov.gk.client.component.table;

import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;

public abstract class GkAbstractCellEditor extends AbstractCellEditor {
  
  
  public boolean isCellEditable(EventObject anEvent) {
    if (anEvent instanceof MouseEvent) { 
     return ((MouseEvent)anEvent).getClickCount() >= 2;
    }
    return true;
}

 

}

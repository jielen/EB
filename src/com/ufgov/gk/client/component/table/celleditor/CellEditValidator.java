package com.ufgov.gk.client.component.table.celleditor;

import javax.swing.JTable;

public interface CellEditValidator {

  boolean validateCellValue(final JTable table, Object oldValue,Object newValue,int row,
    int column);

}

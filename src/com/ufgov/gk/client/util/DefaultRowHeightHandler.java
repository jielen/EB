package com.ufgov.gk.client.util;

import java.awt.FontMetrics;
import java.util.Date;

import javax.swing.JTable;

import com.ufgov.gk.common.system.util.DateUtil;

public class DefaultRowHeightHandler  implements RowHeightHandler{
  
 public  void setProperRowHeight(final JTable t){
   FontMetrics fm = t.getFontMetrics(t.getFont());
   int colWidth = 0;
   int heightTimes = 1;
   int rowMaxCellWidth = 1;
   int cellValueWidth = 0;
   String cellValue = "";
   for (int r = 0; r < t.getRowCount(); r++) {
     rowMaxCellWidth = 1;
     for (int c = 0; c < t.getColumnCount(); c++) {
       try{
       
       if(t.getValueAt(r, c) instanceof java.util.Date){
         cellValue = DateUtil.dateToDdString((Date)t.getValueAt(r, c));  
       }
       else {
         cellValue = t.getValueAt(r, c) == null ? "" : t.getValueAt(r, c).toString();
       }
       
       }
       catch(Exception e){
         return; // do nothing
       }
       cellValueWidth = fm.stringWidth(cellValue);
       colWidth = t.getColumnModel().getColumn(c).getPreferredWidth();
       if(colWidth == 0) colWidth = 10;
       heightTimes = cellValueWidth / colWidth;
       if (cellValueWidth % colWidth != 0) {
         heightTimes += 1;
       }
       rowMaxCellWidth = Math.max(rowMaxCellWidth, fm.getHeight() * heightTimes);
     }
      t.setRowHeight(r, Math.max(rowMaxCellWidth + 4, t.getRowHeight()));
   }
 
 }

}

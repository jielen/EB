/**   
* @(#) project: GK
* @(#) file: TableCellTextAreaRenderer.java
* 
* Copyright 2010 UFGOV, Inc. All rights reserved.
* UFGOV PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
* 
*/
package com.ufgov.gk.client.component.zc;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.TableCellRenderer;

/**
* @ClassName: TableCellTextAreaRenderer
* @Description: 表格单元格字符太长时换行处理渲染器。采用JTextArea功能解决。
* @date: 2010-4-29 下午07:56:08
* @version: V1.0 
* @since: 1.0
* @author: tianly
* @modify: 
*/
public class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer {

  private static final long serialVersionUID = 3750570946998278995L;

  public TableCellTextAreaRenderer() {
    //设置文本区的换行策略。如果设置为 true，则当行的长度大于所分配的宽度时，将换行。如果设置为 false，则始终不换行。当策略更改时，将激发 PropertyChange 事件（"lineWrap"）。此属性默认为 false。 
    setLineWrap(true);
    //设置换行方式（如果文本区要换行）。如果设置为 true，则当行的长度大于所分配的宽度时，将在单词边界（空白）处换行。如果设置为 false，则将在字符边界处换行。此属性默认为 false。
    //setWrapStyleWord(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    boolean hasFocus, int row, int column) {
    // 计算当下行的最佳高度
    int maxPreferredHeight = 0;
    for (int i = 0; i < table.getColumnCount(); i++) {
      setText("" + table.getValueAt(row, i));
      setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
      maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
    }

    if (table.getRowHeight(row) != maxPreferredHeight) // 少了这行则处理器瞎忙
      table.setRowHeight(row, maxPreferredHeight);
    setText(value == null ? "" : value.toString());
    return this;
  }
}

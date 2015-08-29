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
* @Description: ���Ԫ���ַ�̫��ʱ���д�����Ⱦ��������JTextArea���ܽ����
* @date: 2010-4-29 ����07:56:08
* @version: V1.0 
* @since: 1.0
* @author: tianly
* @modify: 
*/
public class TableCellTextAreaRenderer extends JTextArea implements TableCellRenderer {

  private static final long serialVersionUID = 3750570946998278995L;

  public TableCellTextAreaRenderer() {
    //�����ı����Ļ��в��ԡ��������Ϊ true�����еĳ��ȴ���������Ŀ��ʱ�������С��������Ϊ false����ʼ�ղ����С������Ը���ʱ�������� PropertyChange �¼���"lineWrap"����������Ĭ��Ϊ false�� 
    setLineWrap(true);
    //���û��з�ʽ������ı���Ҫ���У����������Ϊ true�����еĳ��ȴ���������Ŀ��ʱ�����ڵ��ʱ߽磨�հף������С��������Ϊ false�������ַ��߽紦���С�������Ĭ��Ϊ false��
    //setWrapStyleWord(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
    boolean hasFocus, int row, int column) {
    // ���㵱���е���Ѹ߶�
    int maxPreferredHeight = 0;
    for (int i = 0; i < table.getColumnCount(); i++) {
      setText("" + table.getValueAt(row, i));
      setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
      maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);
    }

    if (table.getRowHeight(row) != maxPreferredHeight) // ��������������Ϲæ
      table.setRowHeight(row, maxPreferredHeight);
    setText(value == null ? "" : value.toString());
    return this;
  }
}

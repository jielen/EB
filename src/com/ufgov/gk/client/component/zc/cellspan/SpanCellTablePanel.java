package com.ufgov.gk.client.component.zc.cellspan;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * �������Ժϲ���Ԫ���table��塣
 * 
 *
 */
public class SpanCellTablePanel extends JPanel {
  /**
   * UID.
   */
  private static final long serialVersionUID = 1L;

  /**
   * table�����Խ��е�Ԫ��ϲ�
   */
  private CustomTabel table;

  protected CustomTableModel tableModel;

  protected Vector<Vector<?>> tableData;

  private JPanel titlePanel;

  /**
   * ����table��ͷ���ֺͿ��.
   */
  protected String[] columnID = new String[] { "���", "ָ����", "��Ӧ��", "����ר��", "������" };

  /**
   * ����table�ϲ����е�����
   */
  private int[][] spanArray = null;

  public SpanCellTablePanel(Vector<Vector<?>> tableData) {
    this.tableData = tableData;
    initComponents();
  }

  /**
   * ��Ϊ�漰���¼����ݵ�Ԫ��ϲ������⣬���Ը���table�����ݶ������´���
   */
  public SpanCellTablePanel(String[] columnID, Vector<Vector<? extends Object>> tableData) {
    this.columnID = columnID;
    this.tableData = tableData;
    initComponents();
  }

  public String[] getColumnID() {
    return columnID;
  }

  public void setColumnID(String[] columnID) {
    this.columnID = columnID;
  }

  public void initTableModel() {
    if (tableData != null) {
      tableModel = new CustomTableModel(tableData, convertToVector(columnID)) {
        private static final long serialVersionUID = 928805154100817039L;

        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }

      };
    } else {
      tableModel = new CustomTableModel(columnID, 0) {

        private static final long serialVersionUID = -2334052318389959108L;

        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }

      };
    }
  }

  private void initTable() {
    tableData = addRowNoToData(tableData);
    initTableModel();
    table = new CustomTabel(tableModel);
    table.setOpaque(false);
    table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
    table.getTableHeader().setResizingAllowed(true);
    combineTableCell();
    table.clearSelection();
    table.revalidate();
    table.repaint();
  }

  // �ϲ���Ԫ��
  private void combineTableCell() {
    if (tableData != null) {
      ICellAttribute cellAtt = tableModel.getCellAttribute();
      spanArray = combineSpanData(tableData);
      if (spanArray != null) {
        int[] columns = new int[] { 0, 1 };
        for (int i = 0; i < columns.length; i++) {
          for (int t = 0; t < spanArray.length; t++) {
            ((ICellSpan) cellAtt).combine(spanArray[t], new int[] { columns[i] });
          }
        }
      }
    }
  }

  /**
   * ��ʼ��
   */
  private void initComponents() {
    initTable();
    this.setLayout(new BorderLayout());
    this.setOpaque(false);
    titlePanel = new JPanel();
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    this.add(titlePanel, BorderLayout.NORTH);
    JScrollPane scroll = new JScrollPane(table);
    scroll.setOpaque(false);
    scroll.getViewport().setOpaque(false);
    this.add(scroll, BorderLayout.CENTER);
  }

  /**
   * ȡ�úϲ���Ԫ��ı�
   */
  public JTable getTable() {
    return table;
  }

  /**
   * ȡ�úϲ����е�����
   */
  public int[][] getSpanArray() {
    return spanArray;
  }

  /**
   * �����к�ȡ���е�����id�����������ҵ��id��
   */
  public String getSelectedCbsAppId(int row) {
    for (int i = 0; i < table.getModel().getColumnCount(); i++) {
      if (table.getModel().getColumnName(i) != null
        && table.getModel().getColumnName(i).trim().equalsIgnoreCase("obj")) {
        // ȡ��obj�е�ֵ
        Object value = table.getValueAt(table.getSelectedRow(), i);
        return (value == null) ? null : value.toString();
      }
    }
    return null;
  }

  /**
   * �ڴ���ͷ�
   */
  public void release() {
    spanArray = null;
    table = null;
    this.removeAll();
  }

  /**
   * tableͷת��Ϊ��Ҫ��vector����
   */
  protected Vector<Object> convertToVector(Object[] anArray) {
    if (anArray == null) {
      return null;
    }
    Vector<Object> v = new Vector<Object>(anArray.length);
    for (int i = 0; i < anArray.length; i++) {
      v.addElement(anArray[i]);
    }
    return v;
  }

  /**
   * Ϊ������table������������
   */
  private Vector<Vector<?>> addRowNoToData(Vector<Vector<?>> datas) {
    if (datas == null || datas.isEmpty()) {
      return null;
    }
    Vector<Object> rows = new Vector<Object>();
    Vector<Vector<?>> spanList = new Vector<Vector<?>>();
    Object tempInfo = datas.get(0).get(0);
    int order = 1;
    for (int i = 0; i < datas.size(); i++) {
      if (tempInfo.equals(datas.get(i).get(0))) {
      } else {
        tempInfo = datas.get(i).get(0);
        order++;
      }
      rows = new Vector<Object>();
      rows.addAll(datas.get(i));
      rows.insertElementAt(order, 0);
      spanList.add(rows);
    }
    return spanList;
  }

  /**
   * ���ݸ�����table����ȡ����Ҫ�ϲ��ĵ�Ԫ��
   */
  private int[][] combineSpanData(Vector<Vector<?>> datas) {
    if (datas == null || datas.isEmpty()) {
      return null;
    }
    List<Integer> rows = new ArrayList<Integer>();
    List<List<Integer>> spanList = new ArrayList<List<Integer>>();
    Object tempInfo = datas.get(0).get(0);
    for (int i = 0; i < datas.size(); i++) {
      if (tempInfo.equals(datas.get(i).get(0))) {
        rows.add(i);
      } else {
        spanList.add(rows);
        tempInfo = datas.get(i).get(0);
        rows = new ArrayList<Integer>();
        rows.add(i);
      }
      if (i == datas.size() - 1) {
        spanList.add(rows);
      }
    }

    int[][] spanArray = new int[spanList.size()][];
    for (int i = 0; i < spanList.size(); i++) {
      int[] array = new int[spanList.get(i).size()];
      for (int j = 0; j < spanList.get(i).size(); j++) {
        array[j] = spanList.get(i).get(j);
      }
      spanArray[i] = array;
    }

    return spanArray;
  }

  private int[] getSelectRowArray(int row) {
    for (int i = 0; i < getSpanArray().length; i++) {
      for (int j = 0; j < getSpanArray()[i].length; j++) {
        if (row == getSpanArray()[i][j]) {
          return getSpanArray()[i];
        }
      }
    }
    return null;
  }

  public void addListSelectionListener() {
    table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
      @Override
      public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
          int[] allSelectRows = getSelectRowArray(table.getSelectedRow());
          if (allSelectRows == null || allSelectRows.length < 1) {
            return;
          }
          table.setColumnSelectionInterval(0, table.getColumnCount() - 1);
          table.getSelectionModel().setSelectionInterval(allSelectRows[0],
            allSelectRows[allSelectRows.length - 1]);
        }

      }
    });
  }
}

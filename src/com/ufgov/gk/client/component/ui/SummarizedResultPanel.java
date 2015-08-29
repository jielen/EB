package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JComponent;
import javax.swing.table.TableModel;

import com.ufgov.gk.client.component.JTextAreaLabel;
import com.ufgov.gk.common.system.util.StringTools;
import com.ufgov.smartclient.component.table.JGroupableTable;

public class SummarizedResultPanel extends JComponent {

  JTextAreaLabel resultLbl = new JTextAreaLabel();

  private Map resultMap;

  private JGroupableTable table;

  private List columnList; //������

  private Map columnMap; //��ʾ������Map

  /**
   * ��ʾ���Ļ����ֶν��
   * @param table �������
   * @param colNameList ��Ҫ�����ֶ����ƣ����ı�ͷ��ʾ���⣩
   */
  public SummarizedResultPanel(JGroupableTable table, List colNameList) {
    initResult();
    this.table = table;
    columnList = colNameList;
    clearSummarizedResult();
    refreshSummarizedResult();
  }

  public SummarizedResultPanel(JGroupableTable table, Map colNameMap) {
    initResult();
    this.table = table;
    columnMap = colNameMap;
    refreshSummarizedResultForMap();
  }

  public void setSumTable(JGroupableTable table) {
    this.table = table;
  }

  private void initResult() {
    this.setLayout(new BorderLayout());
    this.add(this.resultLbl, BorderLayout.CENTER);
  }

  public String sumProcess() {
    String choosedOrSum = "����";
    if (table != null) {
      if (table.getCheckedRows().length < 1) {
        choosedOrSum = "����";
      } else {
        choosedOrSum = "ѡ��";
      }
    }
    generatResultMap();
    String sumInfo = "�ϼƣ�" + choosedOrSum + getSumRows(table) + "������";
    Iterator itr = columnList.iterator();
    while (itr.hasNext()) {
      String prefix = itr.next().toString();
      sumInfo = sumInfo + "��" + prefix + "��" + StringTools.getNumberFormat((BigDecimal) resultMap.get(prefix)) + "Ԫ";
    }
    return sumInfo;
  }

  private void generatResultMap() {
    resultMap = new HashMap();
    Iterator itr = columnList.iterator();
    while (itr.hasNext()) {
      String key = itr.next().toString();
      resultMap.put(key, BigDecimal.ZERO);
    }
    Integer[] selRows = table.getCheckedRows();
    if (selRows.length > 0) {
      for (int i = 0; i < selRows.length; i++) {
        processRowValue(columnList, table.convertRowIndexToModel(selRows[i]));
      }
    } else {
      for (int i = 0; i < table.getRowCount(); i++) {
        processRowValue(columnList, table.convertRowIndexToModel(i));
      }
    }
  }

  private void generatResultMapFromMap() {
    resultMap = new HashMap();
    Iterator itr = columnList.iterator();
    while (itr.hasNext()) {
      String key = itr.next().toString();
      resultMap.put(key, BigDecimal.ZERO);
    }
    int[] selRows = table.getSelectedRows();
    if (selRows.length > 0) {
      for (int i = 0; i < selRows.length; i++) {
        processRowValue(columnList, table.convertRowIndexToModel(selRows[i]));
      }
    } else {
      for (int i = 0; i < table.getRowCount(); i++) {
        processRowValue(columnList, i);
      }
    }
  }

  private String sumProcess(Map colMap) {
    String choosedOrSum = "����";
    if (table != null) {
      if (table.getSelectedRows().length < 1) {
        choosedOrSum = "����";
      } else {
        choosedOrSum = "ѡ��";
      }
    }
    Set set = colMap.keySet();
    Object[] setArray = set.toArray(new String[set.size()]);
    columnList = Arrays.asList(setArray);
    generatResultMapFromMap();
    String sumInfo = "�ϼƣ�" + choosedOrSum + getSelectSumRows(table) + "������";
    Iterator itr = resultMap.keySet().iterator();
    while (itr.hasNext()) {
      String prefix = itr.next().toString();
      sumInfo = sumInfo + "��" + colMap.get(prefix) + "��" + StringTools.getNumberFormat((BigDecimal) resultMap.get(prefix)) + "Ԫ";
    }
    return sumInfo;
  }

  private void processRowValue(List columnList, int i) {
    Iterator itr;
    int rowIndex = i;
    itr = columnList.iterator();
    while (itr.hasNext()) {
      String k = itr.next().toString();
      TableModel model = table.getModel();
      for (int j = 0; j < model.getColumnCount(); j++) {
        String colName = model.getColumnName(j);
        if (colName.equals(k)) {
          //System.out.println("===colName====>" + colName + ";======key==>" + k);
          Object value = model.getValueAt(rowIndex, j);
          BigDecimal vTmp = (BigDecimal) resultMap.get(k);
          BigDecimal d = new BigDecimal(value != null ? value.toString() : "0");
          vTmp = vTmp.add(d);
          resultMap.put(k, vTmp);
          continue;
        }
      }
    }
  }

  private int getSumRows(JGroupableTable table) {
    return table.getCheckedRows().length == 0 ? table.getRowCount() : table.getCheckedRows().length;
  }

  private int getSelectSumRows(JGroupableTable table) {
    return table.getSelectedRows().length == 0 ? table.getRowCount() : table.getSelectedRows().length;
  }

  /**
   * ˢ���������
   */
  public void refreshSummarizedResult() {
    String resultStr = sumProcess();
    resultLbl.setText(resultStr);
  }

  /**
   * ����������
   */
  public void clearSummarizedResult() {
    resultLbl.setText("");
  }

  public void refreshSummarizedResultForMap() {
    String resultStr = sumProcess(columnMap);
    resultLbl.setText(resultStr);
  }
}

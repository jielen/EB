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

  private List columnList; //列名称

  private Map columnMap; //标示列名称Map

  /**
   * 显示表格的汇总字段结果
   * @param table 关联表格
   * @param colNameList 需要汇总字段名称（表格的表头显示标题）
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
    String choosedOrSum = "共计";
    if (table != null) {
      if (table.getCheckedRows().length < 1) {
        choosedOrSum = "共计";
      } else {
        choosedOrSum = "选择";
      }
    }
    generatResultMap();
    String sumInfo = "合计：" + choosedOrSum + getSumRows(table) + "条数据";
    Iterator itr = columnList.iterator();
    while (itr.hasNext()) {
      String prefix = itr.next().toString();
      sumInfo = sumInfo + "，" + prefix + "：" + StringTools.getNumberFormat((BigDecimal) resultMap.get(prefix)) + "元";
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
    String choosedOrSum = "共计";
    if (table != null) {
      if (table.getSelectedRows().length < 1) {
        choosedOrSum = "共计";
      } else {
        choosedOrSum = "选择";
      }
    }
    Set set = colMap.keySet();
    Object[] setArray = set.toArray(new String[set.size()]);
    columnList = Arrays.asList(setArray);
    generatResultMapFromMap();
    String sumInfo = "合计：" + choosedOrSum + getSelectSumRows(table) + "条数据";
    Iterator itr = resultMap.keySet().iterator();
    while (itr.hasNext()) {
      String prefix = itr.next().toString();
      sumInfo = sumInfo + "，" + colMap.get(prefix) + "：" + StringTools.getNumberFormat((BigDecimal) resultMap.get(prefix)) + "元";
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
   * 刷新面板数据
   */
  public void refreshSummarizedResult() {
    String resultStr = sumProcess();
    resultLbl.setText(resultStr);
  }

  /**
   * 清空面板数据
   */
  public void clearSummarizedResult() {
    resultLbl.setText("");
  }

  public void refreshSummarizedResultForMap() {
    String resultStr = sumProcess(columnMap);
    resultLbl.setText(resultStr);
  }
}

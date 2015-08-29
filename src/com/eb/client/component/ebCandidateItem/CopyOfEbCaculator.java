/**
 * EbCaculator.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Jul 15, 2012
 */
package com.eb.client.component.ebCandidateItem;

import java.math.BigDecimal;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

/**
 * @author Administrator
 *
 */
public class CopyOfEbCaculator {

  private final static String usName = "US";

  private final static String ukName = "UK";

  private final static String deName = "DE";

  private final static String frName = "FR";

  private final static String caName = "CA";

  private final static String auName = "AU";

  private final static String[] fixColumNames = { "一口价", "US", "UK", "DE", "FR", "CA", "AU" };

  private final static String[] chineseColumNames = { "拍卖", "US", "UK", "DE", "FR", "CA", "AU" };

  //一口价
  private ArrayList fixInserts = new ArrayList();//一口价上架费

  private ArrayList fixFVLs = new ArrayList();//成交费

  private ArrayList fixPayPalFees = new ArrayList();//paypal费用

  private ArrayList fixProfits = new ArrayList();//利润

  private ArrayList fixProfitRates = new ArrayList();//利润率

  //拍卖
  private ArrayList chineseInserts = new ArrayList();

  private ArrayList chineseFVLs = new ArrayList();

  private ArrayList chinesePayPalFees = new ArrayList();

  private ArrayList chineseProfits = new ArrayList();

  private ArrayList chineseProfitRates = new ArrayList();

  private ArrayList[] fixArrayLists = { fixInserts, fixFVLs, fixPayPalFees, fixProfits, fixProfitRates };

  private ArrayList[] chineseArrayLists = { chineseInserts, chineseFVLs, chinesePayPalFees, chineseProfits, chineseProfitRates };

  private TableModel fixTableModel = null;

  private TableModel chineseTableModel = null;

  public void creatEmptyFixData() {
    // TODO Auto-generated method stub
    fixInserts.add("上架费");
    fixInserts.add(new BigDecimal(0));
    fixInserts.add(new BigDecimal(0));
    fixInserts.add(new BigDecimal(0));
    fixInserts.add(new BigDecimal(0));
    fixInserts.add(new BigDecimal(0));
    fixInserts.add(new BigDecimal(0));

    fixFVLs.add("成交费");
    fixFVLs.add(new BigDecimal(0));
    fixFVLs.add(new BigDecimal(0));
    fixFVLs.add(new BigDecimal(0));
    fixFVLs.add(new BigDecimal(0));
    fixFVLs.add(new BigDecimal(0));
    fixFVLs.add(new BigDecimal(0));

    fixPayPalFees.add("paypal费");
    fixPayPalFees.add(new BigDecimal(0));
    fixPayPalFees.add(new BigDecimal(0));
    fixPayPalFees.add(new BigDecimal(0));
    fixPayPalFees.add(new BigDecimal(0));
    fixPayPalFees.add(new BigDecimal(0));
    fixPayPalFees.add(new BigDecimal(0));

    fixProfits.add("利润");
    fixProfits.add(new BigDecimal(0));
    fixProfits.add(new BigDecimal(0));
    fixProfits.add(new BigDecimal(0));
    fixProfits.add(new BigDecimal(0));
    fixProfits.add(new BigDecimal(0));
    fixProfits.add(new BigDecimal(0));

    fixProfitRates.add("利润率");
    fixProfitRates.add(new BigDecimal(0));
    fixProfitRates.add(new BigDecimal(0));
    fixProfitRates.add(new BigDecimal(0));
    fixProfitRates.add(new BigDecimal(0));
    fixProfitRates.add(new BigDecimal(0));
    fixProfitRates.add(new BigDecimal(0));
  }

  public void creatEmptyChineseData() {
    // TODO Auto-generated method stub
    chineseInserts.add("上架费");
    chineseInserts.add(new BigDecimal(0));
    chineseInserts.add(new BigDecimal(0));
    chineseInserts.add(new BigDecimal(0));
    chineseInserts.add(new BigDecimal(0));
    chineseInserts.add(new BigDecimal(0));
    chineseInserts.add(new BigDecimal(0));

    chineseFVLs.add("成交费");
    chineseFVLs.add(new BigDecimal(0));
    chineseFVLs.add(new BigDecimal(0));
    chineseFVLs.add(new BigDecimal(0));
    chineseFVLs.add(new BigDecimal(0));
    chineseFVLs.add(new BigDecimal(0));
    chineseFVLs.add(new BigDecimal(0));

    chinesePayPalFees.add("paypal费");
    chinesePayPalFees.add(new BigDecimal(0));
    chinesePayPalFees.add(new BigDecimal(0));
    chinesePayPalFees.add(new BigDecimal(0));
    chinesePayPalFees.add(new BigDecimal(0));
    chinesePayPalFees.add(new BigDecimal(0));
    chinesePayPalFees.add(new BigDecimal(0));

    chineseProfits.add("利润");
    chineseProfits.add(new BigDecimal(0));
    chineseProfits.add(new BigDecimal(0));
    chineseProfits.add(new BigDecimal(0));
    chineseProfits.add(new BigDecimal(0));
    chineseProfits.add(new BigDecimal(0));
    chineseProfits.add(new BigDecimal(0));

    chineseProfitRates.add("利润率");
    chineseProfitRates.add(new BigDecimal(0));
    chineseProfitRates.add(new BigDecimal(0));
    chineseProfitRates.add(new BigDecimal(0));
    chineseProfitRates.add(new BigDecimal(0));
    chineseProfitRates.add(new BigDecimal(0));
    chineseProfitRates.add(new BigDecimal(0));
  }

  public TableModel getFixTableModel() {
    if (fixInserts.size() == 0) {
      creatEmptyFixData();
    }
    fixTableModel = new AbstractTableModel() {

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        ArrayList rowData = fixArrayLists[rowIndex];
        return rowData.get(columnIndex);
      }

      public String getColumnName(int columnIndex) {
        return fixColumNames[columnIndex];
      }

      @Override
      public int getRowCount() {
        // TODO Auto-generated method stub
        return fixArrayLists.length;
      }

      @Override
      public int getColumnCount() {
        // TODO Auto-generated method stub
        return fixColumNames.length;
      }
    };
    return fixTableModel;
  }

  public TableModel getChineseTableModel() {
    if (chineseInserts.size() == 0) {
      creatEmptyChineseData();
    }
    chineseTableModel = new AbstractTableModel() {

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        ArrayList rowData = chineseArrayLists[rowIndex];
        return rowData.get(columnIndex);
      }

      public String getColumnName(int columnIndex) {
        return chineseColumNames[columnIndex];
      }

      @Override
      public int getRowCount() {
        // TODO Auto-generated method stub
        return chineseArrayLists.length;
      }

      @Override
      public int getColumnCount() {
        // TODO Auto-generated method stub
        return chineseColumNames.length;
      }
    };
    return chineseTableModel;
  }

  public void setFixTableModel(TableModel fixTableModel) {
    this.fixTableModel = fixTableModel;
  }

  public void setChineseTableModel(TableModel chineseTableModel) {
    this.chineseTableModel = chineseTableModel;
  }

}

/**
 * EbCaculator.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Jul 15, 2012
 */
package com.eb.client.component.ebCandidateItem;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Hashtable;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.ebfee.EbFeeCaculaterFactory;
import com.ufgov.gk.client.util.EbUtil;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;

/**
 * @author Administrator
 *
 */
public class EbCaculator {

  private final static String[] fixColumNames = { ZcSettingConstants.FIX, ZcSettingConstants.US, ZcSettingConstants.UK, ZcSettingConstants.DE,
    ZcSettingConstants.FR, ZcSettingConstants.CA, ZcSettingConstants.AU };

  private final static String[] chineseColumNames = { ZcSettingConstants.CHINESE, ZcSettingConstants.US, ZcSettingConstants.UK,
    ZcSettingConstants.DE, ZcSettingConstants.FR, ZcSettingConstants.CA, ZcSettingConstants.AU };

  //一口价
  private Hashtable fixInserts = new Hashtable();//一口价上架费

  private Hashtable fixFVLs = new Hashtable();//成交费

  private Hashtable fixPayPalFees = new Hashtable();//paypal费用

  private Hashtable fixProfits = new Hashtable();//利润

  private Hashtable fixProfitRates = new Hashtable();//利润率

  //拍卖
  private Hashtable chineseInserts = new Hashtable();

  private Hashtable chineseFVLs = new Hashtable();

  private Hashtable chinesePayPalFees = new Hashtable();

  private Hashtable chineseProfits = new Hashtable();

  private Hashtable chineseProfitRates = new Hashtable();

  private Hashtable[] fixHashtables = { fixInserts, fixFVLs, fixPayPalFees, fixProfits, fixProfitRates };

  private Hashtable[] chineseHashtables = { chineseInserts, chineseFVLs, chinesePayPalFees, chineseProfits, chineseProfitRates };

  private TableModel fixTableModel = null;

  private TableModel chineseTableModel = null;

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  private void creatEmptyFixData() {
    // TODO Auto-generated method stub
    fixInserts.put(ZcSettingConstants.FIX, "上架费");
    fixInserts.put(ZcSettingConstants.US, new BigDecimal(0));
    fixInserts.put(ZcSettingConstants.UK, new BigDecimal(0));
    fixInserts.put(ZcSettingConstants.DE, new BigDecimal(0));
    fixInserts.put(ZcSettingConstants.FR, new BigDecimal(0));
    fixInserts.put(ZcSettingConstants.CA, new BigDecimal(0));
    fixInserts.put(ZcSettingConstants.AU, new BigDecimal(0));

    fixFVLs.put(ZcSettingConstants.FIX, "成交费");
    fixFVLs.put(ZcSettingConstants.US, new BigDecimal(0));
    fixFVLs.put(ZcSettingConstants.UK, new BigDecimal(0));
    fixFVLs.put(ZcSettingConstants.DE, new BigDecimal(0));
    fixFVLs.put(ZcSettingConstants.FR, new BigDecimal(0));
    fixFVLs.put(ZcSettingConstants.CA, new BigDecimal(0));
    fixFVLs.put(ZcSettingConstants.AU, new BigDecimal(0));

    fixPayPalFees.put(ZcSettingConstants.FIX, "paypal费");
    fixPayPalFees.put(ZcSettingConstants.US, new BigDecimal(0));
    fixPayPalFees.put(ZcSettingConstants.UK, new BigDecimal(0));
    fixPayPalFees.put(ZcSettingConstants.DE, new BigDecimal(0));
    fixPayPalFees.put(ZcSettingConstants.FR, new BigDecimal(0));
    fixPayPalFees.put(ZcSettingConstants.CA, new BigDecimal(0));
    fixPayPalFees.put(ZcSettingConstants.AU, new BigDecimal(0));

    fixProfits.put(ZcSettingConstants.FIX, "利润");
    fixProfits.put(ZcSettingConstants.US, new BigDecimal(0));
    fixProfits.put(ZcSettingConstants.UK, new BigDecimal(0));
    fixProfits.put(ZcSettingConstants.DE, new BigDecimal(0));
    fixProfits.put(ZcSettingConstants.FR, new BigDecimal(0));
    fixProfits.put(ZcSettingConstants.CA, new BigDecimal(0));
    fixProfits.put(ZcSettingConstants.AU, new BigDecimal(0));

    fixProfitRates.put(ZcSettingConstants.FIX, "利润率");
    fixProfitRates.put(ZcSettingConstants.US, new BigDecimal(0));
    fixProfitRates.put(ZcSettingConstants.UK, new BigDecimal(0));
    fixProfitRates.put(ZcSettingConstants.DE, new BigDecimal(0));
    fixProfitRates.put(ZcSettingConstants.FR, new BigDecimal(0));
    fixProfitRates.put(ZcSettingConstants.CA, new BigDecimal(0));
    fixProfitRates.put(ZcSettingConstants.AU, new BigDecimal(0));
  }

  private void creatEmptyChineseData() {
    // TODO Auto-generated method stub
    chineseInserts.put(ZcSettingConstants.CHINESE, "上架费");
    chineseInserts.put(ZcSettingConstants.US, new BigDecimal(0));
    chineseInserts.put(ZcSettingConstants.UK, new BigDecimal(0));
    chineseInserts.put(ZcSettingConstants.DE, new BigDecimal(0));
    chineseInserts.put(ZcSettingConstants.FR, new BigDecimal(0));
    chineseInserts.put(ZcSettingConstants.CA, new BigDecimal(0));
    chineseInserts.put(ZcSettingConstants.AU, new BigDecimal(0));

    chineseFVLs.put(ZcSettingConstants.CHINESE, "成交费");
    chineseFVLs.put(ZcSettingConstants.US, new BigDecimal(0));
    chineseFVLs.put(ZcSettingConstants.UK, new BigDecimal(0));
    chineseFVLs.put(ZcSettingConstants.DE, new BigDecimal(0));
    chineseFVLs.put(ZcSettingConstants.FR, new BigDecimal(0));
    chineseFVLs.put(ZcSettingConstants.CA, new BigDecimal(0));
    chineseFVLs.put(ZcSettingConstants.AU, new BigDecimal(0));

    chinesePayPalFees.put(ZcSettingConstants.CHINESE, "paypal费");
    chinesePayPalFees.put(ZcSettingConstants.US, new BigDecimal(0));
    chinesePayPalFees.put(ZcSettingConstants.UK, new BigDecimal(0));
    chinesePayPalFees.put(ZcSettingConstants.DE, new BigDecimal(0));
    chinesePayPalFees.put(ZcSettingConstants.FR, new BigDecimal(0));
    chinesePayPalFees.put(ZcSettingConstants.CA, new BigDecimal(0));
    chinesePayPalFees.put(ZcSettingConstants.AU, new BigDecimal(0));

    chineseProfits.put(ZcSettingConstants.CHINESE, "利润");
    chineseProfits.put(ZcSettingConstants.US, new BigDecimal(0));
    chineseProfits.put(ZcSettingConstants.UK, new BigDecimal(0));
    chineseProfits.put(ZcSettingConstants.DE, new BigDecimal(0));
    chineseProfits.put(ZcSettingConstants.FR, new BigDecimal(0));
    chineseProfits.put(ZcSettingConstants.CA, new BigDecimal(0));
    chineseProfits.put(ZcSettingConstants.AU, new BigDecimal(0));

    chineseProfitRates.put(ZcSettingConstants.CHINESE, "利润率");
    chineseProfitRates.put(ZcSettingConstants.US, new BigDecimal(0));
    chineseProfitRates.put(ZcSettingConstants.UK, new BigDecimal(0));
    chineseProfitRates.put(ZcSettingConstants.DE, new BigDecimal(0));
    chineseProfitRates.put(ZcSettingConstants.FR, new BigDecimal(0));
    chineseProfitRates.put(ZcSettingConstants.CA, new BigDecimal(0));
    chineseProfitRates.put(ZcSettingConstants.AU, new BigDecimal(0));
  }

  public TableModel getFixTableModel() {
    if (fixInserts.size() == 0) {
      creatEmptyFixData();
    }
    fixTableModel = new AbstractTableModel() {

      @Override
      public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        Hashtable rowData = fixHashtables[rowIndex];
        return rowData.get(getColumnName(columnIndex));
      }

      public String getColumnName(int columnIndex) {
        return fixColumNames[columnIndex];
      }

      @Override
      public int getRowCount() {
        // TODO Auto-generated method stub
        return fixHashtables.length;
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
        Hashtable rowData = chineseHashtables[rowIndex];
        return rowData.get(getColumnName(columnIndex));
      }

      public String getColumnName(int columnIndex) {
        return chineseColumNames[columnIndex];
      }

      @Override
      public int getRowCount() {
        // TODO Auto-generated method stub
        return chineseHashtables.length;
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

  public TableModel cacualateFixPriceFee(EbCandidateItem item) {
    // TODO Auto-generated method stub
    EbFeeCaculaterFactory factory = EbFeeCaculaterFactory.getInstance();
    EbUtil ebu = new EbUtil();
    fixInserts.put(ZcSettingConstants.FIX, "上架费");
    fixInserts.put(
      ZcSettingConstants.US,
      factory.getFixInsertFees(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US)));
    fixInserts.put(
      ZcSettingConstants.UK,
      factory.getFixInsertFees(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK)));
    fixInserts.put(
      ZcSettingConstants.DE,
      factory.getFixInsertFees(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE)));
    fixInserts.put(
      ZcSettingConstants.FR,
      factory.getFixInsertFees(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR)));
    fixInserts.put(
      ZcSettingConstants.CA,
      factory.getFixInsertFees(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA)));
    fixInserts.put(
      ZcSettingConstants.AU,
      factory.getFixInsertFees(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU)));

    fixFVLs.put(ZcSettingConstants.FIX, "成交费");
    fixFVLs.put(
      ZcSettingConstants.US,
      factory.getFixFVLs(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US), item.getCategoryType()));
    fixFVLs.put(
      ZcSettingConstants.UK,
      factory.getFixFVLs(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK), item.getCategoryType()));
    fixFVLs.put(
      ZcSettingConstants.DE,
      factory.getFixFVLs(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE), item.getCategoryType()));
    fixFVLs.put(
      ZcSettingConstants.FR,
      factory.getFixFVLs(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR), item.getCategoryType()));
    fixFVLs.put(
      ZcSettingConstants.CA,
      factory.getFixFVLs(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA), item.getCategoryType()));
    fixFVLs.put(
      ZcSettingConstants.AU,
      factory.getFixFVLs(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU), item.getCategoryType()));

    fixPayPalFees.put(ZcSettingConstants.FIX, "paypal费");
    fixPayPalFees.put(
      ZcSettingConstants.US,
      factory.getFixPayPalFees(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.US)));
    fixPayPalFees.put(
      ZcSettingConstants.UK,
      factory.getFixPayPalFees(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.UK)));
    fixPayPalFees.put(
      ZcSettingConstants.DE,
      factory.getFixPayPalFees(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.DE)));
    fixPayPalFees.put(
      ZcSettingConstants.FR,
      factory.getFixPayPalFees(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.FR)));
    fixPayPalFees.put(
      ZcSettingConstants.CA,
      factory.getFixPayPalFees(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.CA)));
    fixPayPalFees.put(
      ZcSettingConstants.AU,
      factory.getFixPayPalFees(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.AU)));

    fixProfits.put(ZcSettingConstants.FIX, "利润");
    fixProfitRates.put(ZcSettingConstants.FIX, "利润率");

    if (item.getCost() != null && item.getTransportFee() != null) {

      EbProfit profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()),
        ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()), item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD));
      fixProfits.put(ZcSettingConstants.US, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.US, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(), ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP));
      fixProfits.put(ZcSettingConstants.UK, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.UK, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(), ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR));
      fixProfits.put(ZcSettingConstants.DE, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.DE, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(), ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR));
      fixProfits.put(ZcSettingConstants.FR, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.FR, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(), ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD));
      fixProfits.put(ZcSettingConstants.CA, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.CA, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(), ebu.getRMBValue((BigDecimal) fixInserts.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD),
        ebu.getRMBValue((BigDecimal) fixFVLs.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD),
        ebu.getRMBValue((BigDecimal) fixPayPalFees.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD));
      fixProfits.put(ZcSettingConstants.AU, profit.getProfit());
      fixProfitRates.put(ZcSettingConstants.AU, profit.getProfitRate());
    }
    return getFixTableModel();
  }

  private EbProfit getProfit(BigDecimal price, BigDecimal shippingFee, BigDecimal cost, BigDecimal transportFee, BigDecimal inserts, BigDecimal fvl,
    BigDecimal paypal) {
    double a = price.doubleValue() + shippingFee.doubleValue();
    double b = cost.doubleValue() + transportFee.doubleValue() + inserts.doubleValue() + fvl.doubleValue() + paypal.doubleValue();
    double c = a - b;
    double d = c / b;
    EbProfit p = new EbProfit();
    DecimalFormat df = new DecimalFormat("#.00");
    p.setProfit(new BigDecimal(df.format(c)));
    p.setProfitRate(new BigDecimal(df.format(d)));
    return p;
  }

  public TableModel cacualateChineseFee(EbCandidateItem item) {
    // TODO Auto-generated method stub
    EbFeeCaculaterFactory factory = EbFeeCaculaterFactory.getInstance();
    EbUtil ebu = new EbUtil();
    chineseInserts.put(ZcSettingConstants.CHINESE, "上架费");
    chineseInserts.put(
      ZcSettingConstants.US,
      factory.getChineseInsertFees(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US)));
    chineseInserts.put(
      ZcSettingConstants.UK,
      factory.getChineseInsertFees(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK)));
    chineseInserts.put(
      ZcSettingConstants.DE,
      factory.getChineseInsertFees(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE)));
    chineseInserts.put(
      ZcSettingConstants.FR,
      factory.getChineseInsertFees(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR)));
    chineseInserts.put(
      ZcSettingConstants.CA,
      factory.getChineseInsertFees(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA)));
    chineseInserts.put(
      ZcSettingConstants.AU,
      factory.getChineseInsertFees(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU)));

    chineseFVLs.put(ZcSettingConstants.CHINESE, "成交费");
    chineseFVLs.put(
      ZcSettingConstants.US,
      factory.getChineseFVLs(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US), item.getCategoryType()));
    chineseFVLs.put(
      ZcSettingConstants.UK,
      factory.getChineseFVLs(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK), item.getCategoryType()));
    chineseFVLs.put(
      ZcSettingConstants.DE,
      factory.getChineseFVLs(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE), item.getCategoryType()));
    chineseFVLs.put(
      ZcSettingConstants.FR,
      factory.getChineseFVLs(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR), item.getCategoryType()));
    chineseFVLs.put(
      ZcSettingConstants.CA,
      factory.getChineseFVLs(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA), item.getCategoryType()));
    chineseFVLs.put(
      ZcSettingConstants.AU,
      factory.getChineseFVLs(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU), item.getCategoryType()));

    chinesePayPalFees.put(ZcSettingConstants.CHINESE, "paypal费");
    chinesePayPalFees.put(
      ZcSettingConstants.US,
      factory.getChinesePayPalFees(ZcSettingConstants.US, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.US),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.US)));
    chinesePayPalFees.put(
      ZcSettingConstants.UK,
      factory.getChinesePayPalFees(ZcSettingConstants.UK, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.UK),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.UK)));
    chinesePayPalFees.put(
      ZcSettingConstants.DE,
      factory.getChinesePayPalFees(ZcSettingConstants.DE, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.DE),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.DE)));
    chinesePayPalFees.put(
      ZcSettingConstants.FR,
      factory.getChinesePayPalFees(ZcSettingConstants.FR, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.FR),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.FR)));
    chinesePayPalFees.put(
      ZcSettingConstants.CA,
      factory.getChinesePayPalFees(ZcSettingConstants.CA, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.CA),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.CA)));
    chinesePayPalFees.put(
      ZcSettingConstants.AU,
      factory.getChinesePayPalFees(ZcSettingConstants.AU, ZcSettingConstants.STORE_TYPE_BASIC,
        ebu.getCurencyValue(item.getEbPrice(), item.getCurrencyId(), ZcSettingConstants.AU),
        ebu.getCurencyValue(item.getEbShippingFee(), item.getCurrencyId(), ZcSettingConstants.AU)));

    chineseProfits.put(ZcSettingConstants.CHINESE, "利润");
    chineseProfitRates.put(ZcSettingConstants.CHINESE, "利润率");
    if (item.getCost() != null && item.getTransportFee() != null) {

      EbProfit profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()),
        ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()), item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.US), ZcSettingConstants.CURENCY_USD));
      chineseProfits.put(ZcSettingConstants.US, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.US, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.UK), ZcSettingConstants.CURENCY_GBP));
      chineseProfits.put(ZcSettingConstants.UK, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.UK, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.DE), ZcSettingConstants.CURENCY_EUR));
      chineseProfits.put(ZcSettingConstants.DE, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.DE, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.FR), ZcSettingConstants.CURENCY_EUR));
      chineseProfits.put(ZcSettingConstants.FR, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.FR, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.CA), ZcSettingConstants.CURENCY_CAD));
      chineseProfits.put(ZcSettingConstants.CA, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.CA, profit.getProfitRate());

      profit = getProfit(ebu.getRMBValue(item.getEbPrice(), item.getCurrencyId()), ebu.getRMBValue(item.getEbShippingFee(), item.getCurrencyId()),
        item.getCost(), item.getTransportFee(),
        ebu.getRMBValue((BigDecimal) chineseInserts.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD),
        ebu.getRMBValue((BigDecimal) chineseFVLs.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD),
        ebu.getRMBValue((BigDecimal) chinesePayPalFees.get(ZcSettingConstants.AU), ZcSettingConstants.CURENCY_AUD));
      chineseProfits.put(ZcSettingConstants.AU, profit.getProfit());
      chineseProfitRates.put(ZcSettingConstants.AU, profit.getProfitRate());
    }
    return getChineseTableModel();
  }

  public EbProfit getProfitBySiteId(EbCandidateItem item) {
    if (item.getCost() != null && item.getTransportFee() != null) {
      EbProfit profit = new EbProfit();
      profit.setProfit((BigDecimal) fixProfits.get(item.getEbSite()));
      profit.setProfitRate((BigDecimal) fixProfitRates.get(item.getEbSite()));
      return profit;
    }
    return null;
  }
}

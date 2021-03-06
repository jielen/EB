package com.ufgov.gk.server.system.print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRMapCollectionDataSource;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.dto.MainSubBill;
import com.ufgov.gk.common.system.dto.PrintObject;
import com.ufgov.gk.common.system.exception.PrintException;
import com.ufgov.gk.common.system.model.PrintSetting;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class PrintManager {

  private static JasperPrint genJasperPrint(Map printParameters, List printRecordList,
    JasperReport jasperReport) {
    JasperPrint jasperPrint = null;
    if (printRecordList.size() == 0) {
      printRecordList.add(new HashMap());
    }
    try {
      jasperPrint = JasperFillManager.fillReport(jasperReport, printParameters,
        new JRMapCollectionDataSource(printRecordList));
    } catch (JRException e) {
      throw new PrintException(e.getMessage(), e);
    }
    return jasperPrint;
  }

  /**
   * 
   * @param printParameters
   * @param printRecordList
   * @return
   */

  private static byte[] genJasperPrintBytes(Map printParameters, List printRecordList,
    JasperReport jasperReport) {
    return ObjectUtil.objectToBytes(genJasperPrint(printParameters, printRecordList, jasperReport));
  }

  /**
   * 生成主子表的打印数据
   * @param mainBill
   * @param subBillList
   * @return List 里包含的是 byte[]
   */
  private static List genMainSubJasperPrintBytes(List mainSubBillList) {

    String[] temps = PrintUtil.getCurrentTemplates();

    JasperReport[] jrs = new JasperReport[temps.length];
    int[] fixRows = new int[temps.length];

    Map preParameters = new HashMap();
    preParameters.putAll(PrintUtil.getRareWord());
    preParameters.putAll(PrintUtil.getRequestMetaMap());

    for (int i = 0; i < temps.length; i++) {
      jrs[i] = PrintTemplateLoader.loadJasperReport(temps[i]);
      fixRows[i] = PrintUtil.getFixRowCount(temps[i]);
    }

    List jasperPrintBytesList = new ArrayList();

    for (int i = 0; i < mainSubBillList.size(); i++) {
      MainSubBill msb = (MainSubBill) mainSubBillList.get(i);
      Object mainBill = msb.getMainBill();
      List subBillList = msb.getSubBillList();

      List list = new ArrayList();

      for (int n = 0; n < jrs.length; n++) {

        list.addAll(genMainSubJasperPrintBytes(mainBill, subBillList, jrs[n], fixRows[n], preParameters));
      }

      jasperPrintBytesList.addAll(list);
    }

    return jasperPrintBytesList;
  }

  public static PrintObject genMainSubPrintObject(List mainSubBillList) {
    PrintObject mpo = new PrintObject();
    mpo.setPrintDataList(genMainSubJasperPrintBytes(mainSubBillList));
    setShowPrintDialog(mpo);
    return mpo;
  }

  public static PrintObject genMainSubPrintObject(MainSubBill msb) {
    List list = new ArrayList();
    list.add(msb);
    return genMainSubPrintObject(list);
  }

  public static PrintObject genMainSubPrintObject(List mainSubBillList, String templateCode) {
    PrintObject po = new PrintObject();
    po.setPrintDataList(genMainSubJasperPrintBypes(mainSubBillList, templateCode));
    setShowPrintDialog(po);
    return po;
  }

  private static List genMainSubJasperPrintBypes(List mainSubBillList, String templateCode) {

    JasperReport jasperReport = PrintTemplateLoader.loadJasperReport(templateCode);

    int fixRowCount = PrintUtil.getFixRowCount(templateCode);

    Map preParameters = new HashMap();
    preParameters.putAll(PrintUtil.getRareWord());
    preParameters.putAll(PrintUtil.getRequestMetaMap());

    List jasperPrintBytesList = new ArrayList();

    for (int i = 0; i < mainSubBillList.size(); i++) {
      MainSubBill msb = (MainSubBill) mainSubBillList.get(i);
      Object mainBill = msb.getMainBill();
      List subBillList = msb.getSubBillList();
      jasperPrintBytesList.addAll(genMainSubJasperPrintBytes(mainBill, subBillList, jasperReport,
        fixRowCount, preParameters));
    }

    return jasperPrintBytesList;
  }

  private static List genMainSubJasperPrintBytes(Object mainBill, List subBillList,
    JasperReport jasperReport, int fixRowCount, Map preParameters) {

    Map printParameters = PrintDataConverter.toDataMap(mainBill);

    printParameters.putAll(preParameters);

    List printRecordList = PrintDataConverter.toDataList(subBillList);

    List[] handleResult = handleFixRow(printRecordList, fixRowCount);
    List handleResultList = new ArrayList();
    for (int i = 0; i < handleResult.length; i++) {
      handleResultList.addAll((List) handleResult[i]);
    }
    List jasperPrintBytesList = new ArrayList();
    jasperPrintBytesList.add(genJasperPrintBytes(printParameters, handleResultList, jasperReport));

    return jasperPrintBytesList;
  }

  /**
   *  按固定行数分割billList
   * @param billList
   * @param fixRowCount
   * @return 结果list[]里包含的是分割后的小billList
   */
  private static List[] handleFixRow(List billList, int fixRowCount) {

    if (fixRowCount <= 0) {
      List[] temp = { billList };
      return temp;
    }

    int block = billList.size() / fixRowCount;
    int mod = billList.size() % fixRowCount;
    if (mod != 0) {
      block += 1;
    }
    List[] result = new List[block];

    for (int b = 0; b < block; b++) {
      int n = fixRowCount * b;
      int m = fixRowCount * (b + 1);
      List blockList = new ArrayList();

      for (int j = n; j < m && j < billList.size(); j++) {
        blockList.add(billList.get(j));
      }
      if (b == block - 1 && mod != 0) {
        for (int c = 1; c <= fixRowCount - mod; c++) {
          blockList.add(new HashMap());
        }
      }

      //FIXROWCOUNT
      for (int i = 0; i < blockList.size(); i++) {
        Map map = (Map) blockList.get(i);
        map.put("FIXROWCOUNT", b + "");
      }

      result[b] = blockList;
    }

    return result;
  }

  private static List genMainBillJasperPrintBytes(Object bill) {
    List billList = new ArrayList();
    billList.add(bill);
    return genMainBillJasperPrintBytes(billList);
  }

  /**
   * 
   * @param bill可以是BaseBill 或HashMap 及其子类
   * @return
   */
  public static PrintObject genMainBillPrintObject(Object bill) {
    PrintObject po = new PrintObject();
    po.setPrintDataList(genMainBillJasperPrintBytes(bill));
    setShowPrintDialog(po);
    return po;
  }

  private static List genMainBillJasperPrintBytes(BaseBill bill, String templateCode) {
    List billList = new ArrayList();
    billList.add(bill);
    return genMainBillJasperPrintBytes(billList, templateCode);
  }

  public static PrintObject genMainBillPrintObject(BaseBill bill, String templateCode) {
    PrintObject po = new PrintObject();
    po.setPrintDataList(genMainBillJasperPrintBytes(bill, templateCode));
    setShowPrintDialog(po);
    return po;
  }

  /**
   * 生成单表的打印数据
   * @param baseBillList
   * @return
   */
  private static List genMainBillJasperPrintBytes(List baseBillList) {
    String[] temps = PrintUtil.getCurrentTemplates();

    JasperReport[] jrs = new JasperReport[temps.length];
    String[] templateTypes = new String[temps.length];
    int[] fixRows = new int[temps.length];

    for (int i = 0; i < temps.length; i++) {
      jrs[i] = PrintTemplateLoader.loadJasperReport(temps[i]);
      templateTypes[i] = PrintUtil.getTemplateType(temps[i]);
      fixRows[i] = PrintUtil.getFixRowCount(temps[i]);
    }

    Map preParameters = new HashMap();
    preParameters.putAll(PrintUtil.getRareWord());
    preParameters.putAll(PrintUtil.getRequestMetaMap());

    List resultList = new ArrayList();

    for (int n = 0; n < jrs.length; n++) {

      resultList.addAll(genMainBillJasperPrintBytes(baseBillList, jrs[n], templateTypes[n], fixRows[n],
        preParameters));
    }

    return resultList;
  }

  /**
   * 
   * @param billList  bill可以是BaseBill 或HashMap 及其子类
   * @return
   */
  public static PrintObject genMainBillPrintObject(List billList) {
    PrintObject printObject = new PrintObject();
    printObject.setPrintDataList(genMainBillJasperPrintBytes(billList));
    setShowPrintDialog(printObject);
    return printObject;
  }

  public static PrintObject genMainBillPrintObject(List baseBillList, String templateCode) {
    PrintObject printObject = new PrintObject();
    printObject.setPrintDataList(genMainBillJasperPrintBytes(baseBillList, templateCode));
    setShowPrintDialog(printObject);
    return printObject;
  }

  private static void setShowPrintDialog(PrintObject po) {
    PrintSetting ps = PrintUtil.getCurrentPrintSetting();
    if (ps != null && ps.getShowPrintDialog() != null && ps.getShowPrintDialog().trim().equalsIgnoreCase("Y")) {
      po.setShowPrintDialog(true);
    } else {
      po.setShowPrintDialog(false);
    }
  }

  private static List genMainBillJasperPrintBytes(List billList, String templateCode) {

    String templateType = PrintUtil.getTemplateType(templateCode);
    JasperReport jasperReport = PrintTemplateLoader.loadJasperReport(templateCode);
    int fixRow = PrintUtil.getFixRowCount(templateCode);
    Map preParameters = new HashMap();
    preParameters.putAll(PrintUtil.getRareWord());
    preParameters.putAll(PrintUtil.getRequestMetaMap());

    return genMainBillJasperPrintBytes(billList, jasperReport, templateType, fixRow, preParameters);
  }

  private static List genMainBillJasperPrintBytes(List billList, JasperReport jasperReport,
    String templateType, int fixRow, Map preParameters) {

    if (templateType.equals(PrintConstants.TEMPLATE_TYPE_C)) {
      return genMainBillJasperPrintBytesC(billList, jasperReport, preParameters);
    } else if (templateType.equals(PrintConstants.TEMPLATE_TYPE_E)) {
      return genMainBillJasperPrintBytesE(billList, jasperReport, preParameters);
    } else {
      return genMainBillJasperPrintBytesL(billList, jasperReport, preParameters, fixRow);
    }
  }

  private static List genMainBillJasperPrintBytesL(List billList, JasperReport jasperReport,
    Map preParameters, int fixRow) {

    List printDataList = new ArrayList();

    Map printParameters = new HashMap();
    printParameters.put(PrintConstants.RECORD_TOTAL, billList.size() + "");
    printParameters.putAll(preParameters);

    List printRecordList = PrintDataConverter.toDataList(billList);

    List[] handleResult = handleFixRow(printRecordList, fixRow);
    List handleResultList = new ArrayList();
    for (int i = 0; i < handleResult.length; i++) {
      handleResultList.addAll((List) handleResult[i]);
    }
    byte[] printData = genJasperPrintBytes(printParameters, handleResultList, jasperReport);

    printDataList.add(printData);

    return printDataList;

  }

  private static List genMainBillJasperPrintBytesE(List billList, JasperReport jasperReport, Map preParameters) {

    List printDataList = new ArrayList();
    for (int i = 0; i < billList.size(); i++) {
      Map printParameters = PrintDataConverter.toDataMap(billList.get(i));
      printParameters.putAll(preParameters);

      List printRecordList = new ArrayList();
      printRecordList.add(new HashMap());

      byte[] printData = genJasperPrintBytes(printParameters, printRecordList, jasperReport);
      printDataList.add(printData);
    }

    return printDataList;
  }

  private static List genMainBillJasperPrintBytesC(List billList, JasperReport jasperReport, Map preParameters) {

    List printDataList = new ArrayList();
    for (int i = 0; i < billList.size(); i++) {
      Map printParameters = PrintDataConverter.toDataMap(billList.get(i));
      printParameters.putAll(preParameters);

      List printRecordList = new ArrayList();
      printRecordList.add(printParameters);
      byte[] printData = genJasperPrintBytes(printParameters, printRecordList, jasperReport);
      printDataList.add(printData);
    }
    return printDataList;
  }

}

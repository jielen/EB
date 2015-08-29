package com.ufgov.gk.server.system.util;

import java.util.Date;
import java.util.List;

import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.system.model.AsNoRule;
import com.ufgov.gk.common.system.model.AsNoRuleSeg;
import com.ufgov.gk.common.system.model.AsNumTool;
import com.ufgov.gk.common.system.model.AsNumToolNo;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.common.system.util.DateUtil;
import com.ufgov.gk.server.commonbiz.dao.INumDao;
import com.ufgov.gk.server.system.SpringContext;
import com.ufgov.gk.server.system.ZcSUtil;

public class NumUtil {

  private INumDao numDao = (INumDao) SpringContext.getBean("numDao");

  private static NumUtil numUtil = new NumUtil();

  private NumUtil() {

  }

  public static synchronized NumUtil getInstance() {
    return numUtil;
  }

  /**
   * 调用的时候要保证getNo包含在事务里
   * 
   * @param compoId
   *            部件ID
   * @param noField
   *            被编号的字段名
   * @param bill
   *            单据
   * @return num 编号
   */
  public String getNo(String compoId, String noField, Object bill) {
    String numToolId = "";
    String ruleCode = "";
    String isCont = "N";
    String isFillZero = "Y";
    int numLen = 0;
    String fixPreFix = "";
    String fixAftFix = "";
    String preFix = "";
    String mTab = compoId;
    long toolNo = 0;

    if (compoId == null || compoId.length() == 0) {
      // System.out.println("NumUtil：部件代码为空！");
      return "";
    }
    if (noField == null || noField.length() == 0) {
      // System.out.println("NumUtil：编号字段为空！");
      return "";
    }
    if (bill == null) {
      // System.out.println("NumUtil：单据为空！");
      return "";
    }

    // 根据compoid，nofield查表as_no_rule，得到编码信息和编号器ID
    AsNoRule asNoRule = numDao.getAsNoRule(compoId, noField);
    if (asNoRule == null)
      return "";
    fixPreFix = asNoRule.getNoPrefix();
    fixAftFix = asNoRule.getNoAftfix();
    isFillZero = asNoRule.getIsFillZero();
    if (asNoRule.getNoIndexLen() == null)
      numLen = 10;
    else
      numLen = asNoRule.getNoIndexLen().intValue();
    numToolId = asNoRule.getNumToolId();
    ruleCode = asNoRule.getRuleCode();
    if (numToolId == null || numToolId.equals("")) {
      return "";
    }
    if (ruleCode == null || ruleCode.equals("")) {
      return "";
    }

    if (fixPreFix == null)
      fixPreFix = "";
    if (isCont == null)
      isCont = "N";
    if (fixAftFix == null)
      fixAftFix = "";
    if (isFillZero == null)
      isFillZero = "Y";

    // 根据rulecode查表as_no_rule_seg，得到编码规则
    List ruleSegList = numDao.getAsNoRuleSeg(compoId, ruleCode);
    for (int i = 0; i < ruleSegList.size(); i++) {
      AsNoRuleSeg ruleSeg = (AsNoRuleSeg) ruleSegList.get(i);
      String inField = ruleSeg.getSegField();
      if (inField == null) {
        continue;
      }
      inField = inField.toUpperCase();
      String field = null;
      Object fieldValue = null;
      // 如果map中没有该字段映射，返回""
      try {
        field = (String) FieldMapRegister.get(bill.getClass()).get(inField);
        fieldValue = BeanUtil.get(field, bill);
      } catch (RuntimeException e) {
        field = ZcSUtil.convertColumnToField(inField);
        fieldValue = BeanUtil.get(field, bill);
      } catch (Exception e) {
        throw new RuntimeException("没有找到字段" + field + "对应的Bean属性");
      }

      if (fieldValue instanceof java.util.Date) {
        preFix += transDate(DateUtil.dateToDdString((Date) fieldValue), ruleSeg.getDateFmt());
      } else {
        String fVal = fieldValue == null ? "" : fieldValue.toString();
        int fLen = fVal.length();
        int fixL = ruleSeg.getSegLen() == null ? 0 : ruleSeg.getSegLen().intValue();
        if (fixL > fLen) {
          fixL = fixL - fLen;
          String addC = (String) ruleSeg.getSegFill();
          String addS = "";
          while (fixL > 0) {
            addS += addC;
            fixL--;
          }
          // 1 补前空
          if (ruleSeg.getSegFillPosi() != null && ruleSeg.getSegFillPosi().equals("1"))
            preFix = preFix + addS + fVal;
          else
            preFix = preFix + fVal + addS;
        } else
          preFix += fVal;
      }
      // 分隔符放后面;leidh;20060411;
      String deli = ruleSeg.getSegDeli();
      if (deli == null) {
        deli = "";
      }
      preFix += deli;
    }

    // 取得编号器属性，是否连续编号
    AsNumTool asNumTool = numDao.getAsNumTool(numToolId);
    isCont = asNumTool.getIsCont();
    if (isCont == null || isCont.equals(""))
      isCont = "N";

    lockCounter(numToolId, isCont, fixPreFix, preFix);
    toolNo = getToolNo(numToolId, isCont, preFix);
    // saveNo(numToolId, isCont, fixPreFix, preFix, toolNo);

    String result = String.valueOf(toolNo);
    int addL = numLen - result.length();
    if (isFillZero.equalsIgnoreCase("Y")) {
      while (addL > 0) {
        result = "0" + result;
        addL--;
      }
    }
    result = fixPreFix + preFix + result + fixAftFix;
    // System.out.println("numtool:" + result);
    return result;
  }

  private long getToolNo(String numToolId, String isCont, String preFix) {
    long serialNumber = 1;

    if (preFix.equals(""))
      preFix = "noPreFix";

    List asNumToolNoList;
    if (!isCont.equals("Y"))
      asNumToolNoList = numDao.getAsNumToolNo(numToolId, preFix, null);
    else
      asNumToolNoList = numDao.getAsNumToolNo(numToolId, null, null);

    if (!asNumToolNoList.isEmpty()) {
      AsNumToolNo toolNo = (AsNumToolNo) asNumToolNoList.get(0);
      serialNumber = toolNo.getNumNo().longValue();
    }
    return serialNumber;
  }

  private String transDate(String d, Object dateFmt) {
    if (d.equals(""))
      return "";

    if (dateFmt == null || dateFmt.equals(""))
      return d;

    String dateStr = dateFmt.toString();
    String dYear = d.substring(0, 4);
    String dMon = d.substring(5, 7);
    String dDay = d.substring(8, 10);
    String sYear = dYear.substring(2);

    int i = dateStr.indexOf("YYYY");
    while (i > -1) {
      dateStr = dateStr.substring(0, i) + dYear + dateStr.substring(i + 4);
      i = dateStr.indexOf("YYYY");
    }
    i = dateStr.indexOf("YY");
    while (i > -1) {
      dateStr = dateStr.substring(0, i) + sYear + dateStr.substring(i + 2);
      i = dateStr.indexOf("YY");
    }
    i = dateStr.indexOf("MM");
    while (i > -1) {
      dateStr = dateStr.substring(0, i) + dMon + dateStr.substring(i + 2);
      i = dateStr.indexOf("MM");
    }
    i = dateStr.indexOf("DD");
    while (i > -1) {
      dateStr = dateStr.substring(0, i) + dDay + dateStr.substring(i + 2);
      i = dateStr.indexOf("DD");
    }

    return dateStr;
  }

  private void lockCounter(String numToolId, String isCont, String fixPrefix, String preFix) {
    if (preFix.equals(""))
      preFix = "noPreFix";
    if (fixPrefix.equals(""))
      fixPrefix = "noPreFix";

    int rows = 0;
    if (!isCont.equals("Y"))
      rows = numDao.incNumNo(numToolId, preFix, null);
    else
      rows = numDao.incNumNo(numToolId, null, null);

    if (rows == 0) {
      AsNumToolNo asNumToolNo = new AsNumToolNo();
      asNumToolNo.setNumToolId(numToolId);
      asNumToolNo.setFixPrefix(fixPrefix);
      asNumToolNo.setAltPrefix(preFix);
      asNumToolNo.setNumNo(new Long(1));
      numDao.insertAsNumToolNo(asNumToolNo);
    }
  }

}

package com.ufgov.gk.server.system;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.exception.BusinessException;
import com.ufgov.gk.common.system.util.BeanUtil;

public class ZcSUtil {

  public final static String ENCODING_DEFAULT = "UTF-8";

  public static void setBillDBDigest(List billList) {
    for (int i = 0; i < billList.size(); i++) {
      BaseBill bill = (BaseBill) billList.get(i);
      bill.setDbDigest(bill.digest());
    }
  }

  public static void checkConsistency(List currBeanList, List originalBeanList, String idFieldName) {

    Map originalMap = new HashMap();

    for (int i = 0; i < originalBeanList.size(); i++) {
      BaseBill temp = (BaseBill) originalBeanList.get(i);
      originalMap.put(BeanUtil.get(idFieldName, temp), temp);
    }
    StringBuffer deleteInfo = new StringBuffer("");
    StringBuffer updateInfo = new StringBuffer("");

    boolean isConsistent = true;
    for (int i = 0; i < currBeanList.size(); i++) {
      BaseBill curr = (BaseBill) currBeanList.get(i);
      BaseBill origin = (BaseBill) originalMap.get(BeanUtil.get(idFieldName, curr));
      if (origin == null) {
        isConsistent = false;
        deleteInfo.append(BeanUtil.get(idFieldName, curr) + ",");
      } else {
        if (!curr.getDbDigest().equals(origin.digest())) {
          isConsistent = false;
          updateInfo.append(BeanUtil.get(idFieldName, curr) + ",");
        }
      }
    }
    if (!isConsistent) {
      String errorInfo = "";
      if (deleteInfo.length() > 0) {
        errorInfo += "id为：" + deleteInfo.substring(0, deleteInfo.lastIndexOf(",")) + "的数据已被删除.";
      }
      if (updateInfo.length() > 0) {
        errorInfo += "\nid为：" + updateInfo.substring(0, updateInfo.lastIndexOf(",")) + "的数据已被修改.";
      }
      throw new BusinessException(errorInfo);
    }
  }

  public static String checkConsistency(BaseBill currBean, BaseBill originalBean, String idFieldName) {
    boolean isConsistent = true;
    StringBuffer deleteInfo = new StringBuffer("");
    StringBuffer updateInfo = new StringBuffer("");
    String originalBeanDigest = null;
    if (originalBean == null) {
      isConsistent = false;
      deleteInfo.append(BeanUtil.get(idFieldName, currBean) + ",");
    } else {
      originalBeanDigest = originalBean.digest();
      if (!currBean.getDbDigest().equals(originalBeanDigest)) {
        isConsistent = false;
        updateInfo.append(BeanUtil.get(idFieldName, currBean) + ",");
      }
    }
    if (!isConsistent) {
      String errorInfo = "";
      if (deleteInfo.length() > 0) {
        errorInfo += "id为：" + deleteInfo.substring(0, deleteInfo.lastIndexOf(",")) + "的数据已被删除.";
      }
      if (updateInfo.length() > 0) {
        errorInfo += "\nid为：" + updateInfo.substring(0, updateInfo.lastIndexOf(",")) + "的数据已被修改.";
      }
      throw new BusinessException(errorInfo);
    }
    return originalBeanDigest;
  }

  public static String checkConsistencyDirect(BaseBill currBean, BaseBill originalBean, String idFieldName) {
    boolean isConsistent = true;
    StringBuffer deleteInfo = new StringBuffer("");
    StringBuffer updateInfo = new StringBuffer("");
    String originalBeanDigest = null;
    if (originalBean == null) {
      isConsistent = false;
      deleteInfo.append(BeanUtil.get(idFieldName, currBean) + ",");
    } else {
      originalBeanDigest = originalBean.getDbDigest();
      if (!currBean.getDbDigest().equals(originalBeanDigest)) {
        isConsistent = false;
        updateInfo.append(BeanUtil.get(idFieldName, currBean) + ",");
      }
    }
    if (!isConsistent) {
      String errorInfo = "";
      if (deleteInfo.length() > 0) {
        errorInfo += "id为：" + deleteInfo.substring(0, deleteInfo.lastIndexOf(",")) + "的数据已被删除.";
      }
      if (updateInfo.length() > 0) {
        errorInfo += "\nid为：" + updateInfo.substring(0, updateInfo.lastIndexOf(",")) + "的数据已被修改.";
      }
      throw new BusinessException(errorInfo);
    }
    return originalBeanDigest;
  }

  public static void checkDigest(BaseBill currBean, BaseBill originalBean, String idFieldName) {
    String errorInfo = null;
    boolean isConsistent = true;
    if (originalBean == null) {
      isConsistent = false;
      errorInfo = "id为：" + BeanUtil.get(idFieldName, currBean) + "的数据已被删除.";
    } else {
      if (!currBean.getDbDigest().equals(originalBean.getDbDigest())) {
        isConsistent = false;
        errorInfo = "id为：" + BeanUtil.get(idFieldName, currBean) + "的数据已被修改.";
      }
    }
    if (!isConsistent) {
      throw new BusinessException(errorInfo);
    }
  }

  /**
   * @Description: (FieldToMod:数据库字段转JAVA字段)
   * @return String 返回类型
   * @since 1.0
   */
  public static String convertColumnToField(String inColumn) {
    String field = "";
    String[] strVals = inColumn.split("_");
    for (int i = 0; i < strVals.length; i++) {
      field += strVals[i].substring(0, 1) + strVals[i].substring(1).toLowerCase();
    }
    return (field.substring(0, 1).toLowerCase() + field.substring(1));
  }

  /**
   * @Description: (FieldToMod:JAVA字段转数据库字段)
   * @return String 返回类型
   * @since 1.0
   */
  public static String convertFieldToColumn(String inField) {
    String field = "";
    for (int i = 0; i < inField.length(); i++) {
      char c = inField.charAt(i);
      if (Character.isUpperCase(c)) {
        field = field.concat("_" + String.valueOf(c));
      } else {
        field = field.concat(String.valueOf(c));
      }
    }
    return field.toUpperCase();
  }

  public static String safeString(Object o) {
    return o == null ? "" : o.toString();
  }

  public static byte[] evaluate(Map contextMap, byte[] templateContext, String logTag, String encoding) throws Exception {
    StringWriter sw = new StringWriter();
    Velocity.init();
    VelocityContext context = new VelocityContext();
    Set set = contextMap.keySet();
    Iterator iterator = set.iterator();
    while (iterator.hasNext()) {
      String key = (String) iterator.next();
      Object value = (Object) contextMap.get(key);
      context.put(key, value);
    }
    Velocity.evaluate(context, sw, logTag, new String(templateContext, encoding));
    return sw.toString().getBytes(encoding);
  }

  /**
   * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
   * 
   * @param char
   *            c, 需要判断的字符
   * @return boolean, 返回true,Ascill字符
   */
  public static boolean isLetter(char c) {
    int k = 0x80;
    return c / k == 0 ? true : false;
  }

  /**
   * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
   * 
   * @param String
   *            s ,需要得到长度的字符串
   * @return int, 得到的字符串长度
   */
  public static int length(String s) {
    if (s == null)
      return 0;
    char[] c = s.toCharArray();
    int len = 0;
    for (int i = 0; i < c.length; i++) {
      len++;
      if (!isLetter(c[i])) {
        len++;
      }
    }
    return len;
  }

  /**
   * 截取一段字符的长度,不区分中英文,如果数字不正好，则少取一个字符位
   * 
   * @author patriotlml
   * @param String
   *            origin, 原始字符串
   * @param int
   *            len, 截取长度(一个汉字长度按2算的)
   * @return String, 返回的字符串
   */
  public static String substring(String origin, int len) {
    return substring(origin, len, null);
  }

  public static String substring(String origin, int len, String fix) {
    if (origin == null || origin.equals("") || len < 1)
      return "";
    byte[] strByte = new byte[len];
    if (len >= length(origin)) {
      return origin;
    }
    System.arraycopy(origin.getBytes(), 0, strByte, 0, len);
    int count = 0;
    for (int i = 0; i < len; i++) {
      int value = (int) strByte[i];
      if (value < 0) {
        count++;
      }
    }
    if (count % 2 != 0) {
      len = (len == 1) ? ++len : --len;
    }
    return new String(strByte, 0, len) + fix;
  }

  //  /**
  //   * 获取序列的下一个值
  //   * @param sequenceName 序列名称，如果为空，则从通用序列中获取
  //   * @return
  //   * Administrator
  //   * 2010-10-23
  //   */
  //  public static synchronized String getSequenceNextVal(String sequenceName) {
  //    if (sequenceName == null || sequenceName.trim().equals("")) {
  //      sequenceName = ZcSettingConstants.SEQUENCE_ZC_BASE;
  //    }
  //    // edit by kongqian 要从SpringContext里取，不能直接new
  //    IZcEbBaseService baseService = (IZcEbBaseService) SpringContext.getBean("zcEbBaseService");
  //    return baseService.getSequenceNextVal(sequenceName);
  //
  //  }
}

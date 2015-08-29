package com.ufgov.gk.client.util;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.WorkflowTrace;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.table.ColumnBeanPropertyPair;
import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.common.commonbiz.model.WfAware;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcEvalFiled;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.util.BeanUtil;

public class ZcUtil {
  private static final String ZC_FIELD_TRANS = "ZC_FIELD_";

  public static final String dir = AsOptionMeta.getOptVal("OPT_ZC_FILE_TEMP");

  public static final String attachPath = AsOptionMeta.getOptVal("OPT_ZC_ATTACH_PATCH");

  /**
   * 招投标书文件存放目录
   */
  public static final String ZTB_FILE_DIR = "ztb";

  public static String getZcFileTempDir() {
    File file = new File(dir);
    try {
      if (!file.exists()) {
        file.mkdirs();
      }
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return file.getAbsolutePath();
  }

  public static void showTraceDialog(List beanList, Component comp) {
    if (beanList.size() == 0) {
      JOptionPane.showMessageDialog(comp, "没有选择数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    if (beanList.size() > 1) {
      JOptionPane.showMessageDialog(comp, "只能选择一条数据！", " 提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    WfAware bean = (WfAware) beanList.get(0);
    WorkflowTrace.showTraceDialog(bean.getProcessInstId());
  }

  private static String translate(String identifier, String prefix) {
    return LangTransMeta.translate(prefix + identifier);
  }

  public static void translateColName(JTable table, String prefix) {
    TableColumnModel tcm = table.getColumnModel();
    for (int i = 0; i < tcm.getColumnCount(); i++) {
      TableColumn tableColumn = tcm.getColumn(i);
      String identifier = (String) tableColumn.getIdentifier();
      tableColumn.setHeaderValue(translate(identifier, prefix));
      tableColumn.setIdentifier(identifier);
    }
  }

  public static void translateColName(JTable table, List<ColumnBeanPropertyPair> columnBeans) {
    for (ColumnBeanPropertyPair c : columnBeans) {
      TableColumn tableColumn = table.getColumn(c.getColumnIdentifier());
      tableColumn.setHeaderValue(c.getHeaderValue());
      tableColumn.setIdentifier(c.getColumnIdentifier());
    }
  }

  /**
   * 
  * @Description: 编辑表格字段翻译。
  * @return void 
  * @since 1.0
   */
  public static void translateColName(JTable table) {
    TableColumnModel tcm = table.getColumnModel();
    for (int i = 0; i < tcm.getColumnCount(); i++) {
      TableColumn tableColumn = tcm.getColumn(i);
      String identifier = (String) tableColumn.getIdentifier();
      tableColumn.setHeaderValue(translate(identifier));
      tableColumn.setIdentifier(identifier);
      if (ZcEvalFiled.FIELD_NAME_ITEM_NAME.equals(identifier)) {
        tableColumn.setPreferredWidth(200);
      }
      if (ZcEvalFiled.FIELD_NAME_DESCRIPTION.equals(identifier)) {
        tableColumn.setPreferredWidth(300);
      }
    }
  }

  public static String translate(String identifier) {
    return LangTransMeta.translate(ZC_FIELD_TRANS + identifier);
  }

  public static String safeString(Object o) {
    return o == null ? "" : o.toString();
  }

  /**
   * 校验要素字段
   * @param notNullField (BillElement)
   * @param obj
   * @return true 校验失败
   */
  public static String validateBillElementNull(Object bill, List notNullField) {
    StringBuilder returnInfo = new StringBuilder();
    BillElement billelement = null;
    for (int i = 0; i < notNullField.size(); i++) {
      billelement = (BillElement) notNullField.get(i);
      String fieldName = null;
      Object result = null;
      try {
        fieldName = (String) FieldMapRegister.get(bill.getClass()).get(billelement.getElementCode());
        result = BeanUtil.get(fieldName, bill);
      } catch (RuntimeException e) {
        fieldName = ZcUtil.convertColumnToField(billelement.getElementCode());
        result = BeanUtil.get(fieldName, bill);
      } catch (Exception e) {
        throw new RuntimeException("没有找到字段" + fieldName + "对应的Bean属性");
      }

      String resName = billelement.getElementName();
      if (billelement.getElementCode().equalsIgnoreCase("PAYTYPE_CODE") || billelement.getElementCode().equalsIgnoreCase("FUND_CODE")
        || billelement.getElementCode().equalsIgnoreCase("ORIGIN_CODE")) {
        if (result.toString().trim().equals("1")) {
          returnInfo.append("[").append(resName).append("] ").append("不允许为空！\n");
        }
      }

      if (result == null || result.toString().trim().equals("")) {
        //暂时通过手工设置的方法取消对以下两个字段的非空检验
        if (!(billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_FGKZBFS_SMWJ") || billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_AGEY_CODE"))) {

          returnInfo.append("[").append(resName).append("] ").append("不允许为空！\n");
        }
      } else {
        if (result instanceof BigDecimal) {
          if (((BigDecimal) result).signum() == 0) {
            returnInfo.append("[").append(resName).append("] ").append("不能为零！\n");
          }
        } else if (result instanceof Integer) {
          if (((Integer) result).intValue() == 0) {
            returnInfo.append("[").append(resName).append("] ").append("不能为零！\n");
          }
        }
      }
    }
    return returnInfo.toString();
  }

  public static String validateDetailBillElementNull(List detailData, List notNullField, boolean isAllowEmpty) {
    String returnInfo = new String();
    if (!isAllowEmpty && (detailData == null || detailData.size() == 0)) {
      returnInfo = "必须填写记录！";
    } else {
      for (Object bill : detailData) {
        returnInfo = validateBillElementNull(bill, notNullField);
        if (returnInfo.length() != 0) {
          break;
        }
      }
    }
    return returnInfo;
  }

  /**
  * @Description: (FieldToMod:数据库字段转JAVA字段)
  * @return String 返回类型
  * @since 1.0
  */
  public static String convertColumnToField(String inColumn) {
    String field = "";
    String[] strVals = inColumn.split("_");
    for (String str : strVals) {
      field += str.substring(0, 1) + str.substring(1).toLowerCase();
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

  /**
   * 设置编辑界面上按钮的不同页面状态和单据业务状态下的可用性，目前不支持对工作流按钮的可用性控制
   * @param btnStatusList 按钮状态对象集合
   * @param billStatus 单据的当前业务状态
   * @param pageStatus 单据的当前页面状态
   * @param compoId 部件名称
   * @param processInstId 工作流示例id
   * chenjl
   * 2010-5-14
   */
  public static synchronized void setButtonEnable(ArrayList<ButtonStatus> btnStatusList, String billStatus, String pageStatus, String compoId,
    Long processInstId) {
    if (btnStatusList == null)
      return;
    for (ButtonStatus bt : btnStatusList) {
      boolean funcEnabled = false;
      //没有设置页面状态或者设置成全部页面状态或者包含有当前的页面状态，则设置为可用
      if (bt.getPageStatus().size() == 0 || bt.getPageStatus().contains(ZcSettingConstants.PAGE_STATUS_ALL)
        || bt.getPageStatus().contains(pageStatus)) {
        funcEnabled = true;
      }
      //设置了单据状态并且页面状态满足并且单据状态没有设置成“全部单据状态”才判断单据状态的条件
      if (bt.getBillStats().size() > 0 && !bt.getBillStats().contains(ZcSettingConstants.BILL_STATUS_ALL) && funcEnabled) {
        funcEnabled = bt.getBillStats().contains(billStatus);
      }
      bt.getButton().setEnabled(funcEnabled);
      if (funcEnabled) {
        bt.getButton().setEnabled(true);
      } else {
        bt.getButton().setEnabled(false);
      }
    }
  }

  public static void setWfNodeEnableFunc(JFuncToolBar toolBar, List enableFuncs, long processInstId, RequestMeta requestMeta) {
    if (toolBar != null) {
      String funcId;
      for (Component button : toolBar.getComponents()) {
        funcId = ((FuncButton) button).getFuncId();
        // 不参与控制的按钮
        if (funcId == null || "".equals(funcId.trim()) || "fprint_preview".equals(funcId) || "fprn_tpl_set".equals(funcId) || "fprint".equals(funcId)
          || "fjingJiaGongGao".equals(funcId) || "fconfirmsup".equals(funcId) || "fchengJiaoGongGao".equals(funcId) || "fchengjiao".equals(funcId)) {
          continue;
        }
        if ("fsendtoxieban".equals(funcId)) {
          System.out.println("____________");
        }
        // 流程跟踪永远显示
        if ("fshowinstancetrace" == funcId) {
          button.setVisible(true);
          continue;
        }
        if (enableFuncs.contains(funcId)) {
          button.setVisible(true);
        } else {
          button.setVisible(false);
        }
      }
      FuncButton callbackButton = toolBar.getButtonByFuncId("fcallback");
      if (callbackButton != null) {
        if (enableFuncs.contains("fnewcommit") || enableFuncs.contains("fautocommit") || enableFuncs.contains("fmanualcommit")
          || enableFuncs.contains("fagreecommit") || enableFuncs.contains("fsendtoxieban") || enableFuncs.contains("fsendprocuunit")
          || enableFuncs.contains("fsendrecord")) {
          // 如果【送审按钮】、【手动提交】、【自动提交】存在，就隐藏【收回按钮】
          callbackButton.setVisible(false);
        } else {
          IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(IBaseDataServiceDelegate.class,
            "baseDataServiceDelegate");
          FuncButton unAuditButton = toolBar.getButtonByFuncId("funaudit");
          if (baseDataServiceDelegate.isFinalAudit(processInstId, requestMeta)) {
            unAuditButton.setVisible(true);
            callbackButton.setVisible(false);
          } else {
            unAuditButton.setVisible(false);
            callbackButton.setVisible(true);
          }
        }
      }
    }
  }

  public static void translateColName(JTable table, Map nameMap) {
    TableColumnModel tcm = table.getColumnModel();
    for (int i = 0; i < tcm.getColumnCount(); i++) {
      TableColumn tableColumn = tcm.getColumn(i);
      String identifier = (String) tableColumn.getIdentifier();
      tableColumn.setHeaderValue(nameMap.get(identifier));
      tableColumn.setIdentifier(identifier);
    }
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

  public static boolean browse(URI uri) throws IOException {
    try {
      Desktop desktop = Desktop.getDesktop();
      desktop.browse(uri);
      return true;
    } catch (SecurityException e) {
      e.printStackTrace();
    }
    return false;
  }

  public static void exec(String comd) throws IOException {
    Runtime.getRuntime().exec(comd);
  }

  public static boolean anyBrowse(String url) {
    String osName = System.getProperty("os.name");
    try {
      if (osName.startsWith("Mac OS")) {
        Class fileMgr = Class.forName("com.apple.eio.FileManager");
        Method openURL = fileMgr.getDeclaredMethod("openURL", new Class[] { String.class });
        openURL.invoke(null, new Object[] { url });
      } else if (osName.startsWith("Windows")) {
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
      } else { // assume Unix or Linux    
        String[] browsers = { "firefox", "opera", "konqueror", "epiphany", "mozilla", "netscape" };
        String browser = null;
        for (int count = 0; count < browsers.length && browser == null; count++) {
          if (Runtime.getRuntime().exec(new String[] { "which", browsers[count] }).waitFor() == 0) {
            browser = browsers[count];
          }
        }
        if (browser == null) {
          throw new Exception("Could not find web browser");
        } else {
          Runtime.getRuntime().exec(new String[] { browser, url });
        }
      }
      return true;
    } catch (Exception ex) {
      System.out.println("打开浏览器时出错:" + ex.getMessage());
      JOptionPane.showMessageDialog(null, "打开浏览器时出错:" + ex.getLocalizedMessage());
      return false;
    }

  }

  public static void moveComponentToScreenCenter(Component component) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = component.getSize();
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gs = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gs.getDefaultConfiguration();
    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    component.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - insets.bottom - frameSize.height) / 2);
  }

  /**
   * 
   * @param oriAuditFlag
   * @param opflag      具体操作，0同意，1,不同意
   * @param requestMeta
   * @return
   */
  public static int getAuditFlagValue(Integer oriAuditFlag, int opflag, RequestMeta requestMeta) {
    oriAuditFlag = oriAuditFlag == null ? 0 : oriAuditFlag;
    int flag = oriAuditFlag;
    String jianduzhuren = AsOptionMeta.getOptVal("OPT_JIANDU_ZR");
    if (opflag == 0) {//同意
      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//监审主任，用十位
        if (flag / 10 == 0) {
          flag = flag + 10;
        }
      } else {//主管主任，用个位
        if (flag % 10 == 0) {
          flag += 1;
        }
      }
    } else {//不同意
      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//监审主任，用十位
        if (flag / 10 == 1) {
          flag = flag - 10;
        }
      } else {//主管主任，用个位
        if (flag % 10 == 1) {
          flag = flag / 10 * 10;
        }
      }
    }
    return flag;
  }
}
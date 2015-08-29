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
   * ��Ͷ�����ļ����Ŀ¼
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
      JOptionPane.showMessageDialog(comp, "û��ѡ�����ݣ�", " ��ʾ", JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    if (beanList.size() > 1) {
      JOptionPane.showMessageDialog(comp, "ֻ��ѡ��һ�����ݣ�", " ��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
  * @Description: �༭����ֶη��롣
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
   * У��Ҫ���ֶ�
   * @param notNullField (BillElement)
   * @param obj
   * @return true У��ʧ��
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
        throw new RuntimeException("û���ҵ��ֶ�" + fieldName + "��Ӧ��Bean����");
      }

      String resName = billelement.getElementName();
      if (billelement.getElementCode().equalsIgnoreCase("PAYTYPE_CODE") || billelement.getElementCode().equalsIgnoreCase("FUND_CODE")
        || billelement.getElementCode().equalsIgnoreCase("ORIGIN_CODE")) {
        if (result.toString().trim().equals("1")) {
          returnInfo.append("[").append(resName).append("] ").append("������Ϊ�գ�\n");
        }
      }

      if (result == null || result.toString().trim().equals("")) {
        //��ʱͨ���ֹ����õķ���ȡ�������������ֶεķǿռ���
        if (!(billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_FGKZBFS_SMWJ") || billelement.getElementId().equals("ZC_P_PRO_MAKE_ZC_AGEY_CODE"))) {

          returnInfo.append("[").append(resName).append("] ").append("������Ϊ�գ�\n");
        }
      } else {
        if (result instanceof BigDecimal) {
          if (((BigDecimal) result).signum() == 0) {
            returnInfo.append("[").append(resName).append("] ").append("����Ϊ�㣡\n");
          }
        } else if (result instanceof Integer) {
          if (((Integer) result).intValue() == 0) {
            returnInfo.append("[").append(resName).append("] ").append("����Ϊ�㣡\n");
          }
        }
      }
    }
    return returnInfo.toString();
  }

  public static String validateDetailBillElementNull(List detailData, List notNullField, boolean isAllowEmpty) {
    String returnInfo = new String();
    if (!isAllowEmpty && (detailData == null || detailData.size() == 0)) {
      returnInfo = "������д��¼��";
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
  * @Description: (FieldToMod:���ݿ��ֶ�תJAVA�ֶ�)
  * @return String ��������
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
   * @Description: (FieldToMod:JAVA�ֶ�ת���ݿ��ֶ�)
   * @return String ��������
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
   * ���ñ༭�����ϰ�ť�Ĳ�ͬҳ��״̬�͵���ҵ��״̬�µĿ����ԣ�Ŀǰ��֧�ֶԹ�������ť�Ŀ����Կ���
   * @param btnStatusList ��ť״̬���󼯺�
   * @param billStatus ���ݵĵ�ǰҵ��״̬
   * @param pageStatus ���ݵĵ�ǰҳ��״̬
   * @param compoId ��������
   * @param processInstId ������ʾ��id
   * chenjl
   * 2010-5-14
   */
  public static synchronized void setButtonEnable(ArrayList<ButtonStatus> btnStatusList, String billStatus, String pageStatus, String compoId,
    Long processInstId) {
    if (btnStatusList == null)
      return;
    for (ButtonStatus bt : btnStatusList) {
      boolean funcEnabled = false;
      //û������ҳ��״̬�������ó�ȫ��ҳ��״̬���߰����е�ǰ��ҳ��״̬��������Ϊ����
      if (bt.getPageStatus().size() == 0 || bt.getPageStatus().contains(ZcSettingConstants.PAGE_STATUS_ALL)
        || bt.getPageStatus().contains(pageStatus)) {
        funcEnabled = true;
      }
      //�����˵���״̬����ҳ��״̬���㲢�ҵ���״̬û�����óɡ�ȫ������״̬�����жϵ���״̬������
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
        // ��������Ƶİ�ť
        if (funcId == null || "".equals(funcId.trim()) || "fprint_preview".equals(funcId) || "fprn_tpl_set".equals(funcId) || "fprint".equals(funcId)
          || "fjingJiaGongGao".equals(funcId) || "fconfirmsup".equals(funcId) || "fchengJiaoGongGao".equals(funcId) || "fchengjiao".equals(funcId)) {
          continue;
        }
        if ("fsendtoxieban".equals(funcId)) {
          System.out.println("____________");
        }
        // ���̸�����Զ��ʾ
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
          // ���������ť�������ֶ��ύ�������Զ��ύ�����ڣ������ء��ջذ�ť��
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
   * ��ȡһ���ַ��ĳ���,��������Ӣ��,������ֲ����ã�����ȡһ���ַ�λ
   * 
   * @author patriotlml
   * @param String
   *            origin, ԭʼ�ַ���
   * @param int
   *            len, ��ȡ����(һ�����ֳ��Ȱ�2���)
   * @return String, ���ص��ַ���
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
   * �ж�һ���ַ���Ascill�ַ����������ַ����纺���գ������ַ���
   * 
   * @param char
   *            c, ��Ҫ�жϵ��ַ�
   * @return boolean, ����true,Ascill�ַ�
   */
  public static boolean isLetter(char c) {
    int k = 0x80;
    return c / k == 0 ? true : false;
  }

  /**
   * �õ�һ���ַ����ĳ���,��ʾ�ĳ���,һ�����ֻ��պ��ĳ���Ϊ2,Ӣ���ַ�����Ϊ1
   * 
   * @param String
   *            s ,��Ҫ�õ����ȵ��ַ���
   * @return int, �õ����ַ�������
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
      System.out.println("�������ʱ����:" + ex.getMessage());
      JOptionPane.showMessageDialog(null, "�������ʱ����:" + ex.getLocalizedMessage());
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
   * @param opflag      ���������0ͬ�⣬1,��ͬ��
   * @param requestMeta
   * @return
   */
  public static int getAuditFlagValue(Integer oriAuditFlag, int opflag, RequestMeta requestMeta) {
    oriAuditFlag = oriAuditFlag == null ? 0 : oriAuditFlag;
    int flag = oriAuditFlag;
    String jianduzhuren = AsOptionMeta.getOptVal("OPT_JIANDU_ZR");
    if (opflag == 0) {//ͬ��
      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//�������Σ���ʮλ
        if (flag / 10 == 0) {
          flag = flag + 10;
        }
      } else {//�������Σ��ø�λ
        if (flag % 10 == 0) {
          flag += 1;
        }
      }
    } else {//��ͬ��
      if (requestMeta.getSvUserID().equals(jianduzhuren)) {//�������Σ���ʮλ
        if (flag / 10 == 1) {
          flag = flag - 10;
        }
      } else {//�������Σ��ø�λ
        if (flag % 10 == 1) {
          flag = flag / 10 * 10;
        }
      }
    }
    return flag;
  }
}
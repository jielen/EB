package com.ufgov.gk.client.util;

import java.awt.Dimension;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Insets;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JDialog;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.dto.BankDataDto;

public class Util {
  /**
   * ���㵥λ
   */
  private static final String jcCoType = "02";

  public static boolean isCurrCoTypeJc() {
    boolean flag = false;
    if (jcCoType.trim().equals(WorkEnv.getInstance().getCurrCoTypeCode())) {
      flag = true;
    }
    return flag;
  }

  public static String asterisk(String elementCode, BillElementMeta bem) {
    String v = "";
    if (!bem.isElementNullable(elementCode)) {
      v = "*";
    }
    return v;
  }

  public static void bankDataExport(List bankDataDtoList) {
    String dir = AsOptionMeta.getOptVal("OPT_AM_EXPORT_PATH");
    File file = new File(dir);
    if (!file.exists()) {
      file.mkdirs();
    }
    String extension = "txt";
    try {
      for (Object o : bankDataDtoList) {
        BankDataDto dto = (BankDataDto) o;
        FileOutputStream fos = new FileOutputStream(dir + dto.getFileName() + "." + extension);
        fos.write(dto.getData().getBytes());
        fos.close();
      }
    } catch (Exception ex) {
      throw new RuntimeException(ex);
    }
  }

  /**
   * ��Ǯ��ת����ָ����λ��Ǯ������unit����Ϊ10���������������������򷵻�ԭֵ.
   * @param unitCHN�����磺��
   * @param unit�����磺10000
   * @param money�����磺100000��ת��"10��"
   */
  public static String transMoneyYUAN_TO_UNIT_YUAN(String unitCHN, long unit, BigDecimal money) {
    String res = null;
    if (unit % 10 != 0 && unit <= 0) {
      return money.toPlainString();
    }
    BigDecimal bdunit = new BigDecimal(unit);
    res = money.divide(bdunit).toPlainString() + unitCHN;
    return res;
  }

  public static String transMoneyToBetterYUAN(BigDecimal money) {
    if (money == null) {
      return "0";
    }
    String result = null;
    String temp = money.toPlainString();
    int index = temp.indexOf(".");
    if (index != -1) {
      result = getBetterYUAN(temp.substring(0, index)) + temp.substring(index + 1, temp.length());
    } else {
      result = getBetterYUAN(temp);
    }
    return result;
  }

  private static String getBetterYUAN(String money) {
    int len = money.length();
    long lm = Long.parseLong(money);
    if (len == 4) {
      return lm / 1000 + "ǧ";
    } else if (len == 5 || len == 6) {
      return lm / 10000 + "��";
    } else if (len == 7) {
      return lm / 1000000 + "����";
    } else if (len == 8) {
      return lm / 10000000 + "ǧ��";
    } else if (len >= 9) {
      return lm / 100000000 + "��";
    } else {
      return money;
    }
  }

  public static void moveToScreenCenter(JDialog dialog) {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = dialog.getSize();

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
    dialog.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - insets.bottom - frameSize.height) / 2);
  }
}

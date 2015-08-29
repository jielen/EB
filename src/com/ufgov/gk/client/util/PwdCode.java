package com.ufgov.gk.client.util;

/**
 * ����ƽ̨generalFunc���еļ��ܽ��� ����ķ�������client��ʹ��
 * 
 * @param passwd
 * @return
 */
public class PwdCode {

  /**
   * ������������
   * 
   * @param passwd
   * @return
   */

  public static String encodePwd(String passwd) {

    String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
    String tempStr = "";
    if (passwd == null) {
      passwd = "";
    }

    int i;
    for (i = 0; i < passwd.length(); i++) {
      tempStr = tempStr + (char) (passwd.charAt(i) ^ encodeStr.charAt(i));
    }

    return tempStr;
  }

  /**
   * �����û�����
   * 
   * @param encodedPasswd
   *            String
   * @return String
   */
  public static String recodePwd(String encodedPasswd) {
    String encodeStr = "$#TGDF*FAA&21we@VGXD532w23413!";
    String tempStr = "";
    if (encodedPasswd == null) {
      encodedPasswd = "";
    }

    int i;
    for (i = 0; i < encodedPasswd.length(); i++) {
      char truePass = (char) ~(encodedPasswd.charAt(i) ^ ~encodeStr.charAt(i));
      tempStr = tempStr + truePass;
    }

    return tempStr;
  }
}

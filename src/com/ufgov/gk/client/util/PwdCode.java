package com.ufgov.gk.client.util;

/**
 * 复制平台generalFunc类中的加密解密 密码的方法，供client端使用
 * 
 * @param passwd
 * @return
 */
public class PwdCode {

  /**
   * 口令加密与解密
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
   * 解密用户密码
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

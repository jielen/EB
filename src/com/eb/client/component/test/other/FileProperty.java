package com.eb.client.component.test.other;

import java.io.File;

public class FileProperty {

  /**
   * @param args
   * Administrator
   * Jul 17, 2012
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    File directory = new File("");//�趨Ϊ��ǰ�ļ���
    try {
      System.out.println(directory.getCanonicalPath());//��ȡ��׼��·��
      System.out.println(directory.getAbsolutePath());//��ȡ����·��

      String IMAGE_DIRECTROY_FOR_CANDIDATE = "/img/candidateitems/";
      String ss = IMAGE_DIRECTROY_FOR_CANDIDATE.replaceAll("/", "\\\\");
      System.out.println("=====" + ss);
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}

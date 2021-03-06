package com.ufgov.gk.common.system.util;

import java.io.ByteArrayInputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class XmlUtils {

  public static Document parse(String xmlStr) throws DocumentException {
    try {
      ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes("gb2312"));
      SAXReader saxReader = new SAXReader();
      saxReader.setEncoding("gb2312");
      return saxReader.read(inputStream);
    } catch (Exception ex) {
      System.out.println(ex.getMessage());
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  public static Document parse(String xmlStr, String encoding) throws DocumentException {
    ByteArrayInputStream inputStream = null;
    try {
      inputStream = new ByteArrayInputStream(xmlStr.getBytes(encoding));
    } catch (Exception ex) {
      inputStream = new ByteArrayInputStream(xmlStr.getBytes());
    }
    SAXReader saxReader = new SAXReader();
    saxReader.setEncoding(encoding);
    return saxReader.read(inputStream);
  }

  public static String evaluate(String path, Document doc) {
    String result = "";
    Node node = doc.selectSingleNode(path);
    if (node != null) {
      result = node.getText();
    }
    return result;
  }

  public static void main(String[] args) {
    try {
      String source = "<?xml version=\"1.0\" encoding=\"GB2312\"?><MESSAGE><MESSINFO><DATATMP>00</DATATMP><DATETIME>00</DATETIME><TRADEFLAG>1</TRADEFLAG><DESC>成功</DESC></MESSINFO><RETURNCODE>000000</RETURNCODE><RETURNMSG>交易成功</RETURNMSG></MESSAGE>";
      Document doc = XmlUtils.parse(source);
      System.out.println(XmlUtils.evaluate("//MESSAGE/MESSINFO/DESC", doc));
      System.out.println(System.getProperty("file.encoding"));
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

}

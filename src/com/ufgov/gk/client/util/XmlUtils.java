package com.ufgov.gk.client.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XmlUtils {
  private static XPath xpath = null;
  
  static {
    XPathFactory xpathFactry = XPathFactory.newInstance();
    xpath = xpathFactry.newXPath();
  }

  public static Document parse(String xmlStr) throws ParserConfigurationException, SAXException, IOException {
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    factory.setValidating(false);
    factory.setNamespaceAware(false);
    factory.setIgnoringComments(true);
    factory.setIgnoringElementContentWhitespace(false);
    factory.setCoalescing(false);
    factory.setExpandEntityReferences(true);
    DocumentBuilder builder = factory.newDocumentBuilder();
    ByteArrayInputStream inputStream = new ByteArrayInputStream(xmlStr.getBytes());
    return builder.parse(inputStream);
  }

  public static String evaluate(String path, Document doc) throws XPathExpressionException {
    xpath.compile(path);
    String result = xpath.evaluate(path, doc);
    return result;
  }
  
  
}

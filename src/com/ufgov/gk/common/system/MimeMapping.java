package com.ufgov.gk.common.system;

import java.util.HashMap;
import java.util.Map;

public class MimeMapping {
  private static String defaultMimeType = "application/octet-stream";

  private static Map mimeMapping = new HashMap();
  static {
    mimeMapping.put("xls", "application/excel");
    mimeMapping.put("pot", "application/vnd.ms-powerpoint");
    mimeMapping.put("pps", "application/vnd.ms-powerpoint");
    mimeMapping.put("ppt", "application/vnd.ms-powerpoint");
    mimeMapping.put("ppz", "application/vnd.ms-powerpoint");

    mimeMapping.put("doc", "application/msword");
    mimeMapping.put("bin", "application/octet-stream");
    mimeMapping.put("class", "application/octet-stream");
    mimeMapping.put("dms", "application/octet-stream");
    mimeMapping.put("exe", "application/octet-stream");
    mimeMapping.put("lha", "application/octet-stream");
    mimeMapping.put("lzh", "application/octet-stream");

    mimeMapping.put("pdf", "application/pdf");
    mimeMapping.put("pgp", "application/pgp");
    mimeMapping.put("lzh", "application/octet-stream");
    mimeMapping.put("lzh", "application/octet-stream");

    mimeMapping.put("xlc", "application/vnd.ms-excel");
    mimeMapping.put("xll", "application/vnd.ms-excel");
    mimeMapping.put("xlm", "application/vnd.ms-excel");
    mimeMapping.put("xls", "application/vnd.ms-excel");
    mimeMapping.put("xlw", "application/vnd.ms-excel");

    mimeMapping.put("css", "text/css");
    mimeMapping.put("htm", "text/html");
    mimeMapping.put("html", "text/html");
    mimeMapping.put("txt", "text/plain");
    mimeMapping.put("rtf", "text/rtf");

    mimeMapping.put("gif", "image/gif");
    mimeMapping.put("jpeg", "image/jpeg");
    mimeMapping.put("au", "audio/basic");
    mimeMapping.put("ra", "audio/x-pn-realaudio");
    mimeMapping.put("ram", "audio/x-pn-realaudio");
    mimeMapping.put("mpg", "video/mpeg");
    mimeMapping.put("mpeg", "video/mpeg");
    mimeMapping.put("avi", "video/x-msvideo");

    mimeMapping.put("zip", "application/x-zip-compressed");
    mimeMapping.put("rar", "application/x-rar-compressed");

  }

  public static String getMimeType(String fileExtention) {
    String mimeType = (String) mimeMapping.get(fileExtention);
    if (mimeType == null) {
      mimeType = defaultMimeType;
    }
    return  mimeType;
  }

}

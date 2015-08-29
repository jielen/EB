package com.ufgov.gk.client.component;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class ExtFileFilter extends FileFilter {
  String ext;

  public ExtFileFilter(String ext) {
    this.ext = ext;
  }

  public boolean accept(File file) {
    if (file.isDirectory()) {
      return true;
    }
    String fileName = file.getName();
    int index = fileName.lastIndexOf('.');
    if (index > 0 && index < fileName.length() - 1) {

      String extension = fileName.substring(index + 1).toLowerCase();
      if (extension.equals(ext))
        return true;
    }
    return false;
  }

  public String getDescription() {
    if ("txt".equals(ext))
      return "�ı��ĵ�(*.txt)";
    else if ("xls".equals(ext)) {
      return "Excel ������(*.xls)";
    }
    return "";
  }

}
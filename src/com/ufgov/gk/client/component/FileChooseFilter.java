package com.ufgov.gk.client.component;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class FileChooseFilter extends FileFilter {
  private String ext;

  public FileChooseFilter() {
    this(null);
  }

  public FileChooseFilter(String ext) {
    this.ext = ext;
  }

  @Override
  public boolean accept(File f) {
    if (f.isDirectory()) {
      return true;
    }
    if (this.ext == null) {
      return true;
    }
    String locExt = "." + this.ext.toLowerCase();
    return f.getAbsolutePath().toLowerCase().endsWith(locExt);
  }

  @Override
  public String getDescription() {
    String locExt = this.ext.toLowerCase();
    if (locExt.endsWith("xml")) {
      return "XML文件(*.xml)";
    } else if (locExt.equals("doc")) {
      return "Microsoft Word文件(*.doc)";
    }
    return null;
  }

}

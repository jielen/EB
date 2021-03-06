package com.ufgov.gk.client.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
  public void zip(String zipFileName, String inputFile) throws Exception {
    if (inputFile == null || "".equals(inputFile) || !(new File(inputFile)).exists()) {
      return;
    }
    zip(zipFileName, new File(inputFile));
  }

  public void zip(String zipFileName, File inputFile) throws Exception {
    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
    zip(out, inputFile, "");
    out.close();
  }

  //��ѹ��
  public void unzip(String zipFileName, String outputDirectory) throws Exception {
    if (zipFileName == null || "".equals(zipFileName)) {
      return;
    }
    if (outputDirectory == null || "".equals(outputDirectory)) {
      outputDirectory = zipFileName.substring(0, zipFileName.indexOf("."));
    }
    ZipInputStream in = new ZipInputStream(new FileInputStream(zipFileName));
    ZipEntry z;
    while ((z = in.getNextEntry()) != null) {
      if (z.isDirectory()) {
        String name = z.getName();
        name = name.substring(0, name.length() - 1);
        File f = new File(outputDirectory + File.separator + name);
        f.mkdir();
      } else {
        File f = new File(outputDirectory + File.separator + z.getName());
        f.createNewFile();
        FileOutputStream out = new FileOutputStream(f);
        int b;
        while ((b = in.read()) != -1)
          out.write(b);
        out.close();
      }
    }

    in.close();
  }

  //ѹ��
  public void zip(ZipOutputStream out, File f, String base) throws Exception {
    if (f.isDirectory()) {
      File[] fl = f.listFiles();
      out.putNextEntry(new ZipEntry(base + "/"));
      base = base.length() == 0 ? "" : base + "/";
      for (int i = 0; i < fl.length; i++) {
        zip(out, fl[i], base + fl[i].getName());
      }
    } else {
      out.putNextEntry(new ZipEntry(base));
      FileInputStream in = new FileInputStream(f);
      int b;
      while ((b = in.read()) != -1)
        out.write(b);
      in.close();
    }
  }

  public static void main(String[] args) {
    try {
      Zip t = new Zip();
      //t.zip("d:\\test.zip","d:\\test");
      t.unzip("d:\\test.zip", "d:\\test2");
    } catch (Exception e) {
      e.printStackTrace(System.out);
    }
  }
}

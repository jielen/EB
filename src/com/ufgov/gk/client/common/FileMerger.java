/**
 * 
 */
package com.ufgov.gk.client.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;
import java.util.Iterator;

import javax.swing.JOptionPane;

/**
 * @author LEO
 *
 */
public class FileMerger extends AFile {

  public FileMerger() {
    this.PATHNAME_FILE_MAP.clear();
    this.fileTotalLen = 0;
  }

  public void mergerFiles(String rootPath, String targetFile) {
    this.getAllFilesAttributes(rootPath, rootPath);
    boolean isCreated = false;
    File tarFile = new File(targetFile);
    if (tarFile.exists()) {
      if (tarFile.length() > 0) {
        int select = JOptionPane.showConfirmDialog(null, "ָ�����ļ�" + tarFile.getAbsolutePath() + "�Ѵ��ڴ��ڣ��Ƿ񸲸ǣ�");
        if (select != 0) {//��ѡ��Ϊ����ʱ�����ص�ֵΪ0
          return;
        }
      }
      isCreated = true;
    } else {
      try {
        isCreated = tarFile.createNewFile();
      } catch (Exception e) {
        e.printStackTrace();
        isCreated = false;
      }
    }

    if (isCreated) {
      System.out.println("��ʼ�ϲ��ļ�...");
      this.doMergerFiles(tarFile);
    } else {

    }
  }

  /**
   * ִ���ļ��ϲ�����ȡ��д��
   * @param newFile
   */
  private void doMergerFiles(File newFile) {
    RandomAccessFile raf = null;
    FileInputStream fis = null;
    int len = 0;
    long writed = 0;
    byte[] content = new byte[FileMerger.readBufferSize * 2];
    try {
      raf = new RandomAccessFile(newFile.getAbsolutePath(), "rw");
      Iterator<String> it = this.PATHNAME_FILE_MAP.keySet().iterator();
      while (it.hasNext()) {
        raf.seek(writed);
        String filePath = it.next();
        FileAttributes fAtts = this.PATHNAME_FILE_MAP.get(filePath);
        byte[] header = this.makeFileHeaderBody(fAtts);
        raf.write(header);
        fis = new FileInputStream(filePath);
        while ((len = fis.read(content)) > 0) {
          raf.write(content, 0, len);
        }
        fis.close();
        writed = writed + header.length + fAtts.getFileSize();
      }
      raf.close();
    } catch (Exception ne) {
      try {
        if (raf != null) {
          raf.close();
        }
        if (fis != null) {
          fis.close();
        }
      } catch (IOException ioe) {
        ioe.printStackTrace();
      }
    }
  }

  /**
   * �ϳ��ļ�ͷ�����ļ�ͷ����ʽ���£�
   * HEADER_LEN;SIZE:8888;RPATH:work_doc/hello/;NAME:test.jpg;MODTIME:123000022222;
   * HEADER_LEN----���ȱ���Ϊ4;
   * @param fAtts
   * @return
   */
  private byte[] makeFileHeaderBody(FileAttributes fAtts) throws Exception {
    StringBuffer all = null;
    StringBuffer header = new StringBuffer();
    header.append("SIZE:");
    header.append(fAtts.getFileSize());
    header.append(";RPATH:");
    header.append(fAtts.getFileDirPath()
      .substring(0, fAtts.getFileDirPath().lastIndexOf(fAtts.getFileName())));
    header.append(";NAME:");
    header.append(fAtts.getFileName());
    header.append(";MODTIME:");
    header.append(fAtts.getFileLastModifyTime());
    header.append(";|");
    try {
      int len = header.toString().getBytes(Charset.forName("GBK")).length;
      //��ΪҪ�����Ⱥ������һ��";"�����Գ�����Ӧ�ü�1;
      all = standardHeaderStart(len + 1);
      all.append(";");
      all.append(header);
    } catch (Exception e) {
      throw e;
    }
    return all.toString().getBytes(Charset.forName("GBK"));
  }

  /**
   * ��Ϊ��ֵ����ת����϶����Ƕ�Ӧһ���ֽڵģ����Կ��Է���StringBuffer
   * @param len
   * @return ����һ���ĸ��ֽڵı�ʾ��ǰ�ļ�ͷ�����̵��ַ���
   */
  private StringBuffer standardHeaderStart(int len) throws Exception {
    int len_len = (len + "").length();
    if (len_len > FileMerger.headerBeginnerLen) {
      throw new Exception("�ļ���������̫����ϵͳ�޷�����...");
    }
    StringBuffer buff = new StringBuffer();
    for (int i = 0; i < FileMerger.headerBeginnerLen - len_len; i++) {
      buff.append("0");
    }
    buff.append(len);

    return buff;
  }

  /**
   * �Ȼ��ÿ���ļ��������������
   * @param path �ļ����ڵĸ�Ŀ¼
   * @param rootDir �ļ����ڵĸ�Ŀ¼�ĸ�Ŀ¼
   */
  private void getAllFilesAttributes(String path, String rootDir) {
    File file = new File(path);
    if (!file.exists()) {
      return;
    } else {
      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++) {
        if (files[i].isDirectory()) {
          this.getAllFilesAttributes(files[i].getAbsolutePath(), rootDir);
        } else {
          String fileName = files[i].getName();
          FileAttributes fAttr = new FileAttributes();
          if (fileName.lastIndexOf(".") != -1) {
            fAttr.setFileExtension(fileName.substring(fileName.lastIndexOf(".")));
          } else {
            fAttr.setFileExtension("");
          }
          fAttr.setFileLastModifyTime(files[i].lastModified() + "");
          fAttr.setFileName(fileName);
          fAttr.setFileOwner("sys");
          fAttr.setFileDirPath(files[i].getAbsolutePath().substring(rootDir.length()));
          fAttr.setFileSize(files[i].length());
          this.PATHNAME_FILE_MAP.put(files[i].getAbsolutePath(), fAttr);
          fileTotalLen += files[i].length();
        }
      }
    }
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    long sTime = System.currentTimeMillis();
    FileMerger fm = new FileMerger();
    String sourceDir = "d://eclipse2";
    fm.mergerFiles(sourceDir, sourceDir + ".tdes");
    System.out.println("fileTotalSize:" + fm.fileTotalLen / 1024.0 / 1024.0 + "MB");
    long eTime = System.currentTimeMillis();
    System.out.println("ʱ�䣺" + (eTime - sTime));
  }
}

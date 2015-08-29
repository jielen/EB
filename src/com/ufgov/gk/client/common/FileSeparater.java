package com.ufgov.gk.client.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileSeparater extends AFile {

  public long lastReadPos = 0;

  public FileSeparater() {
    this.PATHNAME_FILE_MAP.clear();
    this.fileTotalLen = 0;
  }

  public void separaterFiles(String filePath, String tarDir) throws NumberFormatException, IOException {
    RandomAccessFile raf = null;
    FileOutputStream fos = null;
    int headerLen = 0;
    int len = 0;
    this.lastReadPos = 0;
    byte[] beginner = new byte[4];
    byte[] content = new byte[FileSeparater.readBufferSize];
    boolean isGoOn = true;
    tarDir = tarDir + File.separator;
    try {
      while (isGoOn) {
        long writed = 0;
        boolean isGoOnToWrite = true;
        raf = new RandomAccessFile(filePath, "r");
        //读取子文件的文件头大小值;
        raf.seek(this.lastReadPos);
        raf.read(beginner);
        headerLen = Integer.parseInt(new String(beginner));
        byte[] header = new byte[headerLen];
        //读取子文件的文件头部信息
        this.lastReadPos += FileSeparater.headerBeginnerLen;
        raf.seek(this.lastReadPos);
        raf.read(header);
        this.lastReadPos += headerLen;
        FileAttributes fileAttr = this.extractFileHeaderInfo(new String(header));
        File newFile = new File(tarDir + fileAttr.getFileDirPath());
        if (!newFile.exists()) {
          newFile.mkdirs();
        }
        long currFileSize = fileAttr.getFileSize();
        fos = new FileOutputStream(newFile.getAbsolutePath() + File.separator + fileAttr.getFileName());
        //准备读取文件的内容
        raf.seek(lastReadPos);
        while ((len = raf.read(content)) > 0 && isGoOnToWrite) {
          if (writed + len > currFileSize) {
            len = (int) (currFileSize - writed);
            isGoOnToWrite = false;
            this.lastReadPos += currFileSize;
          }
          fos.write(content, 0, len);
          writed += len;
        }
        fos.close();
        if (len == -1) {
          isGoOn = false;
        }
      }
      raf.close();
    } catch (NumberFormatException e) {
      e.printStackTrace();
      throw e;
    } catch (IOException e) {
      e.printStackTrace();
      throw e;
    } finally {
      try {
        if (fos != null) {
          fos.close();
        }
        if (raf != null) {
          raf.close();
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * HEADER_LEN;SIZE:8888;RPATH:work_doc/hello/;NAME:test.jpg;MODTIME:123000022222;
   * @param header
   * @return
   */
  private FileAttributes extractFileHeaderInfo(String header) {
    //System.out.println(header);
    FileAttributes file = new FileAttributes();
    String[] attrs = header.split(";");
    file.setFileExtension(attrs[3].substring(attrs[3].lastIndexOf(".") + 1));
    file.setFileLastModifyTime(attrs[4].substring(attrs[4].indexOf(":") + 1));
    file.setFileName(attrs[3].substring(attrs[3].indexOf(":") + 1));
    file.setFileDirPath(attrs[2].substring(attrs[2].indexOf(":") + 1));
    file.setFileSize(Long.parseLong(attrs[1].substring(attrs[1].indexOf(":") + 1)));

    return file;
  }

  public static void main(String[] args) {
    long sTime = System.currentTimeMillis();
    FileSeparater separater = new FileSeparater();
    try {
      String filePath = "e:/av.tdes";
      separater.separaterFiles(filePath, filePath.substring(0, filePath.indexOf(".")));
    } catch (Exception e) {
      e.printStackTrace();
    }
    long eTime = System.currentTimeMillis();
    System.out.println("时间：" + (eTime - sTime));
  }
}

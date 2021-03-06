package com.ufgov.gk.client.common;

public class FileAttributes {
  private String fileDirPath;

  private String fileName;

  private String fileExtension;

  private long fileSize;

  private String fileLastModifyTime;

  private String fileOwner;

  private String fileAttributes;

  public String getFileDirPath() {
    return fileDirPath;
  }

  public void setFileDirPath(String fileDirPath) {
    this.fileDirPath = fileDirPath;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileExtension() {
    return fileExtension;
  }

  public void setFileExtension(String fileExtension) {
    this.fileExtension = fileExtension;
  }

  public long getFileSize() {
    return fileSize;
  }

  public void setFileSize(long fileSize) {
    this.fileSize = fileSize;
  }

  public String getFileLastModifyTime() {
    return fileLastModifyTime;
  }

  public void setFileLastModifyTime(String fileLastModifyTime) {
    this.fileLastModifyTime = fileLastModifyTime;
  }

  public String getFileOwner() {
    return fileOwner;
  }

  public void setFileOwner(String fileOwner) {
    this.fileOwner = fileOwner;
  }

  public String getFileAttributes_PNECOS() {
    StringBuffer buff = new StringBuffer();
    buff.append(this.fileDirPath);
    buff.append("*");
    buff.append(this.fileName);
    buff.append("*");
    buff.append(this.fileExtension);
    buff.append("*");
    buff.append(this.fileLastModifyTime);
    buff.append("*");
    buff.append(this.fileOwner);
    buff.append("*");
    buff.append(this.fileSize);
    fileAttributes = buff.toString();
    buff = null;

    return fileAttributes;
  }
}

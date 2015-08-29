package com.ufgov.gk.common.system.model;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;

public class AsFile implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private String fileId;

  private byte[] fileContent;

  private String fileName;

  private String mimeType;

  private FileInputStream largeFileContent;

  private InputStream largeFileStream;

  private String filePath;

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public InputStream getLargeFileStream() {
    return largeFileStream;
  }

  public void setLargeFileStream(InputStream largeFileStream) {
    this.largeFileStream = largeFileStream;
  }

  public FileInputStream getLargeFileContent() {
    return largeFileContent;
  }

  public void setLargeFileContent(FileInputStream largeFileContent) {
    this.largeFileContent = largeFileContent;
  }

  public String getFileId() {
    return fileId;
  }

  public void setFileId(String fileId) {
    this.fileId = fileId;
  }

  public byte[] getFileContent() {
    return fileContent;
  }

  public void setFileContent(byte[] fileContent) {
    this.fileContent = fileContent;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getMimeType() {
    return mimeType;
  }

  public void setMimeType(String mimeType) {
    this.mimeType = mimeType;
  }
}

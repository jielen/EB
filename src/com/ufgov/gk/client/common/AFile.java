package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.Map;

public abstract class AFile {
  /**
   * 文件开头的标识文件头部长度的数值，目前最大长度为4个字节，不足四个字节在前面补零;
   */
  protected static final int headerBeginnerLen = 4;

  /**
   * 经过简单测试，合并文件时，这个值大一些好，切分文件时，则当该值为4096时比较好;
   */
  protected static final int readBufferSize = 4096;

  protected long fileTotalLen = 0;

  protected Map<String, FileAttributes> PATHNAME_FILE_MAP = new HashMap<String, FileAttributes>();

  public static int getHeaderBeginnerLen() {
    return headerBeginnerLen;
  }

  public long getFileTotalLen() {
    return fileTotalLen;
  }

  public void setFileTotalLen(long fileTotalLen) {
    this.fileTotalLen = fileTotalLen;
  }
}

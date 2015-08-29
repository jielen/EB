package com.ufgov.gk.client.common;

import java.util.HashMap;
import java.util.Map;

public abstract class AFile {
  /**
   * �ļ���ͷ�ı�ʶ�ļ�ͷ�����ȵ���ֵ��Ŀǰ��󳤶�Ϊ4���ֽڣ������ĸ��ֽ���ǰ�油��;
   */
  protected static final int headerBeginnerLen = 4;

  /**
   * �����򵥲��ԣ��ϲ��ļ�ʱ�����ֵ��һЩ�ã��з��ļ�ʱ���򵱸�ֵΪ4096ʱ�ȽϺ�;
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

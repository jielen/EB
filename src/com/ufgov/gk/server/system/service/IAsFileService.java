package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.system.model.AsFile;

public interface IAsFileService {
  /**
   * ·µ»ØÎÄ¼þId
   * @param asFile
   * @return
   */
  void updateAsFileById(AsFile asFile);

  String uploadFile(AsFile asFile);

  String uploadLargeFile(AsFile asFile);

  String insertAsFileDirectory(AsFile asFile);

  boolean uploadFile(AsFile asFile, String savePath, String fileName);

  AsFile getAsFileById(String fileId);

  AsFile getLargeAsFileById(String fileId);

  List getLargeAsFile(List fileIdList);

  AsFile downloadFile(String fileId);

  void deleteFile(String fileId);

  byte[] getTbylbFromFileMenuById(String fileId, String packCode);

  void uploadFileSavePath(AsFile asFile);

}

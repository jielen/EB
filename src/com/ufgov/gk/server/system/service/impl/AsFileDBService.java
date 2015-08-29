package com.ufgov.gk.server.system.service.impl;

import java.util.List;

import com.ufgov.gk.common.system.Guid;
import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.gk.server.system.dao.IAsFileDao;
import com.ufgov.gk.server.system.service.IAsFileService;

public class AsFileDBService implements IAsFileService {
  IAsFileDao asFileDao;

  public IAsFileDao getAsFileDao() {
    return asFileDao;
  }

  public void setAsFileDao(IAsFileDao asFileDao) {
    this.asFileDao = asFileDao;
  }

  /**
    * �����ļ�Id
    * @param asFile
    * @return
    */
  public String uploadFile(AsFile asFile) {
    if (asFile.getFileId() == null || "".equals(asFile.getFileId())) {
      asFile.setFileId(Guid.genID());
    }
    try {
      asFileDao.deleteAsFileById(asFile.getFileId());
      asFileDao.insertAsFile(asFile);
      return asFile.getFileId();
    } catch (Exception e) {
      throw new RuntimeException("�����ϴ��ļ�ʱ����", e);
    }
  }

  public AsFile getAsFileById(String fileId) {
    return asFileDao.getAsFileById(fileId);
  }

  public AsFile downloadFile(String fileId) {
    try {
      AsFile asFile = asFileDao.getAsFileById(fileId);
      return asFile;
    } catch (Exception e) {
      throw new RuntimeException("�����ļ�ʱ����", e);
    }
  }

  public void deleteFile(String fileId) {
    try {
      asFileDao.deleteAsFileById(fileId);
    } catch (Exception e) {
      throw new RuntimeException("ɾ���ļ�ʱ����", e);
    }
  }

  public boolean uploadFile(AsFile asFile, String savePath, String fileName) {
    return false;
  }

  public void updateAsFileById(AsFile asFile) {
    try {
      asFileDao.updateAsFileById(asFile);
    } catch (Exception e) {
      throw new RuntimeException("�����ļ�ʱ����", e);
    }
  }

  public String uploadLargeFile(AsFile asFile) {
    // TODO Auto-generated method stub
    return null;
  }

  public AsFile getLargeAsFileById(String fileId) {
    // TODO Auto-generated method stub
    return null;
  }

  public List getLargeAsFile(List fileIdList) {
    // TODO Auto-generated method stub
    return null;
  }

  public String insertAsFileDirectory(AsFile asFile) {
    // TODO Auto-generated method stub
    return null;
  }

  public byte[] getTbylbFromFileMenuById(String fileId, String packCode) {
    // TODO Auto-generated method stub
    return null;
  }

  public void uploadFileSavePath(AsFile asFile) {
    // TODO Auto-generated method stub

  }
}

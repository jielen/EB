package com.ufgov.gk.server.system.service.impl;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

import com.ufgov.gk.common.system.Guid;
import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.gk.server.system.dao.IAsFileDao;
import com.ufgov.gk.server.system.service.IAsFileService;

public class AsFileService implements IAsFileService {
  IAsFileDao asFileDao;

  public IAsFileDao getAsFileDao() {
    return asFileDao;
  }

  public void setAsFileDao(IAsFileDao asFileDao) {
    this.asFileDao = asFileDao;
  }

  public void updateAsFileById(AsFile asFile) {
    asFileDao.updateAsFileById(asFile);
  }

  /**
    * 返回文件Id
    * @param asFile
    * @return
    */
  public String uploadFile(AsFile asFile) {
    if (asFile.getFileId() == null || "".equals(asFile.getFileId())) {
      asFile.setFileId(Guid.genID());
    }
    asFileDao.deleteAsFileById(asFile.getFileId());
    asFileDao.insertAsFile(asFile);
    return asFile.getFileId();
  }

  /**
   * 将文件保存到文件系统中，而不保存到数据库
   * @param asFile
   * @param savePath
   * @param fileName
   * @return
   */
  public boolean uploadFile(AsFile asFile, String savePath, String fileName) {
    File test = new File("TESTING");
    StringBuffer workPath = new StringBuffer(test.getAbsolutePath());
    workPath.delete(workPath.lastIndexOf("TESTING"), workPath.length());
    workPath.append("applications/portal/");
    workPath.append(savePath);

    File path = new File(workPath.toString());
    if (!path.exists()) {
      path.mkdirs();
    }

    workPath.append(File.separator);
    workPath.append(fileName);
    File tempFile = new File(workPath.toString());
    FileOutputStream os = null;
    try {
      os = new FileOutputStream(tempFile);
      os.write(asFile.getFileContent());
    } catch (Exception e) {
      throw new RuntimeException("保存上传文件时出错！", e);
    } finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (Exception e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }
    return true;
  }

  public AsFile getAsFileById(String fileId) {
    return asFileDao.getAsFileById(fileId);
  }

  public AsFile getLargeAsFileById(String fileId) {
    return asFileDao.getLargeAsFileById(fileId);
  }

  public AsFile downloadFile(String fileId) {

    AsFile asFile = asFileDao.getAsFileById(fileId);
    return asFile;
  }

  public void deleteFile(String fileId) {
    asFileDao.deleteAsFileById(fileId);
  }

  public String uploadLargeFile(AsFile asFile) {
    asFile.setFileId(Guid.genID());
    asFileDao.insertLargeAsFile(asFile);
    return asFile.getFileId();
  }

  public List getLargeAsFile(List fileIdList) {
    return asFileDao.getLargeAsFile(fileIdList);
  }

  public String insertAsFileDirectory(AsFile asFile) {
    asFileDao.insertAsFileDirectory(asFile);
    return asFile.getFileId();
  }

  public byte[] getTbylbFromFileMenuById(String fileId, String packCode) {
    File tempFile = new File("fileUploads/" + fileId);
    ZipFile zipFile = null;
    try {
      zipFile = new ZipFile(tempFile, "GBK");
      Enumeration emu = zipFile.getEntries();
      while (emu.hasMoreElements()) {
        ZipEntry entry = (ZipEntry) emu.nextElement();
        System.err.println(entry.getName());
        if (getMatchedItem(entry.getName(), packCode)) {
          System.out.println(entry.getName() + "---------->命中...");
          BufferedInputStream bis = new BufferedInputStream(zipFile.getInputStream(entry));
          byte data[] = new byte[1024 * 5 * 5];
          int buffLen = data.length;
          int len = 0;
          int fileLen = (int) entry.getSize();
          byte buff[] = new byte[fileLen];
          int k = 0;
          while ((len = bis.read(data)) != -1) {
            int tempLen = 0;
            if (len < buffLen) {
              tempLen = len;
            } else {
              tempLen = buffLen;
            }
            for (int j = 0; j < tempLen; j++) {
              buff[k++] = data[j];
            }
          }
          return buff;
        }
      }
      zipFile.close();
    } catch (Exception e) {
      try {
        if (zipFile != null) {
          zipFile.close();
        }
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      e.printStackTrace();
    }
    return null;
  }

  private boolean getMatchedItem(String name, String packCode) {
    if ((name.indexOf("\\投标文件\\") != -1 || name.indexOf("\\响应文件\\") != -1) && name.indexOf(packCode) != -1 && name.endsWith("一览表.config")) {
      return true;
    } else if ((name.indexOf("/投标文件/") != -1 || name.indexOf("/响应文件/") != -1) && name.indexOf(packCode) != -1 && name.endsWith("一览表.config")) {
      return true;
    } else {
      return false;
    }
  }

  public void uploadFileSavePath(AsFile asFile) {
    File test = new File("TESTING");
    StringBuffer workPath = new StringBuffer(test.getAbsolutePath());
    workPath.delete(workPath.lastIndexOf("TESTING"), workPath.length());
    workPath.append("applications").append(File.separator).append("portal").append(File.separator);
    workPath.append("impfiles");
    asFile.setFilePath(workPath.toString());
    File path = new File(workPath.toString());
    if (!path.exists()) {
      path.mkdirs();
    }

    workPath.append(File.separator);
    workPath.append(asFile.getFileName());
    File tempFile = new File(workPath.toString());
    FileOutputStream os = null;
    try {
      os = new FileOutputStream(tempFile);
      os.write(asFile.getFileContent());
      os.flush();
      asFile.setFileContent(null);
      asFileDao.insertAsFileDirectory(asFile);
    } catch (Exception e) {
      throw new RuntimeException("保存上传文件时出错！", e);
    } finally {
      try {
        if (os != null) {
          os.close();
        }
      } catch (Exception e) {
        throw new RuntimeException(e.getMessage(), e);
      }
    }
  }
}
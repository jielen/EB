package com.ufgov.gk.server.system.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.system.model.AsFile;
import com.ufgov.gk.server.system.dao.IAsFileDao;

public class AsFileDao extends SqlMapClientDaoSupport implements IAsFileDao {

  public void deleteAsFileById(String fileId) {
    this.getSqlMapClientTemplate().insert("AsFile.deleteAsFileById", fileId);

  }

  public AsFile getAsFileById(String fileId) {
    return (AsFile) this.getSqlMapClientTemplate().queryForObject("AsFile.getAsFileById", fileId);
  }

  public AsFile getLargeAsFileById(String fileId) {
    return (AsFile) this.getSqlMapClientTemplate().queryForObject("AsFile.getLargeAsFileById", fileId);
  }

  public void insertAsFile(AsFile asFile) {
    this.getSqlMapClientTemplate().insert("AsFile.insertAsFile", asFile);
  }

  public void updateAsFileById(AsFile asFile) {
    this.getSqlMapClientTemplate().update("AsFile.updateAsFileById", asFile);
  }

  public void insertLargeAsFile(AsFile asFile) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().insert("AsFile.insertLargeAsFile", asFile);
  }

  public List getLargeAsFile(List fileIdList) {
    // TODO Auto-generated method stub
    return this.getSqlMapClientTemplate().queryForList("AsFile.getLargeAsFile", fileIdList);
  }

  public void insertAsFileDirectory(AsFile asFile) {
    this.getSqlMapClientTemplate().insert("AsFile.insertAsFileDirectory", asFile);
  }

}

package com.ufgov.gk.server.commonbiz.dao.ibatis;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.commonbiz.model.SendDoc;
import com.ufgov.gk.server.commonbiz.dao.ISendDocDao;

public class SendDocDao extends SqlMapClientDaoSupport implements ISendDocDao {

  public List getSendDoc(int nd) {
    return this.getSqlMapClientTemplate().queryForList("SendDoc.getSendDoc",
      new Integer(nd));
  }

  public void deleteSendDoc(SendDoc sendDoc) {
    this.getSqlMapClientTemplate().delete("SendDoc.deleteSendDoc", sendDoc);
  }

  public void insertSendDoc(SendDoc sendDoc) {
    this.getSqlMapClientTemplate().insert("SendDoc.insertSendDoc", sendDoc);
  }

  public void updateSendDoc(SendDoc sendDoc) {
    this.getSqlMapClientTemplate().update("SendDoc.updateSendDoc", sendDoc);
  }

  public boolean codeExist(SendDoc sendDoc) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "SendDoc.codeExist", sendDoc)).intValue() > 0 ? true : false;
  }

  public boolean nameExist(SendDoc sendDoc) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "SendDoc.nameExist", sendDoc)).intValue() > 0 ? true : false;
  }

  public boolean nameExistSelfExcluded(SendDoc sendDoc) {
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "SendDoc.nameExisteSelfExcluded", sendDoc)).intValue() > 0 ? true : false;
  }
  public boolean sendDocUsed(SendDoc sendDoc){
    return ((Integer) this.getSqlMapClientTemplate().queryForObject(
      "SendDoc.getUsedSendDocNum", sendDoc)).intValue() > 0 ? true : false;
  }

}
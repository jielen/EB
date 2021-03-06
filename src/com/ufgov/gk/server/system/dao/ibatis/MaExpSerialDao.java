package com.ufgov.gk.server.system.dao.ibatis;

import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.ufgov.gk.common.commonbiz.model.MaExpSerial;
import com.ufgov.gk.server.system.dao.IMaExpSerialDao;

public class MaExpSerialDao extends SqlMapClientDaoSupport implements IMaExpSerialDao {

  public MaExpSerialDao() {
    super();
  }
  
  public MaExpSerial getMaExpSerial(Map params) {
    // TODO Auto-generated method stub
    MaExpSerial serial = (MaExpSerial) this.getSqlMapClientTemplate().queryForObject(
      "MaExpSerial.getMaExpSerial", params);
    return serial;
  }


  public void insertMaExpSerial(MaExpSerial serial) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().insert("MaExpSerial.insertMaExpSerial", serial);
  }

  public void updateMaExpSerial(MaExpSerial serial) {
    // TODO Auto-generated method stub
    this.getSqlMapClientTemplate().update("MaExpSerial.updateMaExpSerial", serial);
  }

}

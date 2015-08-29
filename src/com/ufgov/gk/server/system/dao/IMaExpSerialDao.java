package com.ufgov.gk.server.system.dao;

import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.MaExpSerial;

public interface IMaExpSerialDao {
  public MaExpSerial getMaExpSerial(Map params);
  
  public void insertMaExpSerial(MaExpSerial serial);
  
  public void updateMaExpSerial(MaExpSerial serial);
}

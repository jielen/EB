package com.ufgov.gk.server.system.service;

import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.MaExpSerial;

public interface IMaExpSerialService {
  public MaExpSerial getMaExpSerial(Map params);
  
  public void insertMaExpSerial(MaExpSerial serial);
  
  public void updateMaExpSerial(MaExpSerial serial);
}

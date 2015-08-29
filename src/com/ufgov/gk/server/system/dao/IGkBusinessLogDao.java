package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.GkBusinessLog;

public interface IGkBusinessLogDao {

  void saveGkBusinessLog(GkBusinessLog log);

  void saveGkBusinessLog(List logList);

  List getGkBusinessLog(BaseBill bill);

  List getGkBusinessLog(String billid,String tabname);

}

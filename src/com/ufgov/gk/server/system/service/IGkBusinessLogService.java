package com.ufgov.gk.server.system.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.model.GkBusinessLog;

public interface IGkBusinessLogService {

  void saveGkBusinessLog(GkBusinessLog log);

  void saveGkBusinessLog(List logList);

  List getGkBusinessLog(BaseBill bill);

  List getGkBusinessLog(String billid,String tabname);

}

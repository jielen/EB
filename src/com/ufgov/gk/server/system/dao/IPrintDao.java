package com.ufgov.gk.server.system.dao;

import java.util.List;

import com.ufgov.gk.common.system.model.PrintSetting;
import com.ufgov.gk.common.system.model.PrintTemplate;

public interface IPrintDao {

  List getCurrentPrintTemplate();

  PrintTemplate getCurrentPrintTemplateByCode(String templateCode);

  PrintSetting getCurrentPrintSetting();

  void savePrintSetting(PrintSetting printSetting);
  
  List getRareWord();

}

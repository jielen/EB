package com.ufgov.gk.server.commonbiz.service;

import java.util.List;

import com.ufgov.gk.common.commonbiz.model.BaseBill;
import com.ufgov.gk.common.system.dto.PrintObject;
import com.ufgov.gk.common.system.model.PrintSetting;

public interface IPrintService {

  public List getCurrentPrintTemplate();

  public PrintSetting getCurrentPrintSetting();

  public void savePrintSetting(PrintSetting printSetting);

  public PrintObject genMainBillPrintObject(BaseBill bill);

  public PrintObject genMainBillPrintObject(List billList);

  public PrintObject genMainBillPrintObject(BaseBill bill, String templateCode);

  public PrintObject genMainBillPrintObject(List billList, String templateCode);

  public  PrintObject genMainSubPrintObject(List billList);
}

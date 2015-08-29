package com.ufgov.gk.server.commonbiz.service;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BillElement;

public interface IBillElementService {
  Map getBillElement(int nd, String billTypeCode);

  List getDecBillElementList(int nd, String billTypeCode);

  List getAllDecBillElementList(int nd, String billTypeCode);

  List getDownDisplayBillElementList(int nd, String billTypeCode, String displayType);

  public void updateIncludeForBillElement(BillElement billElement);

  public void updateBillElementGroupInfo(BillElement billElement);

  public void updateBillElementForBb(List list);

  public Map getWfCanEditField(Long proInstId);
}

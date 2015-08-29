package com.ufgov.gk.server.commonbiz.dao;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BillElement;

public interface IBillElementDao {

  Map getBillElement(int nd, String billTypeCode);

  Map getDecBillElement(int nd, String billTypeCode);

  List getDecBillElementList(int nd, String billTypeCode);

  List getAllDecBillElementList(int nd, String billTypeCode);

  List getDownDisplayBillElementList(int nd, String billTypeCode, String displayFieldType);

  public void updateIncludeForBillElement(BillElement billElement);

  public void updateBillElementGroupInfo(BillElement billElement);

  public void updateBillElementForBb(List list);

  Map getWfCanEditField(Long proInstId);
  
  Map getBillIncludeElement(int nd, String billTypeCode);
}
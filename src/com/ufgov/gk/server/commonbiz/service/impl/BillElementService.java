package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.server.commonbiz.dao.IBillElementDao;
import com.ufgov.gk.server.commonbiz.service.IBillElementService;

public class BillElementService implements IBillElementService {

  private IBillElementDao billElementDao;

  public IBillElementDao getBillElementDao() {
    return billElementDao;
  }

  public void setBillElementDao(IBillElementDao billElementDao) {
    this.billElementDao = billElementDao;
  }

  public Map getBillElement(int nd, String billTypeCode) {

    return billElementDao.getBillElement(nd, billTypeCode);
  }

  public List getDownDisplayBillElementList(int nd, String billTypeCode, String displayType) {
    return billElementDao.getDownDisplayBillElementList(nd, billTypeCode, displayType);
  }

  public List getDecBillElementList(int nd, String billTypeCode) {
    return billElementDao.getDecBillElementList(nd, billTypeCode);
  }

  public List getAllDecBillElementList(int nd, String billTypeCode){
    return billElementDao.getAllDecBillElementList(nd, billTypeCode);
  }

  public void updateIncludeForBillElement(BillElement billElement) {
    billElementDao.updateIncludeForBillElement(billElement);
  }

  public void updateBillElementGroupInfo(BillElement billElement) {
    billElementDao.updateBillElementGroupInfo(billElement);
  }

  public void updateBillElementForBb(List list) {
    billElementDao.updateBillElementForBb(list);
  }

  public Map getWfCanEditField(Long proInstId) {
    return billElementDao.getWfCanEditField(proInstId);
  }

}

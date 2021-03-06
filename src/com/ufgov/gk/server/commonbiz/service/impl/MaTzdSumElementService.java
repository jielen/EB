package com.ufgov.gk.server.commonbiz.service.impl;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.common.commonbiz.model.MaTzdSumElement;
import com.ufgov.gk.server.commonbiz.dao.IMaTzdSumElementDao;
import com.ufgov.gk.server.commonbiz.service.IMaTzdSumElementService;

public class MaTzdSumElementService implements IMaTzdSumElementService {
  private IMaTzdSumElementDao maTzdSumElementDao;

  public IMaTzdSumElementDao getMaTzdSumElementDao() {
    return maTzdSumElementDao;
  }

  public void setMaTzdSumElementDao(IMaTzdSumElementDao maTzdSumElementDao) {
    this.maTzdSumElementDao = maTzdSumElementDao;
  }

  public MaTzdSumElement getMaTzdSumElement(int nd, String billTypeCode, String elementCode) {
    return maTzdSumElementDao.getMaTzdSumElement(nd, billTypeCode, elementCode);
  }

  public List getMaTzdSumElement(int nd, String billTypeCode) {
    return maTzdSumElementDao.getMaTzdSumElement(nd, billTypeCode);
  }
  
  public List getMaUserTzdSumElement(int nd, String billTypeCode,String userId) {
    return maTzdSumElementDao.getMaUserTzdSumElement(nd, billTypeCode, userId);
  }

  public Map getMaTzdSumElementMap(int nd, String billTypeCode, String userId) {
    return maTzdSumElementDao.getMaTzdSumElementMap(nd, billTypeCode, userId);
  }

  public void updateMaTzdSumElement(MaTzdSumElement maTzdSumElement) {
    maTzdSumElementDao.updateMaTzdSumElement(maTzdSumElement);
  }

  public void updateMaTzdSum(MaTzdSumElement maTzdSumElement) {
    maTzdSumElementDao.updateMaTzdSum(maTzdSumElement);
  }

  public void updateMaTzdSumElements(List maTzdSumElementList) {
    maTzdSumElementDao.updateMaTzdSumElements(maTzdSumElementList);
  }
  
  public void updateMaUserTzdSumElements(List maTzdSumElementList){
    maTzdSumElementDao.updateMaUserTzdSumElements(maTzdSumElementList);
  }

}

package com.ufgov.gk.server.system.service.impl;

import java.util.List;
import java.util.Map;

import com.ufgov.gk.server.system.dao.ILangTransDao;
import com.ufgov.gk.server.system.service.ILangTransService;

public class LangTransService implements ILangTransService {
  private ILangTransDao langTransDao;

  public ILangTransDao getLangTransDao() {
    return langTransDao;
  }

  public void setLangTransDao(ILangTransDao langTransDao) {
    this.langTransDao = langTransDao;
  }

  public Map getLangTrans(String resId) {
    return langTransDao.getLangTrans(resId);
  }

  public List getAsLangTrans(String resId) {
    return langTransDao.getAsLangTrans(resId);
  }

  public void updateAslangTrans(List langTranList) {
    langTransDao.updateAslangTrans(langTranList);
  }

}

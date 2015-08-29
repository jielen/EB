package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.model.EbAppAccountExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbAppAccountDAO;
import com.ufgov.gk.server.ebay.service.IEbAppAccountService;

public class EbAppAccountService implements IEbAppAccountService {
  private EbAppAccountDAO ebAppAccountDao;

  @Override
  public List getEbAppAccount(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbAppAccountExample example = new EbAppAccountExample();
    return this.ebAppAccountDao.selectByExample(example);
  }

  @Override
  public void saveEbAppAccount(EbAppAccount account, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebAppAccountDao.insert(account);
    } else {
      this.ebAppAccountDao.updateByPrimaryKey(account);
    }
  }

  @Override
  public int deleteEbAppAccount(EbAppAccount account, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppAccountDao.deleteByPrimaryKey(account.getAppAccount());
  }

  @Override
  public EbAppAccount getEbAppAccountByID(String appAccount, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppAccountDao.selectByPrimaryKey(appAccount);
  }

  public EbAppAccountDAO getEbAppAccountDao() {
    return ebAppAccountDao;
  }

  public void setEbAppAccountDao(EbAppAccountDAO ebAppAccountDao) {
    this.ebAppAccountDao = ebAppAccountDao;
  }

}

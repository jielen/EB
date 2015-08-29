package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.ebay.model.EbCurrencyExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbCurrencyDAO;
import com.ufgov.gk.server.ebay.service.IEbCurrencyService;

public class EbCurrencyService implements IEbCurrencyService {

  private EbCurrencyDAO ebCurrencyDao;

  @Override
  public List getEbCurrency(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbCurrencyExample example = new EbCurrencyExample();
    return this.ebCurrencyDao.selectByExample(example);
  }

  @Override
  public void saveEbCurrency(EbCurrency currency, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub

    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebCurrencyDao.insert(currency);
    } else {
      this.ebCurrencyDao.updateByPrimaryKey(currency);
    }
  }

  @Override
  public int deleteEbCurrency(EbCurrency currency, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCurrencyDao.deleteByPrimaryKey(currency.getCurrencyId());
  }

  @Override
  public EbCurrency getebCurrencyByID(String currencyId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCurrencyDao.selectByPrimaryKey(currencyId);
  }

  public EbCurrencyDAO getEbCurrencyDao() {
    return ebCurrencyDao;
  }

  public void setEbCurrencyDao(EbCurrencyDAO ebCurrencyDao) {
    this.ebCurrencyDao = ebCurrencyDao;
  }

}

package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.ebay.dao.EbItemCheckedDAO;
import com.ufgov.gk.server.ebay.service.IEbItemCheckedService;

public class EbItemCheckedService implements IEbItemCheckedService {

  private EbItemCheckedDAO itemCheckedDao;

  @Override
  public List<EbItemChecked> getEbItemChecked(EbItemCheckedExample ex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.itemCheckedDao.selectByExample(ex);
  }

  public EbItemCheckedDAO getItemCheckedDao() {
    return itemCheckedDao;
  }

  public void setItemCheckedDao(EbItemCheckedDAO itemCheckedDao) {
    this.itemCheckedDao = itemCheckedDao;
  }

  public void saveEbItemCheckeds(List<EbItemChecked> itemLst, RequestMeta requestMeta) {
    this.itemCheckedDao.saveEbItemCheckeds(itemLst);
  }

  @Override
  public void deleteEbItemCheckeds(List<String> itemIds, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbItemCheckedExample ex = new EbItemCheckedExample();
    ex.createCriteria().andItemIdIn(itemIds);
    this.itemCheckedDao.deleteByExample(ex);
  }
}

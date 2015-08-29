package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbItemGroup;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbItemDAO;
import com.ufgov.gk.server.ebay.service.IEbItemService;

public class EbItemService implements IEbItemService {

  private EbItemDAO ebItemDao;

  @Override
  public List getEbItem(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbItemExample example = new EbItemExample();
    return this.ebItemDao.selectByExample(example);
  }

  @Override
  public void saveEbItem(EbItem item, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub

    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebItemDao.insert(item);
    } else {
      this.ebItemDao.updateByPrimaryKey(item);
    }
  }

  @Override
  public int deleteEbItem(EbItem item, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemDao.deleteByPrimaryKey(item.getItemId());
  }

  @Override
  public EbItem getEbItemByID(String itemId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemDao.selectByPrimaryKey(itemId);
  }

  public EbItemDAO getEbItemDao() {
    return ebItemDao;
  }

  public void setEbItemDao(EbItemDAO ebItemDao) {
    this.ebItemDao = ebItemDao;
  }

  @Override
  public List getEbItem(EbItemExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemDao.selectByExample(example);
  }

  @Override
  public void saveEbItems(List<EbItem> ebItemLst, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemDao.saveEbItems(ebItemLst);
  }

  @Override
  public void deleteEbItems(EbItemExample ebItemExample, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemDao.deleteByExample(ebItemExample);
  }

  @Override
  public List<EbItemGroup> getEbItemGroup(EbItemExample emex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemDao.getEbItemGroup(emex);
  }

}

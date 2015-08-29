package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRefExample2;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.server.ebay.dao.EbCandidateItemDAO;
import com.ufgov.gk.server.ebay.dao.EbCandidateItemRefDAO;
import com.ufgov.gk.server.ebay.service.IEbCandidateItemService;

public class EbCandidateItemService implements IEbCandidateItemService {
  private EbCandidateItemDAO ebCandidateItemDAO;

  private EbCandidateItemRefDAO ebCandidateItemRefDAO;

  @Override
  public List getEbCandidateItem(EbCandidateItemExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return ebCandidateItemDAO.selectByExample(example);
  }

  public EbCandidateItemDAO getEbCandidateItemDAO() {
    return ebCandidateItemDAO;
  }

  public void setEbCandidateItemDAO(EbCandidateItemDAO ebCandidateItemDAO) {
    this.ebCandidateItemDAO = ebCandidateItemDAO;
  }

  @Override
  public void saveEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub

    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebCandidateItemDAO.insert(ebCandidateItem);
    } else {
      this.ebCandidateItemDAO.updateByPrimaryKey(ebCandidateItem);
    }
    EbCandidateItemRefExample2 ex = new EbCandidateItemRefExample2();
    ex.createCriteria().andCandidateIdEqualTo(ebCandidateItem.getCandidateId());
    this.ebCandidateItemRefDAO.deleteByExample(ex);
    this.ebCandidateItemRefDAO.saveRefs(ebCandidateItem.getCandidateItemRefLst());
  }

  @Override
  public int deleteEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbCandidateItemRefExample2 ex = new EbCandidateItemRefExample2();
    ex.createCriteria().andCandidateIdEqualTo(ebCandidateItem.getCandidateId());
    this.ebCandidateItemRefDAO.deleteByExample(ex);
    return this.ebCandidateItemDAO.deleteByPrimaryKey(ebCandidateItem.getCandidateId());
  }

  @Override
  public EbCandidateItem getebCandidateItemByID(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemDAO.selectByPrimaryKey(candidateId);
  }

  @Override
  public EbCandidateItem getEbCandidateItemByRefItemId(String itemId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemDAO.getEbCandidateItemByRefItemId(itemId);
  }

  public EbCandidateItemRefDAO getEbCandidateItemRefDAO() {
    return ebCandidateItemRefDAO;
  }

  public void setEbCandidateItemRefDAO(EbCandidateItemRefDAO ebCandidateItemRefDAO) {
    this.ebCandidateItemRefDAO = ebCandidateItemRefDAO;
  }

}

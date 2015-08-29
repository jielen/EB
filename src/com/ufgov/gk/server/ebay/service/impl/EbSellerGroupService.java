package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.model.EbSellerGroupExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbSellerDAO;
import com.ufgov.gk.server.ebay.dao.EbSellerGroupDAO;
import com.ufgov.gk.server.ebay.service.IEbSellerGroupService;

public class EbSellerGroupService implements IEbSellerGroupService {

  private EbSellerGroupDAO ebSellerGroupDao;

  private EbSellerDAO ebSellerDao;

  @Override
  public List getEbSellerGroup(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbSellerGroupExample example = new EbSellerGroupExample();
    List<EbSellerGroup> groupLst = this.ebSellerGroupDao.selectByExample(example);
    for (EbSellerGroup ebSellerGroup : groupLst) {
      EbSellerExample ebEx = new EbSellerExample();
      ebEx.createCriteria().andGroupIdEqualTo(ebSellerGroup.getGroupId());
      ebSellerGroup.setSellerLst(this.ebSellerDao.selectByExample(ebEx));
    }
    return groupLst;
  }

  @Override
  public void saveEbSellGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebSellerGroupDao.insert(sellerGroup);
    } else {
      this.ebSellerGroupDao.updateByPrimaryKeySelective(sellerGroup);
    }
    if (sellerGroup.getSellerLst() != null) {
      for (EbSeller seller : sellerGroup.getSellerLst()) {
        this.ebSellerDao.updateByPrimaryKeySelective(seller);
      }
    }
  }

  @Override
  public int deleteEbSellerGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerGroupDao.deleteByPrimaryKey(sellerGroup.getGroupId());
  }

  @Override
  public EbSellerGroup getebSellerGroupByID(String groupId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerGroupDao.selectByPrimaryKey(groupId);
  }

  public EbSellerGroupDAO getEbSellerGroupDao() {
    return ebSellerGroupDao;
  }

  public void setEbSellerGroupDao(EbSellerGroupDAO ebSellerGroupDao) {
    this.ebSellerGroupDao = ebSellerGroupDao;
  }

  public EbSellerDAO getEbSellerDao() {
    return ebSellerDao;
  }

  public void setEbSellerDao(EbSellerDAO ebSellerDao) {
    this.ebSellerDao = ebSellerDao;
  }

}

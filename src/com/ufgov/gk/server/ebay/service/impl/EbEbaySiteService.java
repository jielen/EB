package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSite;
import com.ufgov.gk.common.ebay.model.EbSiteExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbSiteDAO;
import com.ufgov.gk.server.ebay.service.IEbEbaySiteService;

public class EbEbaySiteService implements IEbEbaySiteService {
  private EbSiteDAO ebaySiteDao;

  @Override
  public List getEbSite(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbSiteExample example = new EbSiteExample();
    return getEbaySiteDao().selectByExample(example);
  }

  public EbSiteDAO getEbaySiteDao() {
    return ebaySiteDao;
  }

  public void setEbaySiteDao(EbSiteDAO ebaySiteDao) {
    this.ebaySiteDao = ebaySiteDao;
  }

  @Override
  public EbSite getebSiteByID(String siteId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return ebaySiteDao.selectByPrimaryKey(siteId);
  }

  @Override
  public int deleteEbSite(EbSite site, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbSiteExample example = new EbSiteExample();
    example.createCriteria().andSiteIdEqualTo(site.getSiteId());
    return ebaySiteDao.deleteByExample(example);
  }

  @Override
  public void saveEbSite(EbSite site, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebaySiteDao.insert(site);
    } else {
      this.ebaySiteDao.updateByPrimaryKey(site);
    }
  }

}

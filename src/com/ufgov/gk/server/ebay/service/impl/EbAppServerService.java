package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.ebay.model.EbAppServerExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbAppServerDAO;
import com.ufgov.gk.server.ebay.service.IEbAppServerService;

public class EbAppServerService implements IEbAppServerService {

  private EbAppServerDAO ebAppServerDao;

  @Override
  public void saveEbAppServer(EbAppServer server, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebAppServerDao.insert(server);
    } else {
      this.ebAppServerDao.updateByPrimaryKey(server);
    }
  }

  @Override
  public int deleteEbAppServer(EbAppServer server, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbAppServerExample example = new EbAppServerExample();
    example.createCriteria().andSiteIdEqualTo(server.getSiteId());
    return ebAppServerDao.deleteByExample(example);
  }

  @Override
  public EbAppServer getEbAppServerByID(String siteId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppServerDao.selectByPrimaryKey(siteId);
  }

  public EbAppServerDAO getEbAppServerDao() {
    return ebAppServerDao;
  }

  public void setEbAppServerDao(EbAppServerDAO ebAppServerDao) {
    this.ebAppServerDao = ebAppServerDao;
  }

  @Override
  public List getEbAppServer(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbAppServerExample example = new EbAppServerExample();
    return this.ebAppServerDao.selectByExample(example);
  }

}

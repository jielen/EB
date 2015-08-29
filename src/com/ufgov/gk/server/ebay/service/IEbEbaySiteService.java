package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbSite;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbEbaySiteService {

  public List getEbSite(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  public EbSite getebSiteByID(String siteId, RequestMeta requestMeta);

  public int deleteEbSite(EbSite site, RequestMeta requestMeta);

  public void saveEbSite(EbSite site, RequestMeta requestMeta, String pageStatus);
}

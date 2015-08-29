package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbAppServerService {

  public void saveEbAppServer(EbAppServer server, RequestMeta requestMeta, String pageStatus);

  public int deleteEbAppServer(EbAppServer server, RequestMeta requestMeta);

  public EbAppServer getEbAppServerByID(String siteId, RequestMeta requestMeta);

  public List getEbAppServer(ElementConditionDto elementConditionDto, RequestMeta requestMeta);
}

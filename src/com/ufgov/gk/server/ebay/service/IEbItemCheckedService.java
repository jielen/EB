package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.system.RequestMeta;

public interface IEbItemCheckedService {

  List<EbItemChecked> getEbItemChecked(EbItemCheckedExample ex, RequestMeta requestMeta);

  public void saveEbItemCheckeds(List<EbItemChecked> itemLst, RequestMeta requestMeta);

  void deleteEbItemCheckeds(List<String> itemIds, RequestMeta requestMeta);

}

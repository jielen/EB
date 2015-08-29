package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbItemGroup;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbItemService {

  List getEbItem(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  List getEbItem(EbItemExample example, RequestMeta requestMeta);

  void saveEbItem(EbItem item, RequestMeta requestMeta, String pageStatus);

  int deleteEbItem(EbItem item, RequestMeta requestMeta);

  EbItem getEbItemByID(String itemId, RequestMeta requestMeta);

  void saveEbItems(List<EbItem> ebItemLst, RequestMeta requestMeta);

  void deleteEbItems(EbItemExample ebItemExample, RequestMeta requestMeta);

  List<EbItemGroup> getEbItemGroup(EbItemExample emex, RequestMeta requestMeta);

}

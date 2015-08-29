package com.ufgov.gk.server.ebay.service;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCategory;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;

public interface IEbCategoryService {

  List getEbCategory(ElementConditionDto elementConditionDto, RequestMeta requestMeta);

  void saveEbCategory(EbCategory server, RequestMeta requestMeta, String pageStatus);

  int deleteEbCategory(EbCategory server, RequestMeta requestMeta);

  EbCategory getEbCategoryByID(String categoryId, RequestMeta requestMeta);

}

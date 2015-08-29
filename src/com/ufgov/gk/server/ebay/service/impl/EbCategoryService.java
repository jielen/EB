package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbCategory;
import com.ufgov.gk.common.ebay.model.EbCategoryExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.dao.EbCategoryDAO;
import com.ufgov.gk.server.ebay.service.IEbCategoryService;

public class EbCategoryService implements IEbCategoryService {
  private EbCategoryDAO ebCategoryDao;

  @Override
  public List getEbCategory(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    EbCategoryExample example = new EbCategoryExample();
    return this.ebCategoryDao.selectByExample(example);
  }

  @Override
  public void saveEbCategory(EbCategory category, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub

    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebCategoryDao.insert(category);
    } else {
      this.ebCategoryDao.updateByPrimaryKey(category);
    }
  }

  @Override
  public int deleteEbCategory(EbCategory category, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCategoryDao.deleteByPrimaryKey(category.getCategoryId());
  }

  @Override
  public EbCategory getEbCategoryByID(String categoryId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCategoryDao.selectByPrimaryKey(categoryId);
  }

  public EbCategoryDAO getEbCategoryDao() {
    return ebCategoryDao;
  }

  public void setEbCategoryDao(EbCategoryDAO ebCategoryDao) {
    this.ebCategoryDao = ebCategoryDao;
  }

}

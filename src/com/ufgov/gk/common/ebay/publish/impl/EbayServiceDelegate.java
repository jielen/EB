package com.ufgov.gk.common.ebay.publish.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.model.EbAppServer;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRefExample;
import com.ufgov.gk.common.ebay.model.EbCategory;
import com.ufgov.gk.common.ebay.model.EbCurrency;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbItemGroup;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.model.EbSite;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.server.ebay.service.IEbAppAccountService;
import com.ufgov.gk.server.ebay.service.IEbAppServerService;
import com.ufgov.gk.server.ebay.service.IEbCandidateItemRefService;
import com.ufgov.gk.server.ebay.service.IEbCandidateItemService;
import com.ufgov.gk.server.ebay.service.IEbCategoryService;
import com.ufgov.gk.server.ebay.service.IEbCurrencyService;
import com.ufgov.gk.server.ebay.service.IEbEbaySiteService;
import com.ufgov.gk.server.ebay.service.IEbItemCheckedService;
import com.ufgov.gk.server.ebay.service.IEbItemService;
import com.ufgov.gk.server.ebay.service.IEbSellerGroupService;
import com.ufgov.gk.server.ebay.service.IEbSellerService;

public class EbayServiceDelegate implements IEbayServiceDelegate {
  private IEbEbaySiteService ebaySiteService;

  private IEbAppServerService ebAppServerService;

  private IEbAppAccountService ebAppAccountService;

  private IEbCategoryService ebCategoryService;

  private IEbSellerGroupService ebSellerGroupService;

  private IEbCurrencyService ebCurrencyService;

  private IEbSellerService ebSellerService;

  private IEbItemService ebItemService;

  private IEbCandidateItemService ebCandidateItemService;

  private IEbCandidateItemRefService ebCandidateItemRefService;

  private IEbItemCheckedService ebItemCheckedService;

  @Override
  public List getEbSite(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return ebaySiteService.getEbSite(elementConditionDto, requestMeta);
  }

  public IEbAppServerService getEbAppServerService() {
    return ebAppServerService;
  }

  public void setEbAppServerService(IEbAppServerService ebAppServerService) {
    this.ebAppServerService = ebAppServerService;
  }

  public IEbEbaySiteService getEbaySiteService() {
    return ebaySiteService;
  }

  public void setEbaySiteService(IEbEbaySiteService ebaySiteService) {
    this.ebaySiteService = ebaySiteService;
  }

  @Override
  public EbSite getebSiteByID(String siteId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebaySiteService.getebSiteByID(siteId, requestMeta);
  }

  @Override
  public int deleteEbSite(EbSite site, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebaySiteService.deleteEbSite(site, requestMeta);
  }

  @Override
  public void saveEbSite(EbSite site, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebaySiteService.saveEbSite(site, requestMeta, pageStatus);
  }

  @Override
  public void saveEbAppServer(EbAppServer server, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebAppServerService.saveEbAppServer(server, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbAppServer(EbAppServer server, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppServerService.deleteEbAppServer(server, requestMeta);
  }

  @Override
  public EbAppServer getEbAppServerByID(String siteId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppServerService.getEbAppServerByID(siteId, requestMeta);
  }

  @Override
  public List getEbAppServer(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppServerService.getEbAppServer(elementConditionDto, requestMeta);
  }

  @Override
  public List getEbAppAccount(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppAccountService.getEbAppAccount(elementConditionDto, requestMeta);
  }

  @Override
  public void saveEbAppAccount(EbAppAccount account, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebAppAccountService.saveEbAppAccount(account, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbAppAccount(EbAppAccount account, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppAccountService.deleteEbAppAccount(account, requestMeta);
  }

  @Override
  public EbAppAccount getEbAppAccountByID(String appAccount, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebAppAccountService.getEbAppAccountByID(appAccount, requestMeta);
  }

  public IEbAppAccountService getEbAppAccountService() {
    return ebAppAccountService;
  }

  public void setEbAppAccountService(IEbAppAccountService ebAppAccountService) {
    this.ebAppAccountService = ebAppAccountService;
  }

  @Override
  public List getEbCategory(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCategoryService.getEbCategory(elementConditionDto, requestMeta);
  }

  @Override
  public void saveEbCategory(EbCategory server, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebCategoryService.saveEbCategory(server, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbCategory(EbCategory server, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCategoryService.deleteEbCategory(server, requestMeta);
  }

  @Override
  public EbCategory getEbCategoryByID(String categoryId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCategoryService.getEbCategoryByID(categoryId, requestMeta);
  }

  public IEbCategoryService getEbCategoryService() {
    return ebCategoryService;
  }

  public void setEbCategoryService(IEbCategoryService ebCategoryService) {
    this.ebCategoryService = ebCategoryService;
  }

  @Override
  public List getEbSellerGroup(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerGroupService.getEbSellerGroup(elementConditionDto, requestMeta);
  }

  @Override
  public void saveEbSellGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebSellerGroupService.saveEbSellGroup(sellerGroup, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbSellerGroup(EbSellerGroup sellerGroup, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerGroupService.deleteEbSellerGroup(sellerGroup, requestMeta);
  }

  @Override
  public EbSellerGroup getebSellerGroupByID(String groupId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerGroupService.getebSellerGroupByID(groupId, requestMeta);
  }

  public IEbSellerGroupService getEbSellerGroupService() {
    return ebSellerGroupService;
  }

  public void setEbSellerGroupService(IEbSellerGroupService ebSellerGroupService) {
    this.ebSellerGroupService = ebSellerGroupService;
  }

  @Override
  public List getEbCurrency(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCurrencyService.getEbCurrency(elementConditionDto, requestMeta);
  }

  @Override
  public void saveEbCurrency(EbCurrency currency, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebCurrencyService.saveEbCurrency(currency, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbCurrency(EbCurrency currency, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCurrencyService.deleteEbCurrency(currency, requestMeta);
  }

  @Override
  public EbCurrency getebCurrencyByID(String currencyId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCurrencyService.getebCurrencyByID(currencyId, requestMeta);
  }

  public IEbCurrencyService getEbCurrencyService() {
    return ebCurrencyService;
  }

  public void setEbCurrencyService(IEbCurrencyService ebCurrencyService) {
    this.ebCurrencyService = ebCurrencyService;
  }

  @Override
  public void saveEbSeller(EbSeller seller, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebSellerService.saveEbSeller(seller, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbSeller(EbSeller seller, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerService.deleteEbSeller(seller, requestMeta);
  }

  @Override
  public EbSeller getEbSellerByID(String sellerId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerService.getEbSellerByID(sellerId, requestMeta);
  }

  @Override
  public List getEbSeller(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerService.getEbSeller(elementConditionDto, requestMeta);
  }

  public IEbSellerService getEbSellerService() {
    return ebSellerService;
  }

  public void setEbSellerService(IEbSellerService ebSellerService) {
    this.ebSellerService = ebSellerService;
  }

  @Override
  public List getEbItem(ElementConditionDto elementConditionDto, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemService.getEbItem(elementConditionDto, requestMeta);
  }

  @Override
  public List getEbItem(EbItemExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemService.getEbItem(example, requestMeta);
  }

  @Override
  public void saveEbItem(EbItem item, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebItemService.saveEbItem(item, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbItem(EbItem item, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemService.deleteEbItem(item, requestMeta);
  }

  @Override
  public EbItem getEbItemByID(String itemId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemService.getEbItemByID(itemId, requestMeta);
  }

  public IEbItemService getEbItemService() {
    return ebItemService;
  }

  public void setEbItemService(IEbItemService ebItemService) {
    this.ebItemService = ebItemService;
  }

  @Override
  public List getEbCandidateItem(EbCandidateItemExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemService.getEbCandidateItem(example, requestMeta);
  }

  public IEbCandidateItemService getEbCandidateItemService() {
    return ebCandidateItemService;
  }

  public void setEbCandidateItemService(IEbCandidateItemService ebCandidateItemService) {
    this.ebCandidateItemService = ebCandidateItemService;
  }

  @Override
  public void saveEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebCandidateItemService.saveEbCandidateItem(ebCandidateItem, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbCandidateItem(EbCandidateItem ebCandidateItem, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemService.deleteEbCandidateItem(ebCandidateItem, requestMeta);
  }

  @Override
  public EbCandidateItem getEbCandidateItemByID(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemService.getebCandidateItemByID(candidateId, requestMeta);
  }

  @Override
  public List<EbItemGroup> getEbItemGroup(EbItemExample emex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemService.getEbItemGroup(emex, requestMeta);
  }

  @Override
  public List<EbCandidateItemRef> getEbCandidateItemRef(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefService.getEbCandidateItemRef(candidateId, requestMeta);
  }

  public IEbCandidateItemRefService getEbCandidateItemRefService() {
    return ebCandidateItemRefService;
  }

  public void setEbCandidateItemRefService(IEbCandidateItemRefService ebCandidateItemRefService) {
    this.ebCandidateItemRefService = ebCandidateItemRefService;
  }

  @Override
  public List<EbCandidateItemRef> getEbCandidateItemRef(EbCandidateItemRefExample example, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefService.getEbCandidateItemRef(example, requestMeta);
  }

  @Override
  public EbCandidateItem getEbCandidateItemByRefItemId(String itemId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemService.getEbCandidateItemByRefItemId(itemId, requestMeta);
  }

  @Override
  public List<EbCandidateItemRef2> getEbCandidateItemRef2(String candidateId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefService.getEbCandidateItemRef2(candidateId, requestMeta);
  }

  @Override
  public List<EbItemChecked> getEbItemChecked(EbItemCheckedExample ex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebItemCheckedService.getEbItemChecked(ex, requestMeta);
  }

  public IEbItemCheckedService getEbItemCheckedService() {
    return ebItemCheckedService;
  }

  public void setEbItemCheckedService(IEbItemCheckedService ebItemCheckedService) {
    this.ebItemCheckedService = ebItemCheckedService;
  }

  @Override
  public void saveEbItemCheckeds(List<EbItemChecked> itemLst, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemCheckedService.saveEbItemCheckeds(itemLst, requestMeta);
  }

  @Override
  public void deleteEbItemCheckeds(List<String> itemIds, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemCheckedService.deleteEbItemCheckeds(itemIds, requestMeta);
  }

  @Override
  public List<EbSeller> getEbSeller(EbSellerExample ex, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerService.getEbSeller(ex, requestMeta);
  }

  @Override
  public List<EbCandidateItemRef2> getEbCandidateItemRef2BySeller(String sellerId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebCandidateItemRefService.getEbCandidateItemRef2BySeller(sellerId, requestMeta);
  }

}

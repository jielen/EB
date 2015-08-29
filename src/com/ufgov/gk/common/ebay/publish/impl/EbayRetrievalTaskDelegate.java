package com.ufgov.gk.common.ebay.publish.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.publish.IEbayRetrievalTaskDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.server.ebay.service.IEbItemService;
import com.ufgov.gk.server.ebay.service.IEbRetrievalTaskService;
import com.ufgov.gk.server.ebay.service.IEbSellerService;

public class EbayRetrievalTaskDelegate implements IEbayRetrievalTaskDelegate {

  private IEbRetrievalTaskService ebRetrievalTaskService;

  private IEbItemService ebItemService;

  private IEbSellerService ebSellerService;

  @Override
  public List<EbRetrievalTask> getRetrievalTask(EbRetrievalTaskExample ebRetrievalTaskExample, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return ebRetrievalTaskService.getRetrievalTask(ebRetrievalTaskExample, requestMeta);
  }

  @Override
  public void saveEbRetrievalTask(EbRetrievalTask currentTask, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    ebRetrievalTaskService.saveEbRetrievalTask(currentTask, requestMeta, pageStatus);
  }

  @Override
  public int deleteEbRetrievalTask(EbRetrievalTask task, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return ebRetrievalTaskService.deleteEbRetrievalTask(task, requestMeta);
  }

  public IEbRetrievalTaskService getEbRetrievalTaskService() {
    return ebRetrievalTaskService;
  }

  public void setEbRetrievalTaskService(IEbRetrievalTaskService ebRetrievalTaskService) {
    this.ebRetrievalTaskService = ebRetrievalTaskService;
  }

  public IEbItemService getEbItemService() {
    return ebItemService;
  }

  public void setEbItemService(IEbItemService ebItemService) {
    this.ebItemService = ebItemService;
  }

  public IEbSellerService getEbSellerService() {
    return ebSellerService;
  }

  public void setEbSellerService(IEbSellerService ebSellerService) {
    this.ebSellerService = ebSellerService;
  }

  @Override
  public void saveEbItems(List<EbItem> ebItemLst, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemService.saveEbItems(ebItemLst, requestMeta);
  }

  @Override
  public void saveTaskAndItems(EbRetrievalTask task, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebRetrievalTaskService.saveTaskAndItems(task, requestMeta);
  }

  @Override
  public void deleteEbItems(EbItemExample ebItemExample, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebItemService.deleteEbItems(ebItemExample, requestMeta);
  }

  @Override
  public void updateEbSeller(EbSeller seller, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebSellerService.updateEbSeller(seller, requestMeta);
  }

  @Override
  public EbSeller getEbSellerBySellerId(String sellerId, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    return this.ebSellerService.getEbSellerByID(sellerId, requestMeta);
  }

  @Override
  public void saveEbSeller(EbSeller ebSeller, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub
    this.ebSellerService.saveEbSeller(ebSeller, requestMeta, pageStatus);
  }

@Override
public boolean changeSellerIdFN(String sellerId, String newSellerId,RequestMeta requestMeta) {
	// TODO Auto-generated method stub
	return ebSellerService.changeSellerIdFN(sellerId, newSellerId,requestMeta);
}

}

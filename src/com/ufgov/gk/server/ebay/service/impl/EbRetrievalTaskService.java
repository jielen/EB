package com.ufgov.gk.server.ebay.service.impl;

import java.util.List;

import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.server.ebay.dao.EbCandidateItemDAO;
import com.ufgov.gk.server.ebay.dao.EbCandidateItemRefDAO;
import com.ufgov.gk.server.ebay.dao.EbItemCheckedDAO;
import com.ufgov.gk.server.ebay.dao.EbItemDAO;
import com.ufgov.gk.server.ebay.dao.EbRetrievalTaskDAO;
import com.ufgov.gk.server.ebay.dao.EbSellerDAO;
import com.ufgov.gk.server.ebay.service.IEbRetrievalTaskService;

public class EbRetrievalTaskService implements IEbRetrievalTaskService {

  private EbRetrievalTaskDAO ebRetrievalTaskDao;

  private EbItemDAO ebItemDao;

  private EbSellerDAO ebSellerDao;

  private EbItemCheckedDAO ebItemCheckedDao;

  private EbCandidateItemDAO ebCandidateItemDao;

  private EbCandidateItemRefDAO ebCandidateItemRefDAO;

  public EbItemCheckedDAO getEbItemCheckedDao() {
    return ebItemCheckedDao;
  }

  public void setEbItemCheckedDao(EbItemCheckedDAO ebItemCheckedDao) {
    this.ebItemCheckedDao = ebItemCheckedDao;
  }

  public EbCandidateItemDAO getEbCandidateItemDao() {
    return ebCandidateItemDao;
  }

  public void setEbCandidateItemDao(EbCandidateItemDAO ebCandidateItemDao) {
    this.ebCandidateItemDao = ebCandidateItemDao;
  }

  public EbCandidateItemRefDAO getEbCandidateItemRefDAO() {
    return ebCandidateItemRefDAO;
  }

  public void setEbCandidateItemRefDAO(EbCandidateItemRefDAO ebCandidateItemRefDAO) {
    this.ebCandidateItemRefDAO = ebCandidateItemRefDAO;
  }

  public EbSellerDAO getEbSellerDao() {
    return ebSellerDao;
  }

  public void setEbSellerDao(EbSellerDAO ebSellerDao) {
    this.ebSellerDao = ebSellerDao;
  }

  @Override
  public List<EbRetrievalTask> getRetrievalTask(EbRetrievalTaskExample ebRetrievalTaskExample, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    System.out.println(ebRetrievalTaskExample.getOrderByClause());
    List<EbRetrievalTask> tasks = this.ebRetrievalTaskDao.selectByExample(ebRetrievalTaskExample);
    //    for (EbRetrievalTask retrievalTask : tasks) {
    //      EbSeller seller = this.ebSellerDao.selectByPrimaryKey(retrievalTask.getSellerId());
    //      if (seller != null) {
    //        retrievalTask.setGroupId(seller.getGroupId());
    //      }
    //    }
    //注释，延后加载item数据，太多了。
    //    if (tasks != null && tasks.size() > 0) {
    //      for (EbRetrievalTask ebRetrievalTask : tasks) {
    //        EbItemExample itemExample = new EbItemExample();
    //        itemExample.createCriteria().andSellerIdEqualTo(ebRetrievalTask.getSellerId());
    //        ebRetrievalTask.setItemsLst(this.ebItemDao.selectByExample(itemExample));
    //      }
    //    }
    return tasks;
  }

  @Override
  public void saveEbRetrievalTask(EbRetrievalTask currentTask, RequestMeta requestMeta, String pageStatus) {
    // TODO Auto-generated method stub

    if (ZcSettingConstants.PAGE_STATUS_NEW.equals(pageStatus)) {
      this.ebRetrievalTaskDao.insert(currentTask);
      currentTask.getEbSeller().setSellerId(currentTask.getSellerId());
      this.ebSellerDao.insert(currentTask.getEbSeller());
    } else {
      this.ebRetrievalTaskDao.updateByPrimaryKey(currentTask);
      this.ebSellerDao.updateByPrimaryKey(currentTask.getEbSeller());
    }
  }

  @Override
  public int deleteEbRetrievalTask(EbRetrievalTask task, RequestMeta requestMeta) {
    // TODO Auto-generated method stub

    //delete checked items;
    EbItemCheckedExample icex = new EbItemCheckedExample();
    icex.createCriteria().andSellerIdEqualTo(task.getSellerId());
    ebItemCheckedDao.deleteByExample(icex);

    //delete ref items;
    ebCandidateItemRefDAO.deleteBySeller(task.getSellerId());

    //delete candidate items;
    ebCandidateItemDao.deleteBySeller(task.getSellerId());

    //delete items
    EbItemExample itemExample = new EbItemExample();
    itemExample.createCriteria().andSellerIdEqualTo(task.getSellerId());
    this.ebItemDao.deleteByExample(itemExample);
    //delete retrievalTask
    return this.ebRetrievalTaskDao.deleteByPrimaryKey(task.getSellerId());
  }

  public EbRetrievalTaskDAO getEbRetrievalTaskDao() {
    return ebRetrievalTaskDao;
  }

  public void setEbRetrievalTaskDao(EbRetrievalTaskDAO ebRetrievalTaskDao) {
    this.ebRetrievalTaskDao = ebRetrievalTaskDao;
  }

  @Override
  public void saveTaskAndItems(EbRetrievalTask task, RequestMeta requestMeta) {
    // TODO Auto-generated method stub
    this.ebRetrievalTaskDao.updateByPrimaryKey(task);
    this.ebItemDao.saveEbItems(task.getItemsLst());
  }

  public EbItemDAO getEbItemDao() {
    return ebItemDao;
  }

  public void setEbItemDao(EbItemDAO ebItemDao) {
    this.ebItemDao = ebItemDao;
  }

}

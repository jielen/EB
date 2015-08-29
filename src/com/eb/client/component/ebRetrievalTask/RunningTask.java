package com.eb.client.component.ebRetrievalTask;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Semaphore;

import javax.swing.SwingUtilities;
import javax.xml.datatype.Duration;

import org.apache.log4j.Logger;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetSellerListCall;
import com.ebay.sdk.call.GetUserCall;
import com.ebay.soap.eBLBaseComponents.AddressType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.InternationalShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDetailsType;
import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;
import com.ebay.soap.eBLBaseComponents.ShippingDetailsType;
import com.ebay.soap.eBLBaseComponents.ShippingServiceOptionsType;
import com.ebay.soap.eBLBaseComponents.ShippingTypeCodeType;
import com.ebay.soap.eBLBaseComponents.UserType;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.publish.IEbayRetrievalTaskDelegate;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;

public class RunningTask extends Thread {
  private static Logger logger = Logger.getLogger(RunningTask.class);

  EbRetrievalTask task;

  public EbRetrievalTask getTask() {
    return task;
  }

  public void setTask(EbRetrievalTask task) {
    this.task = task;
  }

  Semaphore queue;

  EbRetrievalTaskPanel panel;

  String runningFlag = EbRetrievalTask.STATUS_RUNNING;

  PaginationType pt = null;

  IEbayRetrievalTaskDelegate ebRetrievalTaskDelegate;

  //  Hashtable<String, EbItem> allItems = new Hashtable<String, EbItem>();

  Hashtable<String, String> allItems = new Hashtable<String, String>();

  BigDecimal totalSoldAmount = new BigDecimal(0);//总销售金额

  long totalSellingItems = 0;//正在销售商品

  long totalSoldQuality = 0;//总销售数量

  long totalItemQuality = 0;//总共检索到的记录数量

  private boolean updateSellerInfoFlag = false;

  public String getFlag() {
    return runningFlag;
  }

  public void setFlag(String flag) {
    this.runningFlag = flag;
  }

  RunningTask(EbRetrievalTask task, Semaphore queue, EbRetrievalTaskPanel panel) {
    this.task = task;
    this.queue = queue;
    this.panel = panel;
    init();
  }

  private void init() {
    // TODO Auto-generated method stub

    this.ebRetrievalTaskDelegate = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class, "ebayRetrievalTaskDelegate");
    createPaginationType(this.panel.getPageNumber());
  }

  private PaginationType createPaginationType(int pageNumber) {
    // TODO Auto-generated method stub

    pt = new PaginationType();
    pt.setEntriesPerPage(new Integer(this.panel.getItemsPerRequire()));
    pt.setPageNumber(new Integer(pageNumber <= 1 ? 1 : pageNumber));
    return pt;
  }

  @Override
  public void run() {
    try {
      if (queue.availablePermits() > 0) {
        logger.debug(task.getSellerId() + "进入检索队列");
      } else {
        task.setStatus(EbRetrievalTask.STATUS_WAITING);
        panel.fireTaskTableChanged();
        logger.debug(task.getSellerId() + "进入等待队列");
      }

      queue.acquire();

      logger.debug(task.getSellerId() + "开始检索");
      //抓取任务
      task.setStatus(EbRetrievalTask.STATUS_RUNNING);
      Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(this.panel.TIME_ZONE));
      task.setTaskStartTime(calendar.getTime());
      this.task.setRetrievalAnchorTime(calendar.getTime());
      clearOldItems();
      updateSellerInfoFlag = true;
      retrievalItems();
      System.out.println(this.task.getSellerId() + " completed.");
      panel.removeRunningTask(task);
      queue.release();
      panel.fireTaskTableChanged();
    } catch (Exception e) {
      this.task.setStatus(EbRetrievalTask.STATUS_EXCEPTION);
      updateToPanel();
      e.printStackTrace();
    }

  }

  private void clearOldItems() {
    // TODO Auto-generated method stub
    EbItemExample ebItemExample = new EbItemExample();
    ebItemExample.createCriteria().andSellerIdEqualTo(this.task.getSellerId());
    this.ebRetrievalTaskDelegate.deleteEbItems(ebItemExample, WorkEnv.getInstance().getRequestMeta());
  }

  private void suspendTask() {
    // TODO Auto-generated method stub
    task.setStatus(EbRetrievalTask.STATUS_SUSPEND);
  }

  private void stopTask() {
    // TODO Auto-generated method stub
    task.setStatus(EbRetrievalTask.STATUS_STOP);
  }

  /*
   * 抓取数据
   */
  private void retrievalItems() {
    // TODO Auto-generated method stub
    //get dev app infomations
    long sartRetrievalTime = Calendar.getInstance().getTimeInMillis();
    long endRetrievalTime = Calendar.getInstance().getTimeInMillis();
    ApiContext apiContext = EbApiContextFactory.getApiContext();
    if (apiContext == null) {
      logger.error("没有找到app账号信息");
      return;
    }
    //清空task的items
    this.task.setItemsLst(new ArrayList<EbItem>());

    allItems = new Hashtable<String, String>();

    totalSoldAmount = new BigDecimal(0);
    try {
      GetSellerListCall api = new GetSellerListCall(apiContext);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
      api.setDetailLevel(detailLevels);

      api.setUserID(this.task.getSellerId());
      api.setSort(this.panel.getSortTypeNoSorting());

      TimeFilter tf;

      Calendar fromDate = Calendar.getInstance(TimeZone.getTimeZone(this.panel.getTimeZone()));
      Calendar toDate = Calendar.getInstance(TimeZone.getTimeZone(this.panel.getTimeZone()));

      if (this.task.getRetrievalType().equals(EbRetrievalTask.RETRIEVAL_TYPE_START_TIME)) {
        //以时间锚点为中心，向前搜索
        for (int i = 0; i < task.getRetrievalMonths(); i++) {
          if (!keepRunning()) {
            break;
          }
          api.setPagination(createPaginationType(this.panel.getPageNumber()));
          if (i == 0) {
            fromDate.setTime(task.getRetrievalAnchorTime());
          }
          toDate = (Calendar) fromDate.clone();
          toDate.add(Calendar.DATE, task.getStep().intValue());
          System.out.println(task.getSellerId() + " no." + (i + 1) + " startTime=" + fromDate.getTime().toLocaleString() + " endTime="
            + toDate.getTime().toLocaleString());
          tf = new TimeFilter(fromDate, toDate);
          api.setStartTimeFilter(tf);

          ItemType[] firstItems;

          firstItems = api.getSellerList();
          System.out.println(firstItems == null ? "no items" : firstItems.length);
          if (firstItems == null || firstItems.length == 0) {//没有数据了，不再往前检索
            break;
          }
          //将第一批的结果保存
          saveItems(firstItems);

          PaginationResultType pnresult = api.getPaginationResult();
          totalItemQuality += pnresult.getTotalNumberOfEntries();
          getOtherItems(api, pnresult);

          fromDate = toDate;
        }

        //以时间锚点为中心，向后搜索
        for (int i = 0; i < task.getRetrievalMonths(); i++) {
          if (!keepRunning()) {
            break;
          }
          api.setPagination(createPaginationType(this.panel.getPageNumber()));
          if (i == 0) {
            toDate.setTime(task.getRetrievalAnchorTime());
          }
          fromDate = (Calendar) toDate.clone();
          fromDate.add(Calendar.DATE, -task.getStep().intValue());
          System.out.println(task.getSellerId() + " no." + (i + 1) + " startTime=" + fromDate.getTime().toLocaleString() + " endTime="
            + toDate.getTime().toLocaleString());
          tf = new TimeFilter(fromDate, toDate);
          api.setStartTimeFilter(tf);

          ItemType[] firstItems;

          firstItems = api.getSellerList();
          if (firstItems == null || firstItems.length == 0) {//没有数据了，不再往后检索
            break;
          }
          //将第一批的结果保存
          //          logger.debug("========" + i);
          saveItems(firstItems);

          PaginationResultType pnresult = api.getPaginationResult();
          totalItemQuality += pnresult.getTotalNumberOfEntries();
          getOtherItems(api, pnresult);

          toDate = fromDate;

        }

      } else if (this.task.getRetrievalType().equals(EbRetrievalTask.RETRIEVAL_TYPE_END_TIME)) {
        //以时间锚点为中心，向前搜索
        for (int i = 0; i < task.getRetrievalMonths(); i++) {
          if (!keepRunning()) {
            break;
          }
          api.setPagination(createPaginationType(this.panel.getPageNumber()));
          if (i == 0) {
            fromDate.setTime(task.getRetrievalAnchorTime());
          }
          toDate = (Calendar) fromDate.clone();
          toDate.add(Calendar.DATE, task.getStep().intValue());
          System.out.println(task.getSellerId() + " no." + (i + 1) + " startTime=" + fromDate.getTime().toLocaleString() + " endTime="
            + toDate.getTime().toLocaleString());
          tf = new TimeFilter(fromDate, toDate);
          api.setEndTimeFilter(tf);

          ItemType[] firstItems;

          firstItems = api.getSellerList();
          if (firstItems == null || firstItems.length == 0) {//没有数据了，不再往前检索
            break;
          }
          //将第一批的结果保存
          saveItems(firstItems);

          PaginationResultType pnresult = api.getPaginationResult();
          totalItemQuality += pnresult.getTotalNumberOfEntries();
          getOtherItems(api, pnresult);

          fromDate = toDate;

        }

        //以时间锚点为中心，向后搜索
        for (int i = 0; i < task.getRetrievalMonths(); i++) {
          if (!keepRunning()) {
            break;
          }
          api.setPagination(createPaginationType(this.panel.getPageNumber()));
          if (i == 0) {
            toDate.setTime(task.getRetrievalAnchorTime());
          }
          fromDate = (Calendar) toDate.clone();
          fromDate.add(Calendar.DATE, -task.getStep().intValue());
          System.out.println(task.getSellerId() + " no." + (i + 1) + " startTime=" + fromDate.getTime().toLocaleString() + " endTime="
            + toDate.getTime().toLocaleString());
          tf = new TimeFilter(fromDate, toDate);
          api.setEndTimeFilter(tf);

          ItemType[] firstItems;

          firstItems = api.getSellerList();
          if (firstItems == null || firstItems.length == 0) {//没有数据了，不再往后检索
            break;
          }
          //将第一批的结果保存
          saveItems(firstItems);

          PaginationResultType pnresult = api.getPaginationResult();
          totalItemQuality += pnresult.getTotalNumberOfEntries();

          getOtherItems(api, pnresult);

          toDate = fromDate;

        }

      } else if (this.task.getRetrievalType().equals(EbRetrievalTask.RETRIEVAL_TYPE_BOTH)) {

      }
      endRetrievalTime = Calendar.getInstance().getTimeInMillis();
      this.task.setTimeConsuming(getConsumeTime(sartRetrievalTime, endRetrievalTime));
      this.task.setTotalSoldAmount(totalSoldAmount);
      this.task.setSellingItemQuality(totalSellingItems);
      this.task.setTotalSoldQuality(totalSoldQuality);
      this.task.setTotalItemQuality(totalItemQuality);
      if (keepRunning()) {//通过点击停止、暂停等按钮停止检索任务的，不改变状态，只有真正检索完成的设置为完成状态
        this.task.setStatus(EbRetrievalTask.STATUS_COMPLETE);
        this.task.setAnalyseStatus(EbRetrievalTask.ANALYSE_STATUS_UPDATE);
      }
      ebRetrievalTaskDelegate.saveEbRetrievalTask(task, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_BROWSE);
    } catch (Exception ex) {
      endRetrievalTime = Calendar.getInstance().getTimeInMillis();
      this.task.setTimeConsuming(getConsumeTime(sartRetrievalTime, endRetrievalTime));
      this.task.setTotalSoldAmount(totalSoldAmount);
      this.task.setSellingItemQuality(totalSellingItems);
      this.task.setTotalSoldQuality(totalSoldQuality);
      this.task.setStatus(EbRetrievalTask.STATUS_EXCEPTION);
      this.task.setAnalyseStatus(EbRetrievalTask.ANALYSE_STATUS_UPDATE);

      this.task.setTotalItemQuality(totalItemQuality);
      this.ebRetrievalTaskDelegate.saveEbRetrievalTask(this.task, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_BROWSE);
      logger.error(ex.getMessage(), ex);
    }
  }

  private String getConsumeTime(long sartRetrievalTime, long endRetrievalTime) {
    // TODO Auto-generated method stub
    long s = (endRetrievalTime - sartRetrievalTime) / 1000;
    double miao = s % 60;
    double m = s / 60;
    double fen = m % 60;
    double shi = s / 60 / 60;
    StringBuffer bf = new StringBuffer();
    if (shi >= 1) {
      bf.append(Double.valueOf(shi).intValue()).append("小时");
    }
    if (fen >= 1) {
      bf.append(Double.valueOf(fen).intValue()).append("分");
    }
    if (miao >= 1) {
      bf.append(Double.valueOf(miao).intValue()).append("秒");
    }
    return bf.toString();
  }

  /**
   * @param api
   * @param allItems
   * @param pnresult
   * @return
   * @throws ApiException
   * @throws SdkException
   * @throws Exception
   * Administrator
   * Jul 3, 2012
   */
  private int getOtherItems(GetSellerListCall api, PaginationResultType pnresult) throws ApiException, SdkException, Exception {
    int pageNumber = 1;
    int totalPageNumber = pnresult.getTotalNumberOfPages();
    ItemType[] results;
    //    logger.error("total page=" + pnresult.getTotalNumberOfPages());
    if (pageNumber < pnresult.getTotalNumberOfPages()) {
      while (pageNumber < pnresult.getTotalNumberOfPages() && keepRunning()) {
        ++pageNumber;
        //        logger.error("page=" + pageNumber);
        System.out.println(task.getSellerId() + "==>" + pageNumber + "/" + totalPageNumber);
        try {
          results = getItemsByPageNumber(api, pageNumber);
          saveItems(results);
          results = null;
        } catch (ApiException e) {
          logger.error(e.getMessage(), e);
          break;
        }
      }
    }
    return pageNumber;
  }

  private boolean keepRunning() {
    if (this.task.getStatus().equals(EbRetrievalTask.STATUS_RUNNING)) {
      return true;
    }
    return false;
  }

  private void saveItems(ItemType[] retItems) throws ApiException, SdkException, Exception {
    //当前时间
    Calendar endDate = Calendar.getInstance();
    List<EbItem> ebItemLst = new ArrayList<EbItem>();
    ItemType item;
    // TODO Auto-generated method stub
    for (int i = 0; i < retItems.length; i++) {
      //      logger.debug("===============" + i);
      item = retItems[i];
      if (updateSellerInfoFlag) {
        updateSellerInfo(item);
        updateSellerInfoFlag = false;
      }

      ListingDetailsType dtl = item.getListingDetails();

      if (dtl.getEndTime().getTime().getTime() > Calendar.getInstance().getTimeInMillis()) {
        totalSellingItems += 1;
      }

      int s = item.getSellingStatus().getQuantitySold() == null ? 0 : item.getSellingStatus().getQuantitySold().intValue();
      if (s >= this.panel.getFiltLimit()) {
        EbItem ebItem = new EbItem();
        ebItem.setItemId(item.getItemID().trim());
        if (haveGetIt(ebItem.getItemId())) {
          continue;
        }
        ebItem.setCurrencyId(item.getSellingStatus().getCurrentPrice().getCurrencyID().value());
        ebItem.setSellerId(this.task.getSellerId());

        ebItem.setStartTime(dtl.getStartTime().getTime());
        ebItem.setEndTime(dtl.getEndTime().getTime());

        endDate = dtl.getEndTime();
        if (endDate.getTime().getTime() > Calendar.getInstance().getTimeInMillis()) {//正在销售的商品

          endDate = Calendar.getInstance();
        }

        double sellingDays = getSellingDays(dtl.getStartTime(), endDate) + 1;

        ebItem.setSellingDays(Long.valueOf(Double.valueOf(sellingDays).intValue()));

        DecimalFormat df = new DecimalFormat("#.00");
        ebItem.setPrice(new BigDecimal(df.format(item.getSellingStatus().getCurrentPrice().getValue())));
        Integer qs = item.getSellingStatus().getQuantitySold();
        String soldQualityStr = qs == null ? "" : "" + qs.intValue();
        ebItem.setSoldQuality(Long.valueOf("" + soldQualityStr));
        if (qs == null) {
          ebItem.setSellingPerDay(new BigDecimal(0));
        } else {
          df = new DecimalFormat("#.000");
          //          logger.debug("sellingdays=" + sellingDays + " quantity=" + qs.intValue());
          ebItem.setSellingPerDay(new BigDecimal(df.format(qs.intValue() / sellingDays)));
        }
        ebItem.setBidCount(item.getSellingStatus().getBidCount());
        ebItem.setName(item.getTitle());
        ebItem.setUrl(dtl.getViewItemURL());
        ebItem.setSiteId(item.getSite().value());
        ebItem.setImageUrl(item.getPictureDetails().getGalleryURL());
        ebItem.setCountry(item.getCountry().name());
        ebItem.setLocation(item.getLocation());
        ebItem.setListingType(item.getListingType().value());
        ebItem.setSku(item.getSKU());
        CaculateShippingFee(item, ebItem);

        Duration tl = item.getTimeLeft();
        ebItem.setTimeLeft(MessageFormat.format("{0}天{1}时{2}分{3}秒", new Object[] { new Integer(tl.getDays()), new Integer(tl.getHours()),
          new Integer(tl.getMinutes()), new Integer(tl.getSeconds()) }));
        ebItem.setCategoryId(item.getPrimaryCategory().getCategoryID());
        ebItem.setCategoryName(item.getPrimaryCategory().getCategoryName());
        //        updateCategory(item.getPrimaryCategory().getCategoryID(), item.getPrimaryCategory().getCategoryName(), item.getPrimaryCategory()
        //          .getCategoryParentID(), item.getPrimaryCategory().getCategoryParentName());
        ebItemLst.add(ebItem);
        allItems.put(ebItem.getItemId(), "");
        double amount = ebItem.getPrice().doubleValue() * ebItem.getSoldQuality().intValue();
        df = new DecimalFormat("#.00");
        totalSoldAmount = totalSoldAmount.add(new BigDecimal(df.format(amount)));
        totalSoldQuality += ebItem.getSoldQuality().longValue();

        //        System.out.println(ebItem.getItemId());
      }
    }
    this.task.getItemsLst().addAll(ebItemLst);

    //保存到数据库
    saveToDatabase(ebItemLst);
    //同步到界面上
    updateToPanel();
  }

  private void CaculateShippingFee(ItemType item, EbItem ebItem) {
    // TODO Auto-generated method stub
    BigDecimal rtn = new BigDecimal(0);
    ShippingDetailsType shippingDetails = item.getShippingDetails();
    ShippingTypeCodeType shippingType = shippingDetails.getShippingType();
    double f = -1, f2 = -1;
    if (shippingType != null) {
      ebItem.setShippingType(shippingType.value());

      ShippingServiceOptionsType[] normalShippings = shippingDetails.getShippingServiceOptions();
      int size = normalShippings != null ? normalShippings.length : 0;
      for (int i = 0; i < size; i++) {
        ShippingServiceOptionsType nso = normalShippings[i];
        if (nso.getShippingService() != null && shippingType == ShippingTypeCodeType.FLAT && !nso.isExpeditedService()
          && (nso.getShippingServicePriority() != null && nso.getShippingServicePriority().intValue() == 1)) {
          if (nso.isFreeShipping() != null && nso.isFreeShipping()) {
            f = 0;
            break;
          }
          f = nso.getShippingServiceCost().getValue();
          break;
        }
      }
      InternationalShippingServiceOptionsType[] internationals = shippingDetails.getInternationalShippingServiceOption();
      int size2 = internationals != null ? internationals.length : 0;
      for (int i = 0; i < size2; i++) {
        InternationalShippingServiceOptionsType isso = internationals[i];
        if (isso.getShippingService() != null && shippingType == ShippingTypeCodeType.FLAT && isso.getShippingServiceCost() != null
          && (isso.getShippingServicePriority() != null && isso.getShippingServicePriority().intValue() == 1)) {
          f2 = isso.getShippingServiceCost().getValue();
          break;
        }
      }
    }
    double k = f < 0 ? 0 : f;
    k = f2 > 0 ? Math.max(k, f2) : k;

    rtn = new BigDecimal(k);
    ebItem.setShippingFee(rtn);

  }

  private void updateCategory(String categoryID, String categoryName, String[] parentIds, String[] parentNames) {
    // TODO Auto-generated method stub
    System.out.println(categoryID + "=" + categoryName);
    if (parentIds != null) {
      for (int i = 0; i < parentIds.length; i++) {
        System.out.println("parent category: " + parentIds[i] + "=" + parentNames[i]);
      }
    }
  }

  private void updateSellerInfo(ItemType item) throws ApiException, SdkException, Exception {
    // TODO Auto-generated method stub
    UserType user = item.getSeller();
    boolean newSeller = false;
    EbSeller ebSeller = this.ebRetrievalTaskDelegate.getEbSellerBySellerId(this.task.getSellerId(), WorkEnv.getInstance().getRequestMeta());
    if (ebSeller == null) {
      ebSeller = new EbSeller();
      ebSeller.setSellerId(this.task.getSellerId());
      newSeller = true;
    }
    ebSeller = getSellerInfo(ebSeller, item.getItemID());
    ebSeller.setImageSite(this.task.getEbSeller().getImageSite());
    ebSeller.setRemark(this.task.getEbSeller().getRemark());
    ebSeller.setGroupId(this.task.getEbSeller().getGroupId());
    ebSeller.setAttentionStatus(this.task.getEbSeller().getAttentionStatus());

    this.task.setEbSeller(ebSeller);
    if (newSeller) {
      this.ebRetrievalTaskDelegate.saveEbSeller(ebSeller, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_NEW);
    } else {
      this.ebRetrievalTaskDelegate.saveEbSeller(ebSeller, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_EDIT);
    }
  }

  private EbSeller getSellerInfo(EbSeller ebSeller, String itemID) throws ApiException, SdkException, Exception {
    // TODO Auto-generated method stub
    ApiContext apiContext = EbApiContextFactory.getApiContext();
    GetUserCall api = new GetUserCall(apiContext);
    DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
    api.setDetailLevel(detailLevels);
    api.setUserID(ebSeller.getSellerId());
    api.setItemID(itemID);
    UserType user = api.getUser();
    if (user.getRegistrationAddress() != null) {
      AddressType address = user.getRegistrationAddress();
      ebSeller.setContry(address.getCountry().value());
      ebSeller.setCity(address.getStateOrProvince());
      StringBuffer bf = new StringBuffer();
      bf.append("name=").append(address.getLastName()).append(" ").append(address.getFirstName()).append("\n");
      bf.append("phone=").append(address.getPhone()).append("\n");
      bf.append("address=").append(address.getCountryName()).append(address.getStateOrProvince()).append(address.getCityName())
        .append(address.getCounty()).append(address.getStreet()).append(address.getName()).append("\n");
      bf.append("postalCode=").append(address.getPostalCode()).append("\n");
      bf.append("company=").append(address.getCompanyName()).append("\n");
      ebSeller.setRemark(bf.toString());
    }
    ebSeller.setRegisterDate(user.getRegistrationDate().getTime());
    ebSeller.setFeedback(user.getFeedbackScore().longValue());
    return ebSeller;
  }

  private void updateToPanel() {
    // TODO Auto-generated method stub
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        panel.updateTask(task);
      }
    });
  }

  private boolean haveGetIt(String itemID) {
    // TODO Auto-generated method stub
    //    this.allItems
    if (this.allItems.containsKey(itemID)) {
      return true;
    }
    return false;
  }

  private void saveToDatabase(List<EbItem> ebItemLst) {
    // TODO Auto-generated method stub
    this.ebRetrievalTaskDelegate.saveEbRetrievalTask(this.task, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_BROWSE);
    this.ebRetrievalTaskDelegate.saveEbItems(ebItemLst, WorkEnv.getInstance().getRequestMeta());
  }

  private static double getSellingDays(Calendar startTime, Calendar endTime) {
    // TODO Auto-generated method stub

    Date st = startTime.getTime();

    Date et = endTime.getTime();

    long ds = et.getTime() - st.getTime();

    long dds = ds / 1000 / 60 / 60 / 24;

    return Math.floor(Double.valueOf("" + dds));
  }

  /*
   * 获取指定页面的物品的结果，并过滤掉没有卖掉的物品
   */
  private ItemType[] getItemsByPageNumber(GetSellerListCall api, int pageNumber) throws ApiException, SdkException, Exception {

    PaginationType pt = new PaginationType();
    pt.setEntriesPerPage(new Integer(this.panel.getItemsPerRequire()));

    pt.setPageNumber(new Integer(pageNumber));

    api.setPagination(pt);

    return api.getSellerList();

  }

  private List<ItemType> filtItem(ItemType[] retItems) {
    List<ItemType> allItems = new ArrayList<ItemType>();
    for (int i = 0; i < retItems.length; i++) {
      int s = retItems[i].getSellingStatus().getQuantitySold() == null ? 0 : retItems[i].getSellingStatus().getQuantitySold().intValue();
      if (s > 0) {
        allItems.add(retItems[i]);
      }
    }
    return allItems;
  }
}

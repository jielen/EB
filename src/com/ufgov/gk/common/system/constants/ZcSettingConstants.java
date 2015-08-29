package com.ufgov.gk.common.system.constants;

public class ZcSettingConstants {

  public final static String TAB_ID_EB_SITE = "EbSite_Tab";

  public final static String CONDITION_ID_EB_SITE = "EbSite_SEARCH";

  public final static String TAB_ID_EB_APP_SERVER = "EbAppServer_Tab";

  public final static String CONDITION_ID_EB_APP_SERVER = "EbAppServer_SEARCH";

  public final static String TAB_ID_EB_APP_ACCOUNT = "EbAppAccount_Tab";

  public final static String CONDITION_ID_EB_APP_ACCOUNT = "EbAppAccount_SEARCH";

  public final static String TAB_ID_EB_CATEGORY = "EbCategory_Tab";

  public final static String CONDITION_ID_EB_CATEGORY = "EbCategory_SEARCH";

  public final static String TAB_ID_EB_SELLER_GROUP = "EbSellerGroup_Tab";

  public final static String CONDITION_ID_EB_SELLER_GROUP = "EbSellerGroup_SEARCH";

  public final static String TAB_ID_EB_CURRENCY = "EbCurrency_Tab";

  public final static String CONDITION_ID_EB_CURRENCY = "EbCurrency_SEARCH";

  public final static String TAB_ID_EB_SELLER = "EbSeller_Tab";

  public final static String CONDITION_ID_EB_SELLER = "EbSeller_SEARCH";

  public final static String TAB_ID_EB_CANDIDATE_ITEM = "EbCandidateItem_Tab";

  public final static String CONDITION_ID_EB_CANDIDATE_ITEM = "EbCandidateItem_SEARCH";

  public final static String TAB_ID_EB_ITEM = "EbItem_Tab";

  public final static String CONDITION_ID_EB_ITEM = "EbItem_SEARCH";

  //--编辑页面状态--
  public final static String PAGE_STATUS_NEW = "NEW_PAGE";//新增页面

  public final static String PAGE_STATUS_EDIT = "EDIT_PAGE";//编辑页面

  public final static String PAGE_STATUS_BROWSE = "BROWSE_PAGE";//浏览页面

  public final static String PAGE_STATUS_ALL = "ALL_PAGE_STATUS";//所有的页面状态

  public final static String BILL_STATUS_ALL = "ALL_BILL_STATUS";//所有的单据状态

  //--外部部件弹出新建对话框类型
  public final static int FOREIGNENTITY_BASE = 0;//通用类型，没有新建模式

  public final static int FOREIGNENTITY_NEW_SUPPLIER = 1;//供应商

  public final static int FOREIGNENTITY_NEW_PROMAKE = 2;//新增采购计划单，用于区县抽取专家时填充项目

  //值集
  public final static String VS_EB_SELLER_GROUP = "VS_EB_SELLER_GROUP"; //目录集合值集ID

  public final static String VS_EB_CATEGORY = "VS_EB_CATEGORY"; //卖家集合值集ID

  public final static String VS_EB_CURRENCY = "VS_EB_CURRENCY";//币种集合

  public final static String VS_EB_SITE = "VS_EB_SITE";//ebay站点集合

  public final static String VS_EB_RETRIEVAL_TASK_STATUS = "VS_EB_RETRIEVAL_TASK_STATUS";//检索任务状态集合

  public final static String VS_EB_RETRIEVAL_TASK_TYPE = "VS_EB_RETRIEVAL_TASK_TYPE";//检索任务类型集合

  public final static String VS_EB_RETRIEVAL_TASK_ANALYSE = "VS_EB_RETRIEVAL_TASK_ANALYSE";//任务分析集合

  public final static String VS_EB_CANDIDATE_ITEM_STATUS = "VS_EB_CANDIDATE_ITEM_STATUS";//候选商品状态集合

  public final static String VS_EB_TRANSPORT_MODE = "VS_EB_TRANSPORT_MODE";//商品运输方式

  public final static String VS_EB_SELLER_ATTENTION_STATUS = "VS_EB_SELLER_ATTENTION_STATUS";//卖家关注状态

  public final static String IMAGE_DIRECTROY_FOR_CANDIDATE = "/img/candidateitems/";//候选商品的目录

  public final static String TIME_LEFT_ZERO = "0天0时0分0秒";//零剩余时间

  public final static String DEFAULT_IMAGE_NAME = "/img/default.jpg";

  public final static String FIX = "一口价";

  public final static String CHINESE = "拍卖";

  public final static String US = "US";

  public final static String UK = "UK";

  public final static String DE = "DE";

  public final static String FR = "FR";

  public final static String CA = "CA";

  public final static String AU = "AU";

  //拍卖类型
  public final static String ACUTION_TYPE_PRIVATE = "private";

  public final static String ACUTION_TYPE_STORE = "store";

  //店铺类型
  public final static String STORE_TYPE_NO = "no";

  public final static String STORE_TYPE_BASIC = "basic";

  public final static String STORE_TYPE_FEATURED = "featured";

  public final static String STORE_TYPE_ANCHOR = "anchor";

  public static final String CURENCY_EUR = "EUR";

  public static final String CURENCY_USD = "USD";

  public static final String CURENCY_AUD = "AUD";

  public static final String CURENCY_GBP = "GBP";

  public static final String CURENCY_CAD = "CAD";

  //运输模式
  public static final String TRANSPORT_MODE_XIAOBAO = "1";

  public static final String TRANSPORT_MODE_XIAOBAO_GUAHAO = "2";

  public static final String TRANSPORT_MODE_4PX = "3";

  public static final String TRANSPORT_MODE_4PX_GUAHAO = "4";

  public static final String TRANSPORT_MODE_EMS = "5";

  //ebay 物品 种类，用于计算ebay费用
  public static final String categoryElectronics = "1";//Electronics

  public static final String categoryClothing = "2";//Clothing, Shoes and Accessories, Motors Parts & Accessori

  public static final String categoryBooks = "3";//Books, DVDs & Movies, Music, Video Games

  public static final String categoryOther = "4";//All other categories

}

package com.ufgov.gk.client.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.common.commonbiz.model.WfAware;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;

public class BillElementMeta {

  /* 没有年度控制的单据要素 */

  public static final int NOT_ND = 9999;

  private Map billElementMap = new HashMap();

  private List<BillElement> displayFieldList = new ArrayList<BillElement>();

  private Map<String, BillElement> displayFieldMap = new HashMap<String, BillElement>();

  private static Map<String, BillElementMeta> dataCacheMap = new HashMap<String, BillElementMeta>();

  private static IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory

  .create(IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private BillElementMeta() {

    super();

  }

  public static BillElementMeta getBillElementMeta(String billTypeCode) {

    BillElementMeta bem = dataCacheMap.get(billTypeCode);

    if (bem == null) {

      int nd = WorkEnv.getInstance().getTransNd();

      bem = new BillElementMeta();

      bem.init(nd, billTypeCode);

      dataCacheMap.put(billTypeCode, bem);

    }

    return bem;

  }

  public static BillElementMeta getBillElementMetaWithoutNd(

  String billTypeCode) {

    BillElementMeta bem = dataCacheMap.get(billTypeCode);

    if (bem == null) {

      // int nd = WorkEnv.getInstance().getTransNd();

      bem = new BillElementMeta();

      bem.init(NOT_ND, billTypeCode);

      dataCacheMap.put(billTypeCode, bem);

    }

    return bem;

  }

  public static BillElementMeta getNewZcBillElementMetaWithoutNd(

  String billTypeCode) {

    // int nd = WorkEnv.getInstance().getTransNd();

    BillElementMeta bem = new BillElementMeta();

    bem.init(NOT_ND, billTypeCode);

    return bem;

  }

  public static BillElementMeta getNewBillElementMeta(String billTypeCode) {

    int nd = WorkEnv.getInstance().getTransNd();

    BillElementMeta bem = new BillElementMeta();

    bem.init(nd, billTypeCode);

    return bem;

  }

  private void init(int nd, String billTypeCode) {

    billElementMap = baseDataServiceDelegate.getBillElement(nd,

    billTypeCode, requestMeta);

    displayFieldList = baseDataServiceDelegate

    .getDownDisplayBillElementList(nd, billTypeCode, "1",

    requestMeta);

    for (BillElement billElement : displayFieldList) {

      displayFieldMap.put(billElement.getElementCode(), billElement);

    }

  }

  public int getElementLevelCtrl(String elementCode) {

    int levelCtrl = 0;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getRenderType() != null) {

      levelCtrl = billElement.getLevelCtrl();

    }

    return levelCtrl;

  }

  public int getParentLevelCtrl(String elementCode) {

    int parentLevelCtrl = 0;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getRenderType() != null) {

      parentLevelCtrl = billElement.getParentLevelCtrl();

    }

    return parentLevelCtrl;

  }

  public String getElementRenderType(String elementCode) {

    String renderType = "";

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getRenderType() != null) {

      renderType = billElement.getRenderType();

    }

    return renderType;

  }

  public String getElementName(String elementCode) {

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null)

      return billElement.getElementName();

    return null;

  }

  public boolean hasElement(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null)

      flag = true;

    return flag;

  }

  public boolean isElementInclude(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getInclude() != null

    && billElement.getInclude().equals("1")) {

      flag = true;

    }

    return flag;

  }

  public boolean isElementInherit(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (isElementInclude(elementCode)) {

      if (billElement != null && billElement.getInherit() != null

      && billElement.getInherit().equals("1")) {

        flag = true;

      }

    }

    return flag;

  }

  public boolean isElementEditable(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (isElementInclude(elementCode)) {

      if (billElement != null && billElement.getEdit() != null

      && billElement.getEdit().equals("1")) {

        flag = true;

      }

    }

    return flag;

  }

  public boolean isElementRandomEdit(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (isElementEditable(elementCode)) {

      if (billElement != null && billElement.getRandomEdit() != null

      && billElement.getRandomEdit().equals("1")) {

        flag = true;

      }

    }

    return flag;

  }

  public boolean isElementNullable(String elementCode) {

    boolean flag = true;

    if (isElementEditable(elementCode)) {

      BillElement billElement = (BillElement) billElementMap

      .get(elementCode);

      if ("1".equals(billElement.getNullable())) {

        flag = true;

      } else {

        flag = false;

      }

    }

    return flag;

  }

  public int getEditableNum() {

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    int num = 0;

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementEditable(key)) {

        num++;

      }

    }

    return num;

  }

  public List<BillElement> getEditableBillElement() {

    List<BillElement> editFieds = new ArrayList<BillElement>();

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementEditable(key)) {

        editFieds.add((BillElement) billElementMap.get(key));

      }

    }

    return editFieds;

  }

  public List<String> getNotNullField() {

    List<String> notNullFied = new ArrayList<String>();

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementEditable(key) && !this.isElementNullable(key)) {

        notNullFied.add(key);

      }

    }

    return notNullFied;

  }

  /**

   * 返回不能为空的BillElement对象列表

   * 

   * @return Administrator 2010-5-12

   */

  public List<BillElement> getNotNullBillElement() {

    List<BillElement> notNullFied = new ArrayList<BillElement>();

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementEditable(key) && !this.isElementNullable(key)) {

        notNullFied.add((BillElement) billElementMap.get(key));

      }

    }

    return notNullFied;

  }

  public boolean isElementLevelCtrl(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getLevelCtrl() > 0) {

      flag = true;

    }

    return flag;

  }

  public int getCtrlLevelNum(String elementCode) {

    int num = 0;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getLevelCtrl() > 0) {

      num = billElement.getLevelCtrl();

    }

    return num;

  }

  public boolean isElementDecFlag(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getDecFlag() != null

    && billElement.getDecFlag().equals("1")) {

      flag = true;

    }

    return flag;

  }

  public int getCtrlLen(String elementCode) {

    int len = 0;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (billElement != null && billElement.getLevelStr() != null) {

      String temp = billElement.getLevelStr();

      String[] nums = temp.split("-");

      for (int i = 0; i < nums.length

      && (i + 1) <= getCtrlLevelNum(elementCode); i++) {

        len += Integer.parseInt(nums[i]);

      }

    }

    return len;

  }

  public boolean isElementDisplayInheritField(String elementCode) {

    return isElementDisplayField(elementCode)

    && isElementInherit(elementCode);

  }

  public boolean isElementDisplayField(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (isElementInclude(elementCode)) {

      if (billElement != null && billElement.getDisplayOrderIndex() < 0) {

        flag = true;

      }

    }

    return flag;

  }

  public boolean isElementDownDisplay(String elementCode) {

    boolean flag = false;

    BillElement billElement = (BillElement) billElementMap.get(elementCode);

    if (isElementInclude(elementCode)) {

      if (billElement != null && billElement.getDisplayOrderIndex() > 0) {

        flag = true;

      }

    }

    return flag;

  }

  public int getDownDisplayNum() {

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    int num = 0;

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementDownDisplay(key)) {

        num++;

      }

    }

    return num;

  }

  /*

   * 先是显示可以编辑的字段，后续再增加一个字段来处理

   */

  public List<BillElement> getDisplayField() {

    return displayFieldList;

  }

  // 获取所有汇总项

  public List getSumField() {

    List result = new ArrayList();

    Iterator itera = billElementMap.keySet().iterator();

    String key = "";

    while (itera.hasNext()) {

      key = (String) itera.next();

      if (this.isElementDecFlag(key)) {

        result.add(billElementMap.get(key));

      }

    }

    return result;

  }

  public Map getAllBillElement() {

    return billElementMap;

  }

  public static Map<String, String> getWfCanEditField(WfAware baseBill,

  RequestMeta requestMeta) {

    return baseDataServiceDelegate.getWfCanEditField(baseBill

    .getProcessInstId(), requestMeta);

  }

  /*

   * 根据当前登录人,部件,工作流节点等信息获取流程模版中配置的按钮可用状态

   */

  public static List<String> getWfNodeEnableFunc(WfAware baseBill,

  RequestMeta requestMeta) {

    Map parameter = new HashMap();

    parameter.put("compoId", requestMeta.getCompoId());

    parameter.put("proInstId", baseBill.getProcessInstId());

    parameter.put("executor", requestMeta.getSvUserID());

    return baseDataServiceDelegate.queryDataForList(

    "BillElement.getWfNodeEnableFunc", parameter, requestMeta);

  }

  public Map getAllEditAbleField() {

    List<BillElement> elements = new ArrayList<BillElement>();

    Map editAbleMap = new HashMap();

    Set set = billElementMap.keySet();

    Iterator it = set.iterator();

    while (it.hasNext()) {

      String key = (String) it.next();

      if (this.isElementEditable(key)) {

        //elements.add((BillElement) billElementMap.get(key));

        BillElement billElement = (BillElement) billElementMap.get(key);

        editAbleMap.put(billElement.getElementCode(), billElement.getElementId());

      }

    }

    return editAbleMap;

  }

}

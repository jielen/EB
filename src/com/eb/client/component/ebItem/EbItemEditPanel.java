package com.eb.client.component.ebItem;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.GkBaseDialog;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.button.DeleteButton;
import com.ufgov.gk.client.component.button.EditButton;
import com.ufgov.gk.client.component.button.ExitButton;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.button.NextButton;
import com.ufgov.gk.client.component.button.PreviousButton;
import com.ufgov.gk.client.component.button.SaveButton;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.gk.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.LongFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.client.util.ButtonStatus;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class EbItemEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(EbItemEditPanel.class);

  private static final int maxContentSize = 200;

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private FuncButton addButton = new AddButton();

  private FuncButton saveButton = new SaveButton();

  private FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton editButton = new EditButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private final ListCursor listCursor;

  private EbItem oldObj;

  private String tabStatus;

  private EbItemListPanel listPanel;

  private EbItemEditPanel self = this;

  private GkBaseDialog parent;

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta billElementMeta;

  private int editFlag = 0;

  private String ebSellerSqlMapSelectedId = "EB_SELLER.selectSellerByDto";

  public EbItemEditPanel(EbItemDialog parent, ListCursor listCursor, String tabStatus, EbItemListPanel listPanel) {
    // TODO Auto-generated constructor stub
    super(EbItem.class, BillElementMeta.getBillElementMetaWithoutNd("EB_ITEM"));
    this.listCursor = listCursor;
    this.tabStatus = tabStatus;
    this.listPanel = listPanel;
    this.parent = parent;
    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(listPanel.getCompoId()),
      TitledBorder.CENTER, TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));
    this.colCount = 2;
    billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(listPanel.getCompoId());
    init();
    requestMeta.setCompoId(listPanel.getCompoId());
    refreshData();
    setButtonStatus();
    updateFieldEditorsEditable();
  }

  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TODO Auto-generated method stub

    toolBar.setModuleCode("ZC");
    toolBar.setCompoId(this.listPanel.getCompoId());
    toolBar.add(addButton);
    toolBar.add(editButton);
    toolBar.add(saveButton);
    toolBar.add(deleteButton);
    toolBar.add(previousButton);
    toolBar.add(nextButton);
    toolBar.add(exitButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doAdd();
      }
    });

    editButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        editFlag = 1;
        doEdit();
      }
    });
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        doDelete();
      }
    });
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        doSave();
      }
    });
    previousButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doPrevious();
      }
    });
    nextButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doNext();
      }
    });
    exitButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doExit();
      }
    });
  }

  protected void doExit() {
    // TODO Auto-generated method stub
    if (isDataChanged()) {
      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);
      if (num == JOptionPane.YES_OPTION) {
        if (!doSave()) {
          return;
        }
      }
    }
    this.parent.dispose();

  }

  protected void doNext() {
    // TODO Auto-generated method stub
    if (isDataChanged()) {
      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);
      if (num == JOptionPane.YES_OPTION) {
        if (!doSave()) {
          return;
        }
      } else {
        listCursor.setCurrentObject(oldObj);
      }
    }
    listCursor.next();
    refreshData();
    setButtonStatus();

  }

  protected void doPrevious() {
    // TODO Auto-generated method stub
    if (isDataChanged()) {
      int num = JOptionPane.showConfirmDialog(this, "当前页面数据已修改，是否要保存", "保存确认", 0);
      if (num == JOptionPane.YES_OPTION) {
        if (!doSave()) {
          return;
        }
      } else {
        listCursor.setCurrentObject(oldObj);
      }
    }
    listCursor.previous();
    refreshData();
    setButtonStatus();

  }

  protected boolean doSave() {
    // TODO Auto-generated method stub
    if (!isDataChanged()) {
      JOptionPane.showMessageDialog(self, "数据未发生变化，不需要保存！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return false;
    }
    EbItem item = (EbItem) this.listCursor.getCurrentObject();
    if (!checkBeforeSave())
      return false;
    boolean success = true;
    String errorInfo = "";
    try {
      this.ebayServiceDelegate.saveEbItem(item, requestMeta, this.pageStatus);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      this.listCursor.setCurrentObject(item);
      this.oldObj = (EbItem) ObjectUtil.deepCopy(item);
      this.listPanel.refreshCurrentTabData();

      JOptionPane.showMessageDialog(self, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      updateFieldEditorsEditable();
      setButtonStatus();
      setOldObject();
      return true;
    } else {
      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      return false;
    }

  }

  private boolean checkBeforeSave() {
    EbItem item = (EbItem) this.listCursor.getCurrentObject();

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    StringBuilder errorInfo = new StringBuilder();
    String validateInfo = ZcUtil.validateBillElementNull(item, notNullBillElementList);
    if (validateInfo.length() != 0) {
      errorInfo.append("").append(validateInfo.toString()).append("\n");
    }
    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this.parent, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }

  public boolean isDataChanged() {
    return !DigestUtil.digest(oldObj).equals(DigestUtil.digest(listCursor.getCurrentObject()));
  }

  protected void doDelete() {
    // TODO Auto-generated method stub
    EbItem item = (EbItem) this.listCursor.getCurrentObject();
    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        int records = this.ebayServiceDelegate.deleteEbItem(item, this.requestMeta);
        if (records > 0) {
          success = true;
        } else {
          success = false;
        }
      } catch (Exception e) {
        logger.error(e.getMessage(), e);
        success = false;
        errorInfo += e.getMessage();
      }
      if (success) {
        JOptionPane.showMessageDialog(self, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
        this.listCursor.removeCurrentObject();
        refreshData();
        updateFieldEditorsEditable();
        setButtonStatus();
        this.listPanel.refreshCurrentTabData();
      } else {
        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      }
    }

  }

  protected void doEdit() {
    // TODO Auto-generated method stub
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
    updateFieldEditorsEditable();
    setButtonStatus();

  }

  protected void doAdd() {
    // TODO Auto-generated method stub
    listCursor.setCurrentObject(null);
    refreshData();
  }

  @Override
  protected void updateFieldEditorsEditable() {
    super.updateFieldEditors();
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {
      for (AbstractFieldEditor fd : this.fieldEditors) {
        if (editFlag == 1) {
          if (fd.getFieldName() != null && (fd.getFieldName().equals("itemId"))) {
            fd.setEnabled(false);
          } else {
            fd.setEnabled(true);
          }
          editFlag = 0;
        } else {
          fd.setEnabled(true);
        }
      }
    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      for (AbstractFieldEditor fd : this.fieldEditors) {
        fd.setEnabled(false);
      }
    }
  }

  @Override
  public List<AbstractFieldEditor> createFieldEditors() {
    // TODO Auto-generated method stub
    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();

    TextFieldEditor editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_ITEM_ID), "itemId");
    editorList.add(editor11);
    MoneyFieldEditor priceField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE), "price");
    editorList.add(priceField);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_NAME), "name");
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_URL), "url");
    editorList.add(editor11);
    AsValFieldEditor siteField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SITE_ID), "siteId",
      ZcSettingConstants.VS_EB_SITE);
    editorList.add(siteField);
    AsValFieldEditor currencyField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CURRENCY_ID), "currencyId",
      ZcSettingConstants.VS_EB_CURRENCY);
    editorList.add(currencyField);

    String columNames[] = { LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID) };
    EbSellerHandler sellerHandler = new EbSellerHandler(columNames);
    ElementConditionDto dto = new ElementConditionDto();
    ForeignEntityFieldEditor sellerField = new ForeignEntityFieldEditor(this.ebSellerSqlMapSelectedId, dto, 20, sellerHandler, columNames,
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID), "sellerId");
    editorList.add(sellerField);
    DateFieldEditor dtField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_START_TIME), "startTime",
      DateFieldEditor.TimeTypeH24);
    editorList.add(dtField);
    dtField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_END_TIME), "endTime", DateFieldEditor.TimeTypeH24);
    editorList.add(dtField);
    LongFieldEditor lfield = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY), "soldQuality");
    editorList.add(lfield);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_TYPE), "shippingType");
    editorList.add(editor11);
    MoneyFieldEditor numField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SHIPPING_FEE), "shippingFee");
    editorList.add(numField);
    numField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY), "sellingPerDay", 3);
    editorList.add(numField);
    LongFieldEditor sdField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_DAYS), "sellingDays");
    editorList.add(sdField);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_IMAGE_URL), "imageUrl");
    editorList.add(editor11);
    return editorList;
  }

  /**
   * 卖家选择部件
   * @author Administrator
   *
   */
  private class EbSellerHandler implements IForeignEntityHandler {

    private String columNames[];

    public EbSellerHandler(String columNames[]) {
      this.columNames = columNames;
    }

    public void excute(List selectedDatas) {
      for (Object object : selectedDatas) {
        EbSeller seller = (EbSeller) object;
        EbItem item = (EbItem) listCursor.getCurrentObject();
        item.setSellerId(seller.getSellerId());
        setEditingObject(item);
      }
    }

    @Override
    public TableModel createTableModel(List showDatas) {
      Object data[][] = new Object[showDatas.size()][columNames.length];
      for (int i = 0; i < showDatas.size(); i++) {
        EbSeller rowData = (EbSeller) showDatas.get(i);
        int col = 0;
        data[i][col++] = rowData.getSellerId();
      }

      MyTableModel model = new MyTableModel(data, columNames) {
        public boolean isCellEditable(int row, int colum) {
          return false;
        }
      };
      return model;
    }

    @Override
    public boolean isMultipleSelect() {
      return false;
    }
  }

  @Override
  public JComponent createSubBillPanel() {
    // TODO Auto-generated method stub
    return null;
  }

  /**
   * 设置工具条上按钮的可用性
   * 
   * Administrator
   * 2010-5-15
   */
  private void setButtonStatus() {
    if (this.btnStatusList.size() == 0) {
      ButtonStatus bs = new ButtonStatus();
      bs.setButton(this.addButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.editButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.exitButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_ALL);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.previousButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.nextButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);
    }
    EbItem obj = (EbItem) (this.listCursor.getCurrentObject());
    ZcUtil.setButtonEnable(this.btnStatusList, ZcSettingConstants.BILL_STATUS_ALL, this.pageStatus, this.listPanel.getCompoId(),
      obj.getProcessInstId());
  }

  private void refreshData() {
    EbItem item = (EbItem) listCursor.getCurrentObject();
    if (item == null) {//新增页面
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      item = new EbItem();
      setDefualtValue(item, ZcSettingConstants.PAGE_STATUS_NEW);
      List lst = new ArrayList();
      lst.add(item);
      this.listCursor.setDataList(lst, -1);
    } else {
      //      item = ebayServiceDelegate.getEbItemByID(item.getItemId(), requestMeta);
    }
    listCursor.setCurrentObject(item);
    this.setEditingObject(item);
    setOldObject();
    updateFieldEditorsEditable();
    setButtonStatus();
  }

  private void setOldObject() {
    oldObj = (EbItem) ObjectUtil.deepCopy(listCursor.getCurrentObject());
  }

  private void setDefualtValue(EbItem Account, String pageStatusNew) {
    // TODO Auto-generated method stub

  }

}

package com.eb.client.component.ebAppAccount;

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
import com.ufgov.gk.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.LongFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.PassWordFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.client.util.ButtonStatus;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.ebay.model.EbAccount;
import com.ufgov.gk.common.ebay.model.EbAppAccount;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class EbAppAccountEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(EbAppAccountEditPanel.class);

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

  private EbAppAccount oldObj;

  private String tabStatus;

  private EbAppAccountListPanel listPanel;

  private EbAppAccountEditPanel self = this;

  private GkBaseDialog parent;

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta billElementMeta;

  private int editFlag = 0;

  private String ebSiteSqlMapSelectedId = "EB_ACCOUNT.selectByDto";

  public EbAppAccountEditPanel(EbAppAccountDialog parent, ListCursor listCursor, String tabStatus, EbAppAccountListPanel listPanel) {
    // TODO Auto-generated constructor stub
    super(EbAppAccount.class, BillElementMeta.getBillElementMetaWithoutNd("EB_APP_ACCOUNT"));
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
    EbAppAccount account = (EbAppAccount) this.listCursor.getCurrentObject();
    if (!checkBeforeSave())
      return false;
    boolean success = true;
    String errorInfo = "";
    try {
      this.ebayServiceDelegate.saveEbAppAccount(account, requestMeta, this.pageStatus);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      this.listCursor.setCurrentObject(account);
      this.oldObj = (EbAppAccount) ObjectUtil.deepCopy(account);
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
    EbAppAccount account = (EbAppAccount) this.listCursor.getCurrentObject();

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    StringBuilder errorInfo = new StringBuilder();
    String validateInfo = ZcUtil.validateBillElementNull(account, notNullBillElementList);
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
    EbAppAccount account = (EbAppAccount) this.listCursor.getCurrentObject();
    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        int records = this.ebayServiceDelegate.deleteEbAppAccount(account, this.requestMeta);
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
          if (fd.getFieldName() != null && (fd.getFieldName().equals("appAccount"))) {
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

    String columNames[] = { LangTransMeta.translate(ZcElementConstants.FIELD_EB_ACCOUNT_EBAY_ACCOUNT) };
    EbAccountHandler projHandler = new EbAccountHandler(columNames);
    ElementConditionDto dto = new ElementConditionDto();
    ForeignEntityFieldEditor editor0 = new ForeignEntityFieldEditor(this.ebSiteSqlMapSelectedId, dto, 20, projHandler, columNames,
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_ACCOUNT_EBAY_ACCOUNT), "ebayAccount");
    editor0.getField().setEnabled(false);
    editorList.add(editor0);

    TextFieldEditor editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_APP_ACCOUNT), "appAccount");
    editorList.add(editor11);
    DateFieldEditor expireTime = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_TOKEN_EXPIRE_TIME),
      "tokenExpireTime", DateFieldEditor.TimeTypeH24);
    editorList.add(expireTime);
    LongFieldEditor limitationField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_CALL_LIMITATION),
      "callLimitation");
    editorList.add(limitationField);
    PassWordFieldEditor passwordField = new PassWordFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_APP_PASSWORD),
      "appPassword");
    editorList.add(passwordField);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_DEVID), "productionDevid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_APPID), "productionAppid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_CERTID), "productionCertid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    TextAreaFieldEditor tokenField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_PRODUCTION_TOKEN),
      "productionToken", 5000, 6, 3);
    editorList.add(tokenField);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_DEVID), "sandboxDevid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_APPID), "sandboxAppid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_CERTID), "sandboxCertid");
    editor11.setMaxContentSize(maxContentSize);
    editorList.add(editor11);
    tokenField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_APP_ACCOUNT_SANDBOX_TOKEN), "sandboxToken", 5000, 6, 3);
    editorList.add(tokenField);
    return editorList;
  }

  /**
   * 账号选择部件
   * @author Administrator
   *
   */
  private class EbAccountHandler implements IForeignEntityHandler {

    private String columNames[];

    public EbAccountHandler(String columNames[]) {
      this.columNames = columNames;
    }

    public void excute(List selectedDatas) {
      for (Object object : selectedDatas) {
        EbAccount ebayAccount = (EbAccount) object;
        EbAppAccount Account = (EbAppAccount) listCursor.getCurrentObject();
        Account.setEbayAccount(ebayAccount.getEbayAccount());
        setEditingObject(Account);
      }
    }

    @Override
    public TableModel createTableModel(List showDatas) {
      Object data[][] = new Object[showDatas.size()][columNames.length];
      for (int i = 0; i < showDatas.size(); i++) {
        EbAccount rowData = (EbAccount) showDatas.get(i);
        int col = 0;
        data[i][col++] = rowData.getEbayAccount();
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
    EbAppAccount obj = (EbAppAccount) (this.listCursor.getCurrentObject());
    ZcUtil.setButtonEnable(this.btnStatusList, ZcSettingConstants.BILL_STATUS_ALL, this.pageStatus, this.listPanel.getCompoId(),
      obj.getProcessInstId());
  }

  private void refreshData() {
    EbAppAccount account = (EbAppAccount) listCursor.getCurrentObject();
    if (account == null) {//新增页面
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      account = new EbAppAccount();
      setDefualtValue(account, ZcSettingConstants.PAGE_STATUS_NEW);
      List lst = new ArrayList();
      lst.add(account);
      this.listCursor.setDataList(lst, -1);
    } else {
      account = ebayServiceDelegate.getEbAppAccountByID(account.getAppAccount(), requestMeta);
    }
    listCursor.setCurrentObject(account);
    this.setEditingObject(account);
    setOldObject();
    updateFieldEditorsEditable();
    setButtonStatus();
  }

  private void setOldObject() {
    oldObj = (EbAppAccount) ObjectUtil.deepCopy(listCursor.getCurrentObject());
  }

  private void setDefualtValue(EbAppAccount Account, String pageStatusNew) {
    // TODO Auto-generated method stub

  }

}

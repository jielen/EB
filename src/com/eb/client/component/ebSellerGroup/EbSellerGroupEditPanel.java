package com.eb.client.component.ebSellerGroup;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.common.converter.EbSellerToTableModelConverter;
import com.ufgov.gk.client.component.GkBaseDialog;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.JTablePanel;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.button.DeleteButton;
import com.ufgov.gk.client.component.button.EditButton;
import com.ufgov.gk.client.component.button.ExitButton;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.button.NextButton;
import com.ufgov.gk.client.component.button.PreviousButton;
import com.ufgov.gk.client.component.button.SaveButton;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityFieldCellEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.client.util.ButtonStatus;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

public class EbSellerGroupEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(EbSellerGroupEditPanel.class);

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

  private EbSellerGroup oldSite;

  private String tabStatus;

  private EbSellerGroupListPanel listPanel;

  private EbSellerGroupEditPanel self = this;

  private GkBaseDialog parent;

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta billElementMeta;

  private JTablePanel tablePanel = new JTablePanel();

  private JFuncToolBar subSellerTableToolbar;

  private int editFlag = 0;

  private ElementConditionDto sellerDto;

  public EbSellerGroupEditPanel(EbSellerGroupDialog parent, ListCursor listCursor, String tabStatus, EbSellerGroupListPanel listPanel) {
    // TODO Auto-generated constructor stub
    super(EbSellerGroup.class, BillElementMeta.getBillElementMetaWithoutNd("EB_SELLER_GROUP"));
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
        listCursor.setCurrentObject(oldSite);
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
        listCursor.setCurrentObject(oldSite);
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
    EbSellerGroup sellerGroup = (EbSellerGroup) this.listCursor.getCurrentObject();
    if (!checkBeforeSave())
      return false;
    boolean success = true;
    String errorInfo = "";
    try {
      this.ebayServiceDelegate.saveEbSellGroup(sellerGroup, requestMeta, this.pageStatus);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      this.listCursor.setCurrentObject(sellerGroup);
      this.oldSite = (EbSellerGroup) ObjectUtil.deepCopy(sellerGroup);
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
    EbSellerGroup sellerGroup = (EbSellerGroup) this.listCursor.getCurrentObject();

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    StringBuilder errorInfo = new StringBuilder();
    String validateInfo = ZcUtil.validateBillElementNull(sellerGroup, notNullBillElementList);
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
    return !DigestUtil.digest(oldSite).equals(DigestUtil.digest(listCursor.getCurrentObject()));
  }

  protected void doDelete() {
    // TODO Auto-generated method stub
    EbSellerGroup sellerGroup = (EbSellerGroup) this.listCursor.getCurrentObject();
    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        int records = this.ebayServiceDelegate.deleteEbSellerGroup(sellerGroup, this.requestMeta);
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
          if (fd.getFieldName() != null && (fd.getFieldName().equals("groupId"))) {
            fd.setEnabled(false);
          } else {
            fd.setEnabled(true);
          }
          editFlag = 0;
        } else {
          fd.setEnabled(true);
        }
      }
      this.tablePanel.getTable().setEnabled(true);
    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      for (AbstractFieldEditor fd : this.fieldEditors) {
        fd.setEnabled(false);
      }
      this.tablePanel.getTable().setEnabled(false);
    }
  }

  @Override
  public List<AbstractFieldEditor> createFieldEditors() {
    // TODO Auto-generated method stub
    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();
    TextFieldEditor editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_GROUP_ID), "groupId");
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_NAME), "name");
    editorList.add(editor11);
    editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_REMARK), "remark");
    editorList.add(editor11);

    return editorList;
  }

  @Override
  public JComponent createSubBillPanel() {
    // TODO Auto-generated method stub
    JTabbedPane tabPane = new JTabbedPane();
    tablePanel.init();
    tablePanel.setTablePreferencesKey(this.getClass().getName() + "_table");
    tablePanel.getTable().setShowCheckedColumn(false);
    tablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));
    setTableCell(tablePanel.getTable());
    tabPane.addTab("卖家", tablePanel);

    this.subSellerTableToolbar = new JFuncToolBar();
    JButton addBtn1 = new JButton("添加");
    JButton insertBtn1 = new JButton("插入");
    JButton delBtn1 = new JButton("删除");
    this.subSellerTableToolbar.add(addBtn1);
    this.subSellerTableToolbar.add(insertBtn1);
    this.subSellerTableToolbar.add(delBtn1);
    tablePanel.add(this.subSellerTableToolbar, BorderLayout.SOUTH);

    addBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        addSub(tablePanel);
      }
    });

    insertBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        insertSub(tablePanel);
      }
    });

    delBtn1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        deleteSub(tablePanel);
      }
    });
    return tabPane;
  }

  protected void insertSub(JTablePanel tablePanel2) {
    // TODO Auto-generated method stub
    stopTableEditing();
    EbSellerGroup sellerGroup = (EbSellerGroup) listCursor.getCurrentObject();
    ForeignEntityFieldCellEditor cellEditor = (ForeignEntityFieldCellEditor) tablePanel.getTable()
      .getColumn(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID)).getCellEditor();
    this.sellerDto = new ElementConditionDto();
    cellEditor.updateDto(sellerDto);
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    EbSeller seller = new EbSeller();
    seller.setGroupId(sellerGroup.getGroupId());
    //    signup.getSignupPacks().add(bean);
    int selectedRow = tablePanel.getTable().getSelectedRow();
    if (selectedRow != -1) {
      editTableModel.insertRow(selectedRow + 1, seller);
    } else {
      editTableModel.insertRow(editTableModel.getRowCount(), seller);
    }
  }

  protected void addSub(JTablePanel tablePanel2) {
    // TODO Auto-generated method stub

    tablePanel.getTable().clearSelection();
    stopTableEditing();
    BeanTableModel editTableModel = (BeanTableModel) tablePanel.getTable().getModel();
    EbSeller seller = new EbSeller();
    EbSellerGroup sellerGroup = (EbSellerGroup) listCursor.getCurrentObject();
    ForeignEntityFieldCellEditor cellEditor = (ForeignEntityFieldCellEditor) tablePanel.getTable()
      .getColumn(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID)).getCellEditor();
    this.sellerDto = new ElementConditionDto();
    cellEditor.updateDto(sellerDto);
    seller.setGroupId(sellerGroup.getGroupId());
    editTableModel.insertRow(editTableModel.getRowCount(), seller);
    //    signup.getSignupPacks().add(bean);
  }

  private void stopTableEditing() {
    JPageableFixedTable table = this.tablePanel.getTable();
    if (table.isEditing()) {
      table.getCellEditor().stopCellEditing();
    }
  }

  private void setTableCell(JPageableFixedTable table) {
    //    SwingUtil.setTableCellEditor(table,columnIdentifier, cellEditor)
  }

  /**
   * 设置字表下面的按钮状态
   * 
   * Administrator
   * 2010-5-15
   */
  private void setSubTableButton() {
    if (this.subSellerTableToolbar != null) {
      if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
        this.subSellerTableToolbar.setEnabled(true);
      } else {
        this.subSellerTableToolbar.setEnabled(false);
      }
    }
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
    EbSellerGroup obj = (EbSellerGroup) (this.listCursor.getCurrentObject());
    ZcUtil.setButtonEnable(this.btnStatusList, ZcSettingConstants.BILL_STATUS_ALL, this.pageStatus, this.listPanel.getCompoId(),
      obj.getProcessInstId());

    setSubTableButton();
  }

  private void refreshData() {
    EbSellerGroup sellerGroup = (EbSellerGroup) listCursor.getCurrentObject();
    if (sellerGroup == null) {//新增页面
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
      sellerGroup = new EbSellerGroup();
      setDefualtValue(sellerGroup, ZcSettingConstants.PAGE_STATUS_NEW);
      List lst = new ArrayList();
      lst.add(sellerGroup);
      this.listCursor.setDataList(lst, -1);
    }
    listCursor.setCurrentObject(sellerGroup);
    refreshSubTableData(sellerGroup.getSellerLst());
    this.setEditingObject(sellerGroup);
    setOldObject();
    updateFieldEditorsEditable();
    setButtonStatus();
  }

  private void refreshSubTableData(List<EbSeller> sellerLst) {
    // TODO Auto-generated method stub
    if (sellerLst == null)
      sellerLst = new ArrayList<EbSeller>();
    EbSellerToTableModelConverter converter = new EbSellerToTableModelConverter();
    this.tablePanel.setTableModel(converter.convertEbSellerToBeanTableModel(sellerLst));
    setTableProperty();
  }

  private void setTableProperty() {

    String columNames[] = { LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID),
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_GROUP_ID) };
    SellerForeintyHandler handler = new SellerForeintyHandler(columNames);
    this.sellerDto = new ElementConditionDto();
    EbSellerGroup group = (EbSellerGroup) listCursor.getCurrentObject();
    ForeignEntityFieldCellEditor packEditor = new ForeignEntityFieldCellEditor("EB_SELLER.getSeller", this.sellerDto, 20, handler, columNames,
      LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID));
    SwingUtil.setTableCellEditor(this.tablePanel.getTable(), LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_SELLER_ID), packEditor);
  }

  private void setOldObject() {
    oldSite = (EbSellerGroup) ObjectUtil.deepCopy(listCursor.getCurrentObject());
  }

  private void setDefualtValue(EbSellerGroup sellerGroup, String pageStatusNew) {
    // TODO Auto-generated method stub

  }

  class SellerForeintyHandler implements IForeignEntityHandler {

    private String columNames[];

    public SellerForeintyHandler(String columNames[]) {
      this.columNames = columNames;
    }

    @Override
    public void excute(List selectedDatas) {
      // TODO Auto-generated method stub
      EbSellerGroup sellerGroup = (EbSellerGroup) listCursor.getCurrentObject();
      JTable table = tablePanel.getTable();

      BeanTableModel model = (BeanTableModel) table.getModel();
      int k = table.getSelectedRow();
      if (k < 0)
        return;
      int k2 = table.convertRowIndexToModel(k);
      EbSeller seller = (EbSeller) (model.getBean(k2));

      if (selectedDatas.size() > 0) {
        EbSeller selectedSeller = (EbSeller) selectedDatas.get(0);
        selectedSeller.setGroupId(sellerGroup.getGroupId());
        model.getDataBeanList().remove(k2);
        model.insertRow(k, selectedSeller);

      }

      //      model.fireTableDataChanged();
    }

    @Override
    public boolean isMultipleSelect() {
      // TODO Auto-generated method stub
      return false;
    }

    @Override
    public TableModel createTableModel(List showDatas) {
      // TODO Auto-generated method stub
      Object data[][] = new Object[showDatas.size()][columNames.length];

      for (int i = 0; i < showDatas.size(); i++) {

        EbSeller rowData = (EbSeller) showDatas.get(i);
        int col = 0;
        data[i][col++] = rowData.getSellerId();
        data[i][col++] = rowData.getGroupId();
      }

      MyTableModel model = new MyTableModel(data, columNames) {
        public boolean isCellEditable(int row, int colum) {
          return false;
        }
      };
      return model;
    }

  }

}
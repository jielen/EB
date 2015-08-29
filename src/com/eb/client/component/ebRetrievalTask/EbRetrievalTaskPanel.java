/**
 * EbRetrievalTaskPanel.java
 * com.eb.client.component.ebRetrievalTask
 * Administrator
 * Jun 27, 2012
 */
package com.eb.client.component.ebRetrievalTask;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.Semaphore;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.TableModel;

import org.apache.log4j.Logger;

import com.eb.client.component.IAppMenuCompo;
import com.eb.client.component.ebCandidateItem.EbCandidateItemDialog;
import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.common.ParentWindowAware;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.common.converter.EbItemToTableModelConverter;
import com.ufgov.gk.client.common.converter.EbRetrievalTaskToTableModelConverter;
import com.ufgov.gk.client.component.IForeignEntityHandler;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.JTablePanel;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.button.AnalysisButton;
import com.ufgov.gk.client.component.button.AnalysisedButton;
import com.ufgov.gk.client.component.button.CancelButton;
import com.ufgov.gk.client.component.button.CandidateButton;
import com.ufgov.gk.client.component.button.DeleteButton;
import com.ufgov.gk.client.component.button.EditButton;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.button.RunButton;
import com.ufgov.gk.client.component.button.SaveButton;
import com.ufgov.gk.client.component.button.StopButton;
import com.ufgov.gk.client.component.button.SuspendButton;
import com.ufgov.gk.client.component.table.BeanTableModel;
import com.ufgov.gk.client.component.table.cellrenderer.DateTime24CellRenderer;
import com.ufgov.gk.client.component.table.codecellrenderer.AsValCellRenderer;
import com.ufgov.gk.client.component.table.codecellrenderer.ColorAsValCellRenderer;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.LongFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.client.util.ButtonStatus;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.BillElement;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemCheckedExample;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbItemGroup;
import com.ufgov.gk.common.ebay.model.EbRetrievalTask;
import com.ufgov.gk.common.ebay.model.EbRetrievalTaskExample;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.publish.IEbayRetrievalTaskDelegate;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.ObjectUtil;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

/**
 * @author Administrator
 *
 */
public class EbRetrievalTaskPanel extends JPanel implements ParentWindowAware, IAppMenuCompo {

  private static final Logger logger = Logger.getLogger(EbRetrievalTaskPanel.class);

  private Window parentWindow;

  protected JFuncToolBar toolBar = new JFuncToolBar();

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private JTablePanel taskTablePanel = new JTablePanel();//任务列表面板

  private JTablePanel itemsTablePanel = new JTablePanel(true);//item表面板

  private JTablePanel itemGroupTablePanel = new JTablePanel(true);//去重后的item表面板

  private JFilterItemPanel searchItemPanel;//搜索、过滤item的面板

  private JFilterItemPanel searchItemGroupPanel;//搜索、过滤item的面板

  private JSplitPane splitPanel = new JSplitPane(JSplitPane.VERTICAL_SPLIT);

  private JTabbedPane taskDetailTabPanel = new JTabbedPane();//任务信息和item表面板

  private JPanel taskEditPanel = new JPanel();//任务信息编辑面板

  private JPanel itemsPanel = new JPanel();

  private JPanel itemGroupPanel = new JPanel();

  private String compoId = "EB_RETRIEVAL_TASK";

  private FuncButton addButton = new AddButton();

  private FuncButton saveButton = new SaveButton();

  private FuncButton deleteButton = new DeleteButton();

  private FuncButton editButton = new EditButton();

  private FuncButton runButton = new RunButton();

  private FuncButton stopButton = new StopButton();

  private FuncButton suspendButton = new SuspendButton();

  //  private FuncButton exitButton = new ExitButton();

  private FuncButton cancelButton = new CancelButton();

  private FuncButton candidateButton = new CandidateButton();

  private FuncButton analysisButton = new AnalysisButton();

  private FuncButton analysisedButton = new AnalysisedButton();
  
  private FuncButton changeSellerIdButton=new FuncButton() {

	  protected void init() {

	    this.funcId = "fchangeSellerId";
	    this.defaultText = "更改卖家ID";
	    //    this.iconName = "add.jpg";
	    super.init();

	    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK), "newAction");
	    getActionMap().put("newAction", new AbstractAction() {
	      public void actionPerformed(ActionEvent e) {
	        doClick();
	      }
	    });

	  }
};

  private EbRetrievalTask currentTask = null;

  /*
   * 内存中只保存当前选中任务的item列表，选择不同任务时，使用lazy加载
   */
  private List<EbItem> currentTaskItemLst = new ArrayList<EbItem>();

  private List<AbstractFieldEditor> taskFields = new ArrayList<AbstractFieldEditor>();

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private BillElementMeta billElementMeta;

  private EbRetrievalTask oldTask;

  private HashMap<String, RunningTask> runningTasks = new HashMap<String, RunningTask>();

  private final static int MAX_RUNNING_TASKS = 2;

  private static final int GET_RUNNING_PERMISION = 1;

  private static final int RETURN_RUNNING_PERMISION = 0;

  private static int current_running_tasks = 0;

  private static final Semaphore taskQueue = new Semaphore(MAX_RUNNING_TASKS);

  static final String TIME_ZONE = "GMT";

  private static final int ITEMS_PER_REQUIRE = 120;

  private static final int PAGE_NUMBER = 1;

  private static final String TASK_INFO = "任务信息";

  private static final String ITEMS_INFO = "物品明细";

  private static final String ITEMS_GROUP_INFO = "合并物品明细";

  private final int SORT_TYPE_NO_SORTING = 0;

  private int filtLimit = 1;//过滤已销售数量,低于这个数量的物品将被过滤

  //候选商品中的同一商品
  private List<String> ebCandidateItemRefItemIdLst = new ArrayList<String>();

  private Hashtable<String, String> ebCandidateItemRefStatus = new Hashtable<String, String>();

  private List<EbRetrievalTask> taskLst = new ArrayList<EbRetrievalTask>();

  private ForeignEntityFieldEditor sellerGroupField;

  public EbRetrievalTaskPanel() {
    billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(this.compoId);
    initSwing();
    refreshData();
  }

  private void refreshData() {
    // TODO Auto-generated method stub
    IEbayRetrievalTaskDelegate ebayRetievalTaskDelegate = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
      "ebayRetrievalTaskDelegate");
    EbRetrievalTaskExample taskEx = new EbRetrievalTaskExample();
    taskEx
      .setOrderByClause(" eb_seller.group_id,eb_seller.feedback desc,eb_seller.seller_id,eb_seller.register_date desc,eb_retrieval_task.task_start_time");
    taskLst = ebayRetievalTaskDelegate.getRetrievalTask(taskEx, requestMeta);
    EbRetrievalTaskToTableModelConverter converter = new EbRetrievalTaskToTableModelConverter();
    this.taskTablePanel.setTableModel(converter.convertEbRetrievalTaskToTableModel(taskLst));
    setTaskTableProperty();
    updateFieldEditorsEditable();
    setButtonStatus();
  }

  /*
   * 获取候选物品列表
   */
  private List<EbCandidateItemRef2> initCandidateItems() {
    // TODO Auto-generated method stub

    //从数据库获取当前供应商的全部参照商品

    List<EbCandidateItemRef2> ebCandidateItemRefLst = ebayServiceDelegate.getEbCandidateItemRef2BySeller(this.currentTask.getSellerId(), requestMeta);
    //      List<EbCandidateItem> candidateItemLst=ebayServiceDelegate.getEbCandidateItem(new EbCandidateItemExample(), requestMeta);

    if (ebCandidateItemRefLst == null) {
      ebCandidateItemRefLst = new ArrayList<EbCandidateItemRef2>();
      this.ebCandidateItemRefItemIdLst = new ArrayList<String>();
      this.ebCandidateItemRefStatus = new Hashtable<String, String>();
    } else {

      CandidateUtil cu = new CandidateUtil();
      //获取所有的候选商品
      List<EbCandidateItem> candidateLst = ebayServiceDelegate.getEbCandidateItem(new EbCandidateItemExample(), requestMeta);
      this.ebCandidateItemRefItemIdLst.clear();
      this.ebCandidateItemRefStatus.clear();
      for (EbCandidateItemRef2 ref : ebCandidateItemRefLst) {
        String itemId = ref.getEbItem().getItemId();
        if (!this.ebCandidateItemRefItemIdLst.contains(itemId)) {
          String candidateStatus = cu.getCandidateStatus(candidateLst, ref.getCandidateId());
          if (candidateStatus != null) {
            ref.getEbItem().setCandidateStatus(candidateStatus);
            ebCandidateItemRefItemIdLst.add(itemId);
            //            System.out.println("candidateid=" + ref.getCandidateId() + "item=" + itemId + "candidateStatus=" + candidateStatus);
            this.ebCandidateItemRefStatus.put(itemId, candidateStatus);
          }
        }
      }
    }
    return ebCandidateItemRefLst;
  }

  private void initSwing() {
    // TODO Auto-generated method stub
    initToolBar();
    initTaskTablePanel();
    createTaskDetailTabPanel();
    splitPanel.add(taskTablePanel);
    splitPanel.add(taskDetailTabPanel);
    splitPanel.validate();
    setLayout(new BorderLayout());
    add(toolBar, BorderLayout.NORTH);
    add(splitPanel, BorderLayout.CENTER);

  }

  private void initTaskTablePanel() {
    // TODO Auto-generated method stub
    taskTablePanel.init();
    taskTablePanel.setTablePreferencesKey(this.getClass().getName() + "task_table");
    taskTablePanel.getTable().addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
          JPageableFixedTable table = taskTablePanel.getTable();
          BeanTableModel model = (BeanTableModel) table.getModel();
          int row = table.getSelectedRow();
          logger.debug("select row=" + row);
          EbRetrievalTask task = (EbRetrievalTask) model.getBean(table.convertRowIndexToModel(row));
          setTask(task);
        }
      }
    });
  }

  private void setTaskTableProperty() {
    // TODO Auto-generated method stub
    JPageableFixedTable table = taskTablePanel.getTable();
    AsValCellRenderer statusCellRender = new AsValCellRenderer(ZcSettingConstants.VS_EB_RETRIEVAL_TASK_STATUS);
    AsValCellRenderer typeCellRender = new AsValCellRenderer(ZcSettingConstants.VS_EB_RETRIEVAL_TASK_TYPE);
    AsValCellRenderer attentionStatusCellRender = new AsValCellRenderer(ZcSettingConstants.VS_EB_SELLER_ATTENTION_STATUS);
    AsValCellRenderer analyseStatusCellRender = new AsValCellRenderer(ZcSettingConstants.VS_EB_RETRIEVAL_TASK_ANALYSE);
    DateTime24CellRenderer timeCellRender = new DateTime24CellRenderer();
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_TYPE), typeCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_STATUS), statusCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_CREATE_TIME), timeCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_ANCHOR_TIME), timeCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TASK_START_TIME), timeCellRender);
    SwingUtil
      .setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_STATUS), analyseStatusCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_ATTENTION_STATUS), attentionStatusCellRender);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_TIME), timeCellRender);
  }

  protected void setTask(EbRetrievalTask task) {
    this.currentTask = task;
    //    fireTaskTableChanged();
    setTaskTotaskDetailPanel();
    taskDetailTabPanel.setSelectedIndex(0);
    //    setItemstoItemsPanel();
    setOldObject();
    setButtonStatus();
  }

  private void setItemstoItemsPanel() {
    // TODO Auto-generated method stub
    EbItemToTableModelConverter converter = new EbItemToTableModelConverter();
    if (this.currentTask == null) {
      itemsTablePanel.setTableModel(converter.convertToTableModelNew(new ArrayList<EbItem>()));
      itemGroupTablePanel.setTableModel(converter.convertToTableModelGroup(new ArrayList<EbItemGroup>()));
      return;
    }

    //    List<EbItem> itemLst = this.currentTask.getItemsLst();
    if (this.currentTaskItemLst == null || this.currentTaskItemLst.size() == 0) {
      EbItemExample emex = new EbItemExample();
      emex.createCriteria().andSellerIdEqualTo(this.currentTask.getSellerId());
      emex.setOrderByClause("EB_ITEM.SOLD_QUALITY DESC");
      this.currentTaskItemLst = this.ebayServiceDelegate.getEbItem(emex, requestMeta);
      this.currentTaskItemLst = this.currentTaskItemLst == null ? new ArrayList<EbItem>() : this.currentTaskItemLst;

    }
    //绑定候选信息到物品上
    setCandidateInfoToItems();

    //绑定已阅信息到物品上；
    setCheckInfoToItems();

    itemsTablePanel.setTableModelWithoutFitColumnWidth(converter.convertToTableModelNew(this.currentTaskItemLst));

    List<EbItemGroup> itemGroupLst = this.currentTask.getItemGroupLst();
    if (itemGroupLst == null || itemGroupLst.size() == 0) {
      EbItemExample emex = new EbItemExample();
      emex.createCriteria().andSellerIdEqualTo(this.currentTask.getSellerId());
      itemGroupLst = this.ebayServiceDelegate.getEbItemGroup(emex, requestMeta);
      itemGroupLst = itemGroupLst == null ? new ArrayList<EbItemGroup>() : itemGroupLst;
    }
    itemGroupTablePanel.setTableModelWithoutFitColumnWidth(converter.convertToTableModelGroup(itemGroupLst));

    setItemsTableProperty();
  }

  private void setCheckInfoToItems() {
    // TODO Auto-generated method stub
    // TODO Auto-generated method stub
    if (this.currentTaskItemLst == null || this.currentTaskItemLst.size() == 0)
      return;

    //先获取已检查物品列表
    List<EbItemChecked> checkedItems = initCheckedItems();

    for (EbItem ebItem : this.currentTaskItemLst) {
      for (EbItemChecked ic : checkedItems) {
        if (ebItem.getItemId().equals(ic.getItemId()) && ebItem.getCandidateStatus() == null) {
          ebItem.setCandidateStatus(EbItemChecked.CHECKED);
          break;
        }
      }
    }

  }

  private List<EbItemChecked> initCheckedItems() {
    // TODO Auto-generated method stub

    //从数据库获取当前卖家全部检查过商品
    EbItemCheckedExample ex = new EbItemCheckedExample();
    ex.createCriteria().andSellerIdEqualTo(this.currentTask.getSellerId());
    List<EbItemChecked> checkedItems = ebayServiceDelegate.getEbItemChecked(ex, requestMeta);

    return checkedItems;
  }

  /*
   * 绑定候选信息到物品上
   */
  private void setCandidateInfoToItems() {
    // TODO Auto-generated method stub
    if (this.currentTaskItemLst == null || this.currentTaskItemLst.size() == 0)
      return;

    //先获取候选物品列表
    initCandidateItems();

    for (EbItem ebItem : this.currentTaskItemLst) {
      for (String itemId : this.ebCandidateItemRefItemIdLst) {
        if (ebItem.getItemId().equals(itemId)) {
          ebItem.setCandidateStatus(this.ebCandidateItemRefStatus.get(itemId));
          break;
        }
      }
    }
  }

  /*
   * 比较两者是否同一商品
   */
  private boolean sameItem(EbItem ebItem, EbCandidateItemRef2 ebCandidateItemRef2) {
    // TODO Auto-generated method stub
    if (ebItem.getItemId().equals(ebCandidateItemRef2.getEbItem().getItemId()) || ebItem.getName().equals(ebCandidateItemRef2.getEbItem().getName())
      || ebItem.getUrl().equals(ebCandidateItemRef2.getEbItem().getUrl())
      || (ebItem.getSku() != null && ebItem.getSku().equals(ebCandidateItemRef2.getEbItem().getSku()))) {
      return true;
    }
    return false;
  }

  private void setTaskTotaskDetailPanel() {
    // TODO Auto-generated method stub
    for (AbstractFieldEditor field : taskFields) {
      //      System.out.println("====" + field.getFieldName());
      field.setEditObject(currentTask);
    }
  }

  private void createTaskDetailTabPanel() {
    // TODO Auto-generated method stub
    createTaskEditPanel();
    this.createItemsPanel();
    this.createItemGroupPanel();
    taskDetailTabPanel.add(taskEditPanel, this.TASK_INFO);
    taskDetailTabPanel.add(itemsPanel, this.ITEMS_INFO);
    taskDetailTabPanel.add(itemGroupPanel, this.ITEMS_GROUP_INFO);
    taskDetailTabPanel.setSelectedComponent(taskEditPanel);
    taskDetailTabPanel.addChangeListener(new ChangeListener() {

      @Override
      public void stateChanged(ChangeEvent e) {
        // TODO Auto-generated method stub
        //        System.out.println(itemsTablePanel.getDataList().size());
        int index = taskDetailTabPanel.getSelectedIndex();
        String tabName = taskDetailTabPanel.getTitleAt(index);
        if (tabName.equals(ITEMS_INFO) || tabName.equals(ITEMS_GROUP_INFO)) {

          lazyInitItemsInfo();
        }
      }
    });
  }

  protected void lazyInitItemsInfo() {
    // TODO Auto-generated method stub
    if (this.currentTask == null) {
      return;
    }
    TableModel model = itemsTablePanel.getTable().getModel();
    boolean needInitModel = false;
    if (model instanceof BeanTableModel) {
      BeanTableModel beanTableModel = (BeanTableModel) model;
      if (beanTableModel.getDataBeanList() != null) {
        if (beanTableModel.getDataBeanList().size() > 0) {
          EbItem ebItem = (EbItem) beanTableModel.getDataBeanList().get(0);
          if (!ebItem.getSellerId().equals(this.currentTask.getSellerId())) {
            needInitModel = true;
          }
        } else {
          needInitModel = true;
        }
      } else {
        needInitModel = true;
      }
    } else {
      needInitModel = true;
    }
    if (needInitModel) {
      clearCurrentItemlst();
      setItemstoItemsPanel();
    }
  }

  private void clearCurrentItemlst() {
    // TODO Auto-generated method stub
    this.currentTaskItemLst.clear();
  }

  private JPanel createItemsPanel() {
    // TODO Auto-generated method stub
    itemsPanel.setLayout(new BorderLayout());
    itemsTablePanel.init();
    itemsTablePanel.setTablePreferencesKey(this.getClass().getName() + "items_table");
    itemsTablePanel.getTable().setUseCellRendererColor(true);
    itemsTablePanel.getTable().addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
          doCandidate();
        }
      }
    });

    searchItemPanel = new JFilterItemPanel(itemsTablePanel.getTable());
    //    searchItemPanel.setBorder(BorderFactory.createTitledBorder("搜索"));
    //    searchItemPanel.setPreferredSize(new Dimension(super.getPreferredSize().width, 30));
    //    itemsPanel.add(searchItemPanel, BorderLayout.NORTH);
    itemsPanel.add(itemsTablePanel, BorderLayout.CENTER);
    setItemsTableProperty();
    return this.itemsPanel;
  }

  private void setItemsTableProperty() {
    // TODO Auto-generated method stub
    Hashtable<String, Color> colorVals = new Hashtable<String, Color>();
    colorVals.put(EbCandidateItem.STATUS_CANDIDATE, Color.GREEN);
    colorVals.put(EbCandidateItem.STATUS_RECOMMEND, Color.ORANGE);
    colorVals.put(EbCandidateItem.STATUS_VERY_RECOMMEND, Color.YELLOW);
    colorVals.put(EbCandidateItem.STATUS_SELLING, Color.RED);
    colorVals.put(EbCandidateItem.STATUS_CHEAP_FOR_SALE, Color.MAGENTA);
    colorVals.put(EbItemChecked.CHECKED, Color.PINK);
    ColorAsValCellRenderer render = new ColorAsValCellRenderer(ZcSettingConstants.VS_EB_CANDIDATE_ITEM_STATUS, colorVals);
    SwingUtil.setTableCellRenderer(this.itemsTablePanel.getTable(), LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS),
      render);
  }

  private JPanel createItemGroupPanel() {
    // TODO Auto-generated method stub
    itemGroupPanel.setLayout(new BorderLayout());
    itemGroupTablePanel.init();
    itemGroupTablePanel.setTablePreferencesKey(this.getClass().getName() + "itemGroup_table");
    searchItemGroupPanel = new JFilterItemPanel(itemGroupTablePanel.getTable());
    //    searchItemPanel.setBorder(BorderFactory.createTitledBorder("搜索"));
    //    searchItemPanel.setPreferredSize(new Dimension(super.getPreferredSize().width, 30));
    //    itemsPanel.add(searchItemPanel, BorderLayout.NORTH);
    itemGroupPanel.add(itemGroupTablePanel, BorderLayout.CENTER);
    return this.itemGroupPanel;
  }

  private void createSearchItemPanel() {
    // TODO Auto-generated method stub
  }

  private JPanel createTaskEditPanel() {
    // TODO Auto-generated method stub
    taskFields = createTaskFields();

    List<BillElement> notNullFields = this.billElementMeta.getNotNullBillElement();

    int row = 0;
    int col = 0;
    int colCount = 3;
    taskEditPanel.setLayout(new GridBagLayout());
    for (int i = 0; i < taskFields.size(); i++) {
      AbstractFieldEditor comp = taskFields.get(i);
      JLabel label = new JLabel(comp.getName());
      if (isNotNullField(EbRetrievalTask.class, comp.getFieldName(), notNullFields)) {
        //          label = new AsteriskLabel(comp.getName() + "*");
        label.setText("<html><a>" + comp.getName() + "<font color='red'>*</font></a></html>");
        //          label.setText(comp.getName() + "*");
        //          label.setForeground(new Color(254, 70, 1));
        label.setFont(new Font("宋体", Font.BOLD, 12));
      }
      if (comp.isVisible()) {
        if (comp instanceof TextAreaFieldEditor) {
          //转到新的一行
          row++;
          col = 0;
          comp.setPreferredSize(new Dimension(150 * comp.getOccCol(), comp.getOccRow() * 26));
          taskEditPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(4,
            0, 4, 4), 0, 0));
          taskEditPanel.add(comp, new GridBagConstraints(col + 1, row, comp.getOccCol(), comp.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
            GridBagConstraints.HORIZONTAL, new Insets(4, 0, 4, 4), 0, 0));
          //将当前所占的行空间偏移量计算上
          row += comp.getOccRow();
          col = 0;
          continue;
        } else {
          comp.setPreferredSize(new Dimension(150, 23));
          taskEditPanel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5,
            0, 5, 5), 0, 0));
          taskEditPanel.add(comp, new GridBagConstraints(col + 1, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL,
            new Insets(5, 0, 5, 5), 0, 0));
          if (col == colCount * 2 - 2) {
            row++;
            col = 0;
          } else {
            col += 2;
          }
        }
      }
    }
    return this.taskEditPanel;
  }

  private boolean isNotNullField(Class billClass, String fieldName, List<BillElement> notNullFields) {
    for (BillElement billElement : notNullFields) {
      String name = null;
      try {
        name = (String) FieldMapRegister.get(billClass).get(billElement.getElementCode());
        if (name == null || "".equals(name.trim())) {
          name = ZcUtil.convertColumnToField(billElement.getElementCode());
        }
      } catch (RuntimeException e) {
        name = ZcUtil.convertColumnToField(billElement.getElementCode());
      }
      if (name.equalsIgnoreCase(fieldName))
        return true;
    }
    return false;
  }

  private List<AbstractFieldEditor> createTaskFields() {
    // TODO Auto-generated method stub
    ArrayList<AbstractFieldEditor> fieldLst = new ArrayList<AbstractFieldEditor>();
    TextFieldEditor field = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_SELLER_ID), "sellerId");
    fieldLst.add(field);
    //    String[] names = { ZcElementConstants.FIELD_EB_SELLER_GROUP_GROUP_ID, ZcElementConstants.FIELD_EB_SELLER_GROUP_NAME };
    //    SellerGroupHandler groupHandler = new SellerGroupHandler(names);

    DateFieldEditor startTimeField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TASK_START_TIME),
      "taskStartTime", DateFieldEditor.TimeTypeH24);
    fieldLst.add(startTimeField);
    AsValFieldEditor typeField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_TYPE),
      "retrievalType", ZcSettingConstants.VS_EB_RETRIEVAL_TASK_TYPE);
    fieldLst.add(typeField);
    LongFieldEditor itemQualityField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_SELLING_ITEM_QUALITY),
      "sellingItemQuality");
    fieldLst.add(itemQualityField);
    AsValFieldEditor statusField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_STATUS), "status",
      ZcSettingConstants.VS_EB_RETRIEVAL_TASK_STATUS);
    fieldLst.add(statusField);
    LongFieldEditor totalItemsfield = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_ITEM_QUALITY),
      "totalItemQuality");
    fieldLst.add(totalItemsfield);
    DateFieldEditor anchorField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_ANCHOR_TIME),
      "retrievalAnchorTime", DateFieldEditor.TimeTypeH24);
    fieldLst.add(anchorField);
    LongFieldEditor stepField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_STEP), "step");
    fieldLst.add(stepField);
    field = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TIME_CONSUMING), "timeConsuming");
    fieldLst.add(field);
    LongFieldEditor monthsField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_RETRIEVAL_MONTHS),
      "retrievalMonths");
    fieldLst.add(monthsField);
    MoneyFieldEditor soldAmountField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_SOLD_AMOUNT),
      "totalSoldAmount");
    fieldLst.add(soldAmountField);
    LongFieldEditor soldQualityField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_TOTAL_SOLD_QUALITY),
      "totalSoldQuality");
    fieldLst.add(soldQualityField);
    DateFieldEditor createTimeField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_CREATE_TIME),
      "createTime", DateFieldEditor.TimeTypeH24);
    fieldLst.add(createTimeField);

    AsValFieldEditor analyseStatusField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_STATUS),
      "analyseStatus", ZcSettingConstants.VS_EB_RETRIEVAL_TASK_ANALYSE, true);
    fieldLst.add(analyseStatusField);
    DateFieldEditor dtEditor = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_RETRIEVAL_TASK_ANALYSE_TIME), "analyseTime");
    fieldLst.add(dtEditor);

    String columNames[] = { "集合编号", "集合名称", "备注" };

    SellerGroupFnHandler groupHandler = new SellerGroupFnHandler(columNames);

    ElementConditionDto dto = new ElementConditionDto();

    sellerGroupField = new ForeignEntityFieldEditor("EB_SELLER_GROUP.selectByDto", dto, 20,

    groupHandler, columNames, "卖家集合", "groupId");

    //    editor0.getField().setEnabled(false);

    fieldLst.add(sellerGroupField);

    LongFieldEditor feedbackField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_FEEDBACK), "feedback");
    fieldLst.add(feedbackField);

    AsValFieldEditor attentionStatusField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_ATTENTION_STATUS),
      "attentionStatus", ZcSettingConstants.VS_EB_SELLER_ATTENTION_STATUS, true);
    fieldLst.add(attentionStatusField);
    TextFieldEditor editor11 = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_CONTRY), "contry");
    fieldLst.add(editor11);
    TextFieldEditor imageSiteField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_IMAGE_SITE), "imageSite");
    fieldLst.add(imageSiteField);
    TextAreaFieldEditor remarField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_SELLER_REMARK), "remark", 5000, 3, 5);
    fieldLst.add(remarField);

    return fieldLst;
  }

  private class SellerGroupFnHandler implements IForeignEntityHandler {
    private String columNames[];

    public SellerGroupFnHandler(String columNames[]) {

      this.columNames = columNames;

    }

    @Override
    public void excute(List selectedDatas) {
      // TODO Auto-generated method stub

      for (Object object : selectedDatas) {

        EbSellerGroup group = (EbSellerGroup) object;
        if (currentTask.getEbSeller() != null) {
          currentTask.getEbSeller().setSellerGroup(group);
        }
        currentTask.setGroupId(group.getGroupId());
        sellerGroupField.setEditObject(currentTask);
      }

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

        EbSellerGroup rowData = (EbSellerGroup) showDatas.get(i);

        int col = 0;

        data[i][col++] = rowData.getGroupId();

        data[i][col++] = rowData.getName();

        data[i][col++] = rowData.getRemark();

      }

      MyTableModel model = new MyTableModel(data, columNames) {

        public boolean isCellEditable(int row, int colum) {

          return false;

        }

      };

      return model;
    }

  }

  private void initToolBar() {
    // TODO Auto-generated method stub

    toolBar.setCompoId(compoId);
    toolBar.add(addButton);
    toolBar.add(editButton);
    toolBar.add(saveButton);
    toolBar.add(deleteButton);
    toolBar.add(runButton);
    toolBar.add(suspendButton);
    toolBar.add(stopButton);
    toolBar.add(cancelButton);
    toolBar.add(candidateButton);
    toolBar.add(analysisButton);
    toolBar.add(analysisedButton);
    toolBar.add(changeSellerIdButton);

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doAdd();
      }
    });
    
    changeSellerIdButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          doChangeSellerId();
        }
      });

    editButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doEdit();
      }
    });
    deleteButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doDelete();
      }
    });
    saveButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doSave();
      }
    });
    runButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doRun();
      }
    });
    suspendButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doSuspend();
      }
    });
    stopButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doStop();
      }
    });
    cancelButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doCancel();
      }
    });
    candidateButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doCandidate();
      }
    });
    analysisButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doAnalysis();
      }
    });
    analysisedButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        doAnalysised();
      }
    });
  }

  protected void doChangeSellerId() {
	// TODO Auto-generated method stub
	  if (this.currentTask == null){
		  JOptionPane.showMessageDialog(this, "请选择一个卖家！", "提示", JOptionPane.INFORMATION_MESSAGE);
	      return;
	  }
	  String newSellerId = JOptionPane.showInputDialog("请输入卖家"+this.currentTask.getSellerId()+"更正后的ID：");
	  if(newSellerId==null || newSellerId.trim().length()==0)return;
	  if(existSeller(newSellerId)){
		  JOptionPane.showMessageDialog(this, "卖家"+newSellerId+"已经存在,请重新输入。", "提示", JOptionPane.WARNING_MESSAGE);
		  return;
	  }
	  IEbayRetrievalTaskDelegate ebayREtrievalTaskDelegate = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
		        "ebayRetrievalTaskDelegate");
	  boolean sucess=ebayREtrievalTaskDelegate.changeSellerIdFN(this.currentTask.getSellerId(),newSellerId,requestMeta);
	  
	  if(sucess){
		  this.currentTask.setSellerId(newSellerId);
		  this.taskTablePanel.getTable().updateUI();
		  JOptionPane.showMessageDialog(this, "卖家更新成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
	  }else{
		  JOptionPane.showMessageDialog(this, "卖家更新失败！", "提示", JOptionPane.INFORMATION_MESSAGE);
	  }
}

private boolean existSeller(String newSellerId) {
    
    if (this.taskTablePanel.getDataList() != null) {
      for (int i = 0; i < this.taskTablePanel.getDataList().size(); i++) {
        EbRetrievalTask task = (EbRetrievalTask) this.taskTablePanel.getDataList().get(i);
        if (newSellerId.equalsIgnoreCase(task.getSellerId())) {
          return true;
        }
      }
    }
	return false;
}

protected void doAnalysised() {
    // TODO Auto-generated method stub
    if (this.currentTask == null)
      return;
    this.currentTask.setAnalyseStatus(EbRetrievalTask.ANALYSE_STATUS_YES);
    this.currentTask.setAnalyseTime(Calendar.getInstance().getTime());
    this.doSave();
  }

  protected void doAnalysis() {
    // TODO Auto-generated method stub
    if (this.currentTask == null)
      return;
    this.currentTask.setAnalyseStatus(EbRetrievalTask.ANALYSE_STATUS_ING);
    this.currentTask.setAnalyseTime(Calendar.getInstance().getTime());
    this.doSave();
  }

  protected void doCandidate() {
    // TODO Auto-generated method stub
    int selectRow = this.itemsTablePanel.getTable().getSelectedRow();
    if (selectRow >= 0) {
      int modelRowIndex = this.itemsTablePanel.getTable().convertRowIndexToModel(selectRow);
      BeanTableModel tableModel = (BeanTableModel) this.itemsTablePanel.getTable().getModel();
      EbItem item = (EbItem) tableModel.getBean(modelRowIndex);
      //打开candidateitem界面
      showCandidateItemDialog(item);
    }
  }

  /*
   * 打开候选商品界面
   */
  private void showCandidateItemDialog(EbItem item) {
    // TODO Auto-generated method stub
    //    EbCandidateItem ebCandidateItem = new EbCandidateItem();
    //    if (item.getCandidateStatus() != null) {
    //      ebCandidateItem = getCandidateItem(item.getItemId());
    //      if (ebCandidateItem != null) {
    //
    //        return;
    //      }
    //    }
    new EbCandidateItemDialog(this, item, true);
  }

  private EbCandidateItem getCandidateItem(String itemId) {
    // TODO Auto-generated method stub
    return null;
  }

  private void addItemToCandidate(EbItem item) {
    // TODO Auto-generated method stub
    item.setCandidateStatus(EbCandidateItem.STATUS_CANDIDATE);
  }

  protected void doCancel() {
    // TODO Auto-generated method stub
    this.currentTask = oldTask;
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
    setTask(this.currentTask);
    updateFieldEditorsEditable();
  }

  protected void doStop() {
    // TODO Auto-generated method stub
    this.currentTask.setStatus(EbRetrievalTask.STATUS_STOP);
    IEbayRetrievalTaskDelegate ebayREtrievalTask = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
      "ebayRetrievalTaskDelegate");
    ebayREtrievalTask.saveEbRetrievalTask(currentTask, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_BROWSE);
    removeRunningTask(this.currentTask);
    setTask(this.currentTask);

  }

  protected void doSuspend() {
    // TODO Auto-generated method stub
    // TODO Auto-generated method stub

    this.currentTask.setStatus(EbRetrievalTask.STATUS_SUSPEND);
    IEbayRetrievalTaskDelegate ebayREtrievalTask = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
      "ebayRetrievalTaskDelegate");
    ebayREtrievalTask.saveEbRetrievalTask(currentTask, WorkEnv.getInstance().getRequestMeta(), ZcSettingConstants.PAGE_STATUS_BROWSE);
    removeRunningTask(this.currentTask);
    setTask(this.currentTask);
  }

  private void stopTableEditing(JPageableFixedTable table) {
    if (table.isEditing() && table.getCellEditor() != null) {
      table.getCellEditor().stopCellEditing();
    }
  }

  protected void doRun() {
    // TODO Auto-generated method stub
    if (this.currentTask == null || this.currentTask.getStatus().equals(EbRetrievalTask.STATUS_RUNNING)
      || this.currentTask.getStatus().equals(EbRetrievalTask.STATUS_WAITING)) {
      return;
    }
    this.currentTask.setStatus(EbRetrievalTask.STATUS_RUNNING);

    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(TIME_ZONE));
    this.currentTask.setRetrievalAnchorTime(calendar.getTime());

    RunningTask runningTask = new RunningTask(this.currentTask, this.taskQueue, this);
    this.runningTasks.put(this.currentTask.getSellerId(), runningTask);
    runningTask.start();
    setTask(this.currentTask);
  }

  protected void doSave() {
    // TODO Auto-generated method stub

    if (this.currentTask == null)
      return;
    if (!checkBeforeSave())
      return;
    boolean success = true;
    String errorInfo = "";
    try {
      IEbayRetrievalTaskDelegate ebayREtrievalTaskDelegate = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
        "ebayRetrievalTaskDelegate");
      ebayREtrievalTaskDelegate.saveEbRetrievalTask(this.currentTask, requestMeta, this.pageStatus);
      addTaskToTaskTable();
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      JOptionPane.showMessageDialog(this, "保存成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      updateFieldEditorsEditable();
      setButtonStatus();
      setOldObject();
      return;
    } else {
      JOptionPane.showMessageDialog(this, "保存失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      return;
    }
  }

  private void addTaskToTaskTable() {
    // TODO Auto-generated method stub
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
      BeanTableModel editTableModel = (BeanTableModel) this.taskTablePanel.getTable().getModel();
      editTableModel.insertRow(editTableModel.getRowCount(), this.currentTask);
    }
    ;
  }

  private void updateFieldEditorsEditable() {
    // TODO Auto-generated method stub
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {
      for (AbstractFieldEditor fd : this.taskFields) {
        fd.setEnabled(true);

      }
      this.taskTablePanel.getTable().setEnabled(false);
    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      for (AbstractFieldEditor fd : this.taskFields) {
        fd.setEnabled(false);
      }
      this.taskTablePanel.getTable().setEnabled(true);
    }

  }

  private boolean checkBeforeSave() {
    if (this.currentTask == null)
      return false;

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    StringBuilder errorInfo = new StringBuilder();
    String validateInfo = ZcUtil.validateBillElementNull(this.currentTask, notNullBillElementList);
    if (validateInfo.length() != 0) {
      errorInfo.append("").append(validateInfo.toString()).append("\n");
    }
    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this, errorInfo.toString(), "提示", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    //检查是否已经存在该任务了
    if (this.taskTablePanel.getDataList() != null) {
      for (int i = 0; i < this.taskTablePanel.getDataList().size(); i++) {
        EbRetrievalTask task = (EbRetrievalTask) this.taskTablePanel.getDataList().get(i);
        if (this.currentTask.getSellerId().equalsIgnoreCase(task.getSellerId())) {
          JOptionPane.showMessageDialog(this, "卖家" + this.currentTask.getSellerId() + "检索任务已经存在", "提示", JOptionPane.WARNING_MESSAGE);
          return false;
        }
      }
    }
    return true;
  }

  protected void doDelete() {
    // TODO Auto-generated method stub
    int num = JOptionPane.showConfirmDialog(this, "确认删除当前数据？", "删除确认", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        IEbayRetrievalTaskDelegate ebayREtrievalTask = (IEbayRetrievalTaskDelegate) ServiceFactory.create(IEbayRetrievalTaskDelegate.class,
          "ebayRetrievalTaskDelegate");
        EbSeller seller = new EbSeller();
        seller.setSellerId(this.currentTask.getSellerId());
        ebayServiceDelegate.deleteEbSeller(seller, this.requestMeta);
        int records = ebayREtrievalTask.deleteEbRetrievalTask(this.currentTask, this.requestMeta);
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
        JOptionPane.showMessageDialog(this, "删除成功！", "提示", JOptionPane.INFORMATION_MESSAGE);
        BeanTableModel tableModel = (BeanTableModel) taskTablePanel.getTable().getModel();
        tableModel.getDataBeanList().remove(this.currentTask);
        tableModel.getEditedMap().remove(this.currentTask.getSellerId());
        tableModel.fireTableDataChanged();
        this.currentTask = null;
        setTask(this.currentTask);
        setButtonStatus();
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      } else {
        JOptionPane.showMessageDialog(this, "删除失败 ！\n" + errorInfo, "错误", JOptionPane.ERROR_MESSAGE);
      }
    }
  }

  void fireTaskTableChanged() {
//    BeanTableModel tableModel = (BeanTableModel) taskTablePanel.getTable().getModel();
//    tableModel.fireTableDataChanged();
	  try {
	  SwingUtilities.invokeLater(new Runnable() {			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				taskTablePanel.getTable().updateUI();	
			}
		});	  
		    	
	} catch (Exception e) {
		// TODO: handle exception
		logger.error(e.getMessage(),e);
	}
  }

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
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      bs.addBillStatus(EbRetrievalTask.STATUS_NEW);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.saveButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(EbRetrievalTask.STATUS_NEW);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.deleteButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_NEW);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      bs.addBillStatus(EbRetrievalTask.STATUS_WAITING);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.runButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_NEW);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.stopButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_RUNNING);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      bs.addBillStatus(EbRetrievalTask.STATUS_WAITING);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.suspendButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_RUNNING);
      bs.addBillStatus(EbRetrievalTask.STATUS_WAITING);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.cancelButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.analysisButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      btnStatusList.add(bs);

      bs = new ButtonStatus();
      bs.setButton(this.analysisedButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      btnStatusList.add(bs); 
      
      bs = new ButtonStatus();
      bs.setButton(this.changeSellerIdButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(EbRetrievalTask.STATUS_COMPLETE);
      bs.addBillStatus(EbRetrievalTask.STATUS_EXCEPTION);
      bs.addBillStatus(EbRetrievalTask.STATUS_STOP);
      bs.addBillStatus(EbRetrievalTask.STATUS_SUSPEND);
      btnStatusList.add(bs);
    }

    if (this.currentTask != null) {
      ZcUtil.setButtonEnable(this.btnStatusList, this.currentTask.getStatus(), this.pageStatus, this.compoId, this.currentTask.getProcessInstId());
    } else {
      ZcUtil.setButtonEnable(this.btnStatusList, EbRetrievalTask.STATUS_COMPLETE, this.pageStatus, this.compoId, null);
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
    this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
    EbRetrievalTask task = new EbRetrievalTask();
    EbSeller seller = new EbSeller();
    task.setEbSeller(seller);
    task = setDefaultValue(task);
    //    stopTableEditing(this.taskTablePanel.getTable());
    //    BeanTableModel model = (BeanTableModel) taskTablePanel.getTable().getModel();
    //    model.insertRow(model.getRowCount(), task);
    setTask(task);
    updateFieldEditorsEditable();
    setButtonStatus();
  }

  private EbRetrievalTask setDefaultValue(EbRetrievalTask task) {
    // TODO Auto-generated method stub
    if (task == null) {
      return null;
    }
    task.setStatus(EbRetrievalTask.STATUS_NEW);
    task.setRetrievalType(EbRetrievalTask.RETRIEVAL_TYPE_END_TIME);
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(TIME_ZONE));
    task.setRetrievalAnchorTime(calendar.getTime());
    task.setStep(new Long(30));
    task.setRetrievalMonths(new Long(4));
    task.setCreateTime(calendar.getTime());
    return task;
  }

  public static String getTimeZone() {
    return TIME_ZONE;
  }

  private void setOldObject() {
    oldTask = (EbRetrievalTask) ObjectUtil.deepCopy(this.currentTask);
  }

  /*
   * 检查是否能够新增一个运行任务。
   */
  private synchronized boolean updateTaskLimit(int updateType) {
    if (updateType == this.GET_RUNNING_PERMISION) {
      if (this.current_running_tasks < this.MAX_RUNNING_TASKS) {
        this.current_running_tasks++;
        return true;
      } else {
        return false;
      }
    } else if (updateType == this.RETURN_RUNNING_PERMISION) {
      this.current_running_tasks--;
    }
    return false;
  }

  public void removeRunningTask(EbRetrievalTask task) {
    // TODO Auto-generated method stub
    if (task == null)
      return;
    this.runningTasks.remove(task.getSellerId());
  }

  public static int getItemsPerRequire() {
    return ITEMS_PER_REQUIRE;
  }

  public static int getPageNumber() {
    return PAGE_NUMBER;
  }

  public int getSortTypeNoSorting() {
    return SORT_TYPE_NO_SORTING;
  }

  public int getFiltLimit() {
    return filtLimit;
  }

  public void setFiltLimit(int filtLimit) {
    this.filtLimit = filtLimit;
  }

  public void updateTask(EbRetrievalTask task) {
    // TODO Auto-generated method stub
    if (task == null) {
      return;
    }
    if (this.currentTask.getSellerId().equals(task.getSellerId())) {
      //      setTask(task);
      setButtonStatus();
    }

    fireTaskTableChanged();
  }

  @Override
  public void refresh() {
    // TODO Auto-generated method stub

  }

  @Override
  public void setParentWindow(Window window) {
    // TODO Auto-generated method stub
    this.parentWindow = window;
  }

  @Override
  public Window getParentWindow() {
    // TODO Auto-generated method stub
    return this.parentWindow;
  }

  public JTablePanel getItemsTablePanel() {
    return itemsTablePanel;
  }

  public void updateItemWithCandidateInfo(EbItem ebRetrievalTagertItem) {
    // TODO Auto-generated method stub

    //    this.ebCandidateItemRefLst = this.ebCandidateItemRefLst == null ? new ArrayList<EbCandidateItemRef2>() : this.ebCandidateItemRefLst;
    //
    //    for (int i = 0; i < list.size(); i++) {
    //      EbCandidateItemRef2 ref = list.get(i);
    //      if (!this.ebCandidateItemRefItemIdLst.contains(ref.getEbItem().getItemId())) {
    //        this.ebCandidateItemRefLst.add(ref);
    //        this.ebCandidateItemRefItemIdLst.add(ref.getEbItem().getItemId());
    //        ebCandidateItemRefStatus.put(ref.getEbItem().getItemId(), ref.getEbItem());
    //      }
    //    }
    if (this.currentTask.getSellerId().equals(ebRetrievalTagertItem.getSellerId())) {
      //绑定候选信息到物品上
      setCandidateInfoToItems();
      fireItemTableModelChanged(this.currentTaskItemLst);
    }

  }

  /*
   * 更新已阅信息到物品上
   */
  public void updateItemWithCheckedInfo(String[] itemIds, String candidateStatus) {
    if (this.currentTaskItemLst == null || this.currentTaskItemLst.size() == 0)
      return;
    if (candidateStatus == null) {
      candidateStatus = EbItemChecked.CHECKED;
    }
    for (EbItem ebItem : this.currentTaskItemLst) {
      for (String itemId : itemIds) {
        if (ebItem.getItemId().equals(itemId)) {
          ebItem.setCandidateStatus(candidateStatus);
          break;
        }
      }
    }

  }

  private void fireItemTableModelChanged(List<EbItem> itemLst) {
    // TODO Auto-generated method stub
    BeanTableModel tableModel = (BeanTableModel) this.itemsTablePanel.getTable().getModel();
    //    int select=this.itemsTablePanel.getTable().getSelectedRow();
    tableModel.refreshData(itemLst);
    //    this.itemsTablePanel.getTable();
    //    tableModel.getDataBeanList();
  }

  private class SellerGroupHandler implements IForeignEntityHandler {

    private String columNames[];

    public SellerGroupHandler(String columNames[]) {
      this.columNames = columNames;
    }

    @Override
    public void excute(List selectedDatas) {
      // TODO Auto-generated method stub
      for (Object object : selectedDatas) {
        EbSellerGroup group = (EbSellerGroup) object;
        currentTask.setGroupId(group.getGroupId());
        setTaskTotaskDetailPanel();
      }

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
        EbSellerGroup rowData = (EbSellerGroup) showDatas.get(i);
        int col = 0;
        data[i][col++] = rowData.getGroupId();
        data[i][col++] = rowData.getName();
      }

      MyTableModel model = new MyTableModel(data, columNames) {
        public boolean isCellEditable(int row, int colum) {
          return false;
        }
      };
      return model;
    }

  }

  public void updateTaskInfoWithGroup(EbSellerGroup _group) {
    // TODO Auto-generated method stub
    BeanTableModel<EbRetrievalTask> model = (BeanTableModel<EbRetrievalTask>) this.taskTablePanel.getTable().getModel();
    for (EbRetrievalTask task : model.getDataBeanList()) {
      for (EbSeller seller : _group.getSellerLst()) {
        if (task.getSellerId().equals(seller.getSellerId())) {
          task.setGroupId(_group.getGroupId());
        }
      }
    }
    fireTaskTableChanged();
  }
}

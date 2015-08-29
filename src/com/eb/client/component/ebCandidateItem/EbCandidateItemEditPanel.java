package com.eb.client.component.ebCandidateItem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.eb.client.component.ebRetrievalTask.EbRetrievalTaskPanel;
import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.common.converter.EbCandidateItemRefToTableModelConverter;
import com.ufgov.gk.client.component.GkBaseDialog;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.JTablePanel;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.button.CaculatorButton;
import com.ufgov.gk.client.component.button.DeleteButton;
import com.ufgov.gk.client.component.button.EditButton;
import com.ufgov.gk.client.component.button.ExitButton;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.button.NextButton;
import com.ufgov.gk.client.component.button.PreviousButton;
import com.ufgov.gk.client.component.button.SaveButton;
import com.ufgov.gk.client.component.button.SearchSameEbItemButton;
import com.ufgov.gk.client.component.ui.fieldeditor.AbstractFieldEditor;
import com.ufgov.gk.client.component.zc.AbstractMainSubEditPanel;
import com.ufgov.gk.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.DateFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.ImageAreaFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.LongFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.MoneyFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextAreaFieldEditor;
import com.ufgov.gk.client.component.zc.fieldeditor.TextFieldEditor;
import com.ufgov.gk.client.ebtransport.TransportFeeFactory;
import com.ufgov.gk.client.util.ButtonStatus;
import com.ufgov.gk.client.util.Util;
import com.ufgov.gk.client.util.ZcUtil;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemRef2;
import com.ufgov.gk.common.ebay.model.EbItem;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.ebay.model.EbItemExample;
import com.ufgov.gk.common.ebay.model.EbSeller;
import com.ufgov.gk.common.ebay.model.EbSellerExample;
import com.ufgov.gk.common.ebay.model.EbSellerGroup;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.util.DigestUtil;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class EbCandidateItemEditPanel extends AbstractMainSubEditPanel {

  private static final Logger logger = Logger.getLogger(EbCandidateItemEditPanel.class);

  private String compoId = "EB_CANDIDATE_ITEM";

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private FuncButton addButton = new AddButton();

  private FuncButton saveButton = new SaveButton();

  private FuncButton deleteButton = new DeleteButton();

  private FuncButton previousButton = new PreviousButton();

  private FuncButton editButton = new EditButton();

  private FuncButton caculatorButton = new CaculatorButton();

  private FuncButton nextButton = new NextButton();

  private FuncButton exitButton = new ExitButton();

  private FuncButton searchSameEbItemButton = new SearchSameEbItemButton();

  private FuncButton groupSellerButton = new FuncButton() {
    protected void init() {
      this.funcCtrl = false;
      this.funcId = "febgroup";
      this.defaultText = "���Ҽ�";
      //    this.iconName = "exit.jpg";
      super.init();
    }
  };

  private final ListCursor listCursor;

  private EbCandidateItem oldEbCandidateItem;

  private String tabStatus;

  private EbCandidateItemListPanel listPanel;

  private EbCandidateItemEditPanel self = this;

  private GkBaseDialog parent;

  private String pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;

  private ArrayList<ButtonStatus> btnStatusList = new ArrayList<ButtonStatus>();

  private BillElementMeta billElementMeta;

  private int editFlag = 0;

  int colCount = 2;

  private JTablePanel sellingTablePanel = new JTablePanel();

  private EbRetrievalTaskPanel ebRetrievalTaskPanel;

  private EbItem ebRetrievalTagertItem;

  private boolean isFromRetrievalTaskPanel = false;

  private ImageAreaFieldEditor itemImageField;

  private long soldQuality = 0;//ͳ�Ƴ�����ͬ��Ʒ�������۶�

  private LongFieldEditor totalSoldField;

  private JTable fixTable;

  private JTable chineseTable;

  private List<EbSeller> sellerLst = new ArrayList<EbSeller>();

  private Color groupAlertColor = Color.red;

  private Font groupAlertFont = new Font("����", Font.BOLD, 16);

  public EbCandidateItemEditPanel(EbCandidateItemDialog parent, ListCursor listCursor, String tabStatus, EbCandidateItemListPanel listPanel) {
    // TODO Auto-generated constructor stub
    //    super(EbCandidateItem.class, BillElementMeta.getBillElementMetaWithoutNd("EB_CANDIDATE_ITEM"));
    this.listCursor = listCursor;
    this.tabStatus = tabStatus;
    this.listPanel = listPanel;
    this.parent = parent;
    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(this.compoId),
      TitledBorder.CENTER, TitledBorder.TOP, new Font("����", Font.BOLD, 15), Color.BLUE));
    this.colCount = 3;
    billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(this.compoId);
    //    creatEmptyTable();
    init();
    //    addKeyListener();
    requestMeta.setCompoId(this.compoId);
    refreshData();
    setButtonStatus();
    updateFieldEditorsEditable();
  }

  //  private void addKeyListener() {
  //    // TODO Auto-generated method stub
  //
  //    getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "exitAction");
  //    getActionMap().put("exitAction", new AbstractAction() {
  //      public void actionPerformed(ActionEvent e) {
  //        doExit();
  //      }
  //    });
  //
  //  }

  /*
   * ���ڼ����������򿪵ĺ�ѡ��Ʒ����
   */
  public EbCandidateItemEditPanel(EbCandidateItemDialog parent, EbRetrievalTaskPanel ebRetrievalTaskPanel, ListCursor listCursor, String tabStatus,
    EbCandidateItemListPanel listPanel, EbItem item, boolean isFromRetrievalTaskPanel) {
    // TODO Auto-generated constructor stub
    this.listCursor = listCursor;
    this.tabStatus = tabStatus;
    this.listPanel = listPanel;
    this.ebRetrievalTaskPanel = ebRetrievalTaskPanel;
    this.parent = parent;
    this.ebRetrievalTagertItem = item;
    this.isFromRetrievalTaskPanel = isFromRetrievalTaskPanel;
    this.workPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(this.compoId),
      TitledBorder.CENTER, TitledBorder.TOP, new Font("����", Font.BOLD, 15), Color.BLUE));
    this.colCount = 3;
    billElementMeta = BillElementMeta.getBillElementMetaWithoutNd(this.compoId);
    init();
    requestMeta.setCompoId(this.compoId);
    refreshData();
    setButtonStatus();
    updateFieldEditorsEditable();
  }

  @Override
  public void initToolBar(JFuncToolBar toolBar) {
    // TODO Auto-generated method stub

    toolBar.setModuleCode("ZC");
    toolBar.setCompoId(this.compoId);
    toolBar.add(addButton);
    toolBar.add(editButton);
    toolBar.add(saveButton);
    toolBar.add(deleteButton);
    toolBar.add(searchSameEbItemButton);
    toolBar.add(caculatorButton);
    toolBar.add(groupSellerButton);
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
    searchSameEbItemButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doSearchSameEbItem();
      }
    });
    caculatorButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doCaculator();
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
    groupSellerButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doGroup();
      }
    });
  }

  //�����ҷ��뵽������
  protected void doGroup() {
    // TODO Auto-generated method stub
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    if (ebCandidateItem.getCandidateItemRefLst().size() == 0)
      return;
    JDialog groupDialog = new EbGroupSellerDialog(this, (EbCandidateItem) this.listCursor.getCurrentObject());
    groupDialog.pack();
    Util.moveToScreenCenter(groupDialog);
    groupDialog.setVisible(true);

  }

  public List<EbSeller> getSellerInfo() {
    if (this.sellerLst.size() == 0) {
      _getSellerInfo();
    }
    return this.sellerLst;
  }

  //��ȡ������Ϣ
  private List<EbSeller> _getSellerInfo() {
    // TODO Auto-generated method stub
    List<String> sellerIds = new ArrayList<String>();
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    for (EbCandidateItemRef2 ref : ebCandidateItem.getCandidateItemRefLst()) {
      if (!sellerIds.contains(ref.getEbItem().getSellerId())) {
        sellerIds.add(ref.getEbItem().getSellerId());
      }
    }
    //�ο����ݵĶ�Ӧ�����ҷ����˱仯���ʿ��ܵ�ǰ��õ�����Ϊ��
    if(sellerIds==null || sellerIds.size()==0){
    	this.sellerLst =new ArrayList<EbSeller>();
    	return this.sellerLst;
    }
    EbSellerExample ex = new EbSellerExample();
    ex.createCriteria().andSellerIdIn(sellerIds);
    List<EbSeller> _sellerLst = this.ebayServiceDelegate.getEbSeller(ex, WorkEnv.getInstance().getRequestMeta());
    this.sellerLst = _sellerLst==null?new ArrayList<EbSeller>():_sellerLst;
    return this.sellerLst;
  }

  protected void doCaculator() {
    // TODO Auto-generated method stub
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
      updateFieldEditorsEditable();
      setButtonStatus();
    }
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    if ((ebCandidateItem.getWeight() == null || ebCandidateItem.getWeight().doubleValue() <= 0)
      || (ebCandidateItem.getCost() == null || ebCandidateItem.getCost().doubleValue() <= 0)) {
      return;
    }
    caculatorTransportFee(ebCandidateItem);
    caculateSellingFee(ebCandidateItem);
    caculateProfit(ebCandidateItem);
    setEditingObject(ebCandidateItem);
  }

  private void caculateProfit(EbCandidateItem item) {
    // TODO Auto-generated method stub
    if (item.getCost() != null && item.getTransportFee() != null) {
    	boolean find=false;
      for (int i = 1; i < this.fixTable.getModel().getColumnCount(); i++) {
        String site = this.fixTable.getModel().getColumnName(i);
        if (isSameSite(item.getEbSite(),site)) {

          item.setProfit((BigDecimal) this.fixTable.getModel().getValueAt(3, i));
          item.setProfitRate((BigDecimal) this.fixTable.getModel().getValueAt(4, i));
          find=true;
          break;
        }
      }
      if(!find){
    	  logger.info("not find site in the main site table:"+item.getEbSite());
      }
    }
  }

  private boolean isSameSite(String ebSite, String site) {
	// TODO Auto-generated method stub
	  if(ebSite.equalsIgnoreCase(site)){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("Canada") && site.equalsIgnoreCase("CA")){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("CanadaFrench") && site.equalsIgnoreCase("CA")){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("Australia") && site.equalsIgnoreCase("AU")){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("Germany") && site.equalsIgnoreCase("DE")){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("France") && site.equalsIgnoreCase("FR")){
		  return true;
	  }
	  if(ebSite.equalsIgnoreCase("eBayMotors") && site.equalsIgnoreCase("US")){
		  return true;
	  }
	return false;
}

private void caculatorTransportFee(EbCandidateItem ebCandidateItem) {
    // TODO Auto-generated method stub
    if (ebCandidateItem.getTransportMode() == null)
      return;
    ebCandidateItem.setTransportFee(TransportFeeFactory.getInstance()
      .getTransportFee(ebCandidateItem.getWeight(), ebCandidateItem.getTransportMode()));
  }

  protected void doSearchSameEbItem() {
    // TODO Auto-generated method stub
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_EDIT;
      updateFieldEditorsEditable();
      setButtonStatus();
    }
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    SkuSearchHelper skuHelper = new SkuSearchHelper();
    skuHelper.setSku(ebCandidateItem.getSku());
    JDialog searchDialog = new SearchSameItemDialog(this, skuHelper);
    searchDialog.pack();
    Util.moveToScreenCenter(searchDialog);
    searchDialog.setVisible(true);

  }

  void searchWithSkuSetting(SkuSearchHelper skuHelper) {
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    List<EbCandidateItemRef2> refItemLst = searchSameItemAsRef(ebCandidateItem, skuHelper);
    ebCandidateItem.setCandidateItemRefLst(refItemLst);
    refreshSellingTable(refItemLst);

    //���ݼ����Ľ��������������
    saveCheckedItems(refItemLst);
    updateEbItemInRetrievalTaskPanel();
    updateGroupButtonStatus();
  }

  //�������Ҽ��ϰ�ť���������Ҫ���ü��ϵ����ң���仯������ɫ������ʾ
  private void updateGroupButtonStatus() {
    _getSellerInfo();
    boolean flag = false;
    String groupid = "";
    for (EbSeller seller : getSellerInfo()) {
      if (seller.getGroupId() == null || seller.getGroupId().isEmpty()) {
        flag = true;
        break;
      }
      if (groupid == null || groupid.isEmpty()) {
        groupid = seller.getGroupId();
        continue;
      }
      if (groupid != null && !groupid.equals(seller.getGroupId())) {
        flag = true;
        break;
      }
    }
    if (flag) {
      setGroupBtnStyle(this.groupAlertColor, this.groupAlertFont);
    }
  }

  public void setGroupBtnStyle(Color color, Font font) {
    // TODO Auto-generated method stub
    this.groupSellerButton.setForeground(color);
    this.groupSellerButton.setFont(font);
  }

  protected void doExit() {
    // TODO Auto-generated method stub
    if (ZcSettingConstants.PAGE_STATUS_BROWSE.equals(this.pageStatus) || this.isFromRetrievalTaskPanel) {
      this.parent.dispose();
      return;
    }
    if (isDataChanged()) {
      int num = JOptionPane.showConfirmDialog(this, "��ǰҳ���������޸ģ��Ƿ�Ҫ����", "����ȷ��", 0);
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
      int num = JOptionPane.showConfirmDialog(this, "��ǰҳ���������޸ģ��Ƿ�Ҫ����", "����ȷ��", 0);
      if (num == JOptionPane.YES_OPTION) {
        if (!doSave()) {
          return;
        }
      } else {
        listCursor.setCurrentObject(oldEbCandidateItem);
      }
    }
    listCursor.next();
    setGroupBtnStyle(getDefaultBtnColor(), getDefaultBtnFont());
    refreshData();
    setButtonStatus();

  }

  protected void doPrevious() {
    // TODO Auto-generated method stub
    if (isDataChanged()) {
      int num = JOptionPane.showConfirmDialog(this, "��ǰҳ���������޸ģ��Ƿ�Ҫ����", "����ȷ��", 0);
      if (num == JOptionPane.YES_OPTION) {
        if (!doSave()) {
          return;
        }
      } else {
        listCursor.setCurrentObject(oldEbCandidateItem);
      }
    }
    listCursor.previous();
    setGroupBtnStyle(getDefaultBtnColor(), getDefaultBtnFont());
    refreshData();
    setButtonStatus();

  }

  protected boolean doSave() {
    // TODO Auto-generated method stub
    if (!isDataChanged()) {
      JOptionPane.showMessageDialog(self, "����δ�����仯������Ҫ���棡", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      updateFieldEditorsEditable();
      setButtonStatus();
      return false;
    }
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    if (!checkBeforeSave())
      return false;
    boolean success = true;
    String errorInfo = "";
    try {
      this.ebayServiceDelegate.saveEbCandidateItem(ebCandidateItem, requestMeta, this.pageStatus);
    } catch (Exception e) {
      logger.error(e.getMessage(), e);
      success = false;
      errorInfo += e.getMessage();
    }
    if (success) {
      this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
      this.listCursor.setCurrentObject(ebCandidateItem);
      this.oldEbCandidateItem = (EbCandidateItem) ObjectUtil.deepCopy(ebCandidateItem);

      refreshListPanel();
      if (isFromRetrievalTaskPanel) {
        //        this.ebRetrievalTaskPanel.updateItemWithCandidateInfo(this.ebRetrievalTagertItem);
        updateEbItemInRetrievalTaskPanel();
        clearDataFromRetrievalTaskPanel();
      }

      //      JOptionPane.showMessageDialog(self, "����ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
      updateFieldEditorsEditable();
      setButtonStatus();
      setOldObject();

      return true;
    } else {
      JOptionPane.showMessageDialog(this, "����ʧ�� ��\n" + errorInfo, "����", JOptionPane.ERROR_MESSAGE);
      return false;
    }

  }

  //�����������
  private void updateEbItemInRetrievalTaskPanel() {
    // TODO Auto-generated method stub
    EbCandidateItem item = (EbCandidateItem) this.listCursor.getCurrentObject();
    String[] itemIds = new String[item.getCandidateItemRefLst().size()];
    for (int i = 0; i < item.getCandidateItemRefLst().size(); i++) {
      itemIds[i] = item.getCandidateItemRefLst().get(i).getEbItem().getItemId();
    }
    String status = item.getStatus();
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
      status = EbItemChecked.CHECKED;
    }
    this.ebRetrievalTaskPanel.updateItemWithCheckedInfo(itemIds, status);
  }

  private boolean checkBeforeSave() {
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();

    List notNullBillElementList = this.billElementMeta.getNotNullBillElement();

    StringBuilder errorInfo = new StringBuilder();
    String validateInfo = ZcUtil.validateBillElementNull(ebCandidateItem, notNullBillElementList);
    if (validateInfo.length() != 0) {
      errorInfo.append("").append(validateInfo.toString()).append("\n");
    }
    if (errorInfo.length() != 0) {
      JOptionPane.showMessageDialog(this.parent, errorInfo.toString(), "��ʾ", JOptionPane.WARNING_MESSAGE);
      return false;
    }
    return true;
  }

  public boolean isDataChanged() {
    return !DigestUtil.digest(oldEbCandidateItem).equals(DigestUtil.digest(listCursor.getCurrentObject()));
  }

  protected void doDelete() {
    // TODO Auto-generated method stub
    EbCandidateItem ebCandidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
    int num = JOptionPane.showConfirmDialog(this, "ȷ��ɾ����ǰ���ݣ�", "ɾ��ȷ��", 0);
    if (num == JOptionPane.YES_OPTION) {
      boolean success = true;
      String errorInfo = "";
      try {
        int records = this.ebayServiceDelegate.deleteEbCandidateItem(ebCandidateItem, this.requestMeta);
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
        JOptionPane.showMessageDialog(self, "ɾ���ɹ���", "��ʾ", JOptionPane.INFORMATION_MESSAGE);
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
        this.listCursor.removeCurrentObject();
        refreshData();
        updateFieldEditorsEditable();
        setButtonStatus();
        refreshListPanel();
      } else {
        JOptionPane.showMessageDialog(this, "ɾ��ʧ�� ��\n" + errorInfo, "����", JOptionPane.ERROR_MESSAGE);
      }
    }

  }

  private void refreshListPanel() {
    // TODO Auto-generated method stub
    if (this.listPanel != null)
      this.listPanel.refreshCurrentTabData();
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

    //��������ʱ������Щ������ɼ���������Ĳ���ȫ�����
    clearDataFromRetrievalTaskPanel();

    refreshData();

  }

  /*
   * ��������ʱ������Щ������ɼ���������Ĳ���ȫ�����
   */
  private void clearDataFromRetrievalTaskPanel() {
    // TODO Auto-generated method stub
    this.isFromRetrievalTaskPanel = false;
    this.ebRetrievalTaskPanel = null;
    this.ebRetrievalTagertItem = null;
  }

  @Override
  protected void updateFieldEditorsEditable() {
    super.updateFieldEditors();
    if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_NEW) || this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {
      for (AbstractFieldEditor fd : this.fieldEditors) {
        if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_EDIT)) {
          if (fd.getFieldName() != null && (fd.getFieldName().equals("ebCandidateItemId"))) {
            fd.setEnabled(false);
          } else {
            fd.setEnabled(true);
          }
        } else {
          fd.setEnabled(true);
        }
      }
    } else if (this.pageStatus.equals(ZcSettingConstants.PAGE_STATUS_BROWSE)) {
      for (AbstractFieldEditor fd : this.fieldEditors) {
        if (fd.getFieldName().equals("name") || fd.getFieldName().equals("ebUrl") || fd.getFieldName().equals("tbFullName")
          || fd.getFieldName().equals("tbUrl") || fd.getFieldName().equals("aliUrl")) {
          fd.setEnabled(true);
        } else {
          fd.setEnabled(false);
        }
        //        fd.setEnabled(false);
      }
    }
  }

  @Override
  public List<AbstractFieldEditor> createFieldEditors() {
    // TODO Auto-generated method stub
//    List<AbstractFieldEditor> editorList = new ArrayList<AbstractFieldEditor>();
    //    TextFieldEditor editor = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CANDIDATE_ID), "candidateItemId");
    //    editorList.add(editor);
    //    editor = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_STATUS), "status");
    //    editorList.add(editor);
    //    ImageAreaFieldEditor imageField = new ImageAreaFieldEditor(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_IMAGE_URL, "imageUrl", 9, 2);
    //    editorList.add(imageField);

    return fieldEditors;
  }

  protected void initFieldEditorPanel() {
    fieldEditors = new ArrayList<AbstractFieldEditor>();

    fieldEditorPanel.setLayout(new GridBagLayout());

    TextFieldEditor editor = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CANDIDATE_ID), "candidateId");
    addFieldToPanel(editor, 0, 0, fieldEditorPanel);//0��0��
    AsValFieldEditor statusField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_STATUS), "status",
      ZcSettingConstants.VS_EB_CANDIDATE_ITEM_STATUS, false);
    addFieldToPanel(statusField, 2, 0, fieldEditorPanel);//0��3��
    itemImageField = new ImageAreaFieldEditor(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_IMAGE_URL, "ebImageUrl", 11, 2);
    itemImageField.setBorder(new LineBorder(Color.YELLOW, 2));
    itemImageField.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          showBigImage();
        }
      }
    });
    addFieldToPanel(itemImageField, 4, 0, fieldEditorPanel);//0��5��
    MoneyFieldEditor priceField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_PRICE), "ebPrice", 2);
    addFieldToPanel(priceField, 0, 1, fieldEditorPanel);//1��0��
    MoneyFieldEditor ebShippingFeeField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SHIPPING_FEE),
      "ebShippingFee", 2);
    addFieldToPanel(ebShippingFeeField, 2, 1, fieldEditorPanel);//1��3��
    totalSoldField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SOLD_QUALITY), "ebSoldQuality");
    addFieldToPanel(totalSoldField, 0, 2, fieldEditorPanel);//2��0��
    MoneyFieldEditor sellingPerDayField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_SELLING_PER_DAY),
      "sellingPerDay", 2);
    addFieldToPanel(sellingPerDayField, 2, 2, fieldEditorPanel);//2��3��
    TextFieldEditor currencyIdField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CURRENCY_ID),
      "currencyId");
    addFieldToPanel(currencyIdField, 0, 3, fieldEditorPanel);//3��0��
    TextFieldEditor ebSiteField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_SITE), "ebSite");
    addFieldToPanel(ebSiteField, 2, 3, fieldEditorPanel);//3��3��
    LongFieldEditor totalSellingDaysField = new LongFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_SELLING_DAYS),
      "sellingDays");
    addFieldToPanel(totalSellingDaysField, 0, 4, fieldEditorPanel);//4��0��
    TextFieldEditor timeLeftField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_IS_SELLING), "isSelling");
    addFieldToPanel(timeLeftField, 2, 4, fieldEditorPanel);//4��3��
    DateFieldEditor startTimeField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_START_TIME), "startTime",
      DateFieldEditor.TimeTypeH24);
    addFieldToPanel(startTimeField, 0, 5, fieldEditorPanel);//5��0��
    DateFieldEditor endTimeField = new DateFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_END_TIME), "endTime",
      DateFieldEditor.TimeTypeH24);
    addFieldToPanel(endTimeField, 2, 5, fieldEditorPanel);//5��3��
    TextAreaFieldEditor nameField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_NAME), "name", 500, 1,
      3);
    addFieldToPanel(nameField, 0, 6, fieldEditorPanel);//6��0��
    TextAreaFieldEditor urlField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_EB_URL), "ebUrl", 500,
      1, 3);
    addFieldToPanel(urlField, 0, 7, fieldEditorPanel);//7��0��
    MoneyFieldEditor weightField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_WEIGHT), "weight", 0);
    addFieldToPanel(weightField, 0, 8, fieldEditorPanel);//8��0��
    //    TextFieldEditor transportModeField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TRANSPORT_MODE),
    //      "transportMode");
    AsValFieldEditor transportModeField = new AsValFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TRANSPORT_MODE),
      "transportMode", ZcSettingConstants.VS_EB_TRANSPORT_MODE, false);
    addFieldToPanel(transportModeField, 2, 8, fieldEditorPanel);//8��3��
    //    TextFieldEditor categoryModeField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_CATEGORY_ID),
    //      "categoryId");
    //    addFieldToPanel(categoryModeField, 4, 8, fieldEditorPanel);//8��5��
    MoneyFieldEditor costField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_COST), "cost", 2);
    addFieldToPanel(costField, 0, 9, fieldEditorPanel);//9��0��
    MoneyFieldEditor tranportFeeField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TRANSPORT_FEE),
      "transportFee", 2);
    addFieldToPanel(tranportFeeField, 2, 9, fieldEditorPanel);//9��3��
    //    TextFieldEditor skuField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_SKU), "sku");
    //    addFieldToPanel(skuField, 4, 9, fieldEditorPanel);//9��5��
    MoneyFieldEditor profitField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_PROFIT), "profit", 2);
    addFieldToPanel(profitField, 0, 10, fieldEditorPanel);//10��0��
    MoneyFieldEditor profitRateField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_PROFIT_RATE),
      "profitRate", 2);
    addFieldToPanel(profitRateField, 2, 10, fieldEditorPanel);//10��3��

  }

  protected void showBigImage() {
    // TODO Auto-generated method stub
    String imageId = getImageId();

    URL path = this.getClass().getResource(ZcSettingConstants.IMAGE_DIRECTROY_FOR_CANDIDATE + imageId + ".jpg");
    if (path != null) {
      try {
        Image itemImage = ImageIO.read(path);
        ImageIcon ic = new ImageIcon(itemImage);
        JLabel label = new JLabel(ic);
        label.setPreferredSize(new Dimension(ic.getIconWidth(), ic.getIconHeight()));
        //        final 
        final JDialog f = new JDialog(this.parent);
        //        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(label);
        f.addKeyListener(new KeyListener() {

          @Override
          public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub
            //            System.out.println("key type:" + e.getKeyCode());
            //            System.out.println("key char:" + e.getKeyChar());
            //            System.out.println("key KeyText:" + e.getKeyText(e.getKeyCode()));
            if (e.getKeyCode() == 0x0) {
              f.dispose();
            }
          }

          @Override
          public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

          }

          @Override
          public void keyPressed(KeyEvent e) {
            // TODO Auto-generated method stub

          }
        });
        f.pack();
        Util.moveToScreenCenter(f);
        f.setVisible(true);
        //        f.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
        //          KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK), "saveAction");
        //        getActionMap().put("saveAction", new AbstractAction() {
        //          public void actionPerformed(ActionEvent e) {
        //            f.dispose();
        //          }
        //        });

      } catch (IOException e) {
        // TODO Auto-generated catch block
        logger.error("����" + imageId + ".jpg ����" + e.getMessage(), e);
        e.printStackTrace();
      }
    }
  }

  private void addFieldToPanel(AbstractFieldEditor editor, int col, int row, JPanel panel) {
    // TODO Auto-generated method stub
    /*
     * GridBagConstraints(int gridx, int gridy,
                              int gridwidth, int gridheight,
                              double weightx, double weighty,
                              int anchor, int fill,
                              Insets insets, int ipadx, int ipady)
                  �����÷��μ�com.eb.client.component.test.TestGridBagLayOut                        
     */
    fieldEditors.add(editor);
    if (editor instanceof ImageAreaFieldEditor) {
      editor.setPreferredSize(new Dimension(150 * editor.getOccCol(), editor.getOccRow() * 23));
      panel.add(editor, new GridBagConstraints(col, row, editor.getOccCol(), editor.getOccRow(), 1.0, 1.0, GridBagConstraints.CENTER,
        GridBagConstraints.BOTH, new Insets(2, 0, 2, 2), 0, 0));

    } else {
      JLabel label = new JLabel(editor.getName());
      editor.setPreferredSize(new Dimension(150 * editor.getOccCol(), 23 * editor.getOccRow()));
      panel.add(label, new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 2, 2), 0,
        0));
      panel.add(editor, new GridBagConstraints(col + 1, row, editor.getOccCol(), editor.getOccRow(), 1.0, 1.0, GridBagConstraints.WEST,
        GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2), 0, 0));
    }
  }

  @Override
  public JComponent createSubBillPanel() {
    // TODO Auto-generated method stub
    JTabbedPane tabbedPanel = new JTabbedPane();
    JPanel tbAliPanl = createTbAliPanel();
    //    JPanel fixPriceSellingPanel = createFixPriceSellingPanel();
    //    JPanel chineseSellingPanel = createChineseSellingPrice();
    JPanel sellingFeePanel = createSellingFeePanel();
    JPanel ebSellingsPanel = createSellingPanel();
    tabbedPanel.add("�������", ebSellingsPanel);
    tabbedPanel.add("���۷���", sellingFeePanel);
    tabbedPanel.add("����", tbAliPanl);
    //    tabbedPanel.add("һ�ڼ�", fixPriceSellingPanel);
    //    tabbedPanel.add("����", chineseSellingPanel);
    tabbedPanel.setSelectedIndex(0);
    return tabbedPanel;
  }

  private JPanel createSellingFeePanel() {
    // TODO Auto-generated method stub
    JPanel pp = new JPanel();
    JPanel fixPriceSellingPanel = createFixPriceSellingPanel();
    JPanel chineseSellingPanel = createChineseSellingPanel();
    fixPriceSellingPanel.setPreferredSize(new Dimension(800, 150));
    chineseSellingPanel.setPreferredSize(new Dimension(800, 150));
    pp.setLayout(new FlowLayout());
    pp.add(fixPriceSellingPanel);
    pp.add(chineseSellingPanel);
    //    pp.setLayout(new GridBagLayout());
    //    pp.add(fixPriceSellingPanel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2,
    //      0, 2, 2), 0, 0));
    //    pp.add(chineseSellingPanel, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0,
    //      2, 2), 0, 0));
    //    pp.setLayout(new BorderLayout());
    //    pp.add(fixPriceSellingPanel, BorderLayout.NORTH);
    //    pp.add(chineseSellingPanel, BorderLayout.CENTER);
    return pp;
  }

  private JPanel createSellingPanel() {
    // TODO Auto-generated method stub
    sellingTablePanel = new JTablePanel();
    sellingTablePanel.init();
    sellingTablePanel.setTablePreferencesKey(this.getClass().getName() + "sellings_table");
    sellingTablePanel.getTable().setShowCheckedColumn(false);
    sellingTablePanel.getTable().getTableRowHeader().setPreferredSize(new Dimension(50, 0));
    return sellingTablePanel;
  }

  private JPanel createChineseSellingPanel() {
    // TODO Auto-generated method stub
    chineseTable = new JTable();
    EbCaculator ca = new EbCaculator();
    chineseTable.setModel(ca.getChineseTableModel());
    JScrollPane sc = new JScrollPane();
    sc.getViewport().add(chineseTable);
    chineseTable.setPreferredScrollableViewportSize(new Dimension(700, 200));
    //    sc.getHorizontalScrollBar().setPreferredSize(new Dimension(0, UIConstants.HORIZONTAL_SCROLLBAR__HEIGHT));
    //    // scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
    //    sc.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    //    sc.add(fixTable);
    //    fitTable(fixTable, sc);
    //    fixTable.revalidate();
    JPanel pp = new JPanel();
    pp.setLayout(new BorderLayout());
    pp.add(sc, BorderLayout.CENTER);
    pp.setBorder(new TitledBorder("����"));
    return pp;
  }

  private JPanel createFixPriceSellingPanel() {
    // TODO Auto-generated method stub
    fixTable = new JTable();
    EbCaculator ca = new EbCaculator();
    fixTable.setModel(ca.getFixTableModel());
    JScrollPane sc = new JScrollPane();
    sc.getViewport().add(fixTable);
    fixTable.setPreferredScrollableViewportSize(new Dimension(700, 200));
    //    sc.getHorizontalScrollBar().setPreferredSize(new Dimension(0, UIConstants.HORIZONTAL_SCROLLBAR__HEIGHT));
    //    // scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
    //    sc.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    //    sc.add(fixTable);
    //    fitTable(fixTable, sc);
    //    fixTable.revalidate();
    JPanel pp = new JPanel();
    pp.setLayout(new BorderLayout());
    pp.add(sc, BorderLayout.CENTER);
    pp.setBorder(new TitledBorder("һ�ڼ�"));

    return pp;
  }

  public void fitTable(final JTable table, JScrollPane sc) {
    sc.getHorizontalScrollBar().setValue(0);
    sc.getVerticalScrollBar().setValue(0);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          fitColumnWidth(table);
        } catch (Exception e) {
        }
      }
    });

  }

  private void fitColumnWidth(JTable table) {
    //    for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {
    //      table.getTableHeader().fitColumnWidth(j);
    //    }
  }

  private JPanel createTbAliPanel() {
    // TODO Auto-generated method stub
    JPanel panel = new JPanel();
    panel.setLayout(new GridBagLayout());

    MoneyFieldEditor tbPriceField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_PRICE), "tbPrice", 2);
    addFieldToPanel(tbPriceField, 0, 0, panel);//0��0��
    MoneyFieldEditor tbShippingFeeField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_SHIPPING_FEE),
      "tbShippingFee");
    addFieldToPanel(tbShippingFeeField, 2, 0, panel);//0��3��
    TextFieldEditor tbNameField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_FULL_NAME), "tbFullName",
      600);
    tbNameField.setOccCol(5);
    addFieldToPanel(tbNameField, 0, 1, panel);//1��0��
    TextFieldEditor tbUrlField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_URL), "tbUrl", 200);
    tbUrlField.setOccCol(5);
    addFieldToPanel(tbUrlField, 0, 2, panel);//2��0��
    TextAreaFieldEditor tbRemarkField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_TB_REMARK),
      "tbRemark", 200, 3, 5);
    addFieldToPanel(tbRemarkField, 0, 3, panel);//3��0��
    //---ali---
    MoneyFieldEditor aliPriceField = new MoneyFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_PRICE), "aliPrice",
      2);
    addFieldToPanel(aliPriceField, 0, 6, panel);//6��0��
    TextFieldEditor aliUrlField = new TextFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_URL), "aliUrl", 200);
    aliUrlField.setOccCol(5);
    addFieldToPanel(aliUrlField, 0, 7, panel);//7��0��
    TextAreaFieldEditor aliRemarkField = new TextAreaFieldEditor(LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_ALI_REMARK),
      "aliRemark", 200, 3, 5);
    aliRemarkField.setOccCol(5);
    addFieldToPanel(aliRemarkField, 0, 8, panel);//8��0��

    JPanel pp = new JPanel();
    pp.setLayout(new BorderLayout());
    pp.add(panel, BorderLayout.NORTH);

    return pp;
  }

  /**
   * ���ù������ϰ�ť�Ŀ�����
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
      bs.setButton(this.searchSameEbItemButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
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

      bs = new ButtonStatus();
      bs.setButton(this.caculatorButton);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_EDIT);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_NEW);
      bs.addPageStatus(ZcSettingConstants.PAGE_STATUS_BROWSE);
      bs.addBillStatus(ZcSettingConstants.BILL_STATUS_ALL);
      btnStatusList.add(bs);
    }
    EbCandidateItem obj = (EbCandidateItem) (this.listCursor.getCurrentObject());
    ZcUtil.setButtonEnable(this.btnStatusList, ZcSettingConstants.BILL_STATUS_ALL, this.pageStatus, this.compoId, obj.getProcessInstId());
  }

  private void refreshData() {

    EbCandidateItem ebCandidateItem = (EbCandidateItem) listCursor.getCurrentObject();

    if (isFromRetrievalTaskPanel) {
      ebCandidateItem = getEbcandidateItemByRefItemId(this.ebRetrievalTagertItem);
      if (ebCandidateItem == null) {
        //����Ŀ��item������ѡitem
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
        ebCandidateItem = createCandidateItemByTargetItem(this.ebRetrievalTagertItem);
        ebCandidateItem.setCandidateItemRefLst(searchSameItemAsRef(ebCandidateItem, null));
        List lst = new ArrayList();
        lst.add(ebCandidateItem);
        this.listCursor.setDataList(lst, -1);
        //�����������Ʒ
        saveCheckedItems(ebCandidateItem.getCandidateItemRefLst());
        updateEbItemInRetrievalTaskPanel();
      } else {
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_BROWSE;
        List lst = new ArrayList();
        lst.add(ebCandidateItem);
        this.listCursor.setDataList(lst, -1);
      }
    } else {
      if (ebCandidateItem == null) {//����ҳ��
        this.pageStatus = ZcSettingConstants.PAGE_STATUS_NEW;
        ebCandidateItem = new EbCandidateItem();
        setDefualtValue(ebCandidateItem, ZcSettingConstants.PAGE_STATUS_NEW);
        List lst = new ArrayList();
        lst.add(ebCandidateItem);
        this.listCursor.setDataList(lst, -1);
      } else {
        ebCandidateItem = ebayServiceDelegate.getEbCandidateItemByID(ebCandidateItem.getCandidateId(), requestMeta);
      }
    }

    List<EbCandidateItemRef2> detailList = new ArrayList<EbCandidateItemRef2>();
    if (ebCandidateItem != null && (ebCandidateItem.getCandidateItemRefLst() == null || ebCandidateItem.getCandidateItemRefLst().size() == 0)) {
      detailList = ebayServiceDelegate.getEbCandidateItemRef2(ebCandidateItem.getCandidateId(), requestMeta);
      ebCandidateItem.setCandidateItemRefLst(detailList);
    }

    refreshSubTableData(ebCandidateItem);
    listCursor.setCurrentObject(ebCandidateItem);
    this.setEditingObject(ebCandidateItem);
    setOldObject();

    //���ز�����ͼƬ
    showItemImage(ebCandidateItem.getItemId(), ebCandidateItem.getImageUrl());

    updateFieldEditorsEditable();
    setButtonStatus();
    updateGroupButtonStatus();
  }

  private void saveCheckedItems(List<EbCandidateItemRef2> candidateItemRefLst) {
    // TODO Auto-generated method stub
    if (candidateItemRefLst == null)
      return;
    List<EbItemChecked> items = new ArrayList<EbItemChecked>();
    List<String> itemIds = new ArrayList<String>();
    int i = 0;
    for (EbCandidateItemRef2 ref : candidateItemRefLst) {
      EbItemChecked item = new EbItemChecked();
      item.setItemId(ref.getEbItem().getItemId());
      itemIds.add(ref.getEbItem().getItemId());
      item.setSellerId(ref.getEbItem().getSellerId());
      items.add(item);
      i++;
      if (i >= 1000) {//��in () �ķ�ʽ������ʱ�����������1000��������oracle���������ݿ�δ֪)
        ebayServiceDelegate.deleteEbItemCheckeds(itemIds, requestMeta);
        itemIds.clear();
        i = 0;
      }
    }
    if (itemIds.size() > 0) {
      ebayServiceDelegate.deleteEbItemCheckeds(itemIds, requestMeta);
    }
    ebayServiceDelegate.saveEbItemCheckeds(items, requestMeta);
  }

  //  public void deleteCheckedItems() {
  //    EbCandidateItem candidateItem = (EbCandidateItem) this.listCursor.getCurrentObject();
  //    if (candidateItem == null || candidateItem.getCandidateItemRefLst() == null)
  //      return;
  //    List<String> itemIds = new ArrayList<String>();
  //    for (EbCandidateItemRef2 ref : candidateItem.getCandidateItemRefLst()) {
  //      itemIds.add(ref.getEbItem().getItemId());
  //    }
  //    ebayServiceDelegate.deleteEbItemCheckeds(itemIds, requestMeta);
  //  }

  private EbCandidateItem createCandidateItemByTargetItem(EbItem item) {
    // TODO Auto-generated method stub
    EbCandidateItem ebCandidateItem = new EbCandidateItem();
    ebCandidateItem.setCandidateId(item.getItemId());
    ebCandidateItem.setItemId(item.getItemId());
    ebCandidateItem.setCategoryId(item.getCategoryId());
    ebCandidateItem.setName(item.getName());
    ebCandidateItem.setEbUrl(item.getUrl());
    ebCandidateItem.setEbPrice(item.getPrice());
    ebCandidateItem.setEbShippingFee(item.getShippingFee());
    ebCandidateItem.setEbSoldQuality(item.getSoldQuality());
    ebCandidateItem.setStatus(EbCandidateItem.STATUS_CANDIDATE);
    ebCandidateItem.setCurrencyId(item.getCurrencyId());
    ebCandidateItem.setEbFullName(item.getName());
    ebCandidateItem.setEbSite(item.getSiteId());
    ebCandidateItem.setStartTime(item.getStartTime());
    ebCandidateItem.setEndTime(item.getEndTime());
    ebCandidateItem.setSellingDays(item.getSellingDays());
    ebCandidateItem.setSellingPerDay(item.getSellingPerDay());
    ebCandidateItem.setIsSelling(item.getTimeLeft());
    ebCandidateItem.setEbImageUrl(item.getImageUrl());
    ebCandidateItem.setImageUrl(item.getImageUrl());
    ebCandidateItem.setSku(item.getSku());
    ebCandidateItem.setTransportMode(ZcSettingConstants.TRANSPORT_MODE_XIAOBAO);
    return ebCandidateItem;
  }

  /*
   * ������ʾitem��ͼƬ
   */
  private void showItemImage(final String itemId, final String imageUrl) {
    // TODO Auto-generated method stub
    //Ŀǰ��ô���ã�ֱ�Ӷ����ж��ļ����ڲ�,�����ļ������ڷ�������
    String imageId = getImageId();
    // if (!imageExist(itemId)) {
    if (imageId == null) {
      Thread t = new Thread(new Runnable() {
        public void run() {
          _downloadImage(itemId, imageUrl);
          showImage(itemId);
        }
      });
      t.start();
    } else {
      showImage(imageId);
    }
  }

  /**
   * ���ݵ�ǰ��ѡ���󣬼���Ƿ��Ѿ�������ͼƬ�����ڵĻ�����ͼƬ��Ӧ��id�����򷵻�null
   * @param itemId
   * @return
   * Administrator
   * Dec 5, 2012
   */
  private String getImageId() {
    // TODO Auto-generated method stub
    EbCandidateItem cur = (EbCandidateItem) this.listCursor.getCurrentObject();
    if (imageExist(cur.getCandidateId())) {
      return cur.getCandidateId();
    }
    if (cur.getCandidateItemRefLst() != null) {
      for (EbCandidateItemRef2 ref2 : cur.getCandidateItemRefLst()) {
        if (imageExist(ref2.getEbItem().getItemId())) {
          return ref2.getEbItem().getItemId();
        }
      }
    }
    return null;
  }

  /*
   * ��ʾͼƬ
   */
  protected void showImage(String itemId) {
    // TODO Auto-generated method stub
    // EbCandidateItem cur = (EbCandidateItem) this.listCursor.getCurrentObject();
    // if (itemId.equals(cur.getItemId())) {//��ǰ��������ʾ��item�Ǹ�ͼƬ��item��������ʾ
    URL path = this.getClass().getResource(ZcSettingConstants.IMAGE_DIRECTROY_FOR_CANDIDATE + itemId + ".jpg");
    if (path == null) {//��ʾĬ��ͼƬ
      path = this.getClass().getResource(ZcSettingConstants.DEFAULT_IMAGE_NAME);
    }
    if (path != null) {
      try {
        Image itemImage = ImageIO.read(path);
        itemImageField.setImage(itemImage);
        this.repaint();
        //          this.validate();
        //          this.repaint();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        logger.error("����" + itemId + ".jpg ����" + e.getMessage(), e);
        e.printStackTrace();
      }
    }

    //}
  }

  private void _downloadImage(String itemId, String imageUrl) {
    // TODO Auto-generated method stub
    if (imageUrl == null) {
      return;
    }
    HttpURLConnection connect = null;
    BufferedInputStream in = null;
    FileOutputStream file = null;
    int BUFFER_SIZE = 1024;
    byte[] buf = new byte[BUFFER_SIZE];
    int size = 0;

    try {
      String fileName = itemId + ".jpg";

      String fullFileName = getAbsolutePath(fileName);

      URL url = new URL(imageUrl);
      connect = (HttpURLConnection) url.openConnection();
      connect.connect();
      in = new BufferedInputStream(connect.getInputStream());
      file = new FileOutputStream(fullFileName);
      while ((size = in.read(buf)) != -1) {
        file.write(buf, 0, size);
      }
      System.out.println(fileName + "���سɹ�,url=" + imageUrl);
    } catch (MalformedURLException e) {
      logger.error("fail");
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
      logger.error("fail");
    } finally {
      try {
        if (file != null)
          file.close();
        if (in != null)
          in.close();
      } catch (IOException e) {
        //        e.printStackTrace();
      }
      connect.disconnect();
    }

  }

  /*
   * ��ȡ����·��
   */
  private String getAbsolutePath(String fileName) {
    // TODO Auto-generated method stub
    String path = "";
    File directory = new File("");
    try {
      //      System.out.println(directory.getCanonicalPath());//��ȡ��׼��·��
      //      System.out.println(directory.getAbsolutePath());//��ȡ����·��
      path = directory.getAbsolutePath();

      //      ����Ĺؼ���String.replaceAll()����regular expression ����Ϊ�����ġ�����java������ַ�������ת���\Ҳ�����ƵĴ���
      //      ���ȣ�java��ѡ�\\\\�����ͳ�һ���ַ���(���а�������char)������\ \�������������JDK���ĵ��￴���ġ� 
      //      ������������replaceAll����������ʽ��Ϊ���������ԡ�\\�������ͳ�һ��regex��
      //      ����һ��regex��˵��ʹ�����һ���ַ������ǡ�\�����Ժ�����Ǹ�4��\��˵�����ջᱻ���ͳɡ�\���� 
      path = path + ZcSettingConstants.IMAGE_DIRECTROY_FOR_CANDIDATE.replaceAll("/", "\\\\");
      directory = new File(path);
      if (!directory.isDirectory()) {
        directory.mkdirs();
      }
      path = path + fileName;
    } catch (Exception e) {
      logger.error("��ȡ����·������," + e.getMessage(), e);
      e.printStackTrace();
    }
    return path;
  }

  /*
   * �ж�ͼƬ�Ƿ����
   */
  private boolean imageExist(String itemId) {
    // TODO Auto-generated method stub
    if (this.getClass().getResource(ZcSettingConstants.IMAGE_DIRECTROY_FOR_CANDIDATE + itemId + ".jpg") == null) {
      return false;
    }
    return true;
  }

  /**
   * ���ݵ�ǰ��ѡitem����Ϣ��ȥitems�л�ȡ��ͬ��item
   * һ�����������������������1�����ƣ�2��sku
   * @param ebCandidateItem
   * @param skuHelper 
   * @return
   * Administrator
   * Jul 17, 2012
   */
  private List<EbCandidateItemRef2> searchSameItemAsRef(EbCandidateItem ebCandidateItem, SkuSearchHelper skuHelper) {
    // TODO Auto-generated method stub
    List<EbCandidateItemRef2> refItemLst = new ArrayList<EbCandidateItemRef2>();
    if (skuHelper == null) {
      skuHelper = new SkuSearchHelper();
      skuHelper.setIllegibility(false);//Ĭ���Ǿ�ȷ����
      skuHelper.setSku(ebCandidateItem.getSku() == null ? "" : ebCandidateItem.getSku());
    }
    String candidateId = ebCandidateItem.getItemId();
    EbItemExample ex = new EbItemExample();
    ex.createCriteria().andNameEqualTo(ebCandidateItem.getName());
    @SuppressWarnings("unchecked")
    List<EbItem> itemLst1 = ebayServiceDelegate.getEbItem(ex, requestMeta);
    ex = new EbItemExample();
    String sku = skuHelper.getSku() == null ? "" : skuHelper.getSku().trim();
    if (skuHelper.isIllegibility() && !sku.isEmpty()) {
      sku = sku + "%";
    }
    ex.createCriteria().andSkuLike(sku);
    @SuppressWarnings("unchecked")
    List<EbItem> itemLst2 = ebayServiceDelegate.getEbItem(ex, requestMeta);

    itemLst1 = itemLst1 == null ? new ArrayList<EbItem>() : itemLst1;
    itemLst2 = itemLst2 == null ? new ArrayList<EbItem>() : itemLst2;

    ArrayList<String> keyLst = new ArrayList<String>();
    this.soldQuality = 0;
    for (EbItem ebItem : itemLst1) {
      if (!keyLst.contains(ebItem.getItemId())) {
        keyLst.add(ebItem.getItemId());
        this.soldQuality += ebItem.getSoldQuality().longValue();
        EbCandidateItemRef2 ref = new EbCandidateItemRef2();
        ref.setCandidateId(candidateId);
        ebItem.setCandidateStatus(EbCandidateItem.STATUS_CANDIDATE);
        ref.setEbItem(ebItem);
        refItemLst.add(ref);
      }
    }
    for (EbItem ebItem : itemLst2) {
      if (!keyLst.contains(ebItem.getItemId())) {
        keyLst.add(ebItem.getItemId());
        this.soldQuality += ebItem.getSoldQuality().longValue();
        EbCandidateItemRef2 ref = new EbCandidateItemRef2();
        ref.setCandidateId(candidateId);
        ref.setEbItem(ebItem);
        refItemLst.add(ref);
      }
    }
    ebCandidateItem.setEbSoldQuality(this.soldQuality);
    this.totalSoldField.setValue(ebCandidateItem);
    return refItemLst;
  }

  private EbCandidateItem getEbcandidateItemByRefItemId(EbItem ebRetrievalTagertItem) {
    // TODO Auto-generated method stub
    EbCandidateItem ebCandidateItem = ebayServiceDelegate.getEbCandidateItemByRefItemId(ebRetrievalTagertItem.getItemId(), requestMeta);
    return ebCandidateItem;
  }

  private void refreshSubTableData(EbCandidateItem ebCandidateItem) {
    refreshSellingTable(ebCandidateItem.getCandidateItemRefLst());
    caculateSellingFee(ebCandidateItem);
  }

  private void refreshSellingTable(List<EbCandidateItemRef2> refItemLst) {
    EbCandidateItemRefToTableModelConverter mc = new EbCandidateItemRefToTableModelConverter();
    sellingTablePanel.setTableModel(mc.convertToTableModel(refItemLst));
  }

  private void caculateSellingFee(EbCandidateItem ebCandidateItem) {
    // TODO Auto-generated method stub
    EbCaculator ca = new EbCaculator();
    this.chineseTable.setModel(ca.cacualateChineseFee(ebCandidateItem));
    this.fixTable.setModel(ca.cacualateFixPriceFee(ebCandidateItem));
    this.chineseTable.validate();
    this.chineseTable.repaint();
    this.fixTable.validate();
    this.fixTable.repaint();
  }

  private void setOldObject() {
    if (isFromRetrievalTaskPanel) {
      oldEbCandidateItem = new EbCandidateItem();
    } else {
      oldEbCandidateItem = (EbCandidateItem) ObjectUtil.deepCopy(listCursor.getCurrentObject());
    }
  }

  private void setDefualtValue(EbCandidateItem ebCandidateItem, String pageStatusNew) {
    // TODO Auto-generated method stub
    if (pageStatusNew.equals(ZcSettingConstants.PAGE_STATUS_NEW)) {
      ebCandidateItem.setCandidateId("temp" + System.currentTimeMillis());
      ebCandidateItem.setStatus(EbCandidateItem.STATUS_CANDIDATE);
      ebCandidateItem.setTransportMode(ZcSettingConstants.TRANSPORT_MODE_XIAOBAO);
    }
  }

  JDialog getOwner() {
    return this.parent;
  }

  public Color getDefaultBtnColor() {
    // TODO Auto-generated method stub
    return this.exitButton.getBackground();
  }

  public Font getDefaultBtnFont() {
    // TODO Auto-generated method stub
    return this.exitButton.getFont();
  }

  //������������ϵ����Ҽ�����Ϣ
  public void updateTaskInfoWithGroup(EbSellerGroup _group) {
    // TODO Auto-generated method stub
    this.ebRetrievalTaskPanel.updateTaskInfoWithGroup(_group);
  }
}

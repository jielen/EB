package com.eb.client.component.ebCandidateItem;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.TableModel;

import com.eb.client.component.IAppMenuCompo;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.MyTableModel;
import com.ufgov.gk.client.common.ParentWindowAware;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.common.converter.EbCandidateItemToTableModelConverter;
import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.table.codecellrenderer.AsValCellRenderer;
import com.ufgov.gk.client.component.ui.AbstractDataDisplay;
import com.ufgov.gk.client.component.ui.AbstractEditListBill;
import com.ufgov.gk.client.component.ui.AbstractSearchConditionArea;
import com.ufgov.gk.client.component.ui.MultiDataDisplay;
import com.ufgov.gk.client.component.ui.SaveableSearchConditionArea;
import com.ufgov.gk.client.component.ui.TableDisplay;
import com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.gk.client.component.ui.conditionitem.SearchConditionUtil;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.gk.client.util.ListUtil;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.ebay.model.EbCandidateItem;
import com.ufgov.gk.common.ebay.model.EbCandidateItemExample;
import com.ufgov.gk.common.ebay.publish.IEbayServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.gk.common.system.util.ObjectUtil;
import com.ufgov.smartclient.common.DefaultInvokeHandler;
import com.ufgov.smartclient.common.UIUtilities;
import com.ufgov.smartclient.component.table.JGroupableTable;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;

public class EbCandidateItemListPanel extends AbstractEditListBill implements ParentWindowAware, IAppMenuCompo {

  private String compoId = "EB_CANDIDATE_ITEM";

  private EbCandidateItemListPanel self = this;

  private Window parentWindow;

  public String getCompoId() {
    return compoId;
  }

  private AbstractSearchConditionArea topSearchConditionArea;

  private RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();

  private IEbayServiceDelegate ebayServiceDelegate = (IEbayServiceDelegate) ServiceFactory.create(IEbayServiceDelegate.class, "ebayServiceDelegate");

  private ElementConditionDto elementConditionDto = new ElementConditionDto();

  public EbCandidateItemListPanel() {
    UIUtilities.asyncInvoke(new DefaultInvokeHandler<List<SearchCondition>>() {
      @Override
      public List<SearchCondition> execute() throws Exception {
        List<SearchCondition> needDisplaySearchConditonList = SearchConditionUtil.getNeedDisplaySearchConditonList(WorkEnv.getInstance()
          .getCurrUserId(), ZcSettingConstants.TAB_ID_EB_CANDIDATE_ITEM);
        return needDisplaySearchConditonList;
      }

      @Override
      public void success(List<SearchCondition> needDisplaySearchConditonList) {
        List<TableDisplay> showingDisplays = SearchConditionUtil.getNeedDisplayTableDisplay(needDisplaySearchConditonList);

        init(createDataDisplay(showingDisplays), null);//调用父类方法
        revalidate();
        repaint();
      }
    });
    requestMeta.setCompoId(compoId);

  }

  public Window getParentWindow() {
    return parentWindow;
  }

  public void setParentWindow(Window parentWindow) {
    this.parentWindow = parentWindow;
  }

  private AbstractSearchConditionArea createTopConditionArea() {
    Map defaultValueMap = new HashMap();
    topSearchConditionArea = new SaveableSearchConditionArea(ZcSettingConstants.CONDITION_ID_EB_CANDIDATE_ITEM, null, false, defaultValueMap, null);

    return topSearchConditionArea;
  }

  private AbstractDataDisplay createDataDisplay(List<TableDisplay> showingDisplays) {
    return new DataDisplay(SearchConditionUtil.getAllTableDisplay(ZcSettingConstants.TAB_ID_EB_CANDIDATE_ITEM), showingDisplays,
      createTopConditionArea(), false);//true:显示收索条件区 false：不显示收索条件区
  }

  private AddButton addButton = new AddButton();

  @Override
  protected void addToolBarComponent(JFuncToolBar toolBar) {
    toolBar.setModuleCode("ZC");
    toolBar.setCompoId(compoId);
    toolBar.add(addButton);

    // 初始化按钮的action事件

    addButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        doAdd();
      }
    });
  }

  private void doAdd() {
    new EbCandidateItemDialog(self, new ArrayList(), this.topDataDisplay.getActiveTableDisplay().getTable().getRowCount(), topDataDisplay
      .getActiveTableDisplay().getStatus());
  }

  private final class DataDisplay extends MultiDataDisplay {

    private DataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays, AbstractSearchConditionArea conditionArea,
      boolean showConditionArea) {
      super(displays, showingDisplays, conditionArea, showConditionArea, ZcSettingConstants.TAB_ID_EB_CANDIDATE_ITEM);
      setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), LangTransMeta.translate(compoId), TitledBorder.CENTER,
        TitledBorder.TOP, new Font("宋体", Font.BOLD, 15), Color.BLUE));
    }

    protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays) {
      for (final TableDisplay d : showingTableDisplays) {
        final JGroupableTable table = d.getTable();
        table.setPreferencesKey(this.getClass().getName() + "_table");
        table.setPreferenceStore(GkPreferencesStore.preferenceStore());
        table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && SwingUtilities.isLeftMouseButton(e)) {
              String tabStatus = d.getStatus();
              JGroupableTable table = d.getTable();
              MyTableModel model = (MyTableModel) table.getModel();
              int row = table.getSelectedRow();
              List viewList = (List) ObjectUtil.deepCopy(ListUtil.convertToTableViewOrderList(model.getList(), table));           
              new EbCandidateItemDialog(self, viewList, row, tabStatus);
            }
          }
        });
      }
    }

    @Override
    protected void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems, final TableDisplay tableDisplay) {
      //      elementConditionDto.setWfcompoId(compoId);
      //      elementConditionDto.setExecutor(WorkEnv.getInstance().getCurrUserId());
      //      elementConditionDto.setNd(WorkEnv.getInstance().getTransNd());
      //      elementConditionDto.setStatus(tableDisplay.getStatus());
      //      elementConditionDto.setMonth(BalanceUtil.getMonthIdBySysOption());

      for (AbstractSearchConditionItem item : searchConditionItems) {
        item.putToElementConditionDto(elementConditionDto);
      }

      final Container c = tableDisplay.getTable().getParent();

      UIUtilities.asyncInvoke(new DefaultInvokeHandler<TableModel>() {

        @Override
        public void before() {
          assert c != null;
          installLoadingComponent(c);
        }

        @Override
        public void after() {
          assert c != null;
          unInstallLoadingComponent(c);
          c.add(tableDisplay.getTable());
          setTableCellRender(tableDisplay.getTable());
        }

        @Override
        public TableModel execute() throws Exception {
          EbCandidateItemToTableModelConverter mc = new EbCandidateItemToTableModelConverter();
          return mc.convertToTableModel(self.ebayServiceDelegate.getEbCandidateItem(createEbCandidateItemExample(tableDisplay.getStatus()),
            requestMeta));
        }

        @Override
        public void success(TableModel model) {
          tableDisplay.setTableModel(model);
          setButtonStatus();
        }
      });
    }

    protected EbCandidateItemExample createEbCandidateItemExample(String status) {
      // TODO Auto-generated method stub
      EbCandidateItemExample ex = new EbCandidateItemExample();
      if (EbCandidateItem.STATUS_CANDIDATE.equals(status) || EbCandidateItem.STATUS_RECOMMEND.equals(status)
        || EbCandidateItem.STATUS_VERY_RECOMMEND.equals(status) || EbCandidateItem.STATUS_SELLING.equals(status)
        || EbCandidateItem.STATUS_CHEAP_FOR_SALE.equals(status)) {
        ex.createCriteria().andStatusEqualTo(status);
      }
      return ex;
    }

  }

  private void setButtonStatus() {
  }

  protected void setTableCellRender(JTable table) {
    //    // TODO Auto-generated method stub
    //        NumberFormat numberFormat = NumberFormat.getInstance();
    //        numberFormat.setMinimumFractionDigits(5);
    //        NumberCellRenderer numCellRender = new NumberCellRenderer(numberFormat);
    AsValCellRenderer statusRender = new AsValCellRenderer(ZcSettingConstants.VS_EB_CANDIDATE_ITEM_STATUS);
    SwingUtil.setTableCellRenderer(table, LangTransMeta.translate(ZcElementConstants.FIELD_EB_CANDIDATE_ITEM_STATUS), statusRender);

  }

  public void refreshCurrentTabData() {
    topSearchConditionArea.doSearch();
  }

  public void refreshCurrentTabData(List dataList) {
    EbCandidateItemToTableModelConverter mc = new EbCandidateItemToTableModelConverter();
    topDataDisplay.getActiveTableDisplay().getTable().setModel(mc.convertToTableModel(dataList));
  }

  public static void main(String[] args) throws Exception {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          UIManager.setLookAndFeel(new BlueLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }
        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
        EbCandidateItemListPanel bill = new EbCandidateItemListPanel();
        JFrame frame = new JFrame("frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(bill);
        frame.setVisible(true);

      }
    });
  }

  @Override
  public void refresh() {
    // TODO Auto-generated method stub
    refreshCurrentTabData();
  }
}

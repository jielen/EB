package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.ufgov.gk.client.component.JListSelectDialog;
import com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.smartclient.component.table.JGroupableTable;

/**
 * <p>Title: GK</p>
 * <p>Description: 数据展示区域</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>创建时间: 2009-4-20</p>
 * @author 刘永伟(manlge)
 * @version 1.0
 */
public abstract class AbstractDataDisplay extends JPanel {

  /**
   * 条件区域
   */
  private AbstractSearchConditionArea conditionArea;

  protected JTabbedPane tabbedPane = new JTabbedPane();
  
  
  protected boolean firstRefresh=true;

  /**
   * 全部TableDisplay
   */
  private List<TableDisplay> allTableDisplays = new ArrayList<TableDisplay>();

  /**
   * 正在显示的TableDisplay
   */
  private List<TableDisplay> showingTableDisplays = new ArrayList<TableDisplay>();

  public List<TableDisplay> getShowingTableDisplays() {
    return showingTableDisplays;
  }

  public void setShowingTableDisplays(List<TableDisplay> showingTableDisplays) {
    this.showingTableDisplays = showingTableDisplays;
  }

  /*
   * 保存风格用的id
   */
  private String prefId = null;

  /**
   * @param displays 所有的TableDisplay
   * @param showingDisplays 需要显示的TableDisplay
   * @param conditionArea 搜索条件显示区域
   * @param showConditionArea 是否显示条件区域
   */
  public AbstractDataDisplay(TableDisplay[] allTableDisplays, TableDisplay[] showingTableDisplays,
    AbstractSearchConditionArea conditionArea, boolean showConditionArea, String prefId) {
    this(Arrays.asList(allTableDisplays), Arrays.asList(showingTableDisplays), conditionArea,
      showConditionArea,true ,prefId);
  }
  
  public AbstractDataDisplay(TableDisplay[] allTableDisplays, TableDisplay[] showingTableDisplays,
    AbstractSearchConditionArea conditionArea, boolean showConditionArea,boolean firstRefresh,String prefId) {
    this(Arrays.asList(allTableDisplays), Arrays.asList(showingTableDisplays), conditionArea,
      showConditionArea,firstRefresh ,prefId);
  }
  
 

  /**
   * @param displays 所有的TableDisplay
   * @param showingDisplays 需要显示的TableDisplay
   * @param conditionArea 搜索条件显示区域
   * @param showConditionArea 是否显示条件区域
   */
  public AbstractDataDisplay(List<TableDisplay> displays, List<TableDisplay> showingDisplays,
    AbstractSearchConditionArea conditionArea, boolean showConditionArea,boolean firstRefresh, String prefId) {
    this.allTableDisplays = displays;
    this.showingTableDisplays = showingDisplays;
    this.conditionArea = conditionArea;
    this.prefId = prefId;
    if(conditionArea!=null){
      conditionArea.setDataDisplay(this);
    }
    setShowConditionArea(showConditionArea);
    addComponents();
    refreshTabbedPane();//初始化不要用线程
    installListeners();
   

    
    if(firstRefresh){
      refreshModelData();//初始化时设置默认值
    }
   
  }

  private void addComponents() {
    setLayout(new BorderLayout());
    if(conditionArea!=null){
      add(conditionArea, BorderLayout.NORTH);
    }
  
    add(tabbedPane, BorderLayout.CENTER);
    //    add(conditionArea, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.13, GridBagConstraints.WEST,
    //      GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
    //    add(tabbedPane, new GridBagConstraints(0, 1, 1, 1, 1.0, 0.87, GridBagConstraints.WEST,
    //      GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0, 0));
  }

  protected void addTabDisplayPanel(TableDisplay tableDispaly) {
    this.remove(tabbedPane);
    add(tableDispaly, BorderLayout.CENTER);
  }

  /**
   * 刷新数据
   */
  public  void refreshModelData() {
    TableDisplay selectedComponent = (TableDisplay) tabbedPane.getSelectedComponent();
    if (selectedComponent != null) {
      JGroupableTable table = selectedComponent.getTable();
      table.setPreferencesKey( prefId);
      table.setPreferenceStore(GkPreferencesStore.preferenceStore());
      if(conditionArea!=null){
        handleTableDisplayActived(conditionArea.getShowingConditionItems(), selectedComponent);
      }
      else{
        handleTableDisplayActived( new AbstractSearchConditionItem[0], selectedComponent);
      }      
    }
  }


  public  void refreshModelDataLater() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        refreshModelData();
      }
    });
  }

  /**
   * 执行刷新页签
   */
  private void refreshTabbedPane() {
    tabbedPane.removeAll();
    preprocessShowingTableDisplay(showingTableDisplays);
    
    for( TableDisplay td:showingTableDisplays){
      td.getTable().setPreferencesKey( prefId);
      td.getTable().setPreferenceStore(GkPreferencesStore.preferenceStore());
    }
    
    for (int i = 0; i < showingTableDisplays.size(); i++) {
      TableDisplay d = showingTableDisplays.get(i);
      tabbedPane.add(d);
      d.repaint();
    }
    tabbedPane.revalidate();
    tabbedPane.repaint();
  }
  
  protected void preprocessShowingTableDisplay(List<TableDisplay> showingTableDisplays){
    
  }

  /**
   * 多线程刷新刷新页签
   */
  private void refreshTabbedPaneLater() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        refreshTabbedPane();
      }
    });
  }

  /**
   *添加监听
   */
  private void installListeners() {
    tabbedPane.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        refreshModelDataLater();
      }
    });

  }

  /**
   * 显示标签选择对话框
   */
  public void showTabSelectDialog() {
    final JListSelectDialog  dlg = new JListSelectDialog(null, true, "设置页签") {
      public void doOk() {
        List rightObjects = this.getSelectedItem();
        if (rightObjects.size() == 0) {
          JOptionPane.showMessageDialog(this, "必须选择一个页签", "警告", JOptionPane.WARNING_MESSAGE);
          return ;
        }
        showingTableDisplays = new ArrayList<TableDisplay>();
        for (int i = 0; i < rightObjects.size(); i++) {
          TableDisplay tempd= (TableDisplay) rightObjects.get(i);
          TableDisplay d = new TableDisplay(tempd.getName());
          d.setStatus(tempd.getStatus());
          d.setSearchCondition(tempd.getSearchCondition());
          showingTableDisplays.add(d);
        }
        refreshTabbedPaneLater();
        saveSelectedTableDisplays(showingTableDisplays.toArray(new TableDisplay[showingTableDisplays.size()]));
        this.close();
      }
    };
    dlg.setLeftList(allTableDisplays);
    dlg.setRightList(showingTableDisplays);
    dlg.setVisible(true);

  }

  /**
   * 页签激时，进行数据搜索，该方法子类必须覆盖
   * @param searchConditionItems
   * @param tableDisplay
   */
  protected abstract void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems,
    TableDisplay tableDisplay);

  /**
   * 保存已经选择的页签到数据库，子类覆盖实现保存
   * @param displays
   */
  protected void saveSelectedTableDisplays(TableDisplay[] displays) {

  }

  /**
   * 返回是否显示条件区域
   * @return
   */
  public boolean isShowConditionArea() {
    return conditionArea.isVisible();
  }

  /**
   * 设置是显示条区域
   * @param showConditionArea
   */
  public void setShowConditionArea(boolean showConditionArea) {
    if(conditionArea!=null){
      conditionArea.setVisible(showConditionArea);
    }

  }

  public TableDisplay[] getTableDisplays() {
    return allTableDisplays.toArray(new TableDisplay[allTableDisplays.size()]);
  }

  /**
   * 返回处于显示状态的TableDisplay对象
   * @return
   */
  public TableDisplay getActiveTableDisplay() {
    if (tabbedPane.getSelectedComponent() == null) {
      return allTableDisplays.get(0);//下面显示区
    }
    return (TableDisplay) tabbedPane.getSelectedComponent();
  }

  public AbstractSearchConditionArea getConditionArea() {
    return conditionArea;
  }

  public JTabbedPane getTabbedPane() {
    return tabbedPane;
  }
}

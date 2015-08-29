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
 * <p>Description: ����չʾ����</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class AbstractDataDisplay extends JPanel {

  /**
   * ��������
   */
  private AbstractSearchConditionArea conditionArea;

  protected JTabbedPane tabbedPane = new JTabbedPane();
  
  
  protected boolean firstRefresh=true;

  /**
   * ȫ��TableDisplay
   */
  private List<TableDisplay> allTableDisplays = new ArrayList<TableDisplay>();

  /**
   * ������ʾ��TableDisplay
   */
  private List<TableDisplay> showingTableDisplays = new ArrayList<TableDisplay>();

  public List<TableDisplay> getShowingTableDisplays() {
    return showingTableDisplays;
  }

  public void setShowingTableDisplays(List<TableDisplay> showingTableDisplays) {
    this.showingTableDisplays = showingTableDisplays;
  }

  /*
   * �������õ�id
   */
  private String prefId = null;

  /**
   * @param displays ���е�TableDisplay
   * @param showingDisplays ��Ҫ��ʾ��TableDisplay
   * @param conditionArea ����������ʾ����
   * @param showConditionArea �Ƿ���ʾ��������
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
   * @param displays ���е�TableDisplay
   * @param showingDisplays ��Ҫ��ʾ��TableDisplay
   * @param conditionArea ����������ʾ����
   * @param showConditionArea �Ƿ���ʾ��������
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
    refreshTabbedPane();//��ʼ����Ҫ���߳�
    installListeners();
   

    
    if(firstRefresh){
      refreshModelData();//��ʼ��ʱ����Ĭ��ֵ
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
   * ˢ������
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
   * ִ��ˢ��ҳǩ
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
   * ���߳�ˢ��ˢ��ҳǩ
   */
  private void refreshTabbedPaneLater() {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        refreshTabbedPane();
      }
    });
  }

  /**
   *��Ӽ���
   */
  private void installListeners() {
    tabbedPane.addChangeListener(new ChangeListener() {
      public void stateChanged(ChangeEvent e) {
        refreshModelDataLater();
      }
    });

  }

  /**
   * ��ʾ��ǩѡ��Ի���
   */
  public void showTabSelectDialog() {
    final JListSelectDialog  dlg = new JListSelectDialog(null, true, "����ҳǩ") {
      public void doOk() {
        List rightObjects = this.getSelectedItem();
        if (rightObjects.size() == 0) {
          JOptionPane.showMessageDialog(this, "����ѡ��һ��ҳǩ", "����", JOptionPane.WARNING_MESSAGE);
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
   * ҳǩ��ʱ�����������������÷���������븲��
   * @param searchConditionItems
   * @param tableDisplay
   */
  protected abstract void handleTableDisplayActived(AbstractSearchConditionItem[] searchConditionItems,
    TableDisplay tableDisplay);

  /**
   * �����Ѿ�ѡ���ҳǩ�����ݿ⣬���า��ʵ�ֱ���
   * @param displays
   */
  protected void saveSelectedTableDisplays(TableDisplay[] displays) {

  }

  /**
   * �����Ƿ���ʾ��������
   * @return
   */
  public boolean isShowConditionArea() {
    return conditionArea.isVisible();
  }

  /**
   * ��������ʾ������
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
   * ���ش�����ʾ״̬��TableDisplay����
   * @return
   */
  public TableDisplay getActiveTableDisplay() {
    if (tabbedPane.getSelectedComponent() == null) {
      return allTableDisplays.get(0);//������ʾ��
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

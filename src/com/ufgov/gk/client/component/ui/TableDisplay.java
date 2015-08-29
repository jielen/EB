package com.ufgov.gk.client.component.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.SimpleRowFilter;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.smartclient.component.table.JGroupableTable;
import com.ufgov.smartclient.component.table.fixedtable.JFixedTable;

/**
 * <p>Title: GK</p>
 * <p>Description: ��ʾ���������ͱ������</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public class TableDisplay extends JComponent {

  private TableDisplay self = this;

  private Map attributes = new HashMap();

  public static TableDisplay[] createTableDisplays(Object[] names) {
    List<TableDisplay> list = new ArrayList<TableDisplay>();
    for (Object obj : names) {
      list.add(new TableDisplay(obj.toString()));
    }
    return list.toArray(new TableDisplay[list.size()]);
  }

  /**
   * ��ѯ���������
   */
  protected JTextField searchConditionTextField = new JTextField(30);

  /**
   * ��ʾ����JScrollPane
   */
  private JScrollPane scrollPane = new JScrollPane();

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setScrollPane(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  /**
   * ��ʾ���ݵı��
   */
  protected JGroupableTable table;

  /**
   * ������ݹ�����
   */
  private TableRowSorter tableSorter = new TableRowSorter();

  /**
   * ҳǩ״̬��ʾ
   */
  private String status;

  private SearchCondition searchCondition;

  private SummarizedResultPanel sumPanel;

  /**
   * @param name ���ƣ�������ʾ�ڱ�ע���еı�������
   * @param model
   */
  public TableDisplay(String name, TableModel model) {
    init();
    installListeners();
    setName(name);
    setTableModel(model);
  }

  public TableDisplay(String name) {
    init();
    installListeners();
    setName(name);
  }

  private void installListeners() {
    searchConditionTextField.addKeyListener(new KeyAdapter() {
      @Override
      public void keyReleased(KeyEvent e) {
        tableSorter.setRowFilter(new SimpleRowFilter(searchConditionTextField
          .getText()));
        fireSorterValueChanged();
        self.revalidate();
        self.repaint();
      }
    });
  }

  public void addSorterValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
  }

  public void removeSorterValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireSorterValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList
      .getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }

  private void init() {
    setLayout(new GridBagLayout());
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 1, 1));
    panel.add(new JLabel("���ң�"));
    searchConditionTextField.setPreferredSize(new Dimension(120, 20));
    panel.add(searchConditionTextField);
    add(panel, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0,
      GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
        0), 0, 0));

    scrollPane.getHorizontalScrollBar().setPreferredSize(
      new Dimension(0, UIConstants.HORIZONTAL_SCROLLBAR__HEIGHT));
    add(scrollPane, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0,
      GridBagConstraints.WEST, GridBagConstraints.BOTH, new Insets(0, 0, 0, 0), 0,
      0));
    //    setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder()));
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));

    scrollPane.getHorizontalScrollBar().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseReleased(MouseEvent e) {
        getTable().savePreferences();
      }
    });
  }

  /**
   * ���ñ���model
   * @param model
   */
  public void setTableModel(TableModel model) {

    JGroupableTable t = getTable();
    t.setModel(model);

    tableSorter.setModel(model);
    t.setRowSorter(tableSorter);
    scrollPane.getViewport().setView(table);
    // Ĭ�����ù�����λ��
    this.getScrollPane().getHorizontalScrollBar().setValue(0);
    this.getScrollPane().getVerticalScrollBar().setValue(0);
    // �����Զ��п�
    for (int j = 0; j < getTable().getColumnModel().getColumnCount(); j++) {
      getTable().getTableHeader().fitColumnWidth(j);
    }
    scrollPane.revalidate();
    scrollPane.repaint();

  }

  /**
   * ���ñ��
   * @param atable
   */
  public void setTable(JGroupableTable atable) {
    this.table = atable;
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        scrollPane.getViewport().setView(table);
        scrollPane.revalidate();
        scrollPane.repaint();
      }
    });
  }

  /**
   * ���ر��
   * @return
   */
  public JGroupableTable getTable() {
    if (table == null) {
      table = createTable();
    }
    if (table.getParent() == null) {
      scrollPane.getViewport().setView(table);
    }
    return table;
  }

  /**
   * �����������ɸ��Ǹ÷���
   * @return
   */
  protected JGroupableTable createTable() {
    final JFixedTable newTable = SwingUtil.createTable(JFixedTable.class);
    newTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    return newTable;
  }

  @Override
  public int hashCode() {
    String name = getName();
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    String name = getName();
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    TableDisplay other = (TableDisplay) obj;
    if (name == null) {
      if (other.getName() != null)
        return false;
    } else if (!name.equals(other.getName()))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return getName();
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setSearchCondition(SearchCondition searchCondition) {
    this.searchCondition = searchCondition;
  }

  public SearchCondition getSearchCondition() {
    return searchCondition;
  }

  public void setAttribute(String key, Object attr) {
    attributes.put(key, attr);
  }

  public Object getAttribute(String key) {
    return attributes.get(key);
  }

  public void setSummarizedResultPanel(SummarizedResultPanel panel) {
    if (panel == null) {
      remove(this.sumPanel);
      this.sumPanel = null;
      return;
    }
    panel.setSumTable(table);
    this.sumPanel = panel;
    add(sumPanel, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
      GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
        0), 0, 0));
    this.invalidate();
    this.validate();
    this.repaint();
  }

  public SummarizedResultPanel getSummarizedResultPanel() {
    return sumPanel;
  }

  private JComponent bottomComponent;

  public void setBottomComponent(JComponent bottomComponent) {
    if (this.bottomComponent != null) {
      remove(this.bottomComponent);
    }
    this.bottomComponent = bottomComponent;
    add(bottomComponent, new GridBagConstraints(0, 2, 1, 1, 1.0, 0.0,
      GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0,
        0), 0, 0));
    this.invalidate();
    this.validate();
    this.repaint();
  }

  public JComponent getBottomComponent() {
    return this.bottomComponent;
  }

  public TableRowSorter getTableSorter() {
    return tableSorter;
  }
}

package com.ufgov.gk.client.report;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.JBasePanel;
import com.ufgov.gk.client.component.SimpleRowFilter;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.common.commonbiz.model.BaseReportBill;
import com.ufgov.smartclient.component.table.JLayerTable;
import com.ufgov.smartclient.component.table.JLayerTableHeader;

public class JLayerTablePanel extends JBasePanel {

  private JLayerTablePanel self = this;

  private JLabel searchLabel = new JLabel("查找：");

  private JTextField searchField = new JTextField(30);

  public JLayerTable table = SwingUtil.createTable(JLayerTable.class);

  public JLayerTableHeader tableHeader = table.getTableHeader();

  private List<BaseReportBill> dataList = new ArrayList<BaseReportBill>();
  
  private List<BaseReportBill> groupList = new ArrayList<BaseReportBill>();

  public JLayerTablePanel() {
    super();
  }

  public JLayerTablePanel(String key) {
    super(key);
  }

  public JLayerTablePanel(JLayerTable table) {
    super();
    this.table = table;
  }

  protected JPanel searchBar = new JPanel();

  protected TableRowSorter tableSorter = new TableRowSorter();

  protected void initSearchBar() {
    searchBar.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    searchBar.add(searchLabel);
    searchBar.add(searchField);
    searchField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        tableSorter.setRowFilter(new SimpleRowFilter(searchField.getText()));
        tableSorterValueChanged();
        table.revalidate();
        table.repaint();
        self.revalidate();
        self.repaint();
      }
    });
  }

  protected void tableSorterValueChanged() {

  }

  public void setTablePreferencesKey(String key) {
    table.setPreferencesKey(key);
    table.setPreferenceStore(GkPreferencesStore.preferenceStore());
  }

  public JLayerTable getTable() {
    return table;
  }

  public TableRowSorter getTableSorter() {
    return tableSorter;
  }

  private void initTable() {
    table.setGridColor(Color.BLACK);
    table.setRowSorter(tableSorter);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setPreferredScrollableViewportSize(new Dimension(700, 150));
  }

  private JScrollPane scrollPane = new JScrollPane();

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setScrollPane(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  public void init() {
    this.initSearchBar();
    this.initTable();
    this.setLayout(new BorderLayout());
    this.add(searchBar, BorderLayout.NORTH);
    scrollPane.getViewport().add(table);
    scrollPane.getHorizontalScrollBar().setPreferredSize(
      new Dimension(0, UIConstants.HORIZONTAL_SCROLLBAR__HEIGHT));
    scrollPane.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    this.add(scrollPane, BorderLayout.CENTER);
    getScrollPane().getHorizontalScrollBar().addMouseListener(new MouseAdapter() {
      public void mouseReleased(MouseEvent e) {
        getTable().savePreferences();
      }
    });
  }

  public void setTableModel(TableModel dataModel) {
    this.table.setModel(dataModel);
    this.tableSorter.setModel(dataModel);
    this.table.revalidate();
    this.table.repaint();
    this.repaint();
  }

  public void setHeaderValue(Map headerValueMap) {
    TableColumnModel tcm = table.getColumnModel();
    for (int i = 0; i < tcm.getColumnCount(); i++) {
      TableColumn tableColumn = tcm.getColumn(i);
      String identifier = (String) tableColumn.getIdentifier();
      tableColumn.setHeaderValue(headerValueMap.get(identifier));
    }
  }

  public List<BaseReportBill> getDataList() {
    return dataList;
  }

  public void setDataList(List<BaseReportBill> dataList) {
    this.dataList = dataList;
  }

  public List<BaseReportBill> getGroupList() {
    return groupList;
  }

  public void setGroupList(List<BaseReportBill> groupList) {
    this.groupList = groupList;
  }

  public void repaintLayerTablePanel() {
    this.init();
    DefaultTableModel model = new DefaultTableModel() {
      public Class getColumnClass(int column) {
        if ((column >= 0) && (column < getColumnCount()) && this.getRowCount() > 0) {
          for (int row = 0; row < this.getRowCount(); row++) {
            if (getValueAt(row, column) != null) {
              return getValueAt(row, column).getClass();
            }
          }
        }
        return Object.class;
      }
    };
    model.setColumnIdentifiers(getColumnIdentifierVector());
    this.setTablePreferencesKey(getTablePreferencesKey());
    this.setTableModel(model);
    this.tableSorter.setModel(model);
    this.initTableHeader();
    this.initTableData();
  }

  //设置表头信息
  protected void initTableHeader() {

  }

  //设置数据信息
  protected void initTableData() {

  }

  //设置ColumnIdentifier
  protected Vector<String> getColumnIdentifierVector() {
    Vector<String> columnIdentifierVector = new Vector<String>();
    return columnIdentifierVector;
  }

  //设置保存风格key
  protected String getTablePreferencesKey() {
    return this.getClass().getName();
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
    IllegalAccessException, UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JLayerTablePanel panel = new JLayerTablePanel();
    panel.init();
    DefaultTableModel model = new DefaultTableModel(3, 3);
    panel.setTableModel(model);

    JFrame f = new JFrame();
    f.getContentPane().add(panel);

    f.setSize(800, 600);
    f.setVisible(true);
    f.setLocationRelativeTo(null);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

  }

}

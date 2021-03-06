package com.ufgov.gk.client.component;

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

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.eb.client.component.ebRetrievalTask.JFilterItemPanel;
import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

public class JTablePanel extends JBasePanel {

  private JTablePanel self = this;

  private JLabel searchLabel = new JLabel("���ң�");

  private JTextField searchField = new JTextField(30);

  private JPageableFixedTable table = SwingUtil.createTable(JPageableFixedTable.class);

  private List dataList = new ArrayList();

  boolean showEbFilterPanel = false;

  private JFilterItemPanel ebFilterItemPanel;

  public JTablePanel() {
    super();
    this.table.setInstantEdit(true);
    addDeftListener();
  }

  public JTablePanel(boolean showEbFilterPanel) {
    super();
    this.table.setInstantEdit(true);
    this.showEbFilterPanel = showEbFilterPanel;
    addDeftListener();
  }

  public JTablePanel(String key) {
    super(key);
    this.table.setInstantEdit(true);
    addDeftListener();
  }

  public JTablePanel(JPageableFixedTable table) {
    super();
    this.table = table;
    this.table.setInstantEdit(true);
    addDeftListener();
  }

  protected void addDeftListener() {
    this.table.getTableHeader().addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e) {
        if (table.isEditing()) {
          table.getCellEditor().stopCellEditing();
        }
      }
    });
    /*
    this.table.getTableHeader().addFocusListener(new FocusAdapter() {
      public void focusGained(FocusEvent e) {
        if (table.isEditing()) {
          table.getCellEditor().stopCellEditing();
        }
      }
    });
    */
  }

  protected JPanel searchBar = new JPanel() {
    {
      this.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
    }
  };

  private TableRowSorter tableSorter = new TableRowSorter();

  private void initSearchBar() {

    searchBar.add(searchLabel);
    searchBar.add(searchField);
    if (showEbFilterPanel) {
      ebFilterItemPanel = new JFilterItemPanel(this.table);
      searchBar.add(ebFilterItemPanel);
    }

    searchField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        search();
      }
    });
    searchField.getDocument().addDocumentListener(new DocumentListener() {

      public void removeUpdate(DocumentEvent e) {
        search();
      }

      public void insertUpdate(DocumentEvent e) {
        search();
      }

      public void changedUpdate(DocumentEvent e) {
        search();
      }
    });

  }

  private void search() {
    tableSorter.setRowFilter(new StringArrayRowFilter(searchField.getText().split(" ")));
    tableSorterValueChanged();
    table.revalidate();
    table.repaint();
    self.revalidate();
    self.repaint();
  }

  protected void tableSorterValueChanged() {

  }

  public void setTablePreferencesKey(String key) {
    table.setPreferencesKey(key);
    table.setPreferenceStore(GkPreferencesStore.preferenceStore());
  }

  public JPageableFixedTable getTable() {
    return table;
  }

  public TableRowSorter getTableSorter() {
    return tableSorter;
  }

  private void initTable() {
    table.setRowSorter(tableSorter);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setPreferredScrollableViewportSize(new Dimension(700, 150));

  }

  JScrollPane scrollPane = new JScrollPane();

  public void init() {
    this.initSearchBar();
    this.initTable();
    this.setLayout(new BorderLayout());
    this.add(searchBar, BorderLayout.NORTH);

    scrollPane.getViewport().add(table);
    scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, UIConstants.HORIZONTAL_SCROLLBAR__HEIGHT));
    // scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(12, 0));
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
    fitTable();
    this.table.repaint();
    this.repaint();
  }

  public void setTableModelWithoutFitColumnWidth(TableModel dataModel) {
    this.table.setModel(dataModel);
    this.tableSorter.setModel(dataModel);
    this.table.revalidate();
    //    fitTable();
    this.table.repaint();
    this.repaint();
  }

  public void refreshData() {

  }

  public List getDataList() {
    return dataList;
  }

  public void setDataList(List dataList) {
    this.dataList = dataList;
  }

  public JTextArea sumLabel = new JTextAreaLabel();

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
    UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JTablePanel panel = new JTablePanel();

    panel.init();

    DefaultTableModel model = new DefaultTableModel(3, 3);
    panel.setTableModel(model);
    //    panel.refreshData();

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

  public JScrollPane getScrollPane() {
    return scrollPane;
  }

  public void setScrollPane(JScrollPane scrollPane) {
    this.scrollPane = scrollPane;
  }

  public JPanel getSearchBar() {
    return searchBar;
  }

  public void setSearchBar(JPanel searchBar) {
    this.searchBar = searchBar;
  }

  public JTextField getSearchField() {
    return searchField;
  }

  public void setSearchField(JTextField searchField) {
    this.searchField = searchField;
  }

  public void fitTable() {
    getScrollPane().getHorizontalScrollBar().setValue(0);
    getScrollPane().getVerticalScrollBar().setValue(0);
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          fitColumnWidth(table);
        } catch (Exception e) {
        }
      }
    });

  }

  private void fitColumnWidth(JPageableFixedTable table) {
    for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {
      table.getTableHeader().fitColumnWidth(j);
    }
  }
}

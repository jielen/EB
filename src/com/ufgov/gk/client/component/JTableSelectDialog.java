package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableRowSorter;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.component.zc.fieldeditor.ForeignEntityField;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.dto.ElementConditionDto;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

public abstract class JTableSelectDialog extends GkBaseDialog {

  protected Logger log = Logger.getLogger(this.getClass());

  protected JTableSelectDialog self = this;

  protected JButtonTextField triggerField;

  protected JPanel searchBar = new JPanel() {
    {
      //      this.setFloatable(false);
      this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
  };

  private final JLabel searchLabel = new JLabel("查找：");

  protected JTextField searchField = new JTextField(30);

  //	protected JButton searchButton = new JButton("查找");

  private void initSearchBar() {

    searchBar.add(searchLabel);
    searchBar.add(searchField);
    //		searchBar.add(searchButton);

    //		conditionField.addKeyListener(new KeyAdapter() {
    //			public void keyPressed(KeyEvent e) {
    //				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
    ////					searchButton.doClick();
    //				}
    //			}
    //		});

    searchField.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        self.selectTableSorter.setRowFilter(new SimpleRowFilter(searchField.getText()));
        self.repaint();
      }
    });

    //		searchButton.addActionListener(new ActionListener() {
    //			public void actionPerformed(ActionEvent arg0) {
    //				doSearch();
    //			}
    //		});

  }

  //	private void doSearch() {
  //		selectTable.clearSelection();
  //		String searchWord = conditionField.getText().trim();
  //		if (!searchWord.trim().equals("")) {
  //
  //			int colCount = selectTable.getColumnCount();
  //			int rowCount = selectTable.getRowCount();
  //			List<Integer> matchedList = new ArrayList<Integer>();
  //
  //			for (int i = 0; i < rowCount; i++) {
  //				for (int c = 0; c < colCount; c++) {
  //					Object value = selectTable.getValueAt(i, c);
  //					if (value != null) {
  //						String temp = value.toString();
  //						if (temp.indexOf(searchWord) >= 0) {
  //							matchedList.add(i);
  //							break;
  //						}
  //					}
  //				}
  //			}
  //
  //			if (matchedList.isEmpty()) {
  //				JOptionPane.showMessageDialog(self, "没有找到相关信息！", "提示",
  //						JOptionPane.INFORMATION_MESSAGE);
  //				return;
  //			}
  //			for (Integer matchedIndex : matchedList) {
  //				selectTable.addRowSelectionInterval(matchedIndex, matchedIndex);
  //			}
  //
  //		}
  //
  //	}

  protected TableRowSorter selectTableSorter;

  protected JPageableFixedTable selectTable = SwingUtil.createTable(JPageableFixedTable.class);

  protected JScrollPane selectTablePane = new JScrollPane();

  protected JPanel bottomPanel = new JPanel();

  protected JButton okButton = new JButton("确定");

  protected JButton clearButton = new JButton("清空");

  protected JButton cancelButton = new JButton("关闭");

  protected JButton newButton = new JButton("新增");

  protected List dataBufferList = new ArrayList();

  protected List tableDataList = new ArrayList();

  protected List numLimDataList = new ArrayList();

  protected String sqlMapSelectedId;

  private int dialogType = ZcSettingConstants.FOREIGNENTITY_BASE;

  protected ElementConditionDto elementConditionDto;

  private String title = "";

  public JTableSelectDialog(Dialog dialog, boolean modal, JButtonTextField triggerField) {
    super(dialog, modal);
    this.triggerField = triggerField;
    init();
  }

  public JTableSelectDialog(JButtonTextField triggerField) {
    this.triggerField = triggerField;
    init();
  }

  public JTableSelectDialog(Dialog dialog, boolean modal, JButtonTextField triggerField, String sqlMapSelectedId, String title) {
    super(dialog, title, modal);
    this.triggerField = triggerField;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.title = title;
    init();
  }

  public JTableSelectDialog(Dialog dialog, boolean modal, JButtonTextField triggerField, String sqlMapSelectedId,
    ElementConditionDto elementConditionDto, String title) {
    super(dialog, title, modal);
    this.triggerField = triggerField;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.elementConditionDto = elementConditionDto;
    init();
  }

  public JTableSelectDialog(Dialog dialog, boolean modal, ForeignEntityField triggerField, String sqlMapSelectedId,
    ElementConditionDto elementConditionDto, String title, int dialogType) {
    super(dialog, title, modal);
    this.triggerField = triggerField;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.elementConditionDto = elementConditionDto;
    this.dialogType = dialogType;
    init();
  }

  private void init() {
    new Thread() {
      public void run() {
        //initDataBufferList();
        triggerField.countDown();
      }
    }.start();
    initTitle();

    Container contentPane = this.getContentPane();
    contentPane.setLayout(new BorderLayout());
    this.initSearchBar();

    selectTable.setShowCheckedColumn(false);
    selectTable.getTableRowHeader().setPreferredSize(new Dimension(50, 0));
    selectTablePane.getViewport().add(selectTable);

    this.initBottomPanel();

    contentPane.add(searchBar, BorderLayout.NORTH);
    contentPane.add(selectTablePane, BorderLayout.CENTER);
    contentPane.add(bottomPanel, BorderLayout.SOUTH);
    this.setSize(500, 380);
    moveToScreenCenter();

  }

  protected abstract void initTitle();

  protected abstract void initDataBufferList();

  protected abstract void initSelectTable();

  public void setVisible(boolean b) {
    if (b) {
      this.initSelectTable();
      this.searchField.setText("");
      this.selectTableSorter = new TableRowSorter(selectTable.getModel());
      this.selectTable.setRowSorter(selectTableSorter);
      this.initSelection();
    } else {
      this.searchField.setText("");
    }
    super.setVisible(b);

  }

  private void initSelection() {

    selectTable.clearSelection();
    Object oldValue = this.triggerField.getValue();
    if (oldValue != null) {
      int row = tableDataList.indexOf(oldValue);
      if (row >= 0) {
        selectTable.addRowSelectionInterval(row, row);
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            scrollToRow(selectTable.getSelectedRow());
          }
        });
      }

    }
  }

  public void scrollToRow(int row) {
    int rowcount = selectTable.getRowCount();
    int max = selectTablePane.getVerticalScrollBar().getMaximum();
    selectTablePane.getVerticalScrollBar().setValue((int) (max * ((double) (row - 1) / (double) rowcount)));
    selectTablePane.revalidate();
    selectTablePane.repaint();
  }

  protected void initBottomPanel() {

    bottomPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    if (this.dialogType != ZcSettingConstants.FOREIGNENTITY_BASE) {
      newButton.setToolTipText("新增" + this.title);
      bottomPanel.add(newButton);
    }
    bottomPanel.add(okButton);
    bottomPanel.add(clearButton);
    bottomPanel.add(cancelButton);

    cancelButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        closeDialog();
      }

    });

    okButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.doOK();
      }

    });

    clearButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        self.doClear();
      }

    });
    newButton.addActionListener(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        openAddDialog();
      }
    });

  }

  public void doClear() {
    self.triggerField.setValue(null);
    self.selectTable.clearSelection();
    closeDialog();
  }

  public void doOK() {

    int selectedRowCount = selectTable.getSelectedRowCount();
    if (selectedRowCount == 0) {
      JOptionPane.showMessageDialog(self, "请选数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    } else if (selectedRowCount > 1) {
      JOptionPane.showMessageDialog(self, "只能选择一条数据 ！", "提示", JOptionPane.INFORMATION_MESSAGE);
      return;
    } else if (selectedRowCount == 1) {
      int selectedRow = selectTable.convertRowIndexToModel(selectTable.getSelectedRow());
      triggerField.setValue(tableDataList.get(selectedRow));
      this.closeDialog();
    }

  }

  protected void openAddDialog() {

  }

  protected void fitColumnWidth(JPageableFixedTable table) {
    for (int j = 0; j < table.getColumnModel().getColumnCount(); j++) {
      table.getTableHeader().fitColumnWidth(j);
    }
  }

  //table表格宽度设置
  protected void fitTable(final JPageableFixedTable table) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          fitColumnWidth(table);
        } catch (Exception e) {
        }
      }
    });
  }

}

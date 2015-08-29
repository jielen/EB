package com.ufgov.gk.client.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.math.BigDecimal;
import java.util.Enumeration;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.client.component.table.cellrenderer.DateCellRenderer;
import com.ufgov.gk.client.component.table.cellrenderer.LineWrapCellRenderer;
import com.ufgov.gk.client.component.table.cellrenderer.NumberCellRenderer;
import com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;
import com.ufgov.gk.common.system.constants.SystemOptionConstants;
import com.ufgov.gk.common.system.util.StringTools;
import com.ufgov.smartclient.component.table.ColumnResizeEvent;
import com.ufgov.smartclient.component.table.ColumnResizeListener;
import com.ufgov.smartclient.component.table.JGroupableTable;

public class SwingUtil {
  public static String sumMoney(JGroupableTable table, List<String> colIdentifiers) {
    int[] rows;
    StringBuffer info = new StringBuffer();
    if (table.getCheckedRows().length < 1) {
      info.append("合计：共计").append((table.getRowCount())).append("条数据");
      int rowCount = table.getRowCount();
      rows = new int[rowCount];
      for (int i = 0; i < rowCount; i++) {
        rows[i] = table.convertRowIndexToModel(i);
      }
    } else {
      info.append("合计：选择").append(table.getCheckedRows().length).append("条数据");
      Integer[] selectedRows = table.getCheckedRows();
      rows = new int[selectedRows.length];
      for (int i = 0; i < selectedRows.length; i++) {
        rows[i] = table.convertRowIndexToModel(selectedRows[i]);
      }
    }
    TableModel model = table.getModel();

    for (String colIdentifier : colIdentifiers) {
      int colIndex = table.getColumn(colIdentifier).getModelIndex();
      String headerValue = (String) table.getColumn(colIdentifier).getHeaderValue();
      BigDecimal colSum = doSum(model, rows, colIndex);

      info.append(" ").append(headerValue).append("：");
      info.append(StringTools.getNumberFormat(colSum.toPlainString())).append("元 ");
    }
    return info.toString();
  }

  private static BigDecimal doSum(TableModel model, int[] rows, int col) {
    BigDecimal sum = new BigDecimal("0");
    for (int row : rows) {
      BigDecimal temp = (BigDecimal) model.getValueAt(row, col);
      if (temp != null) {
        sum = sum.add(temp);
      }
    }
    return sum;
  }

  public static boolean isUseFreeStyle() {
    String freeTypeDialog = AsOptionMeta.getOptVal(SystemOptionConstants.OPT_FREE_STYLE_DIALOG);
    if ("1".equals(freeTypeDialog)) {
      return true;
    } else {
      return false;
    }
  }

  public static void setFontSize(int size) {
    for (Enumeration keys = UIManager.getDefaults().keys(); keys.hasMoreElements();) {
      Object key = keys.nextElement();
      Object value = UIManager.get(key);
      if (value instanceof FontUIResource) {
        UIManager.put(key, ((FontUIResource) value).deriveFont((float) size));
      }
    }
  }

  public static <T extends JGroupableTable> T createTable(Class<T> clazz) {
    T table = null;
    try {
      table = clazz.newInstance();
      table = preprocessTable(table);

    } catch (Exception e) {
      new RuntimeException("创建表格失败", e);
    }
    return table;
  }

  public static <T extends JGroupableTable> T preprocessTable(final T t) {
    t.getTableRowHeader().setPreferredSize(new Dimension(75, 0));
    t.setPreferenceStore(GkPreferencesStore.preferenceStore());

    t.setDefaultRenderer(Object.class, new LineWrapCellRenderer());
    t.setDefaultRenderer(Integer.class, new LineWrapCellRenderer());
    t.setDefaultRenderer(java.util.Date.class, new DateCellRenderer());
    t.setDefaultRenderer(BigDecimal.class, new NumberCellRenderer());

    return preprocessTable(t, new DefaultRowHeightHandler());
  }

  public static <T extends JGroupableTable> T preprocessTable(final T t, final RowHeightHandler rowHeightHandler) {
    if (t.getRowSorter() != null) {
      t.getRowSorter().addRowSorterListener(new RowSorterListener() {
        public void sorterChanged(RowSorterEvent e) {
          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              rowHeightHandler.setProperRowHeight(t);
            }
          });
        }
      });
    }

    t.addPropertyChangeListener("rowSorter", new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent evt) {
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            rowHeightHandler.setProperRowHeight(t);
          }
        });
        if (t.getRowSorter() != null) {
          t.getRowSorter().addRowSorterListener(new RowSorterListener() {
            public void sorterChanged(RowSorterEvent e) {
              SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                  rowHeightHandler.setProperRowHeight(t);
                }
              });
            }
          });
        }
      }
    });

    if (t.getModel() != null) {
      t.getModel().addTableModelListener(new TableModelListener() {
        public void tableChanged(TableModelEvent e) {
          //          rowHeightHandler.setProperRowHeight(t);

          SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              rowHeightHandler.setProperRowHeight(t);
            }
          });
        }
      });
    }

    t.addPropertyChangeListener("model", new PropertyChangeListener() {
      public void propertyChange(PropertyChangeEvent evt) {
        //        rowHeightHandler.setProperRowHeight(t);  //这里不把设置行高的处理放到派发线程里 table渲染会有问题 
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            rowHeightHandler.setProperRowHeight(t);
          }
        });

        if (t.getModel() != null) {
          t.getModel().addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
              //              rowHeightHandler.setProperRowHeight(t);
              SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                  rowHeightHandler.setProperRowHeight(t);
                }
              });
            }
          });
        }
      }
    });

    t.addColumnResizeListener(new ColumnResizeListener() {
      public void columnResized(ColumnResizeEvent e) {
        //        rowHeightHandler.setProperRowHeight(t);
        SwingUtilities.invokeLater(new Runnable() {
          public void run() {
            rowHeightHandler.setProperRowHeight(t);
          }
        });
      }
    });

    return t;
  }

  public static void setTableCellEditor(JTable table, String columnIdentifier, TableCellEditor cellEditor) {
    try {
      table.getColumn(columnIdentifier).setCellEditor(cellEditor);
    } catch (IllegalArgumentException e) {
    }
  }

  public static void removeTableColumn(JTable table, String columnIdentifier) {
    try {
      TableColumn column = table.getColumn(columnIdentifier);
      table.getColumnModel().removeColumn(column);
    } catch (Exception ex) {
    }
  }

  public static void setTableCellRenderer(JTable table, String columnIdentifier, TableCellRenderer cellRenderer) {
    try {
      table.getColumn(columnIdentifier).setCellRenderer(cellRenderer);
    } catch (IllegalArgumentException e) {
    }
  }

  public static TableCellRenderer getTableCellRenderer(JTable table, String columnIdentifier) {
    return table.getColumn(columnIdentifier).getCellRenderer();

  }

  public static int getShowColSize() {
    String colSize = AsOptionMeta.getOptVal("OPT_PREFERRED_SHOW_COL_SIZE");
    if (!"".equals(colSize)) {
      return Integer.valueOf(colSize);
    }
    return 4;
  }

  public static void resetConditionItems(final JPanel panel, final List<AbstractSearchConditionItem> showingConditionItems) {
    resetConditionItems(panel, showingConditionItems, getShowColSize());
  }

  public static void resetConditionItems(final JPanel panel, final List<AbstractSearchConditionItem> showingConditionItems, int colCount) {
    panel.removeAll();

    if (showingConditionItems.size() < colCount) {
      panel.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 2));
      for (int i = 0; i < showingConditionItems.size(); i++) {
        AbstractSearchConditionItem comp = (AbstractSearchConditionItem) showingConditionItems.get(i);
        panel.add(comp.getDisplayLabel());
        panel.add(comp.getEditorComponent());
      }
    } else {
      int row = 0;
      int col = 0;
      panel.setLayout(new GridBagLayout());
      for (int i = 0; i < showingConditionItems.size(); i++) {
        AbstractSearchConditionItem comp = (AbstractSearchConditionItem) showingConditionItems.get(i);
        panel.add(comp.getDisplayLabel(), new GridBagConstraints(col, row, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
          new Insets(5, 0, 5, 5), 0, 0));
        panel.add(comp.getEditorComponent(), new GridBagConstraints(col + 1, row, 1, 1, 1.0, 1.0, GridBagConstraints.WEST,
          GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5, 5), 0, 0));
        if (col == colCount * 2 - 2) {
          row++;
          col = 0;
        } else {
          col += 2;
        }
      }
    }
    panel.setBorder(BorderFactory.createLineBorder(Color.lightGray));
    panel.invalidate();
    panel.validate();
    panel.repaint();
  }

  public static String processAsteriskLabel(String labelString) {
    if (labelString == null) {
      return null;
    }
    StringBuffer sb = new StringBuffer("");
    sb.append("<html><body>&nbsp;");
    int index = labelString.lastIndexOf("*");
    if (index > -1) {
      sb.append(labelString.subSequence(0, index));
      sb.append("<font color='red'>*</font>");
    } else {
      sb.append(labelString + "&nbsp;");
    }
    sb.append("</body></html>");
    return sb.toString();
  }

  public static boolean showProgressBar(List beanList) {
    boolean show = false;
    int threshold = 50;
    String opt = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_GK_SHOW_PROGRESS_BAR_THRESHOLD);
    if (opt != null && !"".equals(opt.trim())) {
      threshold = Integer.parseInt(opt);
    }
    if (beanList.size() > threshold) {
      show = true;
    }
    return show;
  }

}

package com.eb.client.component.ebRetrievalTask;

import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.component.EbFilterKey;
import com.ufgov.gk.client.component.EbitemTableRowFilter;
import com.ufgov.gk.client.component.MoneyField;
import com.ufgov.gk.client.component.zc.fieldeditor.AsValFieldEditor;
import com.ufgov.gk.common.ebay.model.EbItemChecked;
import com.ufgov.gk.common.system.constants.ZcElementConstants;
import com.ufgov.gk.common.system.constants.ZcSettingConstants;
import com.ufgov.gk.common.system.model.AsVal;

public class JFilterItemPanel extends JPanel {
  private MoneyField priceField = new MoneyField(false, 2, 10);

  private MoneyField soldQualityField = new MoneyField(false, 0, 10);

  private MoneyField soldPerDayField = new MoneyField(false, 2, 10);

  private JCheckBox noCanidateItem = new JCheckBox("待选择");

  private JCheckBox keepSelling = new JCheckBox("在售");

  private AsValFieldEditor itemStatusField = new AsValFieldEditor("候选状态", ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS,
    ZcSettingConstants.VS_EB_CANDIDATE_ITEM_STATUS, true);

  private JTable table;

  private TableRowSorter tableSorter;

  public JFilterItemPanel(JTable table) {
    this.table = table;
    this.tableSorter = (TableRowSorter) table.getRowSorter();
    initSwing();
  }

  private void initSwing() {
    // TODO Auto-generated method stub
    setLayout(new FlowLayout());
    JLabel label = new JLabel();
    label.setText(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE) + " >= ");
    add(label);
    add(priceField);
    label = new JLabel();
    label.setText(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY) + " >= ");
    add(label);
    add(soldQualityField);
    label = new JLabel();
    label.setText(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY) + " >= ");
    add(label);
    add(soldPerDayField);

    //    noCanidateItem.setBorder(new EmptyBorder(0, 5, 0, 0));
    //    add(noCanidateItem);

    keepSelling.setBorder(new EmptyBorder(0, 10, 0, 0));
    add(keepSelling);

    label = new JLabel();
    label.setText(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS));
    add(label);
    add(itemStatusField);

    initFieldListeners(priceField);
    initFieldListeners(soldQualityField);
    initFieldListeners(soldPerDayField);

    itemStatusField.getField().addItemListener(new ItemListener() {

      @Override
      public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        doFilter();
      }
    });
    //    noCanidateItem.addItemListener(new ItemListener() {
    //
    //      @Override
    //      public void itemStateChanged(ItemEvent e) {
    //        // TODO Auto-generated method stub
    //        //        System.out.println("==================================noCanidateItem itemStateChanged");
    //        doFilter();
    //      }
    //    });
    keepSelling.addItemListener(new ItemListener() {

      @Override
      public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        doFilter();
      }
    });

  }

  private void initFieldListeners(JTextField field) {

    field.addKeyListener(new KeyAdapter() {
      public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0 || e.getKeyCode() == KeyEvent.VK_1 || e.getKeyCode() == KeyEvent.VK_2 || e.getKeyCode() == KeyEvent.VK_3
          || e.getKeyCode() == KeyEvent.VK_4 || e.getKeyCode() == KeyEvent.VK_5 || e.getKeyCode() == KeyEvent.VK_6 || e.getKeyCode() == KeyEvent.VK_7
          || e.getKeyCode() == KeyEvent.VK_8 || e.getKeyCode() == KeyEvent.VK_9) {
          doFilter();
        }
      }
    });
    field.getDocument().addDocumentListener(new DocumentListener() {

      public void removeUpdate(DocumentEvent e) {
        doFilter();
      }

      public void insertUpdate(DocumentEvent e) {
        doFilter();
      }

      public void changedUpdate(DocumentEvent e) {
        doFilter();
      }
    });
  }

  public void doFilter() {
    // TODO Auto-generated method stub
    Hashtable<EbFilterKey, Object> filts = new Hashtable<EbFilterKey, Object>();
    if (priceField.getMoney() != null && priceField.getMoney().doubleValue() > 0) {
      EbFilterKey key = new EbFilterKey();
      key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_PRICE));
      key.setFieldType(EbFilterKey.TYPE_NUMBER);
      filts.put(key, priceField.getMoney());
    }
    if (soldQualityField.getMoney() != null && soldQualityField.getMoney().doubleValue() > 0) {
      EbFilterKey key = new EbFilterKey();
      key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SOLD_QUALITY));
      key.setFieldType(EbFilterKey.TYPE_NUMBER);
      filts.put(key, soldQualityField.getMoney());
    }
    if (soldPerDayField.getMoney() != null && soldPerDayField.getMoney().doubleValue() > 0) {
      EbFilterKey key = new EbFilterKey();
      key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_SELLING_PER_DAY));
      key.setFieldType(EbFilterKey.TYPE_NUMBER);
      filts.put(key, soldPerDayField.getMoney());
    }

    //    EbFilterKey key = new EbFilterKey();
    //    key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS));
    //    key.setFieldType(EbFilterKey.TYPE_STRING);
    //    filts.put(key, new Boolean(noCanidateItem.isSelected()));

    EbFilterKey key = new EbFilterKey();
    key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_CANDIDATE_STATUS));
    key.setFieldType(EbFilterKey.TYPE_STRING);
    AsVal val = itemStatusField.getField().getSelectedAsVal();
    filts.put(key, val == null ? EbItemChecked.ALL : val.getValId());

    key = new EbFilterKey();
    key.setFieldName(LangTransMeta.translate(ZcElementConstants.FIELD_EB_ITEM_TIME_LEFT));
    key.setFieldType(EbFilterKey.TYPE_STRING);
    filts.put(key, new Boolean(keepSelling.isSelected()));

    //    tableSorter.setRowFilter(new HashTableRowFilter(filts, table.getModel()));
    tableSorter = (TableRowSorter) table.getRowSorter();
    tableSorter.setRowFilter(new EbitemTableRowFilter(filts, table.getModel()));
    table.revalidate();
    table.repaint();
  }
}

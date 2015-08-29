package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.ufgov.gk.client.datacache.AsValDataCache;
import com.ufgov.gk.common.system.model.AsVal;
import com.ufgov.smartclient.component.JComboBoxEx;

public class AsValComboBox extends JComboBoxEx {
  private List dataList = new ArrayList();

  private boolean firstAddNull = false;

  private Map<String, AsVal> dataMap = new HashMap<String, AsVal>();

  private List filterList = new ArrayList();//filterList�е�������Ҫ���˵�������

  public AsValComboBox(String valSetId) {
    super();
    init(valSetId);
  }

  public AsValComboBox(boolean isSearchCondition, String valSetId) {
    super();
    this.isSearchCondition = isSearchCondition;
    init(valSetId);
  }

  private boolean isSearchCondition;

  public AsValComboBox(String valId, boolean firstAddNull) {
    super();
    this.firstAddNull = firstAddNull;
    init(valId);
  }

  //added by mengw 20100719�����ֶ�����combobox���б����� 
  public AsValComboBox(String valId, boolean firstAddNull, List dataList) {
    super();
    this.firstAddNull = firstAddNull;
    init(valId, dataList);
  }

  public AsValComboBox(String valSetId, List filterList) {
    super();
    this.filterList = filterList;
    this.firstAddNull = getFirstAddNull();
    init(valSetId);
  }

  private void init(String valSetId) {

    dataList = AsValDataCache.getAsVal(valSetId);

    this.removeAllItems();
    if (firstAddNull) {
      this.addItem(null);
      if (isSearchCondition) {
        this.addItemDisplaLable(null, "ȫ��");
      }
    }

    for (int i = 0; i < dataList.size(); i++) {
      AsVal data = (AsVal) dataList.get(i);
      if (filterList.contains(data.getValId())) {
        continue;
      }
      this.addItem(data);
      this.addItemDisplaLable(data, data.getVal());
      this.dataMap.put(data.getValId(), data);
    }

    this.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (((AsVal) getSelectedItem()) != null) {
          setToolTipText(((AsVal) e.getItem()).getVal());
        } else {
          setToolTipText(null);
        }
      }
    });
  }

  //added by mengw 20100719�����ֶ�����combobox���б����� 
  private void init(String valSetId, List dataList) {

    this.dataList = dataList;

    this.removeAllItems();
    if (firstAddNull) {
      this.addItem(null);
      if (isSearchCondition) {
        this.addItemDisplaLable(null, "ȫ��");
      }
    }

    for (int i = 0; i < this.dataList.size(); i++) {
      AsVal data = (AsVal) this.dataList.get(i);
      if (filterList.contains(data.getValId())) {
        continue;
      }
      this.addItem(data);
      this.addItemDisplaLable(data, data.getVal());
      this.dataMap.put(data.getValId(), data);
    }

    this.addItemListener(new ItemListener() {
      public void itemStateChanged(ItemEvent e) {
        if (((AsVal) getSelectedItem()) != null) {
          setToolTipText(((AsVal) e.getItem()).getVal());
        } else {
          setToolTipText(null);
        }
      }
    });
  }

  public AsVal getSelectedAsVal() {
    return (AsVal) this.getSelectedItem();
  }

  public void setSelectedAsVal(AsVal asVal) {
    this.setSelectedItem(asVal);
  }

  public void setSelectedAsValByCode(String asValCode) {
    AsVal asVal = dataMap.get(asValCode);
    this.setSelectedItem(asVal);
  }

  public boolean getFirstAddNull() {
    return firstAddNull;
  }

  public static void main(String[] args) {
    JFrame f = new JFrame();
    AsValComboBox textField = new AsValComboBox("VS_Y/N", true);
    //    AsValComboBox textFieldq = new AsValComboBox("VS_TZD_A_DP_TYPE");
    //    textFieldq.setPrototypeDisplayValue("AAAAAAAAAAAAAAAAAAAAAA");

    textField.setEditable(false);
    textField.setEnabled(false);
    textField.setEnabled(true);

    JPanel panel = new JPanel();
    //    textField.
    panel.add(textField);
    //    panel.add(textFieldq);
    f.getContentPane().add(panel, BorderLayout.NORTH);
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}

/**
 *
 * Copyright (C) 2009 UFGOV
 * 
 * 修订历史记录：
 * 
 * Revision	1.0	 2009-4-8  hpj_inter  创建。
 * 
 */

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

import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.datacache.AsValDataCache;
import com.ufgov.gk.common.system.model.AsVal;
import com.ufgov.smartclient.component.JComboBoxEx;

public class MonthComboBox extends JComboBoxEx {

  private static final long serialVersionUID = 7695985762179916173L;

  private List dataList = new ArrayList();

  private Map<String, AsVal> dataMap = new HashMap<String, AsVal>();

  private boolean firstAddNull = true;
  
  private boolean defaultCurrentMonth=true;

  public MonthComboBox() {
    super();
    init();
  }

  public MonthComboBox(boolean firstAddNull) {
    super();
    this.firstAddNull = firstAddNull;
    init();
  }
  
  public MonthComboBox(boolean firstAddNull,boolean defaultCurrentMonth ) {
    super();
    this.firstAddNull = firstAddNull;
    this.defaultCurrentMonth=defaultCurrentMonth;
    init();
  }

  private void init() {

    dataList =AsValDataCache.getAsVal("VS_DP_MONTH");
    if (firstAddNull) {
      this.addItem(null);
    }

    for (int i = 0; i < dataList.size(); i++) {
      AsVal data = (AsVal) dataList.get(i);
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
    
    if(this.defaultCurrentMonth){
      int month = WorkEnv.getInstance().getTransMonth();
      this.setSelectedAsValByCode(Integer.toString(month));
    }
  
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

  public static void main(String[] args) {
    JFrame f = new JFrame();
    MonthComboBox textField = new MonthComboBox();

    textField.setEditable(false);
    textField.setEnabled(false);
    textField.setEnabled(true);
    textField.setSelectedAsValByCode(null);
    JPanel panel = new JPanel();
    panel.add(textField);
    f.getContentPane().add(panel, BorderLayout.NORTH);
    // f.pack();
    // SwingUtilities.updateComponentTreeUI(panel);
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }

}

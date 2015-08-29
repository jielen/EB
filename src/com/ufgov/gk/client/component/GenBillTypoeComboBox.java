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

import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsVal;
import com.ufgov.smartclient.component.JComboBoxEx;

public class GenBillTypoeComboBox extends JComboBoxEx {

  /**
   * 文件名：GenBillTypoeComboBox.java
   *
   * 版本信息：
   * 日期：Aug 25, 2009
   * Copyright ufgov Corporation 2009 
   * 版权所有
   *
   */
  private static final long serialVersionUID = -5938373724392274303L;

  private List dataList = new ArrayList();

  private List filterList = null;

  private Map<String, AsVal> dataMap = new HashMap<String, AsVal>();

  private String genBillTypeValsetid = "VS_BI_GENBILLTYPE";//全部

  public GenBillTypoeComboBox() {
    super();
    init();
  }

  public GenBillTypoeComboBox(String genBillTypeValsetid) {
    super();
    this.genBillTypeValsetid = genBillTypeValsetid;
    init();
  }

  public GenBillTypoeComboBox(List filterList) {
    super();
    this.filterList = filterList;
    init();
  }

  private void init() {
    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
      IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    dataList = baseDataServiceDelegate.getAsVal(this.genBillTypeValsetid, requestMeta);
    this.addItem(null);
    for (int i = 0; i < dataList.size(); i++) {
      AsVal data = (AsVal) dataList.get(i);
      if (filterList == null) {
        this.addItem(data);
        this.addItemDisplaLable(data, data.getVal());
        this.dataMap.put(data.getValId(), data);
      } else {
        if (filterList.contains(data.getValId())) {
          this.addItem(data);
          this.addItemDisplaLable(data, data.getVal());
          this.dataMap.put(data.getValId(), data);
        }
      }
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

  public static void main(String[] args) {
    JFrame f = new JFrame();
    GenBillTypoeComboBox genTypeField = new GenBillTypoeComboBox();
    JPanel panel = new JPanel();
    panel.add(genTypeField);
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

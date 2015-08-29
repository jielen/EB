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

public class PlanTypeComboBox extends JComboBoxEx {

  private static final long serialVersionUID = 7695985762179916173L;

  private List dataList = new ArrayList();

  private List filterList = null;

  private Map<String, AsVal> dataMap = new HashMap<String, AsVal>();

  private String pmadjustCodeValsetid = "VS_DP_PM_ADJUST_CODE";//全部

  public PlanTypeComboBox() {
    super();
    init();
  }

  public PlanTypeComboBox(String pmAdjustCodeValsetid) {
    super();
    this.pmadjustCodeValsetid = pmAdjustCodeValsetid;
    init();
  }

  public PlanTypeComboBox(List filterList) {
    super();
    this.filterList = filterList;
    init();
  }

  private void init() {
    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
      IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    dataList = baseDataServiceDelegate.getAsVal(this.pmadjustCodeValsetid, requestMeta);
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
    PlanTypeComboBox planTypeField = new PlanTypeComboBox();
    JPanel panel = new JPanel();
    panel.add(planTypeField);
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

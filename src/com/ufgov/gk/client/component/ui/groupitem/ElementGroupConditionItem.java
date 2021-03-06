package com.ufgov.gk.client.component.ui.groupitem;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.component.ui.AbstractSearchConditionArea;
import com.ufgov.gk.client.component.ui.MyEntry;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;

public class ElementGroupConditionItem extends JPanel implements ActionListener {
  /**
   *
   */
  private static final long serialVersionUID = -466113130048520412L;

  private static List elements;

  static {
    IBaseDataServiceDelegate bases = (IBaseDataServiceDelegate) ServiceFactory.create(
      IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
    elements = new ArrayList();
    elements.add(new MyEntry("", null));
    elements.add(new MyEntry("预算单位", "CO_CODE"));
    elements.add(new MyEntry("资金性质", "FUND_CODE"));
    elements.add(new MyEntry("科处室", "ORG_CODE"));
    elements.add(new MyEntry("功能分类", "B_ACC_CODE"));
    elements.add(new MyEntry("支付方式", "PAYTYPE_CODE"));
    elements.add(new MyEntry("指标来源", "ORIGIN_CODE"));
    elements.add(new MyEntry("项目代码", "PROJECT_CODE"));
    elements.add(new MyEntry(LangTransMeta.translate("GK_FIELD_PAYOUT_NAME"), "PAYOUT_CODE"));
    elements.add(new MyEntry("经济分类", "OUTLAY_CODE"));
    elements.add(new MyEntry("发文文号", "SENDDOC_CODE"));
  }

  private JComboBox elementBox;

  private JComboBox levelBox;

  private MyEntry codeItem;

  private MyEntry levelItem;

  private AbstractSearchConditionArea conditionArea;

  public MyEntry getCodeItem() {
    return codeItem;
  }

  public void setCodeItem(MyEntry codeItem) {
    this.codeItem = codeItem;
  }

  public MyEntry getLevelItem() {
    return levelItem;
  }

  public void setLevelItem(MyEntry levelItem) {
    this.levelItem = levelItem;
  }

  public ElementGroupConditionItem(AbstractSearchConditionArea area) {
    this.conditionArea = area;
    this.setLayout(new FlowLayout(FlowLayout.LEFT));
    initItem();
  }

  public void actionPerformed(ActionEvent event) {

    this.codeItem = (MyEntry) elementBox.getSelectedItem();
    this.levelItem = (MyEntry) levelBox.getSelectedItem();
    if ("code".equals(event.getActionCommand())) {
      this.codeItem = (MyEntry) elementBox.getSelectedItem();
      initLevelBox((String)this.codeItem.getValue());
    } else if ("level".equals(event.getActionCommand())) {
      this.levelItem = (MyEntry) levelBox.getSelectedItem();
    }
    List itemList = conditionArea.getGroupItemList();
    conditionArea.groupField.clear();
    for (int i = 0; i < itemList.size(); i++) {
      ElementGroupConditionItem item = (ElementGroupConditionItem)itemList.get(i);
      MyEntry entry = item.getCodeItem();
      if (entry != null && entry.getValue() != null) {
        String code = (String)entry.getValue();
        if (containField(code, conditionArea.groupField)) continue;
        entry = item.getLevelItem();
        String level = entry == null || entry.getValue() == null ? "" : (String)entry.getValue();
        Map info = new HashMap();
        info.put("code", code);
        info.put("level", level);
        conditionArea.groupField.add(info);
      }
    }
    conditionArea.groupItemChanged();
  }

  private boolean containField(String code, List fields) {
    boolean result = false;
    Map map = null;
    for (int i = 0; i < fields.size(); i++) {
      map = (Map)fields.get(i);
      if (map.get("code").equals(code)) {
        result = true;
        break;
      }
    }
    return result;
  }

  public void clear() {
    elementBox.setSelectedIndex(0);
    levelBox.setSelectedIndex(0);
  }

  public void setGroutInfo(String fieldCode, String levelStr) {
    int codeIndex = getItemIndex(fieldCode);
    elementBox.setSelectedIndex(codeIndex);
    try {
      int level = Integer.parseInt(levelStr);
      levelBox.setSelectedIndex(level);
    } catch (Exception ex) {
      levelBox.setSelectedIndex(0);
    }
  }

  private static int getItemIndex(String fieldCode) {
    int result = 0;
    MyEntry entry = null;
    for (int i = 0; i < elements.size(); i++) {
      entry = (MyEntry) elements.get(i);
      if (fieldCode.equals(entry.getValue())) {
        result = i;
        break;
      }
    }
    return result;
  }

  private void initItem() {
    elementBox = new JComboBox();
    for (int i = 0; i < elements.size(); i++) {
      elementBox.addItem(elements.get(i));
    }
    elementBox.setActionCommand("code");
    this.add(elementBox);
    elementBox.addActionListener(this);
    JLabel label = new JLabel("级次");
    this.add(label);
    levelBox = new JComboBox();
    initLevelBox("");
    levelBox.setActionCommand("level");
    levelBox.addActionListener(this);
    this.add(levelBox);
  }

  private void initLevelBox(String elementCode) {
    elementCode = elementCode == null ? "" : elementCode;
    levelBox.removeAllItems();
    if (elementCode.equals("B_ACC_CODE")) {
      levelBox.addItem(new MyEntry("无限制", null));
      levelBox.addItem(new MyEntry("类", "1"));
      levelBox.addItem(new MyEntry("款", "2"));
      levelBox.addItem(new MyEntry("项", "3"));
    } else {
      levelBox.addItem(new MyEntry("无限制", null));
      levelBox.addItem(new MyEntry("一级", "1"));
      levelBox.addItem(new MyEntry("二级", "2"));
      levelBox.addItem(new MyEntry("三级", "3"));
      levelBox.addItem(new MyEntry("四级", "4"));
      levelBox.addItem(new MyEntry("五级", "5"));
    }
  }

}

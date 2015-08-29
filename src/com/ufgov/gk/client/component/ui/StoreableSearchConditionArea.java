package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.ui.conditionitem.AbstractSearchConditionItem;
import com.ufgov.gk.client.component.ui.groupitem.ElementGroupConditionItem;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.Guid;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.UserSearchStore;

public class StoreableSearchConditionArea extends SaveableSearchConditionArea {
  private JButton storeSearchBtn = new JButton("��������");

  private JComboBox chooseSearchBtn = new JComboBox();

  private IBaseDataServiceDelegate baseService = (IBaseDataServiceDelegate) ServiceFactory.create(
    IBaseDataServiceDelegate.class, "baseDataServiceDelegate");

  private RequestMeta meta = WorkEnv.getInstance().getRequestMeta();

  private UserSearchStore searchStore = null;

  private List storeList = new ArrayList();

  private static final long serialVersionUID = 3711820730768571872L;

  public StoreableSearchConditionArea(String conditionId, BillElementMeta bem, boolean showFlag,
    Map defaultValueMap, String numLimCompoId) {
    super(conditionId, bem, showFlag, defaultValueMap, numLimCompoId);
    _init();
  }

  public StoreableSearchConditionArea(String conditionId, BillElementMeta bem, boolean showFlag,
    Map defaultValueMap, String numLimCompoId, boolean isRefresh) {
    super(conditionId, bem, showFlag, defaultValueMap, numLimCompoId, isRefresh);
    _init();
  }

  private void _init() {
    JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
    storeSearchBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        String searchBuffer = "";
        AbstractSearchConditionItem[] searchItems = StoreableSearchConditionArea.this
          .getShowingConditionItems();
        AbstractSearchConditionItem item = null;
        for (int i = 0; i < searchItems.length; i++) {
          item = searchItems[i];
          Object value = item.getValue();
          if (value != null) {
            searchBuffer += ";" + item.getSearchCondition().getConditionFieldCode() + "="
              + item.getValue().toString();
          }
        }
        if (searchBuffer.length() > 0) {
          searchBuffer = searchBuffer.substring(1);
        }
        String groupBuffer = "";
        Map map = null;
        List fieldList = StoreableSearchConditionArea.this.groupField;
        for (int i = 0; i < fieldList.size(); i++) {
          map = (Map)fieldList.get(i);
          String key = (String) map.get("code");
          if (key != null && key.length() > 0) {
            String level = map.get("level") == null ? "" : (String)map.get("level");
            groupBuffer += ";" + key + "=" + level;
          }
        }
        if (groupBuffer.length() > 0) {
          groupBuffer = groupBuffer.substring(1);
        }
        try {
          UserSearchStore store = new UserSearchStore();
          store.setConditionId(StoreableSearchConditionArea.this.conditionId);
          store.setNd(meta.getSvNd());
          store.setStoreId(Guid.genID());
          store.setUserId(meta.getSvUserID());
          store.setGroupInf(groupBuffer);
          store.setSearchInfo(searchBuffer);
          if (searchStore == null || searchStore.getStoreId() == null) {
            String desc = JOptionPane.showInputDialog("��������");
            baseService.insertuserSearchStore(store, WorkEnv.getInstance().getRequestMeta());
            JOptionPane.showMessageDialog(StoreableSearchConditionArea.this, "��������ɹ�! ", "��ʾ",
              JOptionPane.INFORMATION_MESSAGE);
          } else {
            int optioin = JOptionPane.showOptionDialog(StoreableSearchConditionArea.this, "�½����߸�����������?",
              "��ʾ", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new String[] { "�½�",
                "����" }, null);
            if (optioin == JOptionPane.YES_OPTION) {
              String desc = JOptionPane.showInputDialog("��������");
              baseService.insertuserSearchStore(store, WorkEnv.getInstance().getRequestMeta());
            } else {
              store.setStoreId(searchStore.getStoreId());
              baseService.updateUserSearchStore(store, meta);
            }
            JOptionPane.showMessageDialog(StoreableSearchConditionArea.this, "��������ɹ�! ", "��ʾ",
              JOptionPane.INFORMATION_MESSAGE);
          }
          refreshStoreList();
          StoreableSearchConditionArea.this.setSelectSearchStore(store);
        } catch (Exception ex) {
          ex.printStackTrace();
          JOptionPane.showMessageDialog(StoreableSearchConditionArea.this, "��������(�½�)ʧ��! :" + ex.getMessage(),
            "����", JOptionPane.ERROR_MESSAGE);
        }
      }
    });
    //panel.add(storeSearchBtn);

    chooseSearchBtn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        UserSearchStore store = (UserSearchStore) chooseSearchBtn.getSelectedItem();
        if (store != null) {
          setSearchItemValue(store);
          setSearchGroupValue(store);
          searchStore = store;
          StoreableSearchConditionArea.this.doSearch();
        }
      }
    });
    refreshStoreList();
    //panel.add(chooseSearchBtn);
    this.showControlPanel.add(panel, BorderLayout.WEST);
    this.groupItemPanel.setBorder(BorderFactory.createTitledBorder("��������"));
    this.conditionItemPanel.setBorder(BorderFactory.createTitledBorder("��ѯ����"));
  }

  private void refreshStoreList() {
    storeList = baseService.getUserSearchStore(meta.getSvUserID(), this.conditionId, meta.getSvNd(), meta);
    chooseSearchBtn.removeAllItems();
    UserSearchStore nullStore = new UserSearchStore();
    nullStore.setSearchInfo("");
    nullStore.setGroupInf("");
    nullStore.setDesc("");
    chooseSearchBtn.addItem(nullStore);
    for (int i = 0; i < storeList.size(); i++) {
      chooseSearchBtn.addItem(storeList.get(i));
    }
  }

  private void setSelectSearchStore(UserSearchStore store) {
    this.searchStore = store;
    UserSearchStore temp = null;
    int selectIndex = 0;
    for (int i = 0; i < this.storeList.size(); i++) {
      temp = (UserSearchStore) this.storeList.get(i);
      if (temp.getStoreId().equals(store.getStoreId())) {
        selectIndex = i;
        break;
      }
    }
    chooseSearchBtn.setSelectedIndex(selectIndex + 1);
  }

  private void setSearchItemValue(UserSearchStore store) {
    String searchItemInfo = store.getSearchInfo();
    if (searchItemInfo != null && searchItemInfo.length() > 0) {
      String[] values = searchItemInfo.split(";");
      String[] valueEntry;
      AbstractSearchConditionItem item = null;
      for (int i = 0; i < values.length; i++) {
        valueEntry = values[i].split("=");
        item = this.getCondItemsByCondiFieldCode(valueEntry[0]);
        if (item != null) {
          item.setValue(valueEntry[1]);
        }
      }
    }
  }

  private void setSearchGroupValue(UserSearchStore store) {
    if (!this.showGroupPanel)
      return;
    List items = this.getGroupItemList();
    ElementGroupConditionItem item = null;
    for (int i = 0; i < items.size(); i++) {
      item = (ElementGroupConditionItem) items.get(i);
      item.clear();
    }
    String groupItemInfo = store.getGroupInf();
    if (groupItemInfo != null && groupItemInfo.length() > 0) {
      String[] values = groupItemInfo.split(";");
      String[] valueEntry;
      for (int i = 0; i < values.length; i++) {
        valueEntry = values[i].split("=");
        item = (ElementGroupConditionItem) this.getGroupItemList().get(i);
        item.setGroutInfo(valueEntry[0], valueEntry[1]);
      }
    }
  }

}

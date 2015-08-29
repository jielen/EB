package com.ufgov.gk.client.component;

import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.gk.common.commonbiz.model.SearchCondition;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.gk.common.system.model.AsCompo;

public class SearchConditionSelectDialog extends JTableSelectDialog {

  private static String searchConditonType ;

  public SearchConditionSelectDialog(Dialog dialog, boolean modal,
    JButtonTextField triggerField,String searchConditonType) {
    super(dialog, modal, triggerField);
    this.searchConditonType = searchConditonType;
    initDataBufferList();
    LangTransMeta.init("GK%");
  }

  @Override
  protected void initDataBufferList() {
    String baseDataServiceDelegateName = "baseDataServiceDelegate";

    IBaseDataServiceDelegate baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory
      .create(IBaseDataServiceDelegate.class, baseDataServiceDelegateName);

    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    dataBufferList = baseDataServiceDelegate.getCompoSearchCondition(searchConditonType,requestMeta);

    for (int i = 0; i < dataBufferList.size(); i++) {
      SearchCondition rowData = (SearchCondition) dataBufferList.get(i);
      this.triggerField.dataMap.put(rowData.getConditionId(), rowData);
    }
    this.triggerField.filteredDataList=dataBufferList;
  }

  @Override
  protected void initSelectTable() {
    String code = "";
    String name = "";
    if(searchConditonType=="tab"){
      code="ҳǩ����";
      name="ҳǩ����";
    }else if(searchConditonType=="condition"){
      code="��������";
      name="��������";
    }
    String[] names = { LangTransMeta.translate(code),
      LangTransMeta.translate(name) };

    Object[][] data = null;

    tableDataList = this.genTableData();

    data = new Object[tableDataList.size()][names.length];

    for (int i = 0; i < tableDataList.size(); i++) {

      SearchCondition rowData = (SearchCondition) tableDataList.get(i);
      int col = 0;
      data[i][col++] = rowData.getConditionId();
      data[i][col++] = rowData.getConditionName();
    }

    DefaultTableModel model = new DefaultTableModel(data, names) {
      @Override
      public boolean isCellEditable(int row, int colum) {
        return false;
      }
    };

    selectTable.setPreferencesKey(this.getClass().getName() + "_searchConditon_Table");
    selectTable.setPreferenceStore(GkPreferencesStore.preferenceStore());
    selectTable.setModel(model);

    selectTable.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
          doOK();
        }
      }

    });

    selectTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
  }

  @Override
  protected void initTitle() {
    LangTransMeta.init("GK%");
    this.setTitle("ѡ��");
  }

  private List genTableData() {
    return dataBufferList;
  }
}

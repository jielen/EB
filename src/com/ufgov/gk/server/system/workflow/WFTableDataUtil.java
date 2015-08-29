package com.ufgov.gk.server.system.workflow;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.kingdrive.workflow.model.TableData;
import com.ufgov.gk.common.commonbiz.fieldmap.FieldMapRegister;
import com.ufgov.gk.common.commonbiz.model.WfAware;
import com.ufgov.gk.common.system.util.BeanUtil;
import com.ufgov.gk.server.system.util.RequestMetaUtil;

public class WFTableDataUtil {

  public static TableData genTableData(WfAware bill) {
    return genTableData(bill, RequestMetaUtil.getCompoId());
  }

  public static TableData genTableData(WfAware bill, String compoId) {
    Map fieldMap = FieldMapRegister.get(bill.getClass());
    TableData tableData = new TableData();
    tableData.setInstanceId(bill.getProcessInstId());
    tableData.setName(compoId);
    tableData.setTitleFieldValue(bill.getTitleField());

    Set keySet = fieldMap.keySet();
    Iterator it = keySet.iterator();
    while (it.hasNext()) {
      String tableFieldName = (String) it.next();
      String objectFieldName = (String) fieldMap.get(tableFieldName);
      tableData.setFieldValue(tableFieldName, BeanUtil.get(objectFieldName, bill));
    }
    return tableData;
  }

}

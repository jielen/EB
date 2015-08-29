/**
 *
 */
package com.ufgov.gk.client.component;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;

import com.kingdrive.workflow.dialog.WFTracePanel;
import com.kingdrive.workflow.model.runtime.TraceInfoModel;
import com.ufgov.gk.client.common.ServiceFactory;
import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.util.GkPreferencesStore;
import com.ufgov.gk.client.util.SwingUtil;
import com.ufgov.gk.common.commonbiz.publish.IBaseDataServiceDelegate;
import com.ufgov.gk.common.system.RequestMeta;
import com.ufgov.smartclient.component.table.fixedtable.JPageableFixedTable;

/**
 * @author ufwangfei
 * �������£������û���ǰѡ�е�ʵ���ż��ɣ�
 * WorkflowTrace.showTraceDialog(dpDetail.getProcessInstId());
 */
public class WorkflowTrace {

  private static IBaseDataServiceDelegate baseDataServiceDelegate;

  public static void showTraceDialog(Long instanceId) {
    if(instanceId==null){
      JOptionPane.showMessageDialog(null, "���̸���ʧ�ܣ�������ʵ����Ϊnull", "����",
        JOptionPane.ERROR_MESSAGE);
      return ;
    }

    if(instanceId==0){
      JOptionPane.showMessageDialog(null, "������ϵͳ�Զ�����,û��������Ϣ!", "����",JOptionPane.ERROR_MESSAGE);
      return ;
    }

    if (instanceId < 0) {
      JOptionPane.showMessageDialog(null, "�˵���Ϊ�ݸ�״̬��û���������̸���", "��ʾ",
        JOptionPane.INFORMATION_MESSAGE);
      return;
    }
    RequestMeta requestMeta = WorkEnv.getInstance().getRequestMeta();
    TraceInfoModel traceInfoModel = null;
    try {
      baseDataServiceDelegate = (IBaseDataServiceDelegate) ServiceFactory.create(
        IBaseDataServiceDelegate.class, "baseDataServiceDelegate");
      traceInfoModel = baseDataServiceDelegate.getTraceInfo(instanceId, requestMeta);

    } catch (Exception e) {
      JOptionPane
        .showMessageDialog(null, "���̸���ʧ�ܣ�", "����", JOptionPane.ERROR_MESSAGE);
      return;
    }
    new TraceDialog(traceInfoModel);
  }
}

class TraceDialog extends GkBaseDialog {
  /**
   *
   */
  private static final long serialVersionUID = -3082759141495155906L;

  public TraceDialog(TraceInfoModel traceInfo) {
    JPageableFixedTable traceTable = SwingUtil.createTable(JPageableFixedTable.class);
    traceTable.setPreferencesKey(this.getClass().getName() + "_traceTable");
    traceTable.setPreferenceStore(GkPreferencesStore.preferenceStore());
    traceTable.setShowCheckedColumn(false);

    WFTracePanel wFTracePanel = new WFTracePanel(traceInfo,traceTable);
    this.getContentPane().setLayout(new BorderLayout());
    this.add(wFTracePanel, BorderLayout.CENTER);
    this.setSize(UIConstants.DIALOG_2_LEVEL_WIDTH, UIConstants.DIALOG_2_LEVEL_HEIGHT);
    this.setModal(true);
    this.setTitle(wFTracePanel.traceInfo);
    this.moveToScreenCenter();
    this.setVisible(true);
  }

}

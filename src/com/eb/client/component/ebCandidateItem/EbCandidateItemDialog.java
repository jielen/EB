package com.eb.client.component.ebCandidateItem;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import com.eb.client.component.ebRetrievalTask.EbRetrievalTaskPanel;
import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.GkBaseDialog;
import com.ufgov.gk.common.ebay.model.EbItem;

public class EbCandidateItemDialog extends GkBaseDialog {

  private EbCandidateItemDialog self = this;

  private EbCandidateItemEditPanel editPanel;

  private EbCandidateItemListPanel listPanel;

  String compoId = "EB_CANDIDATE_ITEM";

  public EbCandidateItemDialog(EbCandidateItemListPanel listPanel, List beanList, int editingRow, String tabStatus) {
    // TODO Auto-generated constructor stub
    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);
    this.listPanel = listPanel;
    editPanel = new EbCandidateItemEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);
    setLayout(new BorderLayout());
    add(editPanel);
    this.setTitle(LangTransMeta.translate(compoId));
    this.setSize(UIConstants.DIALOG_1_LEVEL_WIDTH, UIConstants.DIALOG_1_LEVEL_HEIGHT);
    this.moveToScreenCenter();
    this.setVisible(true);
  }

  /**
   * ������ɼ�����򿪵ĶԻ���
   * @param ebRetrievalTaskPanel ����ɼ�����
   * @param item �ɼ�����ѡ�еĶ���
   * @param isFromRetrievalTaskPanel 
   */
  public EbCandidateItemDialog(EbRetrievalTaskPanel ebRetrievalTaskPanel, EbItem item, boolean isFromRetrievalTaskPanel) {
    // TODO Auto-generated constructor stub
    super(ebRetrievalTaskPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);
    editPanel = new EbCandidateItemEditPanel(this.self, ebRetrievalTaskPanel, new ListCursor(), null, null, item, isFromRetrievalTaskPanel);
    setLayout(new BorderLayout());
    add(editPanel);
    this.setTitle(LangTransMeta.translate(compoId));
    this.setSize(UIConstants.DIALOG_1_LEVEL_WIDTH, UIConstants.DIALOG_1_LEVEL_HEIGHT);
    this.moveToScreenCenter();
    this.setVisible(true);
  }

  /**
   * ���Ǹ���ķ�����ʵ���Լ��������ESCAPE������
   */
  @Override
  protected JRootPane createRootPane() {
    KeyStroke stroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
    JRootPane rootPane = new JRootPane();
    rootPane.registerKeyboardAction(new ActionListener() {

      @Override
      public void actionPerformed(ActionEvent e) {
        escapeKeyProc();
      }
    }, stroke, JComponent.WHEN_IN_FOCUSED_WINDOW);

    return rootPane;
  }

  /**
   * ����ESCAPE����������������¸��Ǹ÷�����ʵ���Լ��Ĵ���ʽ��
   */
  protected void escapeKeyProc() {
    //    setVisible(false);
    dispose();
  }

}

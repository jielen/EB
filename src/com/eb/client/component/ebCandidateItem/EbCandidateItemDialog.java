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
   * 从任务采集界面打开的对话框
   * @param ebRetrievalTaskPanel 任务采集界面
   * @param item 采集界面选中的对象
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
   * 覆盖父类的方法。实现自己的添加了ESCAPE键监听
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
   * 处理ESCAPE按键。子类可以重新覆盖该方法，实现自己的处理方式。
   */
  protected void escapeKeyProc() {
    //    setVisible(false);
    dispose();
  }

}

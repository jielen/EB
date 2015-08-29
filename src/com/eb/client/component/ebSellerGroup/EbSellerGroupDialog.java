package com.eb.client.component.ebSellerGroup;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.util.List;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.common.ListCursor;
import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.GkBaseDialog;

public class EbSellerGroupDialog extends GkBaseDialog {

  private EbSellerGroupDialog self = this;

  private EbSellerGroupEditPanel editPanel;

  private EbSellerGroupListPanel listPanel;

  public EbSellerGroupDialog(EbSellerGroupListPanel listPanel, List beanList, int editingRow, String tabStatus) {
    // TODO Auto-generated constructor stub
    super(listPanel.getParentWindow(), Dialog.ModalityType.APPLICATION_MODAL);
    this.listPanel = listPanel;
    editPanel = new EbSellerGroupEditPanel(this.self, new ListCursor(beanList, editingRow), tabStatus, listPanel);
    setLayout(new BorderLayout());
    add(editPanel);
    this.setTitle(LangTransMeta.translate(listPanel.getCompoId()));
    this.setSize(UIConstants.DIALOG_3_LEVEL_WIDTH, UIConstants.DIALOG_3_LEVEL_HEIGHT);
    this.moveToScreenCenter();
    this.setVisible(true);
  }

}

package com.ufgov.gk.client.component.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComponent;

import com.ufgov.gk.client.component.JFuncToolBar;
import com.ufgov.gk.client.component.JSaveableSplitPane;
import com.ufgov.gk.client.component.button.AddButton;
import com.ufgov.gk.client.component.button.AddReChangeButton;
import com.ufgov.gk.client.component.button.AuditFinalPassButton;
import com.ufgov.gk.client.component.button.AuditPassButton;
import com.ufgov.gk.client.component.button.BlankOutButton;
import com.ufgov.gk.client.component.button.CallbackButton;
import com.ufgov.gk.client.component.button.CancelButton;
import com.ufgov.gk.client.component.button.DeleteButton;
import com.ufgov.gk.client.component.button.EditButton;
import com.ufgov.gk.client.component.button.FuncButton;
import com.ufgov.gk.client.component.button.HelpButton;
import com.ufgov.gk.client.component.button.IsSendToNextButton;
import com.ufgov.gk.client.component.button.PrintButton;
import com.ufgov.gk.client.component.button.PrintPreviewButton;
import com.ufgov.gk.client.component.button.PrintSettingButton;
import com.ufgov.gk.client.component.button.ReleaseButton;
import com.ufgov.gk.client.component.button.SendButton;
import com.ufgov.gk.client.component.button.SuggestAuditPassButton;
import com.ufgov.gk.client.component.button.TraceButton;
import com.ufgov.gk.client.component.button.UnauditButton;
import com.ufgov.gk.client.component.button.UntreadButton;
import com.ufgov.gk.common.system.constants.WFConstants;

/**
 * <p>Title: GK</p>
 * <p>Description: �����˱���Ϊ���б��Ƶ��ݵ��б�ҳ��Ļ���</p>
 * <p>Copyright: Copyright 2009 ufgov, Inc.</p>
 * <p>Company: ufgov</p>
 * <p>����ʱ��: 2009-4-20</p>
 * @author ����ΰ(manlge)
 * @version 1.0
 */
public abstract class AbstractEditListBill extends JComponent {
  /**
   * ����������
   */
  protected JFuncToolBar toolBar = new JFuncToolBar();

  /**
   * ��ʾ�ϡ���ҳǩ�ķָ����
   */
  protected JSaveableSplitPane splitPane = new JSaveableSplitPane(JSaveableSplitPane.VERTICAL_SPLIT);

  /**
   * ��������չʾ��
   */
  protected AbstractDataDisplay topDataDisplay;

  /**
   * ��������չʾ��
   */
  protected AbstractDataDisplay bottomDataDisplay;

  public AbstractEditListBill() {
  }

  /**
   * @param topDataDisplay ��ʾ�������DataDisplay
   * @param bottomDataDisplay ��ʾ�������DataDisplay
   */
  protected void init(AbstractDataDisplay topDataDisplay, AbstractDataDisplay bottomDataDisplay) {
    this.topDataDisplay = topDataDisplay;
    this.bottomDataDisplay = bottomDataDisplay;
    setLayout(new BorderLayout());
    addToolBarComponent(toolBar);
    add(toolBar, BorderLayout.NORTH);
    splitPane.setResizeWeight(0.40);
    splitPane.setOneTouchExpandable(true);
    splitPane.setDividerSize(11);

    splitPane.setDividerDefaultLocation(this.getClass().getName() + "_splitPane_dividerLocation", 300);

    if (topDataDisplay != null) {
      topDataDisplay.setMinimumSize(new Dimension(0, 0));
    }
    if (bottomDataDisplay != null) {
      bottomDataDisplay.setMinimumSize(new Dimension(0, 0));
    }

    splitPane.setLeftComponent(topDataDisplay);
    splitPane.setRightComponent(bottomDataDisplay);
    if (topDataDisplay == null || bottomDataDisplay == null) {
      splitPane.setDividerSize(0);
    }
    add(splitPane);
    onInitFinish();
  }

  /**
   * ��ӹ�������ť
   */
  protected abstract void addToolBarComponent(JFuncToolBar toolBar);

  public void onInitFinish() {

  }

  /**
   * �б�ҳ�泣�õİ�ť
   */
  public FuncButton isSendToNextButton = new IsSendToNextButton();

  public FuncButton callbackButton = new CallbackButton();

  public FuncButton auditPassButton = new AuditPassButton(); //���ͨ��

  public FuncButton unAuditButton = new UnauditButton(); // ����

  public FuncButton unTreadButton = new UntreadButton(); // �˻�

  public FuncButton suggestPassButton = new SuggestAuditPassButton();//��д������ͨ��

  public EditButton editButton = new EditButton();//�޸�

  public FuncButton printButton = new PrintButton();

  public FuncButton printPreviewButton = new PrintPreviewButton();

  public PrintSettingButton printSettingButton = new PrintSettingButton();

  public FuncButton traceButton = new TraceButton();

  public HelpButton helpButton = new HelpButton();

  public FuncButton deleteButton = new DeleteButton();

  public FuncButton addButton = new AddButton();

  public AddReChangeButton addReChangeButton = new AddReChangeButton();

  public FuncButton sendButton = new SendButton();

  public FuncButton cancelButton = new CancelButton();

  public FuncButton blankoutButton = new BlankOutButton();

  public ReleaseButton releaseButton = new ReleaseButton();

  public FuncButton auditFinalButton = new AuditFinalPassButton();

  /**
   * 
  * @Description: TODO ���ݵ�����ҳǩ�����ư�ť����ʾ
  * @return void ��������
  * @since 1.0
   */
  public void setButtonsVisiable() {
    String panelId = WFConstants.AUDIT_TAB_STATUS_TODO;
    if (topDataDisplay != null && topDataDisplay.getActiveTableDisplay() != null) {
      panelId = topDataDisplay.getActiveTableDisplay().getStatus();
    }
    if (WFConstants.AUDIT_TAB_STATUS_TODO.equalsIgnoreCase(panelId)) {//����
      auditPassButton.setVisible(true);
      suggestPassButton.setVisible(true);
      auditFinalButton.setVisible(true);
      isSendToNextButton.setVisible(true);
      unTreadButton.setVisible(true);
      sendButton.setVisible(false);
      deleteButton.setVisible(false);
      addButton.setVisible(false);
      addReChangeButton.setVisible(false);
      callbackButton.setVisible(false);
      traceButton.setVisible(true);
      editButton.setVisible(false);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(true);
    } else if (WFConstants.AUDIT_TAB_STATUS_DONE.equalsIgnoreCase(panelId)) {//�Ѱ�
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(false);
      deleteButton.setVisible(false);
      addButton.setVisible(false);
      addReChangeButton.setVisible(false);
      callbackButton.setVisible(true);
      traceButton.setVisible(true);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(false);
      unAuditButton.setVisible(true);
      cancelButton.setVisible(false);
    } else if (WFConstants.AUDIT_TAB_STATUS_ALL.equalsIgnoreCase(panelId)) {//ȫ��
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(false);
      deleteButton.setVisible(false);
      addButton.setVisible(false);
      addReChangeButton.setVisible(false);
      callbackButton.setVisible(false);
      traceButton.setVisible(true);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(false);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(false);
    } else if (WFConstants.EDIT_TAB_STATUS_EXEC.equalsIgnoreCase(panelId)) {//����
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(false);
      deleteButton.setVisible(false);
      addButton.setVisible(false);
      addReChangeButton.setVisible(false);
      callbackButton.setVisible(false);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(false);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(false);
    } else if (WFConstants.EDIT_TAB_STATUS_DRAFT.equalsIgnoreCase(panelId)) {//�ݸ�
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(true);
      deleteButton.setVisible(true);
      addButton.setVisible(true);
      addReChangeButton.setVisible(true);
      callbackButton.setVisible(false);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(true);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(true);
    } else if (WFConstants.EDIT_TAB_STATUS_UNSIGN.equalsIgnoreCase(panelId)) {//��ȷ��
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(true);
      deleteButton.setVisible(true);
      addButton.setVisible(true);
      addReChangeButton.setVisible(true);
      callbackButton.setVisible(false);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(true);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(true);
    } else if (WFConstants.EDIT_TAB_STATUS_SIGN.equalsIgnoreCase(panelId)) {//��ȷ��
      auditPassButton.setVisible(false);
      isSendToNextButton.setVisible(false);
      unTreadButton.setVisible(false);
      sendButton.setVisible(false);
      deleteButton.setVisible(false);
      addButton.setVisible(false);
      addReChangeButton.setVisible(false);
      callbackButton.setVisible(false);
      suggestPassButton.setVisible(false);
      auditFinalButton.setVisible(false);
      editButton.setVisible(false);
      unAuditButton.setVisible(false);
      cancelButton.setVisible(false);
    }
  }

}

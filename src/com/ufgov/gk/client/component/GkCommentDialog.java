/**
 * 
 */
package com.ufgov.gk.client.component;

/**
 * @author ufwangfei
 *
 */

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class GkCommentDialog extends GkBaseDialog implements ActionListener {
  /**
   * 
   */
  private static final long serialVersionUID = 7714089677620182874L;

  private JTextArea editor = new JTextArea(5, 45);

  private JButton confirmButton;

  private JButton cancelButton;

  private String comment = null;

  public boolean cancel = true;

  public GkCommentDialog() {
    super();
    init();
  }

  public GkCommentDialog(Frame owner) {
    super(owner);
    init();
  }

  public GkCommentDialog(Window owner, ModalityType modalityType) {
    super(owner, modalityType);
    init();
  }

  public GkCommentDialog(Window owner, ModalityType modalityType, String defaultText, String title) {
    super(owner, modalityType);
    this.defaultText = defaultText;
    this.title = title;
    init();
  }

  public GkCommentDialog(Window owner, ModalityType modalityType, String defaultText) {
    super(owner, modalityType);
    this.defaultText = defaultText;
    init();
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  private String defaultText = "同意";

  private String title = "输入意见";

  private void init() {
    this.getContentPane().setLayout(new BorderLayout());
    editor.setText(defaultText);
    JScrollPane jsp = new JScrollPane(editor);
    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.getContentPane().add(jsp, BorderLayout.CENTER);

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));//FlowLayout
    confirmButton = new JButton("确定");
    confirmButton.setActionCommand("confirm");
    confirmButton.addActionListener(this);
    cancelButton = new JButton("取消");
    cancelButton.setActionCommand("cancel");
    cancelButton.addActionListener(this);
    panel.add(confirmButton);
    panel.add(cancelButton);
    this.getContentPane().add(panel, BorderLayout.SOUTH);
    this.setSize(350, 200);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    this.moveToScreenCenter();
    this.setTitle(title);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("confirm")) {
      this.comment = editor.getText();
      this.cancel = false;
      this.closeDialog();
    }
    if (command.equals("cancel")) {
      this.closeDialog();
    }
  }

  public String getDefaultText() {
    return defaultText;
  }

  public void setDefaultText(String defaultText) {
    this.defaultText = defaultText;
  }

}

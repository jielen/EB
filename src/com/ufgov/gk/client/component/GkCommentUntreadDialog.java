/**
 *
 */
package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import com.ufgov.gk.client.common.AsOptionMeta;
import com.ufgov.gk.common.system.constants.BusinessOptionConstants;

public class GkCommentUntreadDialog extends GkBaseDialog implements ActionListener {

  private static final long serialVersionUID = 3472273909692910630L;

  private JTextArea editor = new JTextArea(5, 45);

  private JButton confirmButton;

  private JButton cancelButton;

  private String comment = null;

  public boolean cancel = true;

  private String isCommentControl = AsOptionMeta.getOptVal(BusinessOptionConstants.OPT_GK_UNTREAD_IS_COMMENT_CONTROL);

  private String unTreadComment = "请填写退回意见！";

  public GkCommentUntreadDialog() {
    super();
    init();
  }

  public GkCommentUntreadDialog(Frame owner) {
    super(owner);
    init();
  }

  public GkCommentUntreadDialog(Window owner, ModalityType modalityType) {
    super(owner, modalityType);
    init();
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }

  private void init() {
    this.getContentPane().setLayout(new BorderLayout());
    editor.setText("");
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
    this.setTitle(unTreadComment);
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("confirm")) {
      this.comment = editor.getText();
      if("Y".equalsIgnoreCase(this.isCommentControl)){
        if(comment==null||comment.trim().equals("") || comment.trim().equals(unTreadComment)){
          JOptionPane.showMessageDialog(this, unTreadComment, "提示",JOptionPane.INFORMATION_MESSAGE);
          return;
        }
      }
      this.cancel = false;
      this.closeDialog();
    }
    if (command.equals("cancel")) {
      this.closeDialog();
    }
  }

}

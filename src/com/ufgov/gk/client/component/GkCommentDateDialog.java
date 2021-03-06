package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.common.system.util.StringTools;

public class GkCommentDateDialog extends GkBaseDialog implements ActionListener {

  private static final long serialVersionUID = -2136607459664549383L;

  private JPanel panel = new JPanel();

  private JLabel label = new JLabel("修改日期：");

  private DateField dateTextField = new DateField();

  private JButton confirmButton;

  private JButton cancelButton;

  private Date dateIn = null;

  public boolean cancel = true;

  public GkCommentDateDialog() {
    super();
    init();
  }


  public Date getDateIn() {
    return dateIn;
  }


  public void setDateIn(Date dateIn) {
    this.dateIn = dateIn;
  }


  public GkCommentDateDialog(Frame owner) {
    super(owner);
    init();
  }

  public GkCommentDateDialog(Window owner, ModalityType modalityType) {
    super(owner, modalityType);
    init();
  }


  private void init() {
    this.getContentPane().setLayout(new BorderLayout());
    String date = StringTools.getDateFormat(WorkEnv.getInstance().getTransDate());
    dateTextField.setText(date);
    panel.add(label);
    panel.add(dateTextField);
    JScrollPane jsp = new JScrollPane(panel);
    jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    this.getContentPane().add(jsp, BorderLayout.CENTER);

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
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
    this.setTitle("修改日期");
    this.setVisible(true);
  }

  public void actionPerformed(ActionEvent event) {
    String command = event.getActionCommand();
    if (command.equals("confirm")) {
      this.dateIn = dateTextField.getDate();
        if(dateIn==null||dateTextField.getText().trim().equals("")){
          JOptionPane.showMessageDialog(this, "请选择修改日期 ！", "提示",JOptionPane.INFORMATION_MESSAGE);
          return;
        }
      this.cancel = false;
      this.closeDialog();
    }
    if (command.equals("cancel")) {
      this.closeDialog();
    }
  }

}

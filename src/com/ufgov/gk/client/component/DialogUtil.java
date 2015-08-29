package com.ufgov.gk.client.component;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DialogUtil {
  /**
   * ��ʾ�����
   * @param parentComponent
   * @param title
   * @return
   */
  public static String showPasswordDialog(Component parentComponent, String title) {
    String result = "";
    JPasswordField jpf = new JPasswordField(20);
    jpf.setEchoChar('*');
    int option = JOptionPane.showOptionDialog(parentComponent, jpf, title, JOptionPane.OK_CANCEL_OPTION,
      JOptionPane.QUESTION_MESSAGE, null, null, null);
    if (option == JOptionPane.OK_OPTION) {
      result = jpf.getText();
    }
    return result;
  }

  /**
   * ��ʾ��Ϣ��
   * @param parentComponent
   * @param title
   * @param message
   */
  public static void showMessageBoard(Component parentComponent, String title, String message) {
    JTextArea area = new JTextArea(15, 70);
    area.setEditable(false);
    area.enableInputMethods(false);
    area.setText(message);
    JScrollPane jp = new JScrollPane(area);
    JOptionPane.showOptionDialog(parentComponent, jp, title, JOptionPane.YES_OPTION,
      JOptionPane.INFORMATION_MESSAGE, null, new Object[] {}, null);
  }
  
  /**
   * ��ʾ�޸������
   * @param parentComponent
   * @param title
   * @return
   */
  public static String[] showChangePasswordDialog(Component parentComponent, String title) {
    JPasswordField oldPass = new JPasswordField(20);oldPass.setEchoChar('*');
    JPasswordField newPass = new JPasswordField(20);newPass.setEchoChar('*');
    JPasswordField confirmPass = new JPasswordField(20);confirmPass.setEchoChar('*');
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.add(createPanel("��pin��:", oldPass));
    panel.add(createPanel("��pin��:", newPass));
    panel.add(createPanel("ȷ��pin��:", confirmPass));
    int option = JOptionPane.showOptionDialog(parentComponent, panel, title, JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    if (option == JOptionPane.OK_OPTION) {
      String[] result = new String[]{oldPass.getText(), newPass.getText(), confirmPass.getText()};
      return result;
    } else {
      return null;
    }
    
  }
  
  private static JPanel createPanel(String label, JTextField field) {
    JPanel p = new JPanel();
    p.setLayout(new FlowLayout(FlowLayout.LEFT));
    JLabel l = new JLabel(label);
    l.setPreferredSize(new Dimension(100, 10));
    l.setHorizontalAlignment(SwingConstants.RIGHT);
    p.add(l);
    field.setEditable(true);
    p.add(field);
    return p;   
  }


}

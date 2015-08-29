package com.eb.client.component.test.image;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class Untitled6 extends JFrame implements ActionListener {
  AboutDialog1 dialog1;

  AboutDialog2 dialog2;

  AboutDialog3 dialog3;

  AboutDialog4 dialog4;

  JTextField t1 = new JTextField();

  JTextField t2 = new JTextField();

  CardLayout CardLayout1 = new CardLayout();

  JPanel panel = (JPanel) getContentPane();

  JPanel panel1 = new JPanel();

  JPanel panel2 = new JPanel();

  JPanel panel3 = new JPanel();

  JPanel panel4 = new JPanel();

  JPanel panel5 = new JPanel();

  JPanel panel6 = new JPanel();

  JToolBar toolbar = new JToolBar();

  JToolBar toolbar1 = new JToolBar();

  JButton button1 = new JButton("button1");

  JButton button2 = new JButton("button2");

  JButton button3 = new JButton("button3");

  JButton button4 = new JButton("button4");

  JButton button5 = new JButton("button5");

  JButton button6 = new JButton("button6");

  JButton button7 = new JButton("button7");

  JButton button8 = new JButton("button8");

  JButton button9 = new JButton("button8");

  JTabbedPane tab = new JTabbedPane();

  JLabel label = new JLabel("wo zuo de dialog");

  JLabel label1 = new JLabel("wo zuo sghdfhgsdgde dialog");

  JLabel label2 = new JLabel("wo zgfhgvsdfgag de dialog");

  JLabel label3 = new JLabel("wo sdasdaszuo de dialog");

  JLabel label4 = new JLabel("wo zuo dhmjjljie dialog");

  JLabel label5 = new JLabel("welcom to view my demo");

  public Untitled6() {
    ImageIcon image1 = new ImageIcon(this.getClass().getResource("/img/test/1.jpg"));
    ImageIcon image2 = new ImageIcon(this.getClass().getResource("/img/test/2.jpg"));
    ImageIcon image3 = new ImageIcon(this.getClass().getResource("/img/test/3.jpg"));
    ImageIcon image4 = new ImageIcon(this.getClass().getResource("/img/test/4.jpg"));
    this.setTitle("JSL_DIALOG");
    this.setContentPane(panel);
    panel.setLayout(new BorderLayout());
    panel.add(toolbar, BorderLayout.NORTH);
    panel.add(label, BorderLayout.SOUTH);
    panel.add(tab, BorderLayout.CENTER);

    toolbar.add(button1);
    toolbar.add(button2);
    toolbar.add(button3);
    toolbar.add(button4);
    panel5.setLayout(new BorderLayout());
    panel5.add(toolbar1, BorderLayout.EAST);
    toolbar1.setLayout(new GridLayout(2, 2, 5, 5));
    toolbar1.add(button5);
    toolbar1.add(button6);
    toolbar1.add(button7);
    toolbar1.add(button8);
    button5.addActionListener(this);
    button7.addActionListener(this);
    button6.addActionListener(this);
    button8.addActionListener(this);
    tab.add(panel1, "dome");
    tab.add(panel6, "mi ma ");
    panel6.setLayout(new GridLayout(4, 1, 5, 5));
    panel6.add(label5);
    panel6.add(t1);
    panel6.add(t2);
    panel6.add(button9);
    button9.addActionListener(this);
    panel1.setLayout(CardLayout1);
    panel1.add(panel5, "panel5");
    panel1.add(panel2, "panel2");
    panel2.add(label2);
    panel5.add(label1);
    panel1.add(panel3, "panel3");
    panel3.add(label3);
    panel1.add(panel4, "panel4");
    panel4.add(label4);
    label1.setIcon(image1);
    label2.setIcon(image2);
    label3.setIcon(image3);
    label4.setIcon(image4);
    button1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        CardLayout1.show(panel1, "panel2");

      }
    });
    button2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        CardLayout1.show(panel1, "panel3");

      }
    });
    button3.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        CardLayout1.show(panel1, "panel4");

      }
    });
    button4.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {

        CardLayout1.show(panel1, "panel5");

      }
    });

  }

  public void actionPerformed(ActionEvent evt) {
    Object source = evt.getSource();
    if (source == button5) {
      if (dialog1 == null)

        dialog1 = new AboutDialog1(this);
      dialog1.show();

    }
    if (source == button6) {
      if (dialog2 == null)

        dialog2 = new AboutDialog2(this);
      dialog2.show();

    }
    if (source == button7) {
      if (dialog3 == null)

        dialog3 = new AboutDialog3(this);
      dialog3.show();

    }
    if (source == button8) {
      if (dialog4 == null)

        dialog4 = new AboutDialog4(this);
      dialog4.show();

    }
    if (evt.getSource() == button9) {
      if (t1.getText().length() == 0) {
        label5.setText("请在上框输入用户名！TT");
      } else if (t2.getText().length() == 0) {
        label5.setText("请在下框输入密码！T");
      } else if (!t1.getText().equals(t2.getText())) {
        label5.setText("密码正确，欢迎观看演示图片");
      }
    }

  }

  public static void main(String[] args) {
    Untitled6 q = new Untitled6();
    q.show();
    q.pack();
  }
}

class AboutDialog1 extends JDialog {
  JLabel lab = new JLabel();

  JPanel pp = (JPanel) getContentPane();

  public AboutDialog1(JFrame parent) {

    ImageIcon image3 = new ImageIcon(this.getClass().getResource("/img/test/1.jpg"));
    this.setTitle("fasdfh");
    this.setContentPane(pp);
    pp.add(lab);
    lab.setIcon(image3);
    this.setVisible(true);
    this.pack();

  }

}

class AboutDialog2 extends JDialog {
  JLabel lab = new JLabel();

  JPanel pp = (JPanel) getContentPane();

  public AboutDialog2(JFrame parent) {

    ImageIcon image3 = new ImageIcon(this.getClass().getResource("/img/test/2.jpg"));
    this.setTitle("fasdfh");
    this.setContentPane(pp);
    pp.add(lab);
    lab.setIcon(image3);
    this.setVisible(true);
    this.pack();

  }

}

class AboutDialog3 extends JDialog {
  JLabel lab = new JLabel();

  JPanel pp = (JPanel) getContentPane();

  public AboutDialog3(JFrame parent) {

    ImageIcon image3 = new ImageIcon(this.getClass().getResource("/img/test/3.jpg"));
    this.setTitle("fasdfh");
    this.setContentPane(pp);
    pp.add(lab);
    lab.setIcon(image3);
    this.setVisible(true);
    this.pack();

  }

}

class AboutDialog4 extends JDialog {
  JLabel lab = new JLabel();

  JPanel pp = (JPanel) getContentPane();

  public AboutDialog4(JFrame parent) {

    ImageIcon image3 = new ImageIcon(this.getClass().getResource("/img/test/4.jpg"));
    this.setTitle("fasdfh");
    this.setContentPane(pp);
    pp.add(lab);
    lab.setIcon(image3);
    this.setVisible(true);
    this.pack();

  }

}

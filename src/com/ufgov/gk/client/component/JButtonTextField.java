package com.ufgov.gk.client.component;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.Document;

import com.ufgov.gk.client.common.BillElementMeta;
import com.ufgov.gk.client.component.event.ValueChangeEvent;
import com.ufgov.gk.client.component.event.ValueChangeListener;

public abstract class JButtonTextField extends JTextField {

  protected CountDownLatch latch = new CountDownLatch(1);

  protected JButtonTextField self = this;

  /**
   *
   */
  private static final long serialVersionUID = -6359125331512517315L;

  public Object value;

  public Map dataMap = new HashMap();

  public List filteredDataList = new ArrayList();

  public String compoId;

  public String prefix = "";

  public boolean randomEdit = true;

  public boolean levelCtrl = false;

  public int ctrlLen;

  public int ctrlLevelNum;

  public String elementCode;

  public void setBillElementMeta(BillElementMeta bem) {
    if (elementCode != null && !elementCode.trim().equals("")) {
      setRandomEdit(bem.isElementRandomEdit(elementCode));
      setCtrlLevelNum(bem.getCtrlLevelNum(elementCode));
      setEnabled(bem.isElementEditable(elementCode));
      setEditable(bem.isElementEditable(elementCode));
    }
  }

  public boolean isLevelCtrl() {
    return levelCtrl;
  }

  private void setLevelCtrl(boolean levelCtrl) {
    this.levelCtrl = levelCtrl;
  }

  public int getCtrlLen() {
    return ctrlLen;
  }

  public String getPrefix() {
    return prefix;
  }

  public void setPrefix(String prefix) {
    this.prefix = prefix;
  }

  public boolean isRandomEdit() {
    return randomEdit;
  }

  public void setRandomEdit(boolean randomEdit) {
    this.randomEdit = randomEdit;
  }

  public Map getDataMap() {
    return dataMap;
  }

  public void setDataMap(Map dataMap) {
    this.dataMap = dataMap;
  }

  public void setValueByCode(String valueCode) {
    if (valueCode == null) {
      this.setValue(null);
    } else {
      await();
      Object value = dataMap.get(valueCode);
      this.setValue(value);
    }
  }

  public void setValue(Object value) {
    this.value = value;
    if (value != null) {
      this.setText(value.toString());
      this.setToolTipText(value.toString());
    } else {
      this.setText("");
      this.setToolTipText(null);
    }
    fireValueChanged();

  }

  public Object getValue() {
    return this.value;
  }

  public JButton chooseButton = new JButton(" ") {
    /**
     *
     */
    private static final long serialVersionUID = -7456400999981871987L;

    {
      this.setCursor(Cursor.getDefaultCursor());
      this.setFocusable(false);
    }

    @Override
    public Insets getInsets() {
      return new Insets(0, 0, 0, 0);
    }

    @Override
    public Dimension getPreferredSize() {
      Dimension size = JButtonTextField.super.getPreferredSize();
      size.height -= 6;
      size.width = size.height;
      return size;
    }

    @Override
    public void paint(Graphics g) {
      super.paint(g);
      int width = 3;
      int height = 3;

      Rectangle rect = g.getClipBounds();
      int x = rect.width / 4;
      int y = rect.height / 2;

      for (int i = 0; i < 3;) {
        g.fillOval(++i * x, y, width, height);
      }
    }

  };

  protected Dialog owner;

  public JButtonTextField(Document doc, String text, int columns) {
    super(doc, text, columns);
    initButtonTextField();
  }

  public JButtonTextField(int columns) {
    super(columns);
    initButtonTextField();
  }

  @Override
  public void setEnabled(boolean enabled) {
    // super.setEnabled(enabled);
    chooseButton.setEnabled(enabled);
    super.setEnabled(enabled);
    chooseButton.setVisible(enabled);
  }

  public JButtonTextField(String text, int columns) {
    super(text, columns);
    initButtonTextField();
  }

  public JButtonTextField(String text) {
    super(text);
    initButtonTextField();
  }

  public JButtonTextField() {
    super();
    initButtonTextField();
  }

  protected void initButtonTextField() {

    chooseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        JButtonTextField.this.handleClick(JButtonTextField.this);
      }
    });
    this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));

    addKeyListener(new KeyAdapter() {

      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          chooseButton.doClick();
        }
      }
    });

    this.addFocusListener(new FocusAdapter() {
      public void focusLost(FocusEvent e) {
        validateInput();
      }

    });
    this.addKeyListener(new KeyAdapter() {
      public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == '\n') {
          return;
        }
        self.isInput = true;
      }

      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
          validateInput();
        }
      }

    });
  }

  public abstract void handleClick(JButtonTextField jButtonTextField);

  @Override
  public void addNotify() {
    super.addNotify();
    if (chooseButton != null)
      add(chooseButton);
  }

  public Dialog getOwner() {
    return owner;
  }

  public void addValueChangeListener(ValueChangeListener l) {
    this.listenerList.add(ValueChangeListener.class, l);
    self.setEditable(false);// 设置“品目代码”字段的文本框不可编辑，只可以选择品目。—— guoss
  }

  public void removeValueChangeListener(ValueChangeListener l) {
    this.listenerList.remove(ValueChangeListener.class, l);
  }

  protected void fireValueChanged() {
    ValueChangeEvent e = null;
    ValueChangeListener[] listeners = listenerList.getListeners(ValueChangeListener.class);
    for (ValueChangeListener l : listeners) {
      if (e == null) {
        e = new ValueChangeEvent(this);
      }
      l.valueChanged(e);
    }
  }

  public int getCtrlLevelNum() {
    return ctrlLevelNum;
  }

  public void setCtrlLevelNum(int ctrlLevelNum) {
    this.ctrlLevelNum = ctrlLevelNum;
    if (ctrlLevelNum > 0) {
      levelCtrl = true;
    }
  }

  private boolean isInput = false;

  protected GkBaseDialog selectDialog;

  private void validateInput() {
    String input = getText();
    // edit by kongqian 加了是否可编辑的判断(self.isEditable())
    if (isInput && self.isEditable()) {
      await();
      if (self.dataMap.get(input) == null) {
        self.setValue(null);
        self.isInput = false;
        if (!input.equals("")) {
          self.selectDialog.setVisible(false);
        }
      } else {
        self.isInput = false;
        if (this.filteredDataList.contains(self.dataMap.get(input))) {
          Object obj = dataMap.get(input);
          Class cls = obj.getClass();
          String str = cls.getName();
          String clsName = str.substring(str.lastIndexOf(".") + 1);
          System.out.println(clsName);

          self.setValue(self.dataMap.get(input));

        } else {
          self.setValue(null);
          // self.selectDialog.setVisible(true);
        }
      }
    }
  }

  protected void await() {
    try {
      latch.await();
    } catch (Exception ex) {
      throw new RuntimeException(ex.getMessage(), ex);
    }
  }

  protected void countDown() {
    latch.countDown();
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
    UnsupportedLookAndFeelException {

    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JFrame f = new JFrame();

    JButtonTextField textField = new JButtonTextField(15) {
      @Override
      public void handleClick(JButtonTextField jButtonTextField) {
        JOptionPane.showMessageDialog(null, "ddd");
        jButtonTextField.setText("ddddddddddd");
      }
    };

    // textField.setEditable(false);
    textField.setEnabled(false);
    textField.setEnabled(true);
    JPanel panel = new JPanel();
    panel.add(textField);
    f.getContentPane().add(panel, BorderLayout.NORTH);
    // f.pack();
    // SwingUtilities.updateComponentTreeUI(panel);
    f.setSize(400, 300);
    f.setLocationRelativeTo(null);
    f.setVisible(true);
    f.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // ///////////////

  }

}
/**
 * TimeTextField.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-6-2
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.TextUI;
import javax.swing.text.Document;

import com.ufgov.gk.common.system.util.DateUtil;

/**
 * @author Administrator
 *
 */
public class JDateTimeTextField extends JTextField {

  public static final String TimeTypeH24 = "24";

  public static final String TimeTypeH12 = "12";

  private boolean isZeroSecond = true;

  private boolean isZeroMinutes = true;

  private Integer[] allowMinutes = null;

  public static class DateChangeEvent extends EventObject {
    private Date date;

    public Date getDate() {
      return date;
    }

    public DateChangeEvent(JDateTimeTextField source, Date date) {
      super(source);
      this.date = date;
    }
  }

  public static interface DateChangeListener extends EventListener {
    public void dateChanged(DateChangeEvent e);
  }

  private static int DIALOG_WIDTH = 180;

  private static int DIALOG_HEIGHT = 230;

  private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

  private static SimpleDateFormat longDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  private boolean enabledYearSpinner = true;

  private boolean enabledMonthSpinner = true;

  private boolean enabledHourSpinner = false;

  private boolean enabledMinuteSpinner = false;

  private boolean enabledSecondSpinner = false;

  /**
   * �Ƿ���ʾʱ����
   */
  private boolean isDateTime = false;

  private String timeType = "";

  public void addDateChangeListener(DateChangeListener l) {
    listenerList.add(DateChangeListener.class, l);
  }

  public void removeDateChangeListener(DateChangeListener l) {
    listenerList.remove(DateChangeListener.class, l);
  }

  protected void fireDateChanged(DateChangeEvent e) {
    DateChangeListener[] listeners = listenerList.getListeners(DateChangeListener.class);
    for (DateChangeListener l : listeners) {
      l.dateChanged(e);
    }
  }

  private JButton chooseButton = new JButton(" ") {
    @Override
    protected void paintBorder(Graphics g) {
      super.paintBorder(g);
    }

    @Override
    public boolean isContentAreaFilled() {
      return true;
    }

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
      Dimension size = JDateTimeTextField.super.getPreferredSize();
      size.height -= 6;
      size.width = size.height;
      return size;
    }

    @Override
    public void paint(Graphics g) {
      super.paint(g);
      Rectangle rect = g.getClipBounds();

      int x = rect.width / 4;
      int y = rect.height / 2;
      int width = 2; //Բ����
      int height = 2; //Բ��߶�

      //�ڱ����ϻ�3��Բ��
      for (int i = 0; i < 3;) {
        g.fillOval(++i * x, y, width, height);
      }
    }

    @Override
    public void setBorder(Border border) {
      super.setBorder(border);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
      super.setContentAreaFilled(true);
    }
  };

  public JDateTimeTextField(Document doc, String text, int columns) {
    super(doc, text, columns);
    init();
  }

  public JDateTimeTextField(int columns) {
    super(columns);
    init();
  }

  @Override
  public void setEnabled(boolean enabled) {
    super.setEnabled(enabled);
    chooseButton.setEnabled(enabled);
  }

  public JDateTimeTextField(String text, int columns) {
    super(text, columns);
    init();
  }

  public JDateTimeTextField(String text) {
    super(text);
    init();
  }

  public JDateTimeTextField() {
    //    JDateTimeTextField.this.setUI(new BasicTextFieldUI(){
    //      @Override
    //      protected void paintSafely(Graphics g) {
    //        super.paintSafely(g);
    //      }
    //      
    //      @Override
    //      protected Rectangle getVisibleEditorRect() {
    //        return new Rectangle(80, 20);
    //      }
    //    });
    init();
  }

  public JDateTimeTextField(String text, String timeType) {
    super(text);
    if (timeType != null && (timeType.equals(JDateTimeTextField.TimeTypeH12) || timeType.equals(JDateTimeTextField.TimeTypeH24))) {
      this.isDateTime = true;
      this.enabledHourSpinner = true;
      this.enabledMinuteSpinner = true;
      this.enabledSecondSpinner = true;
      this.timeType = timeType;
    }
    init();
  }

  public JDateTimeTextField(String text, String timeType, int col) {
    super(text, col);
    if (timeType != null && (timeType.equals(JDateTimeTextField.TimeTypeH12) || timeType.equals(JDateTimeTextField.TimeTypeH24))) {
      this.isDateTime = true;
      this.enabledHourSpinner = true;
      this.enabledMinuteSpinner = true;
      this.enabledSecondSpinner = true;
      this.timeType = timeType;
    }
    init();
  }

  public JDateTimeTextField(String text, String timeType, boolean isZeroSecond) {
    super(text);
    if (timeType != null && (timeType.equals(JDateTimeTextField.TimeTypeH12) || timeType.equals(JDateTimeTextField.TimeTypeH24))) {
      this.isDateTime = true;
      this.enabledHourSpinner = true;
      this.enabledMinuteSpinner = true;
      this.enabledSecondSpinner = !isZeroSecond;
      this.isZeroSecond = isZeroSecond;
      this.timeType = timeType;
    }
    init();
  }

  public JDateTimeTextField(String text, String timeType, Integer[] allowMinutes, boolean isZeroSecond) {
    super(text);
    if (timeType != null && (timeType.equals(JDateTimeTextField.TimeTypeH12) || timeType.equals(JDateTimeTextField.TimeTypeH24))) {
      this.isDateTime = true;
      this.enabledHourSpinner = true;
      this.enabledMinuteSpinner = true;
      this.enabledSecondSpinner = !isZeroSecond;
      this.isZeroSecond = isZeroSecond;
      this.allowMinutes = allowMinutes;
      this.timeType = timeType;
    }
    init();
  }

  public JDateTimeTextField(String text, String timeType, boolean isZeroMinutes, boolean isZeroSecond) {
    super(text);
    if (timeType != null && (timeType.equals(JDateTimeTextField.TimeTypeH12) || timeType.equals(JDateTimeTextField.TimeTypeH24))) {
      this.isDateTime = true;
      this.enabledHourSpinner = true;
      this.enabledMinuteSpinner = !isZeroMinutes;
      this.enabledSecondSpinner = !isZeroSecond;
      this.isZeroSecond = isZeroSecond;
      this.timeType = timeType;
      this.isZeroMinutes = isZeroMinutes;
    }
    init();
  }

  private Window findParentWindow() {
    Component comp = this;
    while (comp != null && comp.getParent() != null) {
      comp = comp.getParent();
      if (comp instanceof Window)
        return (Window) comp;
    }
    return null;
  }

  @Override
  public Dimension getPreferredSize() {
    Dimension size = super.getPreferredSize();
    if (isDateTime) {
      size.width = getFontMetrics(getFont()).stringWidth("2000-12-24 23:22:22 ");
    } else {
      size.width = getFontMetrics(getFont()).stringWidth("2000-12-24 ");
    }
    size.width += chooseButton.getPreferredSize().width;
    return size;
  }

  private void init() {
    TimeZone tz = TimeZone.getTimeZone("ETC/GMT-8");
    TimeZone.setDefault(tz);
    setEditable(false);
    chooseButton.setToolTipText("����ѡ������");
    chooseButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        Point onScreenLocation = chooseButton.getLocationOnScreen();

        Point point = new Point(onScreenLocation);
        point.x -= DIALOG_WIDTH;
        if (point.x < 0)
          point.x = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        if (point.y + DIALOG_HEIGHT > screenSize.height)
          point.y -= (point.y + DIALOG_HEIGHT - screenSize.height);

        Calendar c = Calendar.getInstance();
        try {
          if (getText() != null)
            if (isDateTime) {
              c.setTime(DateUtil.ssStringToDate(getText()));
            } else {
              c.setTime(DateUtil.ddStringToDate(getText()));
            }
        } catch (Exception ex) {
        }
        DateChoose datePanel = new DateChoose(c);
        Date date;
        if (getText() != null) {
          try {
            if (isDateTime) {
              date = DateUtil.ssStringToDate(getText());
            } else {
              date = DateUtil.ddStringToDate(getText());
            }
          } catch (Exception ex) {
            date = new Date();
          }
        } else {
          date = new Date();
        }
        datePanel.show(date, point.x, point.y);
      }
    });
    this.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    this.add(chooseButton);

    setInputVerifier(new InputVerifier() {
      @Override
      public boolean verify(JComponent input) {
        if (getText() == null || getText().trim().length() < 1)
          return true;
        simpleDateFormat.setLenient(false);
        try {
          if (isDateTime) {
            longDateFormat.parse(getText());
          } else {
            simpleDateFormat.parse(getText());
          }
          return true;
        } catch (ParseException e) {
          JOptionPane.showMessageDialog(null, String.format("��Ч�����ڡ�%s��", getText()), "����", JOptionPane.WARNING_MESSAGE);
          return false;
        }
      }
    });

    addKeyListener(new KeyAdapter() {
      @Override
      public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
          chooseButton.doClick();
        }
        super.keyPressed(e);
      }
    });
  }

  @Override
  public void setUI(TextUI ui) {
    super.setUI(ui);
    this.removeAll();
    if (chooseButton != null)
      add(chooseButton);
  }

  class DateChoose extends JComponent {

    private int minYear = 1860;

    private int maxYear = 2860;

    private Color palletTableColor = getBackground();

    /**
     * ��������ɫ
     */
    private Color weekForceground = Color.BLUE;

    /**
     * ��������ɫ
     */
    private Color dateForeground = Color.BLACK;

    /**
     * ��ĩ����ɫ
     */
    private Color weekendForeground = Color.RED;

    /**
     * ����ƶ���������ɫ
     */
    private Color activeBackground = Color.LIGHT_GRAY;

    /**
     * �����������ɫ
     */
    private Color todayBackground = Color.GRAY;

    private JSpinner yearSpin;

    private JSpinner monthSpin;

    private JSpinner hourSpin;

    private JSpinner minuteSpin;

    private JSpinner secondSpin;

    /**
     * ��ʾ���ڵ�JLabel
     */
    private Map<Integer, JLabel> dayLabels = new HashMap<Integer, JLabel>(31);

    /**
     * ��ʾ���ǵ�JLabel
     */
    private JLabel[] weekLabels = new JLabel[7];

    /**
     * ��ʾ����ĶԻ���
     */
    private JDialog ownerDialog;

    /**
     * ��ʾ�յ�Panel
     */
    private JPanel dayPanel = new JPanel();

    /**
     * ��ʾ���Panel
     */
    private JPanel yearPanel = new JPanel();

    /**
     * ��ʾʱ�����panel
     */
    private JPanel hourPanel = new JPanel();

    /**
     * �ṩ��ʾ�������ݵ�calendar
     */
    private Calendar calendar = Calendar.getInstance();

    public DateChoose(Calendar calendar) {
      this.calendar = calendar;
      setLayout(new BorderLayout());
      setBorder(new LineBorder(Color.GRAY, 2));
      createWeekLabels();
      createDayLabels();
      createYearMonthPanal();
      createHmsPanal();

      this.setLayout(new BorderLayout());
      this.add(yearPanel, BorderLayout.NORTH);
      JPanel j = new JPanel();
      j.setLayout(new BorderLayout());
      j.add(hourPanel, BorderLayout.NORTH);
      j.add(dayPanel, BorderLayout.CENTER);
      this.add(j, BorderLayout.CENTER);

      yearSpin.setValue(calendar.get(Calendar.YEAR));
      monthSpin.setValue(calendar.get(Calendar.MONTH) + 1);
      hourSpin.setValue(calendar.get(Calendar.HOUR_OF_DAY));
      if (allowMinutes != null && allowMinutes.length > 0) {
        minuteSpin.setValue(allowMinutes[0]);
        for (int i = 0; i < allowMinutes.length; i++) {
          if (calendar.get(Calendar.MINUTE) == allowMinutes[i]) {
            minuteSpin.setValue(allowMinutes[i]);
            break;
          }
        }
      } else {
        if (isZeroMinutes) {
          minuteSpin.setValue(0);
        } else {
          minuteSpin.setValue(calendar.get(Calendar.MINUTE));
        }
      }
      if (isZeroSecond) {
        secondSpin.setValue(0);
      } else {
        secondSpin.setValue(calendar.get(Calendar.SECOND));
      }

      this.update();
      getActionMap().put("cancel", new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent e) {
          ownerDialog.setVisible(false);
          ownerDialog.dispose();
        }
      });
      getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0, false), "cancel");
    }

    /**
     * ������ʾ���ǵ�Label
     */
    private void createWeekLabels() {
      String colname[] = { "��", "һ", "��", "��", "��", "��", "��" };

      for (int i = 0; i < 7; i++) {
        JLabel label = new JLabel(colname[i]);
        label.setOpaque(true);
        label.setBackground(Color.LIGHT_GRAY);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(25, 25));
        if (i == 0 || i == 6) {
          label.setForeground(weekendForeground);
        } else {
          label.setForeground(weekForceground);
        }
        weekLabels[i] = label;
      }
    }

    /**
     * ������ʾ���JLabels
     */
    private void createDayLabels() {
      for (int day = 1; day <= 31; day++) {
        JLabel dayLabel = new JLabel();
        dayLabel.setOpaque(true);
        dayLabel.setBorder(BorderFactory.createEmptyBorder());
        dayLabel.setHorizontalAlignment(SwingConstants.CENTER);

        dayLabel.addMouseListener(new MouseAdapter() {

          @Override
          public void mouseClicked(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1 && e.getClickCount() == 1) {
              JLabel source = (JLabel) e.getSource();

              String value = source.getText();
              int day = Integer.parseInt(value);
              calendar.set(Calendar.DAY_OF_MONTH, day);
              if (isZeroSecond) {
                calendar.set(Calendar.SECOND, 0);
              }
              if (isZeroMinutes) {
                calendar.set(Calendar.MINUTE, 0);
              }
              Date selectDate = calendar.getTime();
              if (isDateTime) {
                JDateTimeTextField.this.setText(longDateFormat.format(selectDate));
              } else {
                JDateTimeTextField.this.setText(simpleDateFormat.format(selectDate));
              }
              ownerDialog.dispose();
            }
          }

          @Override
          public void mouseEntered(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            label.setBackground(activeBackground);
          }

          @Override
          public void mouseExited(MouseEvent e) {
            JLabel label = (JLabel) e.getSource();
            int comm = Integer.parseInt(label.getText());
            int today = calendar.get(Calendar.DAY_OF_MONTH);
            if (comm == today) {
              label.setBackground(todayBackground);
            } else {
              label.setBackground(palletTableColor);
            }
          }
        });

        dayLabel.setBackground(palletTableColor);
        dayLabel.setForeground(dateForeground);
        dayLabel.setText(String.valueOf(day));
        dayLabel.setPreferredSize(new Dimension(18, 18));
        dayLabels.put(day, dayLabel);
      }
    }

    /**
     * ������ʾ�ꡢ�µ�Panel
     */
    private void createYearMonthPanal() {
      int currentYear = calendar.get(Calendar.YEAR);
      int currentMonth = calendar.get(Calendar.MONTH) + 1;
      yearSpin = new JSpinner(new SpinnerNumberModel(currentYear, minYear, maxYear, 1));
      monthSpin = new JSpinner(new SpinnerNumberModel(currentMonth, 1, 12, 1));

      yearPanel.setLayout(new FlowLayout());
      yearPanel.setBackground(Color.GRAY);

      yearSpin.setPreferredSize(new Dimension(48, 20));
      yearSpin.setEditor(new JSpinner.NumberEditor(yearSpin, "####"));
      yearSpin.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
          calendar.set(Calendar.YEAR, ((Integer) yearSpin.getValue()).intValue());
          dayPanel.removeAll();
          update();
          dayPanel.revalidate();
          dayPanel.repaint();
        }
      });
      yearPanel.add(yearSpin);

      JLabel yearLabel = new JLabel("��");
      yearLabel.setForeground(Color.WHITE);
      yearPanel.add(yearLabel);

      monthSpin.setPreferredSize(new Dimension(35, 20));
      monthSpin.addChangeListener(new ChangeListener() {

        @Override
        public void stateChanged(ChangeEvent e) {
          calendar.set(Calendar.MONTH, ((Integer) monthSpin.getValue()).intValue() - 1);
          dayPanel.removeAll();
          update();
          dayPanel.revalidate();
          dayPanel.repaint();
        }

      });
      yearPanel.add(monthSpin);

      JLabel monthLabel = new JLabel("��");
      monthLabel.setForeground(Color.WHITE);
      yearPanel.add(monthLabel);
    }

    /**
     * ������ʾʱ���֡����Panel
     */
    private void createHmsPanal() {
      int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
      int currentMinute = calendar.get(Calendar.MINUTE);
      int currentSecond = calendar.get(Calendar.SECOND);
      hourSpin = new JSpinner(new SpinnerNumberModel(currentHour, 0, 23, 1));
      hourSpin.setPreferredSize(new Dimension(35, 20));
      if (allowMinutes != null && allowMinutes.length > 0) {
        minuteSpin = new JSpinner(new SpinnerListModel(allowMinutes));
      } else {
        minuteSpin = new JSpinner(new SpinnerNumberModel(currentMinute, 0, 59, 1));
      }
      minuteSpin.setPreferredSize(new Dimension(35, 20));
      if (isZeroSecond) {
        Integer[] second = { 0 };
        SpinnerModel model = new SpinnerListModel(second);
        secondSpin = new JSpinner(model);
      } else {
        secondSpin = new JSpinner(new SpinnerNumberModel(currentSecond, 0, 59, 1));
      }
      secondSpin.setPreferredSize(new Dimension(35, 20));
      if (allowMinutes == null || allowMinutes.length == 0) {
        if (isZeroMinutes) {
          Integer[] second = { 0 };
          SpinnerModel model = new SpinnerListModel(second);
          minuteSpin = new JSpinner(model);
        } else {
          minuteSpin = new JSpinner(new SpinnerNumberModel(currentMinute, 0, 59, 1));
        }
      }

      hourPanel.setLayout(new FlowLayout());
      hourPanel.setBackground(Color.GRAY);

      hourSpin.setPreferredSize(new Dimension(40, 20));
      hourSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          calendar.set(Calendar.HOUR_OF_DAY, ((Integer) hourSpin.getValue()).intValue());
        }
      });
      hourPanel.add(hourSpin);

      JLabel hourLabel = new JLabel("ʱ");
      hourLabel.setForeground(Color.WHITE);
      hourPanel.add(hourLabel);

      minuteSpin.setPreferredSize(new Dimension(40, 20));
      minuteSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          calendar.set(Calendar.MINUTE, ((Integer) minuteSpin.getValue()).intValue());
        }
      });
      hourPanel.add(minuteSpin);

      JLabel minuteLabel = new JLabel("��");
      minuteLabel.setForeground(Color.WHITE);
      hourPanel.add(minuteLabel);

      secondSpin.setPreferredSize(new Dimension(40, 20));
      secondSpin.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent e) {
          calendar.set(Calendar.SECOND, ((Integer) secondSpin.getValue()).intValue());
        }
      });
      hourPanel.add(secondSpin);

      JLabel secondLabel = new JLabel("��");
      secondLabel.setForeground(Color.WHITE);
      hourPanel.add(secondLabel);
    }

    /**
     * ����������
     */
    private void update() {
      int today = calendar.get(Calendar.DAY_OF_MONTH);
      dayPanel.setLayout(new GridBagLayout());
      dayPanel.setBackground(Color.WHITE);
      int x = 0;
      int y = 0;

      for (int i = 0; i < 7; i++) {
        dayPanel.add(weekLabels[i], new GridBagConstraints(x++, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0,
          0, 0, 0), 0, 0));
      }
      y++;

      Calendar c = (Calendar) calendar.clone();
      c.set(Calendar.DAY_OF_MONTH, 1); //ת�����µ�1��
      int month = c.get(Calendar.MONTH); //��
      while (month == c.get(Calendar.MONTH)) {
        int day = c.get(Calendar.DAY_OF_MONTH);
        /*
         * ȡ����ǰ���������еĵڼ��죬
         *    ������ 1
         *    ����һ 2
         *    ���Ƕ� 3
         *    ������ 4
         *    ������ 5
         *    ������ 6
         *    ������ 7
         */
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);

        JLabel dayLabel = dayLabels.get(day);
        x = dayOfWeek - 1;

        if (x == 0 || x == 6) {
          dayLabel.setForeground(weekendForeground);
        } else {
          dayLabel.setForeground(dateForeground);
        }
        if (day == today) {
          dayLabel.setBackground(todayBackground);
        }
        dayPanel.add(dayLabel, new GridBagConstraints(x, y, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
          new Insets(0, 0, 0, 0), 0, 0));

        //System.out.println(day + " " + (dayOfWeek));
        c.add(Calendar.DAY_OF_MONTH, 1);
        if (x == 6)
          y++; //��ʼ����
      }

      //��������ť
      JButton clearButton = new JButton("���");
      clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
          JDateTimeTextField.this.setText(null);
          ownerDialog.dispose();
        }
      });

      dayPanel.add(clearButton, new GridBagConstraints(0, y + 1, 7, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0,
        0, 0), 0, 0));

      //���ȷ����ť
      JButton okButton = new JButton("ȷ��");
      okButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          if (isZeroSecond) {
            calendar.set(Calendar.SECOND, 0);
          }
          if (isZeroMinutes) {
            calendar.set(Calendar.MINUTE, 0);
          }
          calendar.set(Calendar.MINUTE, ((Integer) minuteSpin.getValue()).intValue());
          Date selectDate = calendar.getTime();
          if (isDateTime) {
            JDateTimeTextField.this.setText(longDateFormat.format(selectDate));
          } else {
            JDateTimeTextField.this.setText(simpleDateFormat.format(selectDate));
          }
          ownerDialog.dispose();
        }
      });

      dayPanel.add(okButton, new GridBagConstraints(1, y + 1, 7, 1, 0.0, 0.0, GridBagConstraints.EAST, GridBagConstraints.NONE,
        new Insets(0, 0, 0, 0), 0, 0));
    }

    /**
     * ��ʾ����ѡ��
     * @param x
     * @param y
     */
    public void show(Date date, int x, int y) {
      yearSpin.setEnabled(isEnabledYearSpinner());
      monthSpin.setEnabled(isEnabledMonthSpinner());
      hourSpin.setEnabled(isEnabledHourSpinner());
      minuteSpin.setEnabled(isEnabledMinuteSpinner());
      secondSpin.setEnabled(isEnabledSecondSpinner());
      Window w = findParentWindow();
      if (w != null) {
        ownerDialog = new JDialog(w);
      } else {
        ownerDialog = new JDialog();
      }
      ownerDialog.setModal(false);
      ownerDialog.setUndecorated(true);
      ownerDialog.setLocation(x, y);
      ownerDialog.setSize(DIALOG_WIDTH, DIALOG_HEIGHT);

      ownerDialog.addWindowListener(new WindowAdapter() {
        @Override
        public void windowDeactivated(WindowEvent e) {
          SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
              ownerDialog.setVisible(false);
              ownerDialog.dispose();
              ownerDialog = null;
            }
          });
        }
      });
      Calendar c = Calendar.getInstance();
      c.setTime(date);
      ownerDialog.getContentPane().setLayout(new BorderLayout());
      ownerDialog.getContentPane().add(this);
      ownerDialog.setVisible(true);
    }
  }

  public boolean isEnabledYearSpinner() {
    return enabledYearSpinner;
  }

  public void setEnabledYearSpinner(boolean enabledYearSpinner) {
    this.enabledYearSpinner = enabledYearSpinner;
  }

  public boolean isEnabledMonthSpinner() {
    return enabledMonthSpinner;
  }

  public void setEnabledMonthSpinner(boolean enabledMonthSpinner) {
    this.enabledMonthSpinner = enabledMonthSpinner;
  }

  @Override
  public void setText(String t) {
    super.setText(t);
    fireDateChanged(new DateChangeEvent(this, getDate()));
  }

  public Date getDate() {
    String str = getText();
    if (str == null || str.trim().length() == 0)
      return null;
    try {
      if (isDateTime) {
        return longDateFormat.parse(str);
      } else {
        return simpleDateFormat.parse(str);
      }
    } catch (ParseException e) {
      e.printStackTrace();
      return null;
    }
  }

  /**
   * @return the enabledHourSpinner
   */
  public boolean isEnabledHourSpinner() {
    return enabledHourSpinner;
  }

  /**
   * @return the enabledMinuteSpinner
   */
  public boolean isEnabledMinuteSpinner() {
    return enabledMinuteSpinner;
  }

  /**
   * @return the enabledSecondSpinner
   */
  public boolean isEnabledSecondSpinner() {
    return enabledSecondSpinner;
  }

  public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
    UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    JDialog f = new JDialog();
    //    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setBounds(0, 0, 320, 240);
    Integer[] minutes = new Integer[60];//{ 0, 30 };
    for (int i = 0; i < minutes.length; i++) {
      minutes[i] = i;
    }
    JDateTimeTextField dateTextField = new JDateTimeTextField("", TimeTypeH24, true, true);
    dateTextField.setText("1998-11-15 12:13:20");
    dateTextField.setEnabled(true);
    f.add(dateTextField, BorderLayout.NORTH);
    SwingUtilities.updateComponentTreeUI(f);
    f.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    f.setVisible(true);
  }
}
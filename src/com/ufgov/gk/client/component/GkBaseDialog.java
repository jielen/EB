package com.ufgov.gk.client.component;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JDialog;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.util.UserPreferencesUtil;

public class GkBaseDialog extends JDialog {
  /**
  * Logger for this class
  */
  protected static final Logger logger = Logger.getLogger(GkBaseDialog.class);

  protected static int instanceCount = 0;

  /**
   *
   */
  private static final long serialVersionUID = 2630183294458549943L;

  public GkBaseDialog() {
    super();
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Frame owner) {
    super(owner);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Frame owner, boolean modal) {
    super(owner, modal);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Frame owner, String title) {
    super(owner, title);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Frame owner, String title, boolean modal) {
    super(owner, title, modal);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Frame owner, String title, boolean modal, GraphicsConfiguration gc) {
    super(owner, title, modal, gc);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Dialog owner) {
    super(owner);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Dialog owner, boolean modal) {
    super(owner, modal);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Dialog owner, String title) {
    super(owner, title);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Dialog owner, String title, boolean modal) {
    super(owner, title, modal);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Dialog owner, String title, boolean modal, GraphicsConfiguration gc) {
    super(owner, title, modal, gc);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Window owner) {
    super(owner);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Window owner, ModalityType modalityType) {
    super(owner, modalityType);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Window owner, String title) {
    super(owner, title);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Window owner, String title, ModalityType modalityType) {
    super(owner, title, modalityType);
    initIcon();
    installWindowListener();
  }

  public GkBaseDialog(Window owner, String title, ModalityType modalityType, GraphicsConfiguration gc) {
    super(owner, title, modalityType, gc);
    initIcon();
    installWindowListener();
  }

  private void initIcon() {
    Image image = new ImageIcon(this.getClass().getResource("/img/windowicon.jpg")).getImage();
    this.setIconImage(image);
  }

  protected void installWindowListener() {
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        isWindowClosingListenerInvoked = true;
        closeDialog();
      }
    });
  }

  public void moveToScreenCenter() {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gs = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gs.getDefaultConfiguration();
    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);

    if (frameSize.height > screenSize.height) {
      frameSize.height = screenSize.height;
    }
    if (frameSize.width > screenSize.width) {
      frameSize.width = screenSize.width;
    }
    setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - insets.bottom - frameSize.height) / 2);
  }

  @Override
  public void setVisible(boolean b) {

    UserPreferencesUtil userPreferencesUtil = UserPreferencesUtil.getInstance();
    int width = userPreferencesUtil.getInt(this.getClass().getName() + "Width", this.getWidth());
    int height = userPreferencesUtil.getInt(this.getClass().getName() + "Height", this.getHeight());

    setSize(width, height);
    this.moveToScreenCenter();

    if (isWindowClosingListenerInvoked) {
      if (isDisposed) {
        super.setVisible(false);
      } else {
        super.setVisible(true);
      }
      isWindowClosingListenerInvoked = false;
    } else {
      super.setVisible(b);
    }
  }

  public void closeDialog() {
    this.dispose();
  }

  @Override
  public void dispose() {
    instanceCount--;
    if (!dialogIsClosing()) {
      return;
    }
    if (logger.isDebugEnabled()) {
      logger.debug(this.getClass().getName() + " isDisposed:" + this.isDisposed + " isVisible: " + this.isVisible());
    }
    try {
      if (this.isVisible()) {
        UserPreferencesUtil userPreferencesUtil = UserPreferencesUtil.getInstance();
        userPreferencesUtil.putInt(this.getClass().getName() + "Width", this.getWidth());
        userPreferencesUtil.putInt(this.getClass().getName() + "Height", this.getHeight());
      }
    } finally {
      isDisposed = true;
      super.dispose();
    }
  }

  private boolean isDisposed = false;

  private boolean isWindowClosingListenerInvoked = false;

  protected boolean dialogIsClosing() {
    return true;
  }

  public void setMaxSizeWindow() {
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gs = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gs.getDefaultConfiguration();
    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(gc);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    this.setSize(screenSize.getSize().width, screenSize.getSize().height - insets.bottom);
  }

  public static int getInstanceCount() {
    return instanceCount;
  }
}

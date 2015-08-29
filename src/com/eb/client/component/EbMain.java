/**
 * Shell.java
 * com.eb.client.component
 * Administrator
 * Jun 22, 2012
 */
package com.eb.client.component;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.apache.log4j.PropertyConfigurator;

import com.ufgov.gk.client.common.LangTransMeta;
import com.ufgov.gk.client.component.EbComponentUtil;
import com.ufgov.gk.client.component.EbGarbageCollectButton;
import com.ufgov.gk.client.component.EbMemoryBar;
import com.ufgov.gk.client.component.EbStatusBar;
import com.ufgov.gk.client.component.EbStatusLabel;
import com.ufgov.gk.client.component.EbStatusMessageLabel;
import com.ufgov.gk.client.component.EbStatusTimeLabel;
import com.ufgov.gk.common.ebay.model.AppMenuItem;
import com.ufgov.gk.common.system.model.AsMenuCompo;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;

/**
 * @author Administrator
 *
 */
public class EbMain extends JFrame {

  TopMenuBarPanel tpMnbar;

  AppMenuPanel appMenuPanel;

  WorkplaceTabedPanel tbWorkPanel;

  EbStatusBar statusBar = new EbStatusBar();

  JPanel contentPanel = new JPanel();

  private EbStatusMessageLabel lbStatusMessage = new EbStatusMessageLabel();

  private EbMemoryBar memoryBar = new EbMemoryBar();

  private EbStatusLabel lbServer = createStatusLabel("127.0.0.1", "server.png");

  private EbStatusLabel lbUser = createStatusLabel("admin", "user.png");

  private EbStatusLabel lbVersion = createStatusLabel("v3.0.0", null);

  private EbStatusTimeLabel lbStatusTime = new EbStatusTimeLabel();

  static {
    LangTransMeta.init("%");
    PropertyConfigurator.configureAndWatch("log4j.properties", 50);
  }

  public EbMain() {
    super();
//    PropertyConfigurator.configureAndWatch("log4j.properties", 50);
    initswing();
    initStatusBar();

  }

  private void initswing() {
    // TODO Auto-generated method stub
    //    setTitle("Ebay Tools");
    //    setTitle("Ebay Tools");
    tpMnbar = new TopMenuBarPanel(this);
    tpMnbar.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 0));
    contentPanel.setLayout(new BorderLayout());
    contentPanel.add(tpMnbar, BorderLayout.NORTH);
    appMenuPanel = new AppMenuPanel(this);
    appMenuPanel.setBorder(BorderFactory.createEmptyBorder(3, 5, 3, 3));
    contentPanel.add(appMenuPanel, BorderLayout.WEST);
    tbWorkPanel = new WorkplaceTabedPanel(this);
    tbWorkPanel.setBorder(BorderFactory.createEmptyBorder(3, 0, 0, 3));
    contentPanel.add(tbWorkPanel, BorderLayout.CENTER);
    contentPanel.add(statusBar, BorderLayout.SOUTH);
    this.setContentPane(contentPanel);
    this.addWindowListener(new WindowAdapter() {

      @Override
      public void windowClosing(WindowEvent e) {
        // TODO Auto-generated method stub 
        // super.windowClosing(e); 
        System.exit(0);
      }
    });

  }

  /**
   * @param args
   * Administrator
   * Jun 22, 2012
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub    
    try {
      //      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
      UIManager.setLookAndFeel(new BlueLookAndFeel());
    } catch (Exception e) {
      e.printStackTrace();
    }
    SwingUtilities.invokeLater(new Runnable() {

      @Override
      public void run() {
        // TODO Auto-generated method stub
        EbMain eb = new EbMain();
        eb.validate();
        eb.setExtendedState(JFrame.MAXIMIZED_BOTH);
        eb.setVisible(true);
      }
    });

  }

  /*
   * 响应菜单树的双击时间
   */
  public void actionPerformMenuTreeDoubleClick(AppMenuItem item) {
    // TODO Auto-generated method stub
    if (item == null)
      return;
    AsMenuCompo menuCompo = item.getMenuCompo();
    if (menuCompo != null) {
      this.tbWorkPanel.setCompo(menuCompo);
    }
  }

  private void initStatusBar() {
    statusBar.getLeftPane().add(lbStatusMessage, BorderLayout.CENTER);
    statusBar.addSeparator();
    statusBar.getRightPane().add(memoryBar);
    statusBar.addSeparator();
    statusBar.getRightPane().add(new EbGarbageCollectButton());
    statusBar.addSeparator();
    statusBar.getRightPane().add(lbServer);
    statusBar.addSeparator();
    statusBar.getRightPane().add(lbUser);
    statusBar.addSeparator();
    statusBar.getRightPane().add(lbStatusTime);
    statusBar.addSeparator();
    statusBar.getRightPane().add(lbVersion);
    statusBar.addSeparator();
    statusBar.getRightPane().add(createStatusLabel("Powered by CJL", null));
  }

  private EbStatusLabel createStatusLabel(String text, String imageURL) {
    if (imageURL != null) {
      return new EbStatusLabel(text, EbComponentUtil.getIcon(imageURL));
    } else {
      return new EbStatusLabel(text);
    }
  }
}

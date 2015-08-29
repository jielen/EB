/*
Copyright (c) 2007 eBay, Inc.

This program is licensed under the terms of the eBay Common Development and
Distribution License (CDDL) Version 1.0 (the "License") and any subsequent
version thereof released by eBay.  The then-current version of the License
can be found at https://www.codebase.ebay.com/Licenses.html and in the
eBaySDKLicense file that is under the eBay SDK install directory.
*/

package example.apicallsdemo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.call.GetProductFinderCall;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;

/**
* <p>Title: </p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2004</p>
* <p>Company: eBay Inc.</p>
 * @author Changyi
 * @version 1.0
 */
public class DialogGetProductFinder extends JDialog {
  private ApiContext apiContext = new ApiContext();

  BorderLayout borderLayout1 = new BorderLayout();
  TitledBorder titledBorder1;
  TitledBorder titledBorder2;

  JPanel jPanel1 = new JPanel();
  BorderLayout borderLayout2 = new BorderLayout();
  JPanel jPanel2 = new JPanel();
  JPanel jPanel3 = new JPanel();
  JPanel jPanel4 = new JPanel();
  GridBagLayout gridBagLayout1 = new GridBagLayout();
  JButton btnGetProductFinder = new JButton();
  GridBagLayout gridBagLayout2 = new GridBagLayout();
  JLabel jLabel1 = new JLabel();
  JLabel jLabel2 = new JLabel();
  JTextField txtIDs = new JTextField();
  JLabel jLabel3 = new JLabel();
  JTextField txtBrowser = new JTextField();
  JLabel jLabel4 = new JLabel();
  GridBagLayout gridBagLayout3 = new GridBagLayout();
  JLabel jLabel5 = new JLabel();
  JLabel jLabel6 = new JLabel();
  JTextField txtCallStatus = new JTextField();

  public DialogGetProductFinder(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      pack();

      FrameDemo fd = (FrameDemo)frame;
      this.apiContext = fd.getApiContext();
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetProductFinder() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    titledBorder1 = new TitledBorder("");
    titledBorder2 = new TitledBorder("");
    jPanel1.setLayout(borderLayout2);
    this.setModal(true);
    this.setTitle("eBay SDK for Java - GetProductFinder");

    jPanel2.setBorder(null);
    this.jPanel2.setPreferredSize(new Dimension(320, 100));
    jPanel2.setLayout(gridBagLayout2);
    jPanel3.setBorder(BorderFactory.createEtchedBorder());
    this.jPanel3.setPreferredSize(new Dimension(420, 50));
    jPanel3.setLayout(gridBagLayout3);
    this.jPanel4.setPreferredSize(new Dimension(420, 50));
    jPanel4.setLayout(gridBagLayout1);

    btnGetProductFinder.setText("GetProductFinder");
    btnGetProductFinder.addActionListener(new DialogGetProductFinder_btnGetProductFinder_actionAdapter(this));
    jLabel1.setText("ProductFinderIDs:");
    jLabel2.setText("    ");
    txtIDs.setMinimumSize(new Dimension(6, 21));
    txtIDs.setPreferredSize(new Dimension(120, 21));
    txtIDs.setText("");
    jLabel3.setText("    ");
    txtBrowser.setPreferredSize(new Dimension(257, 21));
    txtBrowser.setText("");
    jLabel4.setText("Browser Command:");
    jLabel5.setText("CallStatus:");
    jLabel6.setText("        ");
    txtCallStatus.setBackground(Color.lightGray);
    txtCallStatus.setPreferredSize(new Dimension(80, 21));
    txtCallStatus.setText("");
    txtCallStatus.setHorizontalAlignment(SwingConstants.CENTER);
    this.getContentPane().add(jPanel1, BorderLayout.CENTER);
    jPanel1.add(jPanel2, BorderLayout.NORTH);
    jPanel1.add(jPanel3, BorderLayout.SOUTH);
    jPanel3.add(jLabel5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(jLabel6, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel3.add(txtCallStatus, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(btnGetProductFinder,  new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel2,  new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtIDs,   new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel3,   new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(jLabel4,   new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel2.add(txtBrowser, new GridBagConstraints(2, 2, 1, 2, 0.0, 0.0
            ,GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));

    this.txtBrowser.setText("C:/Program Files/Internet Explorer/IEXPLORE.EXE");
    this.setSize(new Dimension(420, 200));
    this.setResizable(false);
  }

  void btnGetProductFinder_actionPerformed(ActionEvent e) {
    try {
      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] {
          DetailLevelCodeType.RETURN_ALL,
          DetailLevelCodeType.ITEM_RETURN_ATTRIBUTES,
          DetailLevelCodeType.ITEM_RETURN_DESCRIPTION
      };

      String browserPath = this.txtBrowser.getText().trim();
      if (browserPath.length() < 1) {

      }

      GetProductFinderCall api = new GetProductFinderCall(this.apiContext);
      api.setDetailLevel(detailLevels);

      String sIDs = this.txtIDs.getText().trim();

      StringTokenizer st = new StringTokenizer(sIDs, ",");
      ArrayList lstIDs = new ArrayList();
      while (st.hasMoreTokens()) {
        lstIDs.add(st.nextToken());
      }

      int size = lstIDs.size();
      if (size > 0) {
        int [] ids = new int[size];
        for (int i = 0; i < size; i++) {
          ids[i] = Integer.parseInt(lstIDs.get(i).toString().trim());
        }
        api.setProductFinderIDs(ids);
      }

      api.getProductFinder();
      String resp = api.getProductFinderData();

      String homeDir = System.getProperty("user.home");
      long t = System.currentTimeMillis();
      String filePath = homeDir.replace('\\', '/') + "/" + t + ".xml";
      FileWriter fw = new FileWriter(filePath);
      if (resp == null) {
        Date dt = api.getResponseObject().getTimestamp().getTime();
        resp = "<?xml version=\"1.0\" encoding=\"utf-8\"?><eBay><EBayTime>";
        resp += eBayUtil.toAPITimeString(dt);
        resp += "</EBayTime><Version>";
        resp += api.getAttributeSystemVersion();
        resp += "</Version></eBay>";
      }
      fw.write(resp);
      fw.close();
      String cmd = browserPath + " " + filePath;
      Process process = Runtime.getRuntime().exec(cmd);
      this.txtCallStatus.setText(api.getResponseObject().getAck().value());
    }
    catch(Exception ex) {
      ((FrameDemo)this.getParent()).showErrorMessage(ex.getMessage());
    }
  }
}

class DialogGetProductFinder_btnGetProductFinder_actionAdapter implements java.awt.event.ActionListener {
  DialogGetProductFinder adaptee;

  DialogGetProductFinder_btnGetProductFinder_actionAdapter(DialogGetProductFinder adaptee) {
    this.adaptee = adaptee;
  }
  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetProductFinder_actionPerformed(e);
  }
}

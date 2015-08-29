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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.xml.datatype.Duration;

import org.apache.log4j.Logger;

import com.ebay.sdk.ApiContext;
import com.ebay.sdk.ApiException;
import com.ebay.sdk.SdkException;
import com.ebay.sdk.TimeFilter;
import com.ebay.sdk.call.GetSellerListCall;
import com.ebay.sdk.helper.Utils;
import com.ebay.sdk.helper.ui.ControlEntryTypes;
import com.ebay.sdk.helper.ui.ControlTagItem;
import com.ebay.sdk.helper.ui.GuiUtil;
import com.ebay.sdk.util.eBayUtil;
import com.ebay.soap.eBLBaseComponents.BestOfferDetailsType;
import com.ebay.soap.eBLBaseComponents.DetailLevelCodeType;
import com.ebay.soap.eBLBaseComponents.ItemType;
import com.ebay.soap.eBLBaseComponents.ListingDetailsType;
import com.ebay.soap.eBLBaseComponents.PaginationResultType;
import com.ebay.soap.eBLBaseComponents.PaginationType;

public class DialogGetSellerList extends JDialog {
  private static Logger log = Logger.getLogger(DialogGetSellerList.class);

  private ApiContext apiContext;

  final static String[] colNames = new String[] { "ItemID", "StartTime", "EndTime", "SellingDays", "Price", "QuantitySold", "sellingPerDay",
    "BidCount", "TimeLeft", "BOE", "title", "url" };

  final static int totalColumns = colNames.length;

  JPanel panel1 = new JPanel();

  BorderLayout borderLayout1 = new BorderLayout();

  JPanel jPanel1 = new JPanel();

  JPanel jPanelResponse = new JPanel();

  JPanel jPanel3 = new JPanel();

  JPanel jPanel4 = new JPanel();

  JPanel jPanel5 = new JPanel();

  BorderLayout borderLayout2 = new BorderLayout();

  JPanel jPanel6 = new JPanel();

  JPanel jPanel7 = new JPanel();

  JTextField txtUserID = new JTextField();

  JLabel jLabel1 = new JLabel();

  JTextField txtItemsPerPage = new JTextField();

  JLabel jLabel3 = new JLabel();

  JTextField txtPageNumber = new JTextField();

  JLabel jLabelPageNumber = new JLabel();

  JLabel jLabel4 = new JLabel();

  BorderLayout borderLayout3 = new BorderLayout();

  JLabel jLabel8 = new JLabel();

  JTextField txtStartTimeTo = new JTextField();

  JRadioButton rbtnUseStartTime = new JRadioButton();

  JPanel jPanel16 = new JPanel();

  JRadioButton rbtnUseEndTime = new JRadioButton();

  JPanel jPanelEndTimeFilter = new JPanel();

  JTextField txtEndTimeTo = new JTextField();

  JTextField txtStartTimeFrom = new JTextField();

  JTextField txtEndTimeFrom = new JTextField();

  JLabel jLabel5 = new JLabel();

  JLabel jLabel6 = new JLabel();

  JPanel jPanelStartTimeFilter = new JPanel();

  JLabel jLabel9 = new JLabel();

  JPanel jPanel13 = new JPanel();

  JButton btnGetSellerList = new JButton();

  ButtonGroup TimeFilterGroup = new ButtonGroup();

  BorderLayout borderLayout4 = new BorderLayout();

  JPanel jPanel14 = new JPanel();

  JScrollPane jScrollPane1 = new JScrollPane();

  JTable tblItems = new JTable();

  JPanel jPanel2 = new JPanel();

  BorderLayout borderLayout5 = new BorderLayout();

  JTextField txtHasMoreItems = new JTextField();

  JLabel jLabel7 = new JLabel();

  JTextField txtTotalNumberOfPages = new JTextField();

  JTextField txtCount = new JTextField();

  JLabel jLabel11 = new JLabel();

  JPanel jPanel22 = new JPanel();

  JTextField txtReturnedItemCountActual = new JTextField();

  JButton btnGetEntireSellerList = new JButton();

  BorderLayout borderLayout6 = new BorderLayout();

  JPanel jPanel30 = new JPanel();

  JPanel jPanel31 = new JPanel();

  JPanel jPanel32 = new JPanel();

  JPanel jPanel33 = new JPanel();

  JPanel jPanel34 = new JPanel();

  BorderLayout borderLayout7 = new BorderLayout();

  JPanel jPanel11 = new JPanel();

  JPanel jPanel12 = new JPanel();

  JPanel jPanel23 = new JPanel();

  GridBagLayout gridBagLayout1 = new GridBagLayout();

  JLabel jLabel2 = new JLabel();

  JLabel jLabel13 = new JLabel();

  JLabel jLabel14 = new JLabel();

  JLabel jLabel15 = new JLabel();

  JLabel jLabel16 = new JLabel();

  JLabel jLabel17 = new JLabel();

  GridBagLayout gridBagLayout2 = new GridBagLayout();

  JLabel jLabel18 = new JLabel();

  BorderLayout borderLayout8 = new BorderLayout();

  JPanel jPanel17 = new JPanel();

  JPanel jPanel24 = new JPanel();

  JPanel jPanel25 = new JPanel();

  GridBagLayout gridBagLayout3 = new GridBagLayout();

  JLabel jLabel19 = new JLabel();

  JLabel jLabel20 = new JLabel();

  JLabel jLabel21 = new JLabel();

  JLabel jLabel22 = new JLabel();

  JLabel jLabel23 = new JLabel();

  JLabel jLabel24 = new JLabel();

  GridBagLayout gridBagLayout4 = new GridBagLayout();

  JLabel jLabel10 = new JLabel();

  JLabel jLabel12 = new JLabel();

  JLabel jLabel25 = new JLabel();

  JLabel jLabel26 = new JLabel();

  JLabel jLabel27 = new JLabel();

  JComboBox cbxSortOrder = new JComboBox();

  JLabel jLabel28 = new JLabel();

  JTextField jTxtSoldQuality = new JTextField();

  public DialogGetSellerList(Frame frame, String title, boolean modal) {
    super(frame, title, modal);
    try {
      jbInit();
      customInit();
      FrameDemo fd = (FrameDemo) frame;
      this.apiContext = fd.getApiContext();

      // Pre-set time fields first.
      java.util.Calendar calTo = java.util.Calendar.getInstance(java.util.TimeZone.getTimeZone("GMT"));
      java.util.Date to = calTo.getTime();

      java.util.Calendar calFrom = (java.util.Calendar) calTo.clone();
      calFrom.add(java.util.Calendar.DATE, -5);
      java.util.Date from = calFrom.getTime();

      String fromStr = eBayUtil.toAPITimeString(from);
      String toStr = eBayUtil.toAPITimeString(to);

      this.txtStartTimeFrom.setText(fromStr);
      this.txtStartTimeTo.setText(toStr);

      this.txtEndTimeFrom.setText(fromStr);
      this.txtEndTimeTo.setText(toStr);

      //
      updateControlStatus();

    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public DialogGetSellerList() {
    this(null, "", false);
  }

  private void jbInit() throws Exception {
    panel1.setLayout(borderLayout1);
    jPanel3.setLayout(borderLayout2);
    jLabel1.setToolTipText("");
    jLabel1.setText("UserID: ");
    txtUserID.setPreferredSize(new Dimension(100, 21));
    txtUserID.setText("");
    jLabel3.setText("ItemsPerPage: ");
    jLabelPageNumber.setText("PageNumber: ");
    txtPageNumber.setPreferredSize(new Dimension(60, 21));
    txtPageNumber.setEditable(true);
    txtPageNumber.setText("1");
    txtItemsPerPage.setOpaque(true);
    txtItemsPerPage.setPreferredSize(new Dimension(60, 21));
    txtItemsPerPage.setText("200");
    jLabel4.setText("Sort: ");
    jPanel1.setLayout(borderLayout3);
    jLabel8.setVerifyInputWhenFocusTarget(true);
    jLabel8.setPreferredSize(new Dimension(80, 15));
    jLabel8.setText("EndTimeFrom: ");
    txtStartTimeTo.setMargin(new Insets(1, 1, 1, 1));
    txtStartTimeTo.setPreferredSize(new Dimension(120, 21));
    rbtnUseStartTime.setText("");
    rbtnUseStartTime.addChangeListener(new DialogGetSellerList_rbtnUseStartTime_changeAdapter(this));
    rbtnUseStartTime.setActionCommand("");
    rbtnUseStartTime.setSelected(true);
    txtEndTimeTo.setText("");
    txtEndTimeTo.setMargin(new Insets(1, 1, 1, 1));
    txtEndTimeTo.setPreferredSize(new Dimension(120, 21));
    txtStartTimeFrom.setOpaque(true);
    txtStartTimeFrom.setPreferredSize(new Dimension(120, 21));
    txtStartTimeFrom.setToolTipText("");
    txtStartTimeFrom.setSelectedTextColor(Color.white);
    txtStartTimeFrom.setText("");
    txtEndTimeFrom.setText("");
    txtEndTimeFrom.setSelectedTextColor(Color.white);
    txtEndTimeFrom.setToolTipText("");
    txtEndTimeFrom.setOpaque(true);
    txtEndTimeFrom.setPreferredSize(new Dimension(120, 21));
    jLabel5.setPreferredSize(new Dimension(80, 15));
    jLabel5.setText("StartTimeTo: ");
    jLabel6.setPreferredSize(new Dimension(80, 15));
    jLabel6.setVerifyInputWhenFocusTarget(true);
    jLabel6.setText("StartTimeFrom: ");
    jLabel9.setPreferredSize(new Dimension(80, 15));
    jLabel9.setText("EndTimeTo: ");
    btnGetSellerList.setText("GetSellerList");
    btnGetSellerList.addActionListener(new DialogGetSellerList_btnGetSellerList_actionAdapter(this));
    jPanelResponse.setLayout(borderLayout4);
    jScrollPane1.getViewport().setBackground(Color.white);
    jScrollPane1.setPreferredSize(new Dimension(454, 140));
    jScrollPane1.setToolTipText("");
    jPanel14.setLayout(borderLayout5);
    jLabel7.setText("HasMoreItems: ");
    jLabel11.setText("Count: ");
    txtCount.setPreferredSize(new Dimension(60, 21));
    txtCount.setEditable(false);
    txtCount.setText("");
    txtHasMoreItems.setPreferredSize(new Dimension(60, 21));
    txtHasMoreItems.setEditable(false);
    txtHasMoreItems.setText("");
    txtTotalNumberOfPages.setPreferredSize(new Dimension(60, 21));
    txtTotalNumberOfPages.setEditable(false);
    txtTotalNumberOfPages.setText("");
    txtReturnedItemCountActual.setPreferredSize(new Dimension(60, 21));
    txtReturnedItemCountActual.setEditable(false);
    txtReturnedItemCountActual.setText("asdf");
    rbtnUseEndTime.addChangeListener(new DialogGetSellerList_rbtnUseEndTime_changeAdapter(this));
    btnGetEntireSellerList.setText("GetEntireSellerList");
    btnGetEntireSellerList.addActionListener(new DialogGetSellerList_btnGetEntireSellerList_actionAdapter(this));
    jPanelStartTimeFilter.setBorder(null);
    jPanelStartTimeFilter.setPreferredSize(new Dimension(471, 130));
    jPanelStartTimeFilter.setLayout(borderLayout7);
    jPanel4.setPreferredSize(new Dimension(409, 41));
    jPanel4.setLayout(gridBagLayout4);
    jPanel11.setBorder(null);
    jPanel11.setPreferredSize(new Dimension(10, 80));
    jPanel11.setLayout(gridBagLayout1);
    jLabel2.setText("    ");
    jLabel13.setText("    ");
    jLabel15.setText("    ");
    jLabel16.setText("    ");
    jLabel17.setPreferredSize(new Dimension(45, 15));
    jLabel17.setText(" ");
    jPanel23.setLayout(gridBagLayout2);
    jLabel18.setText("        ");
    jPanelEndTimeFilter.setLayout(borderLayout8);
    jPanelEndTimeFilter.setBorder(BorderFactory.createEtchedBorder());
    jPanel16.setPreferredSize(new Dimension(10, 80));
    jPanel16.setLayout(gridBagLayout3);
    jLabel19.setText("    ");
    jLabel20.setPreferredSize(new Dimension(60, 15));
    jLabel20.setText(" ");
    jLabel21.setText("    ");
    jLabel22.setText("    ");
    jLabel23.setText("TotalNumberOfPages:");
    jLabel24.setText("ReturnedItemCountActual: ");
    jPanel2.setPreferredSize(new Dimension(20, 1));
    jPanel12.setPreferredSize(new Dimension(10, 1));
    jPanel13.setPreferredSize(new Dimension(10, 1));
    jLabel10.setText("    ");
    jLabel25.setText("    ");
    jLabel27.setText("    ");
    jLabel12.setPreferredSize(new Dimension(40, 15));
    jLabel12.setText("");
    jLabel26.setPreferredSize(new Dimension(40, 15));
    jLabel26.setText("");
    getContentPane().add(panel1);
    panel1.add(jPanel1, BorderLayout.CENTER);
    jPanelEndTimeFilter.add(jPanel16, BorderLayout.NORTH);
    jPanel16.add(jLabel11, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel16.add(jLabel19, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel16.add(txtCount, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel16.add(jLabel20, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel16.add(jLabel7,
      new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
    jPanel16.add(jLabel21, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel16.add(txtHasMoreItems, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
      0, 0), 0, 0));
    jPanel16.add(jLabel22, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel16.add(jLabel23, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel16.add(txtTotalNumberOfPages, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
      0, 0, 0, 0), 0, 0));
    jPanel16.add(jLabel24, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel16.add(txtReturnedItemCountActual, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
      new Insets(0, 0, 0, 0), 0, 0));
    jPanelEndTimeFilter.add(jPanel17, BorderLayout.SOUTH);
    jPanelEndTimeFilter.add(jPanel24, BorderLayout.WEST);
    jPanelEndTimeFilter.add(jPanel25, BorderLayout.EAST);
    jPanelEndTimeFilter.add(jScrollPane1, BorderLayout.CENTER);
    jScrollPane1.getViewport().add(tblItems, null);
    jPanel1.add(jPanelStartTimeFilter, BorderLayout.NORTH);
    jPanelStartTimeFilter.add(jPanel11, BorderLayout.NORTH);
    jPanel11.add(rbtnUseStartTime, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
      0, 0), 0, 0));
    jPanel11.add(jLabel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel11.add(jLabel5, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel11.add(jLabel13, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel11.add(txtStartTimeTo, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0,
      0), 0, 0));
    jPanel11.add(jLabel14, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel11.add(jLabel6, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel11.add(jLabel15, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel11.add(txtStartTimeFrom, new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
      0, 0), 0, 0));
    jPanel11.add(jLabel16, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel11.add(rbtnUseEndTime, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0,
      0), 0, 0));
    jPanel11.add(jLabel9, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel11.add(txtEndTimeTo, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
      new Insets(0, 0, 0, 0), 0, 0));
    jPanel11.add(jLabel8, new GridBagConstraints(7, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel11.add(txtEndTimeFrom, new GridBagConstraints(9, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0,
      0), 0, 0));
    jPanel11.add(jLabel17, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanelStartTimeFilter.add(jPanel12, BorderLayout.SOUTH);
    jPanelStartTimeFilter.add(jPanel23, BorderLayout.CENTER);
    jPanel23.add(btnGetSellerList, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
      0, 0), 0, 0));
    jPanel23.add(jLabel18, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0),
      0, 0));
    jPanel23.add(btnGetEntireSellerList, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
      0, 0, 0, 0), 0, 0));
    jPanel1.add(jPanel13, BorderLayout.SOUTH);
    jPanel1.add(jPanelEndTimeFilter, BorderLayout.CENTER);
    panel1.add(jPanelResponse, BorderLayout.SOUTH);
    jPanelResponse.add(jPanel14, BorderLayout.NORTH);
    panel1.add(jPanel3, BorderLayout.NORTH);
    jPanel3.add(jPanel5, BorderLayout.NORTH);
    jPanel5.add(jPanel7, null);
    jPanel7.add(jLabel1, null);
    jPanel7.add(txtUserID, null);
    jPanel5.add(jPanel6, null);
    jPanel3.add(jPanel4, BorderLayout.CENTER);
    jPanel4.add(jLabel3, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(jLabel10, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(txtItemsPerPage, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0,
      0), 0, 0));
    jPanel4.add(jLabel12, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(jLabelPageNumber, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0,
      0, 0), 0, 0));
    jPanel4.add(jLabel25, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(txtPageNumber, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
      new Insets(0, 0, 0, 0), 0, 0));
    jPanel4.add(jLabel26, new GridBagConstraints(7, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(jLabel4, new GridBagConstraints(8, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(jLabel27, new GridBagConstraints(9, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0,
      0));
    jPanel4.add(cbxSortOrder, new GridBagConstraints(10, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE,
      new Insets(0, 0, 0, 0), 0, 0));
    TimeFilterGroup.add(rbtnUseStartTime);
    TimeFilterGroup.add(rbtnUseEndTime);
    jPanel14.add(jPanel2, BorderLayout.CENTER);
    jPanel2.add(jPanel22, null);
    txtReturnedItemCountActual.setText("");

    this.setSize(new Dimension(750, 600));
  }

  void customInit() {
    initStaticControls();
  }

  void initStaticControls() {
    DefaultComboBoxModel dataModel = new DefaultComboBoxModel(ControlEntryTypes.sortOrderInt);
    this.cbxSortOrder.setModel(dataModel);
    this.cbxSortOrder.setSelectedIndex(0);

  }

  static void UpdateFilterPanel(JRadioButton rbtn, JTextField from, JTextField to) {
    boolean enable = rbtn.isSelected();
    from.setEnabled(enable);
    to.setEnabled(enable);

  }

  void updateControlStatus() {
    UpdateFilterPanel(this.rbtnUseStartTime, this.txtStartTimeFrom, this.txtStartTimeTo);
    UpdateFilterPanel(this.rbtnUseEndTime, this.txtEndTimeFrom, this.txtEndTimeTo);
  }

  static String[] itemToColumns(ItemType item) {
    String[] cols = new String[DialogGetSellerList.totalColumns];
    int i = 0;
    cols[i++] = item.getItemID().toString();

    ListingDetailsType dtl = item.getListingDetails();

    cols[i++] = eBayUtil.toAPITimeString(dtl.getStartTime().getTime());

    cols[i++] = eBayUtil.toAPITimeString(dtl.getEndTime().getTime());

    Calendar curDate = dtl.getEndTime();
    if (curDate.getTime().getTime() > Calendar.getInstance().getTimeInMillis()) {
      curDate = Calendar.getInstance();
    }

    double days = getSellingDays(dtl.getStartTime(), curDate) + 1;
    cols[i++] = "" + days;

    cols[i++] = (new Double(item.getSellingStatus().getCurrentPrice().getValue())).toString();
    Integer qs = item.getSellingStatus().getQuantitySold();
    cols[i++] = (qs == null) ? "" : qs.toString();

    DecimalFormat df = new DecimalFormat("#.00");
    cols[i++] = (qs == null) ? "" : "" + df.format((qs.intValue() / days));

    cols[i++] = item.getSellingStatus().getBidCount().toString();

    Duration tl = item.getTimeLeft();
    cols[i++] = java.text.MessageFormat.format("{0} days {1} hours", new Object[] { new Integer(tl.getDays()), new Integer(tl.getHours()) });

    BestOfferDetailsType bod = item.getBestOfferDetails();
    cols[i++] = bod == null ? "" : Utils.booleanToYesNo(bod.isBestOfferEnabled());

    cols[i++] = item.getTitle();

    cols[i++] = dtl.getViewItemURL();

    return cols;
  }

  private static double getSellingDays(Calendar startTime, Calendar endTime) {
    // TODO Auto-generated method stub
    Calendar cl = Calendar.getInstance();
    cl.setTime(startTime.getTime());

    Date st = startTime.getTime();

    Date et = endTime.getTime();

    long ds = et.getTime() - st.getTime();

    long dds = ds / 1000 / 60 / 60 / 24;

    return Math.floor(Double.valueOf("" + dds));
  }

  void CallGST(boolean getEntire) {
    try {
      GetSellerListCall api = new GetSellerListCall(this.apiContext);

      DetailLevelCodeType[] detailLevels = new DetailLevelCodeType[] { DetailLevelCodeType.RETURN_ALL };
      api.setDetailLevel(detailLevels);

      if (this.txtUserID.getText().length() > 0) {
        api.setUserID(this.txtUserID.getText());
      }

      // Time filters.
      TimeFilter tf;

      if (this.rbtnUseStartTime.isSelected()) {
        tf = GuiUtil.getTimeFilterFromFields(this.txtStartTimeFrom, this.txtStartTimeTo);
        if (tf != null)
          api.setStartTimeFilter(tf);
      }

      if (this.rbtnUseEndTime.isSelected()) {
        tf = GuiUtil.getTimeFilterFromFields(this.txtEndTimeFrom, this.txtEndTimeTo);
        if (tf != null)
          api.setEndTimeFilter(tf);
      }

      // Pagination.
      PaginationType pt = new PaginationType();
      if (this.txtItemsPerPage.getText().length() > 0)
        pt.setEntriesPerPage(new Integer(this.txtItemsPerPage.getText()));
      if (this.txtPageNumber.getText().length() > 0)
        pt.setPageNumber(new Integer(this.txtPageNumber.getText()));

      api.setPagination(pt);

      // Sort.
      Integer sortOrder = (Integer) ((ControlTagItem) this.cbxSortOrder.getSelectedItem()).Tag;
      api.setSort(sortOrder.intValue());

      ItemType[] firstItems;

      List<ItemType> allItems = new ArrayList<ItemType>();

      // Call eBay.
      if (getEntire) {
        firstItems = api.getEntireSellerList();
        this.txtCount.setText(new Integer(firstItems.length).toString());
        this.txtHasMoreItems.setText("");
        this.txtTotalNumberOfPages.setText("");
        this.txtReturnedItemCountActual.setText("");
      } else {
        firstItems = api.getSellerList();

        PaginationResultType pnresult = api.getPaginationResult();

        // Display results.
        int pageNumber = this.txtPageNumber.getText() == null ? 1 : Integer.parseInt(this.txtPageNumber.getText());
        if (pageNumber < pnresult.getTotalNumberOfPages()) {
          while (pageNumber < pnresult.getTotalNumberOfPages()) {
            ++pageNumber;
            getNextPageItems(api, pageNumber, allItems);
          }
        }
        this.txtCount.setText(pnresult.getTotalNumberOfEntries().toString());

        this.txtHasMoreItems.setText(api.getHasMoreItems() ? "yes" : "no");
        this.txtTotalNumberOfPages.setText(pnresult.getTotalNumberOfPages() == null ? "" : pnresult.getTotalNumberOfPages().toString());
        this.txtReturnedItemCountActual.setText(new Integer(api.getReturnedItemCountActual()).toString());
      }
      //将第一批的结果也加入到结果中
      filtItem(firstItems, allItems);

      //      final ItemType[] items = allItems.toArray(new ItemType[0]);
      ItemType[] orignal = allItems.toArray(new ItemType[0]);
      //计入文本文件
      writeToFile(orignal);

      final ItemType[] items = sort(orignal);
      //
      TableModel dataModel = new AbstractTableModel() {
        public int getColumnCount() {
          return DialogGetSellerList.totalColumns;
        }

        public int getRowCount() {
          return items == null ? 0 : items.length;
        }

        public String getColumnName(int columnIndex) {
          return colNames[columnIndex];
        }

        public Object getValueAt(int row, int col) {
          ItemType item = items[row];
          return DialogGetSellerList.itemToColumns(item)[col];
        }

        public boolean isCellEditable(int rowIndex, int columnIndex) {
          return true;
        }
      };

      this.tblItems.setModel(dataModel);

      this.tblItems.setEnabled(true);

    } catch (Exception ex) {
      ((FrameDemo) this.getParent()).showErrorMessage(ex.getMessage());
      log.error(ex.getMessage(), ex);
    }
  }

  /*
   * 写入文本文件
   */
  private void writeToFile(ItemType[] items) throws ParseException {
    if (items == null || items.length == 0)
      return;
    // TODO Auto-generated method stub
    //写入文本文件
    String fileName = this.txtUserID.getText();
    Calendar cl = Calendar.getInstance();
    DateFormat df = DateFormat.getInstance();
    if (this.rbtnUseStartTime.isSelected()) {
      //      Date d = df.parse(this.txtStartTimeFrom.getText());
      //      cl.setTime(d);
      //      fileName += "_UseStartTime_" + cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH);
      //      d = df.parse(this.txtStartTimeTo.getText());
      //      cl.setTime(d);
      //      fileName += "_" + cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH);
      fileName += "_UseStartTime_" + this.txtStartTimeFrom.getText().substring(0, 10).trim();
      fileName += "_" + this.txtStartTimeTo.getText().substring(0, 10).trim();

    }
    if (this.rbtnUseEndTime.isSelected()) {
      //      Date d = df.parse(this.txtEndTimeFrom.getText());
      //      cl.setTime(d);
      //      fileName += "_UseEndTime_" + cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH);
      //
      //      d = df.parse(this.txtEndTimeTo.getText());
      //      cl.setTime(d);
      //      fileName += "_" + cl.get(Calendar.YEAR) + "-" + (cl.get(Calendar.MONTH) + 1) + "-" + cl.get(Calendar.DAY_OF_MONTH);
      fileName += "_UseEndTime_" + this.txtEndTimeFrom.getText().substring(0, 10).trim();
      fileName += "_" + this.txtEndTimeTo.getText().substring(0, 10).trim();
    }
    fileName += ".csv";

    FileOutputStream outSTr = null;
    BufferedOutputStream Buff = null;

    StringBuffer bf = new StringBuffer();

    try {
      outSTr = new FileOutputStream(new File(fileName));
      Buff = new BufferedOutputStream(outSTr);
      bf.append("itemId,fromTime,toTime,sellingDays,price,quantitySold,sellingPerDay,bidCount,timeLeft,boe,title,url\n");
      Buff.write(bf.toString().getBytes());

      for (int i = 0; i < items.length; i++) {
        ItemType item = items[i];
        bf = new StringBuffer();
        bf.append(item.getItemID()).append(",");

        ListingDetailsType dtl = item.getListingDetails();

        bf.append(eBayUtil.toAPITimeString(dtl.getStartTime().getTime())).append(",");

        bf.append(eBayUtil.toAPITimeString(dtl.getEndTime().getTime())).append(",");

        Calendar curDate = dtl.getEndTime();
        if (curDate.getTime().getTime() > Calendar.getInstance().getTimeInMillis()) {
          curDate = Calendar.getInstance();
        }

        double days = getSellingDays(dtl.getStartTime(), curDate) + 1;
        bf.append(days).append(",");

        bf.append(new Double(item.getSellingStatus().getCurrentPrice().getValue())).append(",");

        Integer qs = item.getSellingStatus().getQuantitySold();
        bf.append((qs == null) ? "" : qs.toString()).append(",");

        DecimalFormat dft = new DecimalFormat("#.00");
        bf.append((qs == null) ? "" : "" + dft.format((qs.intValue() / days))).append(",");

        bf.append(item.getSellingStatus().getBidCount().toString()).append(",");

        bf.append(item.getTitle()).append(",");

        bf.append(dtl.getViewItemURL()).append(",");

        bf.append("\n");

        Buff.write(bf.toString().getBytes());
      }
      Buff.flush();
      Buff.close();
      outSTr.close();
    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error(e.getMessage(), e);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      log.error(e.getMessage(), e);
    } finally {

      try {
        Buff.close();
        outSTr.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        log.error(e.getMessage(), e);
      }
    }

  }

  private ItemType[] sort(ItemType[] array) {
    quickSort(array, 0, array.length - 1);
    return array;
  }

  private void quickSort(ItemType[] array, int low, int high) {
    /*   
     * 如果分区中的低指针小于高指针时循环；如果low=higth说明数组只有一个元素，无需再处理；   
     * 如果low > higth，则说明上次枢纽元素的位置pivot就是low或者是higth，此种情况   
     * 下分区不存，也不需处理   
     */
    if (low < high) {
      //对分区进行排序整理      

      int pivot = partition1(array, low, high);
      //        int pivot = partition2(array, low, high);     
      //int pivot = partition3(array, low, high);         

      /*   
       * 以pivot为边界，把数组分成三部分[low, pivot - 1]、[pivot]、[pivot + 1, high]   
       * 其中[pivot]为枢纽元素，不需处理，再对[low, pivot - 1]与[pivot + 1, high]   
       * 各自进行分区排序整理与进一步分区   
       */
      quickSort(array, low, pivot - 1);
      quickSort(array, pivot + 1, high);
    }
  }

  /**   
   * 快速排序算法实现一   
   *    
   * @param array 待排序数组   
   * @param low 低指针   
   * @param high 高指针   
   * @param c 比较器   
   * @return int 调整后中枢位置   
   */
  private int partition1(ItemType[] array, int low, int high) {
    ItemType pivotElem = array[low];//以第一个元素为中枢元素      
    //从前向后依次指向比中枢元素小的元素，刚开始时指向中枢，也是小于与大小中枢的元素的分界点      
    int border = low;

    /*   
     * 在中枢元素后面的元素中查找小于中枢元素的所有元素，并依次从第二个位置从前往后存放   
     * 注，这里最好使用i来移动，如果直接移动low的话，最后不知道数组的边界了，但后面需要   
     * 知道数组的边界   
     */
    for (int i = low + 1; i <= high; i++) {
      //如果找到一个比中枢元素小的元素      
      if (array[i].getSellingStatus().getQuantitySold().intValue() < pivotElem.getSellingStatus().getQuantitySold().intValue()) {
        swap(array, ++border, i);//border前移，表示有小于中枢元素的元素      
      }
    }
    /*   
     * 如果border没有移动时说明说明后面的元素都比中枢元素要大，border与low相等，此时是   
     * 同一位置交换，是否交换都没关系；当border移到了high时说明所有元素都小于中枢元素，此   
     * 时将中枢元素与最后一个元素交换即可，即low与high进行交换，大的中枢元素移到了 序列最   
     * 后；如果 low <minIndex< high，表 明中枢后面的元素前部分小于中枢元素，而后部分大于   
     * 中枢元素，此时中枢元素与前部分数组中最后一个小于它的元素交换位置，使得中枢元素放置在   
     * 正确的位置   
     */
    swap(array, border, low);
    return border;
  }

  /**   
  * 交换数组中的两个元素的位置   
  * @param array 待交换的数组   
  * @param i 第一个元素   
  * @param j 第二个元素   
  */
  private void swap(ItemType[] array, int i, int j) {
    if (i != j) {//只有不是同一位置时才需交换      
      ItemType tmp = array[i];
      array[i] = array[j];
      array[j] = tmp;
    }

  }

  private void filtItem(ItemType[] retItems, List<ItemType> allItems) {
    for (int i = 0; i < retItems.length; i++) {
      int s = retItems[i].getSellingStatus().getQuantitySold() == null ? 0 : retItems[i].getSellingStatus().getQuantitySold().intValue();
      if (s > 0) {
        allItems.add(retItems[i]);
      }
    }
    retItems = null;
  }

  /*
   * 获取其他页面的结果，并过滤掉没有卖掉的物品
   */
  private void getNextPageItems(GetSellerListCall api, int pageNumber, List<ItemType> allItems) throws ApiException, SdkException, Exception {
    PaginationType pt = new PaginationType();
    if (this.txtItemsPerPage.getText().length() > 0)
      pt.setEntriesPerPage(new Integer(this.txtItemsPerPage.getText()));
    if (pageNumber > 0)
      pt.setPageNumber(new Integer(pageNumber));

    api.setPagination(pt);

    ItemType[] rlt = api.getSellerList();

    filtItem(rlt, allItems);

  }

  void btnGetSellerList_actionPerformed(ActionEvent e) {
    CallGST(false);
  }

  void btnGetEntireSellerList_actionPerformed(ActionEvent e) {
    CallGST(true);
  }

  void rbtnUseStartTime_stateChanged(ChangeEvent e) {
    updateControlStatus();
  }

  void rbtnUseEndTime_stateChanged(ChangeEvent e) {
    updateControlStatus();
  }
}

class DialogGetSellerList_btnGetSellerList_actionAdapter implements java.awt.event.ActionListener {
  DialogGetSellerList adaptee;

  DialogGetSellerList_btnGetSellerList_actionAdapter(DialogGetSellerList adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetSellerList_actionPerformed(e);
  }
}

class DialogGetSellerList_rbtnUseStartTime_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetSellerList adaptee;

  DialogGetSellerList_rbtnUseStartTime_changeAdapter(DialogGetSellerList adaptee) {
    this.adaptee = adaptee;
  }

  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnUseStartTime_stateChanged(e);
  }
}

class DialogGetSellerList_rbtnUseEndTime_changeAdapter implements javax.swing.event.ChangeListener {
  DialogGetSellerList adaptee;

  DialogGetSellerList_rbtnUseEndTime_changeAdapter(DialogGetSellerList adaptee) {
    this.adaptee = adaptee;
  }

  public void stateChanged(ChangeEvent e) {
    adaptee.rbtnUseEndTime_stateChanged(e);
  }
}

class DialogGetSellerList_btnGetEntireSellerList_actionAdapter implements java.awt.event.ActionListener {
  DialogGetSellerList adaptee;

  DialogGetSellerList_btnGetEntireSellerList_actionAdapter(DialogGetSellerList adaptee) {
    this.adaptee = adaptee;
  }

  public void actionPerformed(ActionEvent e) {
    adaptee.btnGetEntireSellerList_actionPerformed(e);
  }
}

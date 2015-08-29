/**
 * SearchSameItemDialog.java
 * com.eb.client.component.ebCandidateItem
 * Administrator
 * Jul 20, 2012
 */
package com.eb.client.component.ebCandidateItem;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * @author Administrator
 *
 */
public class SearchSameItemDialog extends JDialog {

  /**
   * 
   */
  private static final long serialVersionUID = -8684857739729553176L;

  private EbCandidateItemEditPanel parent;

  private SkuSearchHelper skuHelper;

  JPanel panel = new JPanel();

  JLabel label1 = new JLabel("搜索模式：");

  JLabel label2 = new JLabel("SKU：");

  final JTextField skuText = new JTextField(20);

  final JRadioButton yesButton = new JRadioButton("模糊");

  final JRadioButton noButton = new JRadioButton("精确");

  JButton confirmButton = new JButton("确定");

  public SearchSameItemDialog(EbCandidateItemEditPanel ebCandidateItemEditPanel, SkuSearchHelper skuHelper) {
    super(ebCandidateItemEditPanel.getOwner());
    //    this.skuHelper = ebCandidateItem;
    this.parent = ebCandidateItemEditPanel;
    this.skuHelper = skuHelper;
    init();
  }

  private void init() {
    // TODO Auto-generated method stub
    skuText.setText(skuHelper.getSku());
    ButtonGroup bg = new ButtonGroup();
    bg.add(yesButton);
    bg.add(noButton);
    yesButton.setSelected(true);
    noButton.setSelected(false);

    confirmButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        confirm();
      }
    });

    panel.setLayout(new GridBagLayout());

    panel.add(label1, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 2, 2), 0, 0));
    panel.add(yesButton, new GridBagConstraints(1, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2),
      0, 0));
    panel.add(noButton, new GridBagConstraints(2, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2),
      0, 0));
    panel.add(label2, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(2, 0, 2, 2), 0, 0));

    panel.add(skuText, new GridBagConstraints(1, 1, 2, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(2, 0, 2, 2),
      0, 0));
    panel.add(confirmButton, new GridBagConstraints(1, 2, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(5, 0, 5,
      2), 0, 0));
    getContentPane().add(panel);
  }

  protected void confirm() {
    if (yesButton.isSelected()) {
      skuHelper.setIllegibility(true);
    } else if (noButton.isSelected()) {
      skuHelper.setIllegibility(false);
    }
    skuHelper.setSku(skuText.getText());
    this.parent.searchWithSkuSetting(skuHelper);
    this.dispose();
  }

}

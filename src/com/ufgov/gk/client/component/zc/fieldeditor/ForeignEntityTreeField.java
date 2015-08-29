/**
 * ForeignEntityTreeField.java
 * com.ufgov.gk.client.component.zc.fieldeditor
 * Administrator
 * 2010-5-6
 */
package com.ufgov.gk.client.component.zc.fieldeditor;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.ufgov.gk.client.common.WorkEnv;
import com.ufgov.gk.client.component.IForeignEntityTreeHandler;
import com.ufgov.gk.client.component.JButtonTextField;
import com.ufgov.gk.common.system.model.TreeNodeValueObject;
import com.ufgov.smartclient.plaf.BlueLookAndFeel;

/**
 * @author Administrator
 *
 */
public class ForeignEntityTreeField extends JButtonTextField {

  /**
   * 
   */
  private static final long serialVersionUID = 2512095201613517440L;

  private int nd = WorkEnv.getInstance().getTransNd();

  private String sqlMapSelectedId;

  private IForeignEntityTreeHandler handler;

  private String title;

  /**
   * @return the nd
   */
  public int getNd() {
    return nd;
  }

  /**
   * @param nd the nd to set
   */
  public void setNd(int nd) {
    this.nd = nd;
  }

  /**
   * @return the dataRuleId
   */
  public String getSqlMapSelectedId() {
    return sqlMapSelectedId;
  }

  /**
   * @param dataRuleId the dataRuleId to set
   */
  public void setSqlMapSelectedId(String sqlMapSelectedId) {
    this.sqlMapSelectedId = sqlMapSelectedId;
  }

  public ForeignEntityTreeField(String sqlMapSelectedId, int col, IForeignEntityTreeHandler handler, String title) {

    super(col);
    this.title = title;
    this.sqlMapSelectedId = sqlMapSelectedId;
    this.handler = handler;
    this.init();
  }

  private void init() {
    selectDialog = new ForeignEntityTreeDialog(owner, true, this, this.handler, this.sqlMapSelectedId, this.title);
  }

  /* (non-Javadoc)
   * @see com.ufgov.gk.client.component.JButtonTextField#handleClick(com.ufgov.gk.client.component.JButtonTextField)
   */
  @Override
  public void handleClick(JButtonTextField jButtonTextField) {
    await();
    selectDialog.setVisible(true);
  }

  /**
   * @param args
   * Administrator
   * 2010-5-6
   */
  public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
          UIManager.setLookAndFeel(new BlueLookAndFeel());
        } catch (Exception e) {
          e.printStackTrace();
        }
        class TreeHandler implements IForeignEntityTreeHandler {

          @Override
          public void excute(List selectedDatas) {
            // TODO Auto-generated method stub
            for (Object obj : selectedDatas) {
              TreeNodeValueObject td = (TreeNodeValueObject) obj;
              System.out.println(td.getCode() + "\t" + td.getName());
            }
          }

          @Override
          public boolean isMultipleSelect() {
            // TODO Auto-generated method stub
            return false;
          }

          @Override
          public boolean isSelectLeaf() {
            // TODO Auto-generated method stub
            return true;
          }

        }
        //        UIManager.getDefaults().put("SplitPaneUI", BigButtonSplitPaneUI.class.getName());
        ForeignEntityTreeField textField = new ForeignEntityTreeField("ZcBCatalogue.getZcBCatalogue", 20, new TreeHandler(), "ƷĿѡ��");

        JPanel panel = new JPanel();
        panel.add(textField);
        JFrame frame = new JFrame("ForeignEntityTreeField test Window");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setVisible(true);
      }
    });
  }

}

package com.ufgov.gk.client.print;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperPrint;

import org.apache.log4j.Logger;

import com.ufgov.gk.client.common.UIConstants;
import com.ufgov.gk.client.component.GkBaseDialog;
import com.ufgov.gk.common.system.dto.PrintObject;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class PrintPreviewer extends GkBaseDialog {
  /**
   * 
   */
  private static final long serialVersionUID = -2500423493405968163L;

  /**
  * Logger for this class
  */
  private static final Logger logger = Logger.getLogger(PrintPreviewer.class);

  private List jasperPrintList = new ArrayList();

  private PrintPreviewer self = this;

  private PrintPreviewPanel printPreviewPanel;

  private PrintObject printObject;

  public PrintPreviewer(PrintObject po) {
    super();
    printObject = po;
    this.setJasperPrint(po.getPrintDataList());
    this.init();
  }

  private void init() {
    getContentPane().setLayout(new BorderLayout());
    printPreviewPanel = new PrintPreviewPanel(jasperPrintList) {
      private static final long serialVersionUID = 1333149876328101828L;

      public void doPrint() {
        self.doPrint();
      }
    };
    getContentPane().add(printPreviewPanel, BorderLayout.CENTER);
    setModal(true);
 
    setSize(UIConstants.PRINT_PREVIEW_DIALOG_WIDTH, UIConstants.PRINT_PREVIEW_DIALOG_HEIGHT);
    setTitle("��ӡԤ��");
  }

  private void setJasperPrint(List jasperPrintBytesList) {
    for (Object o : jasperPrintBytesList) {
      byte[] jasperPrintBytes = (byte[]) o;
      jasperPrintList.add((JasperPrint) ObjectUtil.bytesToObject(jasperPrintBytes));
    }
  }

  public void preview() {
    this.moveToScreenCenter();
    setVisible(true);
  }

  public static void preview(PrintObject po) {
    (new PrintPreviewer(po)).preview();
  }

  public boolean doPrint() {
    boolean success = true;
    boolean printed = false;
    try {
      if(!beforePrint()){
         return false;
      }
      if (Printer.print(printObject)) {
        printed = true;
      }
    } catch (Exception e) {
      success = false;
      logger.error(e.getMessage(), e);
      JOptionPane.showMessageDialog(this, "��ӡ����\n" + e.getMessage(), "����",
        JOptionPane.ERROR_MESSAGE);
    }
    if (success && printed) {
        afterSuccessPrint();
    }
    return printed;
  }
  /**
   * 
   * @return ����true ʱ��ӡ�������� �����ٽ��д�ӡ
   */
  
  protected boolean  beforePrint(){
    return true;
  }

  protected void afterSuccessPrint() {

  }
}

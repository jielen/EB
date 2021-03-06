package com.ufgov.gk.client.print;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import java.awt.print.PrinterJob;
import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRReport;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRGraphics2DExporter;
import net.sf.jasperreports.engine.export.JRGraphics2DExporterParameter;
import net.sf.jasperreports.engine.util.JRGraphEnvInitializer;

import com.ufgov.gk.common.system.dto.PrintObject;
import com.ufgov.gk.common.system.exception.PrintException;
import com.ufgov.gk.common.system.util.ObjectUtil;

public class Printer implements Printable {

  private List jasperPrintList = new ArrayList();

  private int totalPageSize = 0;

  private int pageOffset = 0;

  private Printer(List jasperPrintList) {
    try {
      JRGraphEnvInitializer.initializeGraphEnv();
    } catch (JRException e) {
      throw new PrintException(e.getMessage(), e);
    }
    this.jasperPrintList = jasperPrintList;
    totalPageSize = calculateTotalPageNum(this.jasperPrintList);
  }

  private static boolean printPages(List jrPrintList, int firstPageIndex,
    int lastPageIndex, boolean withPrintDialog) {

    Printer printer = new Printer(jrPrintList);

    return printer.printPages(firstPageIndex, lastPageIndex, withPrintDialog);
  }

  private boolean printPages(int firstPageIndex, int lastPageIndex,
    boolean withPrintDialog) {
    boolean isOK = true;

    if (firstPageIndex < 0 || firstPageIndex > lastPageIndex
      || lastPageIndex >= totalPageSize) {
      throw new PrintException("Invalid page index range : " + firstPageIndex
        + " - " + lastPageIndex + " of " + totalPageSize);
    }

    pageOffset = firstPageIndex;

    PrinterJob printJob = PrinterJob.getPrinterJob();
    PageFormat pageFormat = printJob.defaultPage();
    Paper paper = pageFormat.getPaper();

    switch (getCurrentJasperPrint(firstPageIndex).getOrientation()) {
    case JRReport.ORIENTATION_LANDSCAPE: {
      pageFormat.setOrientation(PageFormat.LANDSCAPE);
      paper.setSize(getCurrentJasperPrint(firstPageIndex).getPageHeight(),
        getCurrentJasperPrint(firstPageIndex).getPageWidth());
      paper.setImageableArea(0, 0, getCurrentJasperPrint(firstPageIndex)
        .getPageHeight(), getCurrentJasperPrint(firstPageIndex).getPageWidth());
      break;
    }
    case JRReport.ORIENTATION_PORTRAIT:
    default: {
      pageFormat.setOrientation(PageFormat.PORTRAIT);
      paper.setSize(getCurrentJasperPrint(firstPageIndex).getPageWidth(),
        getCurrentJasperPrint(firstPageIndex).getPageHeight());
      paper.setImageableArea(0, 0, getCurrentJasperPrint(firstPageIndex)
        .getPageWidth(), getCurrentJasperPrint(firstPageIndex).getPageHeight());
    }
    }

    pageFormat.setPaper(paper);

    Book book = new Book();
    book.append(this, pageFormat, lastPageIndex - firstPageIndex + 1);
    printJob.setPageable(book);
    try {
      if (withPrintDialog) {
        if (printJob.printDialog()) {
          printJob.print();
        } else {
          isOK = false;
        }
      } else {
        printJob.print();
      }
    } catch (Exception ex) {
      throw new PrintException("Error printing report.", ex);
    }

    return isOK;
  }

  public int print(Graphics graphics, PageFormat pageFormat, int tatolPageIndex) {
    if (Thread.currentThread().isInterrupted()) {
      throw new PrintException("Current thread interrupted.");
    }

    tatolPageIndex += pageOffset;

    if (tatolPageIndex < 0 || tatolPageIndex >= this.totalPageSize) {
      return Printable.NO_SUCH_PAGE;
    }

    try {
      JRGraphics2DExporter exporter = new JRGraphics2DExporter();
      exporter.setParameter(JRExporterParameter.JASPER_PRINT,
        getCurrentJasperPrint(tatolPageIndex));
      exporter.setParameter(JRGraphics2DExporterParameter.GRAPHICS_2D,
        (Graphics2D) graphics);
      exporter.setParameter(JRGraphics2DExporterParameter.PAGE_INDEX, new Integer(
        convertToPageIndexInCurrentJasperPrint(tatolPageIndex)));
      exporter.exportReport();
    } catch (JRException e) {
      throw new PrintException(e.getMessage());
    }
    return Printable.PAGE_EXISTS;
  }

  private static int calculateTotalPageNum(List jrList) {
    int total = 0;
    for (int i = 0; i < jrList.size(); i++) {
      JasperPrint temp = (JasperPrint) jrList.get(i);
      total += temp.getPages().size();
    }
    return total;
  }

  private JasperPrint getCurrentJasperPrint(int totalPageIndex) {
    int total = 0;
    JasperPrint current = null;
    for (int i = 0; i < jasperPrintList.size(); i++) {
      JasperPrint temp = (JasperPrint) jasperPrintList.get(i);
      if (temp.getPages() != null) {
        total += temp.getPages().size();
      }
      if (totalPageIndex <= (total - 1)) {
        current = temp;
        break;
      }
    }
    return current;
  }

  private int convertToPageIndexInCurrentJasperPrint(int pageIndex) {
    int beforeCurrentTotal = 0;
    int pageIndexInCurrentJasperPrint = 0;

    for (int i = 0; i < jasperPrintList.size(); i++) {
      JasperPrint temp = (JasperPrint) jasperPrintList.get(i);

      if (temp.getPages() != null) {
        beforeCurrentTotal += temp.getPages().size();
      }
      if (pageIndex <= (beforeCurrentTotal - 1)) {
        beforeCurrentTotal -= temp.getPages().size();
        break;
      }
    }
    pageIndexInCurrentJasperPrint = pageIndex - beforeCurrentTotal;
    return pageIndexInCurrentJasperPrint;
  }

  private static boolean printReport(List jasperPrintList, boolean withPrintDialog) {
    return printPages(jasperPrintList, 0,
      calculateTotalPageNum(jasperPrintList) - 1, withPrintDialog);
  }

  private static boolean printReport(JasperPrint jasperPrint, boolean withPrintDialog) {
    List list = new ArrayList();
    list.add(jasperPrint);
    return printReport(list, withPrintDialog);
  }

  private static void print(byte[] jasperPrintBytes, boolean withPrintDialog) {
    printReport((JasperPrint) ObjectUtil.bytesToObject(jasperPrintBytes),
      withPrintDialog);
  }

  private static boolean print(List jasperPrintBytesList, boolean withPrintDialog) {
    List jasperPrintList = new ArrayList();
    for (int i = 0; i < jasperPrintBytesList.size(); i++) {
      JasperPrint jasperPrint = (JasperPrint) ObjectUtil
        .bytesToObject((byte[]) jasperPrintBytesList.get(i));
      jasperPrintList.add(jasperPrint);
    }
   return   printReport(jasperPrintList, withPrintDialog);
  }

//  private static void print(byte[] jasperPrintBytes) {
//    print(jasperPrintBytes, false);
//  }
//
//  private static void print(List jasperPrintBytesList) {
//    print(jasperPrintBytesList, false);
//  }

  public static boolean print(PrintObject po) {
   return  print(po.getPrintDataList(), po.isShowPrintDialog());
  }

}

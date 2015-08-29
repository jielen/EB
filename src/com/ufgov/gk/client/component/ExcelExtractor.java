package com.ufgov.gk.client.component;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class ExcelExtractor {

  private Component parentComponent;

  private int rows = 0;

  private int columns = 0;

  private List<List<String>> data = new ArrayList<List<String>>();

  private boolean isFileSelected;

  public int getRows() {
    return rows;
  }

  public int getColumns() {
    return columns;
  }

  public List<List<String>> getData() {
    return data;
  }

  private void reset() {
    rows = 0;
    columns = 0;
    data = new ArrayList<List<String>>();
  }

  public ExcelExtractor(Component parentComponent) {
    this.parentComponent=parentComponent;
    init();
  }

  public ExcelExtractor(Component parentComponent,File file) {
    this.parentComponent=parentComponent;
    init2(file);
  }

  private void init() {

    JFileChooser fileChooser = new JFileChooser();
    //    fileChooser.setApproveButtonText("");
    //    fileChooser.setApproveButtonToolTipText("");
    fileChooser.setDialogTitle("选择文件");
    fileChooser.addChoosableFileFilter(new ExtFileFilter("xls"));
    fileChooser.setAcceptAllFileFilterUsed(false);
    int result = fileChooser.showOpenDialog(parentComponent);
    if (result == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      try {
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        rows = sheet.getRows();
        columns = sheet.getColumns();

        List<List<String>> sheetData = new ArrayList<List<String>>();

        for (int row = 0; row < rows; row++) {
          List<String> rowData = new ArrayList<String>();
          for (int col = 0; col < columns; col++) {
            Cell a1 = sheet.getCell(col, row);
            rowData.add(a1.getContents());
          }
          sheetData.add(rowData);
        }
        this.data=sheetData;

        workbook.close();

        isFileSelected=true;

      } catch (Exception e) {
        JOptionPane.showMessageDialog(parentComponent, "提取数据时出错！\n" + e, "错误",
          JOptionPane.ERROR_MESSAGE);
        reset();
      }
    }
  }

  private void init2(File file) {
      try {
        Workbook workbook = Workbook.getWorkbook(file);
        Sheet sheet = workbook.getSheet(0);
        rows = sheet.getRows();
        columns = sheet.getColumns();

        List<List<String>> sheetData = new ArrayList<List<String>>();

        for (int row = 0; row < rows; row++) {
          List<String> rowData = new ArrayList<String>();
          for (int col = 0; col < columns; col++) {
            Cell a1 = sheet.getCell(col, row);
            rowData.add(a1.getContents());
          }
          sheetData.add(rowData);
        }
        this.data=sheetData;

        workbook.close();

        isFileSelected=true;

      } catch (Exception e) {
        JOptionPane.showMessageDialog(parentComponent, "提取数据时出错！\n" + e, "错误",
          JOptionPane.ERROR_MESSAGE);
        reset();
      }
    }

  public static void main(String[] args) {
    ExcelExtractor ee = new ExcelExtractor(null);
    for(List<String> row :ee.getData()){
      for(String celldata:row){
        System.out.print(celldata+" , ");
      }
      System.out.println();
    }
  }

  public boolean isFileSelected() {
    return isFileSelected;
  }

}


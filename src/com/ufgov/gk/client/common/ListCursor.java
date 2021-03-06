package com.ufgov.gk.client.common;

import java.util.ArrayList;
import java.util.List;

public class ListCursor<T> {

  private int currentRow = 0;

  private int previousRow = 0;

  private int nextRow = 0;

  private List<T> dataList = new ArrayList<T>();

  public ListCursor() {

  }

  public ListCursor(List<T> dataList, int currentRow) {
    this.setDataList(dataList, currentRow);
  }

  public synchronized void setDataList(List<T> dataList, int currentRow) {
    this.currentRow = currentRow;
    this.previousRow = currentRow;
    this.nextRow = currentRow;
    this.dataList = dataList;
  }

  public synchronized void setDataList(List<T> dataList) {
    this.dataList = dataList;
  }

  public synchronized List<T> getDataList() {
    return this.dataList;
  }

  public synchronized int getCurrentRow() {
    return this.currentRow;
  }

  /**
   * 
   * @return 当dataList空的时候返回null
   */
  public synchronized T getCurrentObject() {
    if (this.dataList.isEmpty()) {
      return null;
    } else {

      if (this.currentRow >= this.dataList.size()) {
        this.currentRow = this.dataList.size() - 1;
      } else if (this.currentRow < 0) {
        this.currentRow = 0;
      }
      return this.dataList.get(this.currentRow);
    }
  }
  
  public synchronized void setCurrentObject(T object) {
    if (this.dataList.isEmpty()) {
      return ;
    } else {

      if (this.currentRow >= this.dataList.size()) {
        this.currentRow = this.dataList.size() - 1;
      } else if (this.currentRow < 0) {
        this.currentRow = 0;
      }
       this.dataList.set(this.currentRow, object);
    }
  }

  /**
   * 下移一个
   */
  public synchronized void next() {
    this.nextRow++;
    if (this.nextRow >= this.dataList.size()) {
      this.nextRow = 0;
    }
    this.currentRow = this.nextRow;
    this.previousRow = this.currentRow;
  }

  /**
   * 上移一个
   */
  public synchronized void previous() {
    this.previousRow--;
    if (this.previousRow < 0) {
      this.previousRow = this.dataList.size() - 1;
    }
    this.currentRow = this.previousRow;
    this.nextRow = this.currentRow;
  }

  public synchronized boolean isEmpty() {
    return this.dataList.isEmpty();
  }

  public synchronized void removeCurrentObject() {
    if (this.dataList.isEmpty()) {
      return;
    }

    if (this.currentRow >= this.dataList.size()) {
      this.currentRow = this.dataList.size() - 1;
    } else if (this.currentRow < 0) {
      this.currentRow = 0;
    }

    this.dataList.remove(this.currentRow);

    this.nextRow--;
    this.currentRow--;
    if (this.currentRow < 0) {
      this.currentRow = this.dataList.size() - 1;
    }
  }
}

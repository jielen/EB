package com.eb.client.component.test.blockingQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

  private BlockingQueue queue;

  // put producer in queue   
  public Producer(BlockingQueue q) {
    this.queue = q;
  }

  public void run() {
    try {
      while (true) {
        // wait for a random time   
        Thread.sleep((int) (Math.random() * 3000));
        queue.put(produce());
      }
    } catch (InterruptedException ex) {
      // catch exception   
    }
  }

  public String produce() {
    List<String> product = new ArrayList<String>();
    String producProduct = null;
    product.add("Car");
    product.add("Phone");
    product.add("Plane");
    product.add("Computer");
    boolean flag = true;
    int getProduct = (int) (Math.random() * 3);
    while (flag) {
      if (getProduct <= product.size()) {
        producProduct = product.get(getProduct);
        flag = false;
      }
    }
    System.out.println("Producer producing " + producProduct);
    return producProduct;
  }

}

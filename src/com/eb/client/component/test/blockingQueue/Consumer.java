package com.eb.client.component.test.blockingQueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

  private BlockingQueue queue;

  public Consumer(BlockingQueue q) {
    this.queue = q;
  }

  @Override
  public void run() {
    // TODO Auto-generated method stub   
    try {
      while (true) {
        // wait for a random time   
        Thread.sleep((int) (Math.random() * 3000));
        consume(queue.take());
      }
    } catch (InterruptedException ex) {
    }

  }

  public void consume(Object x) {
    System.out.println("Consumer buy product " + x.toString());
  }
}

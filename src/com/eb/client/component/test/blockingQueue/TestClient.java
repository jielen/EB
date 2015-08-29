package com.eb.client.component.test.blockingQueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class TestClient {

  /**  
   * @param args  
   */
  public static void main(String[] args) {
    // TODO Auto-generated method stub   
    new TestClient();
  }

  public TestClient() {
    BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(1);
    Thread producerThread = new Thread(new Producer(queue));
    Thread consumerThread = new Thread(new Consumer(queue));
    producerThread.start();
    consumerThread.start();
  }
}

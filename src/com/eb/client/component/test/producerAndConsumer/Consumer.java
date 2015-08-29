package com.eb.client.component.test.producerAndConsumer;

public class Consumer extends Thread {
  private Queue queue;

  Consumer(Queue queue) {
    this.queue = queue;
  }

  public void run() {
    while (true) {
      queue.consume();
      try {
        sleep(100);
      } catch (Exception e) {
      }

    }
  }
}

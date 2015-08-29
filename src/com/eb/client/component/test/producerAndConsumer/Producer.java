package com.eb.client.component.test.producerAndConsumer;

public class Producer extends Thread {

  private Queue queue;

  Producer(Queue queue) {
    this.queue = queue;
  }

  public void run() {

    while (true) {
      Message message = new Message();
      message.setId(++Message.id);
      message.setContent("food" + Message.id);
      queue.produce(message);
      try {
        sleep(100);
      } catch (Exception e) {
      }
    }

  }
}
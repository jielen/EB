package com.eb.client.component.test.producerAndConsumer;

public class Test {

  public static void main(String[] args) {

    Queue Q = new Queue();

    Producer wQ1 = new Producer(Q);
    Producer wQ2 = new Producer(Q);
    Producer wQ4 = new Producer(Q);
    Producer wQ5 = new Producer(Q);
    Producer wQ6 = new Producer(Q);

    Consumer rQ1 = new Consumer(Q);
    Consumer rQ2 = new Consumer(Q);
    Consumer rQ3 = new Consumer(Q);

    Thread threadWQ1 = new Thread(wQ1, "thread-wQ1");
    Thread threadWQ2 = new Thread(wQ2, "thread-wQ2");
    Thread threadWQ4 = new Thread(wQ4, "thread-wQ4");
    Thread threadWQ5 = new Thread(wQ5, "thread-wQ5");
    Thread threadWQ6 = new Thread(wQ6, "thread-wQ6");

    Thread threadRQ1 = new Thread(rQ1, "thread-rQ1");
    Thread threadRQ2 = new Thread(rQ2, "thread-rQ2");
    Thread threadRQ3 = new Thread(rQ3, "thread-rQ3");

    threadWQ1.start();
    threadWQ2.start();
    threadWQ4.start();
    threadWQ5.start();
    threadWQ6.start();

    threadRQ1.start();
    threadRQ2.start();
    threadRQ3.start();
  }
}

//class Producer extends Thread {
//
//  private Queue queue;
//
//  Producer(Queue queue) {
//    this.queue = queue;
//  }
//
//  public void run() {
//
//    while (true) {
//      Message message = new Message();
//      message.setId(++Message.id);
//      message.setContent("food" + Message.id);
//      queue.produce(message);
//      try {
//        sleep(100);
//      } catch (Exception e) {
//      }
//    }
//
//  }

//}

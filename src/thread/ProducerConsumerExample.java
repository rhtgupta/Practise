package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {


    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(10);

        Runnable producerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                    blockingQueue.put(1);
                    System.out.println("Producing...size : " + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread producerThread1 = new Thread(producerRunnable);
        Thread producerThread2 = new Thread(producerRunnable);

        Runnable consumerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    blockingQueue.take();
                    System.out.println("Consuming...size : " + blockingQueue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread consumerThread1 = new Thread(consumerRunnable);
        Thread consumerThread2 = new Thread(consumerRunnable);
        Thread consumerThread3 = new Thread(consumerRunnable);

        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();
        consumerThread3.start();

    }

}

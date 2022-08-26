package revision;

import javax.print.attribute.standard.RequestingUserName;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingJavaBlockingQueue {

    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(1);

        Runnable producerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    blockingQueue.put(1);
                    System.out.println("Produced : ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(producerRunnable);
        Thread t2 = new Thread(producerRunnable);
        Thread t3 = new Thread(producerRunnable);

        t1.start();
        t2.start();
        t3.start();

        Runnable consumerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(3000);
                    blockingQueue.take();
                    System.out.println("Consumed :");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t4 = new Thread(consumerRunnable);
        Thread t5 = new Thread(consumerRunnable);
        Thread t6 = new Thread(consumerRunnable);
        Thread t7 = new Thread(consumerRunnable);
        Thread t8 = new Thread(consumerRunnable);

        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

    }

}

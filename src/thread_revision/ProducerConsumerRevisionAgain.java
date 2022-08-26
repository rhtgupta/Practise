package thread_revision;

import java.util.concurrent.*;

public class ProducerConsumerRevisionAgain {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(1);

        ExecutorService service = Executors.newFixedThreadPool(2);

        Runnable producerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    queue.put(1);
                    System.out.println("Producing....!!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable consumerRunnable = () -> {
            while (true) {
                try {
                    Thread.sleep(5000);
                    queue.take();
                    System.out.println("Consuming.....!!!!!");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        service.execute(producerRunnable);
        service.execute(consumerRunnable);

    }

}

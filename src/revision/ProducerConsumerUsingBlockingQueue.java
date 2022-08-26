package revision;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumerUsingBlockingQueue {

    public static void main(String[] args) {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(15);
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 4; i++) {
            service.execute(new ProducerTask(queue));
        }
        for (int i = 0; i < 6; i++) {
            service.execute(new ConsumerTask(queue));
        }
    }

    public static class ProducerTask implements Runnable {
        private CustomBlockingQueue<Integer> queue;

        ProducerTask(CustomBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                queue.put(1);
            }
        }
    }

    public static class ConsumerTask implements Runnable {
        private CustomBlockingQueue<Integer> queue;

        ConsumerTask(CustomBlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    System.out.println("Size before consume :" + queue.size());
                    queue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

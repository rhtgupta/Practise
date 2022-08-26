package thread;

public class ProducerConsumerUsingMyBlockingQueue {

    public static void main(String[] args) {

        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue<>(10);

        Runnable producerRunnable = () -> {
            while (true) {
                myBlockingQueue.put(1);
                System.out.println("Produced ::::::: Size :::::: " + myBlockingQueue.size());
            }
        };

        Thread producerThread1 = new Thread(producerRunnable);
        Thread producerThread2 = new Thread(producerRunnable);

        Runnable consumerRunnable = () -> {
            while (true) {
                myBlockingQueue.take();
                System.out.println("Consumed ::::::: Size :::::: " + myBlockingQueue.size());
            }
        };

        Thread consumerThread1 = new Thread(consumerRunnable);
        Thread consumerThread2 = new Thread(consumerRunnable);

        producerThread1.start();
        producerThread2.start();
        consumerThread1.start();
        consumerThread2.start();

    }

}

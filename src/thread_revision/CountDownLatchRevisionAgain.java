package thread_revision;

import java.util.concurrent.*;

public class CountDownLatchRevisionAgain {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);

        Runnable r1 = () -> {
            System.out.println("Started.....!!!");
            countDownLatch.countDown();
            countDownLatch.countDown();
            countDownLatch.countDown();
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for(int i=0;i<1;i++){
            executor.execute(r1);
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Completed....!!!");

    }

}

package revision;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public class CountDownLatchRevision {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Decreasing the count ....!!");
                countDownLatch.countDown();
            }
        });
        t1.start();
        try {
            System.out.println("Waiting for count down........!!!!");
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Finished........!!!!");

    }
}

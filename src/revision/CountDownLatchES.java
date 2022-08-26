package revision;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchES {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);
        CountDownLatch countDownlatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            service.execute(new Task(countDownlatch));
        }
        System.out.println("Waiting for count to be zero");
        countDownlatch.await();
        System.out.println("Count is zero");
    }

    public static class Task implements Runnable {
        private CountDownLatch latch;

        Task(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Count is decreased by 1");
                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

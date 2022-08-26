package thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {

    static class Task implements Runnable {
        CountDownLatch latch;

        Task(CountDownLatch latch) {
            this.latch = latch;
        }

        public void run() {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CountDown Called....!!!!!");
            latch.countDown();
        }
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3);
        Thread t1 = new Thread(new CountDownLatchExample.Task(latch));
        Thread t2 = new Thread(new CountDownLatchExample.Task(latch));
        Thread t3 = new Thread(new CountDownLatchExample.Task(latch));

        /*Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CountDown Called....!!!!!");
            latch.countDown();
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CountDown Called....!!!!!");
            latch.countDown();
        });

        Thread t3 = new Thread(() -> {
            try {
                Thread.sleep(12000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("CountDown Called....!!!!!");
            latch.countDown();
        });
*/
        t1.start();
        t2.start();
        t3.start();

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}

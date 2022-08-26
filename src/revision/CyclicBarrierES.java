package revision;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierES {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(4);
        service.execute(new Task(barrier));
        service.execute(new Task(barrier));
        service.execute(new Task(barrier));
        System.out.println("Main method completed its task");
    }

    public static class Task implements Runnable {
        CyclicBarrier barrier;

        Task(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                System.out.println("Waiting for barrier to break");
                barrier.await();
                System.out.println("I am done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

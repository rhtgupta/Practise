package revision;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Two or more threads waits for each other to break the barrier.
public class CyclicBarrierRevision {

    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);

        ExecutorService service = Executors.newFixedThreadPool(3);
        System.out.println("Barrier size Before : " + barrier.getNumberWaiting());
        for (int i = 0; i < 3; i++) {
            service.execute(() -> {
                try {
                    Thread.sleep(2000);
                    barrier.await();
                    System.out.println("Barrier size After : " + barrier.getParties());
                    System.out.println(Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();
    }

}

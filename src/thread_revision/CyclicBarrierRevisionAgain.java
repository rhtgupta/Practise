package thread_revision;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierRevisionAgain {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        ExecutorService service = Executors.newFixedThreadPool(3);
        Runnable r1 = () -> {
            try {
                System.out.println("Await method called.....!!!!");
                cyclicBarrier.await();
                System.out.println("Await method completed.....!!!!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 3; i++) {
            service.execute(r1);
        }
    }
}

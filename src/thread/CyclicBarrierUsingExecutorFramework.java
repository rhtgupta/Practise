package thread;

import java.util.Calendar;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierUsingExecutorFramework {


    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        service.execute(new Task(cyclicBarrier, service));
        service.execute(new Task(cyclicBarrier, service));
        service.execute(new Task(cyclicBarrier, service));
        System.out.println("Main thread completes.......!!!!");
    }


    static class Task implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private ExecutorService service;

        Task(CyclicBarrier cyclicBarrier, ExecutorService service) {
            this.cyclicBarrier = cyclicBarrier;
            this.service = service;
        }

        public void run() {
            try {
                System.out.println(Calendar.getInstance().getTime());
                Thread.sleep(2000);
                cyclicBarrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("Cyclic Barrier broken............!!!!!" + Calendar.getInstance().getTime());
            System.out.println(service.isShutdown());
            service.shutdown();
            System.out.println(service.isShutdown());
        }
    }

}

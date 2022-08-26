package thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolExample {

    static class RunnableTask implements Runnable {
        public void run() {
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for(int i=0;i<100;i++){
            executor.execute(new RunnableTask());
        }
        System.out.println("Thread name : " + Thread.currentThread().getName());
    }
}

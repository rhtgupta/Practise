package thread;

import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool implements MyExecutorService{
    static int initialCapacity;
    static int capacity;
    static LinkedBlockingQueue<Runnable> blockingQueue;
    MyExecution e;
    @Override
    public void execute(Runnable r) {
        blockingQueue.add(r);
        e.executeMyMethod();
    }
    MyThreadPool(int capacity){
        initialCapacity = 0;
        this.capacity = capacity;
        blockingQueue = new LinkedBlockingQueue<>();
        e = new MyExecution();
    }

}

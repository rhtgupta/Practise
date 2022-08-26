package revision;

import thread.MyBlockingQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueFinal<E> {

    private Queue<E> queue = new LinkedList<>();
    private int maxSize = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition nonEmpty = lock.newCondition();
    private Condition nonFull = lock.newCondition();

    MyBlockingQueueFinal(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(E item) {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                nonFull.await();
            }
            queue.add(item);
            nonEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


}

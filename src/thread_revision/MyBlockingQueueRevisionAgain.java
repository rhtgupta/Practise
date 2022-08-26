package thread_revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueueRevisionAgain<E> {

    private Queue<E> queue;
    private int maxSize = 3;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition nonEmpty = lock.newCondition();
    private Condition nonFull = lock.newCondition();

    MyBlockingQueueRevisionAgain(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
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

    public E take() {
        E item = null;
        lock.lock();
        try {
            while (queue.size() == 0) {
                nonEmpty.await();
            }
            item = queue.remove();
            nonFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

}

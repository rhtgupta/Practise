package revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueueImplementation<E> {
    private Queue<E> queue;
    private int maxSize = 16;
    ReentrantLock lock = new ReentrantLock(true);
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();

    CustomBlockingQueueImplementation(int maxSize) {
        this.maxSize = maxSize;
        queue = new LinkedList<>();
    }

    public void put(E item) {
        lock.lock();
        try {
            while (queue.size() == maxSize) {
                notFull.await();
            }
            queue.add(item);
            notEmpty.signalAll();
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
                notEmpty.await();
            }
            item = queue.remove();
            notFull.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return item;
    }

}

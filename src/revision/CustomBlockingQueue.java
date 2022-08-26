package revision;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class CustomBlockingQueue<E> {
    private Queue<E> queue;
    private int size = 16;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();

    CustomBlockingQueue(int size) {
        queue = new LinkedList<>();
        this.size = size;
    }

    public void put(E e) {
        lock.lock();
        try {
            while (queue.size() == size) {
                notFull.await();
            }
            queue.add(e);
            notEmpty.signalAll();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        return queue.size();
    }

    public Queue<E> getQueue() {
        return queue;
    }

    public E take() {
        lock.lock();
        E e = null;
        try {
            while (queue.size() == 0) {
                notEmpty.await();
            }
            e = queue.remove();
            notFull.signalAll();
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        } finally {
            lock.unlock();
        }
        return e;
    }
}

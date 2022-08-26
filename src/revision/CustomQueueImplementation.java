package revision;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CustomQueueImplementation<E> {

    private static int INITIAL_CAPACITY = 10;
    private int front = -1;
    private int rear = -1;
    private Object queue[];

    CustomQueueImplementation() {
        queue = new Object[INITIAL_CAPACITY];
    }

    public void enqueue(E e) {
        if (rear + 1 == queue.length) {
            ensureSize();
        }
        if (front == -1) {
            queue[++front] = e;
            queue[++rear] = e;
        } else {
            queue[++rear] = e;
        }
    }

    public E dequeue() {
        if (front == -1 || rear == -1) {
            return null;
        } else {
            E element = (E) queue[front];
            front++;
            return element;
        }
    }

    public void display() {
        if (front == -1 || rear == -1) {
            throw new NoSuchElementException();
        }
        for (int i = front; i <= rear; i++) {
            System.out.println(queue[i]);
        }
    }

    public E front() {
        if (front == -1) {
            return null;
        }
        E element = (E) queue[front];
        return element;
    }

    public E rear() {
        if (rear == -1) {
            return null;
        }
        E element = (E) queue[rear];
        return element;
    }

    private void ensureSize() {
        int newCapacity = queue.length * 2;
        queue = Arrays.copyOf(queue, newCapacity);
    }

    public static void main(String[] args) {
        CustomQueueImplementation<Integer> queue = new CustomQueueImplementation<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.display();
        System.out.println("------------------------");
        System.out.println(queue.dequeue());
        System.out.println("------------------------");
        queue.display();
        System.out.println("------------------------");
        System.out.println(queue.dequeue());
        System.out.println("------------------------");
        queue.display();
        System.out.println("------------------------");
        System.out.println("front :" + queue.front());
        System.out.println("------------------------");
        System.out.println("rear :" + queue.rear());
    }
}

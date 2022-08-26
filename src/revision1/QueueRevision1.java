package revision1;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class QueueRevision1<E> {

    private Object[] queueArray;
    private int front;
    private int rear;
    private int defaultCapacity;
    private int size;

    QueueRevision1() {
        defaultCapacity = 5;
        queueArray = new Object[defaultCapacity];
        front = -1;
        rear = -1;
        size = 0;
    }

    public void enqueue(E element) {
        if ((rear + 1) % defaultCapacity == front) {
            System.out.println("Queue is full");
        }
        if (front == -1 && rear == -1) {
            front++;
            rear++;
        } else {
            rear = (rear + 1) % defaultCapacity;
        }
        size++;
        queueArray[rear] = element;
    }

    public E dequeue() {
        E element;
        if (front == -1 && rear == -1) {
            throw new NoSuchElementException();
        } else if (front == rear) {
            element = (E) queueArray[front];
            front = -1;
            rear = -1;
        } else {
            element = (E) queueArray[front];
            front = (front + 1) % defaultCapacity;
        }
        size--;
        return element;
    }

    public void print() {
        if (front == -1) {
            return;
        }
        for (int i = front; i <= rear; i++) {
            System.out.print(queueArray[i] + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public void ensureCapacity() {
        int newCapacity = queueArray.length * 2;
        queueArray = Arrays.copyOf(queueArray, newCapacity);
    }

    public static void main(String[] args) {
        QueueRevision1 queue = new QueueRevision1();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        queue.print();
        queue.dequeue();
        System.out.println(" ");
        queue.print();
        queue.dequeue();
        System.out.println(" ");
        queue.print();
        queue.dequeue();
        System.out.println(" ");
        queue.print();
        queue.dequeue();
        System.out.println(" ");
        queue.print();
        queue.dequeue();
        System.out.println(" ");
        queue.print();
        System.out.println("size : " + queue.getSize());
    }
}

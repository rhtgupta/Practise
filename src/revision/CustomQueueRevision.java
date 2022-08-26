package revision;

public class CustomQueueRevision<E> {

    private Object[] queueArray;
    private int defaultCapacity;
    private int front;
    private int rear;

    CustomQueueRevision() {
        defaultCapacity = 5;
        queueArray = new Object[defaultCapacity];
        front = -1;
        rear = -1;
    }

    public void enqueue(E element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return;
        }
        if (isEmpty()) {
            front++;
            rear++;
        } else {
            rear = (rear + 1) % defaultCapacity;
        }
        queueArray[rear] = element;
    }

    public E dequeue() {
        E element = null;
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else if (front == rear) {
            element = (E) queueArray[front];
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % defaultCapacity;
        }
        return element;
    }

    private boolean isEmpty() {
        if (front == -1 && rear == -1) {
            return true;
        }
        return false;
    }

    private boolean isFull() {
        if ((rear + 1) % defaultCapacity == front) {
            return true;
        }
        return false;
    }

}

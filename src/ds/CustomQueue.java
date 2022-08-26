package ds;

public class CustomQueue {

    private int front, rear, capacity;
    private int queue[];

    CustomQueue(int capacity){
        this.capacity = capacity;
        front = 0;
        rear = 0;
        queue = new int[capacity];
    }

    public void queueEnqueue(int element){
    if(rear + 1 == capacity){
        System.out.println("Queue is full");
    }else{
        queue[rear] = element;
    }
    }

}

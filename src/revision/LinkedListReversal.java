package revision;

public class LinkedListReversal {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public void reversal() {
        Node current = head;
        Node prev = null;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        LinkedListReversal linkedListReversal = new LinkedListReversal();
        linkedListReversal.insert(10);
        linkedListReversal.insert(20);
        linkedListReversal.insert(30);
        linkedListReversal.insert(40);
        linkedListReversal.insert(50);
        linkedListReversal.print();
        linkedListReversal.reversal();
        System.out.println("After reversal :");
        linkedListReversal.print();
    }

}

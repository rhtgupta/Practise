package revision1;

public class LinkedListReversalRevision1<E> {

    class Node<E> {
        private E data;
        private Node next;

        Node(E data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;

    LinkedListReversalRevision1() {
        head = null;
        tail = null;
    }

    public void add(E element) {
        Node newNode = new Node(element);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
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
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        Node previous = null;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
    }

    public static void main(String[] args) {
        LinkedListReversalRevision1 linkedList = new LinkedListReversalRevision1();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.print();
        linkedList.reversal();
        System.out.println(" ");
        linkedList.print();

    }

}


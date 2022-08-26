package revision1;

public class SinglyLinkedListRevision1<E> {

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

    SinglyLinkedListRevision1() {
        head = null;
        tail = null;
    }

    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public E removeFirst() {
        if (head == null) {
            return null;
        }
        Node current = head;
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = current.next;
        }
        return (E) current.data;
    }

    public E removeLast() {
        if (head == null) {
            return null;
        }
        Node current = head;
        if (head == tail) {
            head = null;
            tail = null;
            return (E) current.data;
        }
        Node prev = null;
        while (current != tail) {
            prev = current;
            current = current.next;
        }
        tail = prev;
        tail.next = null;
        return (E) current.data;
    }

    public void print() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedListRevision1 linkedList = new SinglyLinkedListRevision1();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        linkedList.print();
        System.out.println(" ");
        System.out.println("Remove first :");
        linkedList.removeFirst();
        linkedList.print();
        System.out.println(" ");
        System.out.println("Remove last :");
        linkedList.removeLast();
        linkedList.print();
        System.out.println(" ");
        System.out.println("Remove last :");
        linkedList.removeLast();
        linkedList.print();
        System.out.println(" ");
        System.out.println("Remove first :");
        linkedList.removeFirst();
        linkedList.print();
    }

}

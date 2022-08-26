package ds;

import java.util.LinkedList;
import java.util.List;

public class DoublyLinkList {

    class Node {
        int data;
        Node previous;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    Node head = null;
    Node tail = null;

    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
            head.previous = null;
            head.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            newNode.next = null;
            tail = newNode;
        }
    }

    public void display() {
        Node currentNode = head;
        if (currentNode == null) {
            System.out.println("List is empty");
        } else {
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.next;
            }
        }
    }

    public static void main(String[] args) {
        DoublyLinkList doublyLinkList = new DoublyLinkList();
        doublyLinkList.add(10);
        doublyLinkList.add(20);
        doublyLinkList.add(30);
        doublyLinkList.add(40);
        doublyLinkList.add(50);
        doublyLinkList.display();
        List<String> list = new LinkedList<>();
        int size = 10;
        System.out.println((size << 2));
    }

}

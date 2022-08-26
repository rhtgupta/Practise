package revision;

import java.util.NoSuchElementException;

public class CustomSinglyLinkedList<E> {

    public class Node<E> {
        private Node next;
        private E data;

        Node(E e) {
            this.data = e;
            this.next = null;
        }
    }

    private Node head = null;
    private Node tail = null;
    private int size;

    public void add(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
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

    public E remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E element = (E) head.data;
        head = head.next;
        size--;
        return element;
    }

    public int size() {
        return size;
    }

    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E element = (E) tail.data;
        Node currentNode = head;
        while (currentNode.next != tail) {
            currentNode = currentNode.next;
        }
        tail = currentNode;
        tail.next = null;
        size--;
        return element;
    }


    public static void main(String[] args) {
        CustomSinglyLinkedList<Integer> list = new CustomSinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.display();
        System.out.println("-----------------------------");
        list.remove();
        list.display();
        System.out.println("-----------------------------");
        list.removeLast();
        list.display();
    }
}

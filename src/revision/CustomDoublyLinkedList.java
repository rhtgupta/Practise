package revision;

import java.util.NoSuchElementException;

public class CustomDoublyLinkedList<E> {

    public class Node<E> {
        private E data;
        private Node previousNode;
        private Node nextNode;

        Node(E data) {
            this.data = data;
            previousNode = null;
            nextNode = null;
        }
    }

    private Node head;
    private Node tail;

    public void add(E e) {
        Node newNode = new Node(e);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.previousNode = tail;
            tail = newNode;
        }
    }

    public void display() {
        Node currentNode = head;
        if (currentNode == null) {
            throw new NoSuchElementException();
        } else {
            while (currentNode != null) {
                System.out.println(currentNode.data);
                currentNode = currentNode.nextNode;
            }
        }
    }

    public E remove() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        E element = (E) head.data;
        head = head.nextNode;
        head.previousNode = null;
        return element;
    }

    public E removeLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node currentNode = head;
        while (currentNode.nextNode != tail) {
            currentNode = currentNode.nextNode;
        }
        E element = (E) tail.data;
        tail = currentNode;
        tail.nextNode = null;
        tail.previousNode = currentNode.previousNode;
        return element;
    }

    public static void main(String[] args) {
        CustomDoublyLinkedList<Integer> list = new CustomDoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.display();
        System.out.println("------------------------");
        list.remove();
        list.display();
        System.out.println("------------------------");
        list.removeLast();
        list.display();
    }
}

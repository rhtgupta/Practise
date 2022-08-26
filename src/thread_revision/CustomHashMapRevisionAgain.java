package thread_revision;

import java.util.LinkedList;
import java.util.Objects;

public class CustomHashMapRevisionAgain<K, V> {

    class Node<K, V> {
        private K key;
        private V value;
        private int hashCode;
        private Node<K, V> nextNode;

        Node(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            nextNode = null;
        }
    }

    private int maxSize = 5;
    private LinkedList<Node<K, V>> bucketMap;
    private int size;

    CustomHashMapRevisionAgain() {
        size = 0;
        bucketMap = new LinkedList<>();
        for (int i = 0; i < maxSize; i++) {
            bucketMap.add(null);
        }
    }

    private int getHashCode(K key) {
        int hashCode = Objects.hashCode(key);
        return hashCode < 0 ? hashCode * -1 : hashCode;
    }

    private int getBucketId(K key) {
        int hashCode = getHashCode(key);
        return hashCode % maxSize;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketId(key);
        Node<K, V> head = bucketMap.get(bucketIndex);
        Node<K, V> current = head;
        Node<K, V> previous = null;
        while (current != null) {
            if (current.hashCode == getHashCode(key) && current.key == key) {
                current.value = value;
                return;
            }
            previous = current;
            current = current.nextNode;

        }
        Node newNode = new Node(key, value, getHashCode(key));
        size++;
        if (head == null) {
            head = newNode;
        } else {
            previous.nextNode = newNode;
        }
        bucketMap.add(bucketIndex, head);

        if (size / maxSize >= .75) {
            LinkedList<Node<K, V>> tmp = bucketMap;
            maxSize = maxSize * 2;
            bucketMap = new LinkedList<>();
            size = 0;
            for (int i = 0; i < maxSize; i++) {
                bucketMap.add(null);
            }
            for (Node<K, V> node : tmp) {
                Node<K, V> tmpNode = node;
                while (tmpNode != null) {
                    put(tmpNode.key, tmpNode.value);
                    tmpNode = tmpNode.nextNode;
                }
            }
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketId(key);
        Node<K, V> head = bucketMap.get(bucketIndex);
        Node<K, V> current = head;
        while (current != null) {
            if (current.key == key && current.key.hashCode() == getHashCode(key)) {
                return current.value;
            }
            current = current.nextNode;
        }
        return null;
    }

    public V remove(K key) {
        V value = null;
        int bucketIndex = getBucketId(key);
        Node<K, V> head = bucketMap.get(bucketIndex);
        Node<K, V> current = head;
        Node<K, V> previous = null;
        while (current != null) {
            if (current.key == key && current.hashCode == getHashCode(key)) {
                break;
            } else {
                previous = current;
                current = current.nextNode;
            }
        }
        value = current.value;
        if (previous == null) {
            head = null;
        } else {
            previous.nextNode = current.nextNode;
        }
        bucketMap.add(bucketIndex, head);
        return value;
    }

    public void print() {
        for (Node<K, V> node : bucketMap) {
            Node<K, V> temp = node;
            while (temp != null) {
                System.out.println("Key :" + temp.key + " value :" + temp.value);
                temp = temp.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        CustomHashMapRevisionAgain<Integer, Integer> map = new CustomHashMapRevisionAgain<>();

        map.put(10, 10);
        map.put(20, 20);
        map.put(30, 30);
        map.put(40, 40);

        System.out.println(map.get(30));

    }

}

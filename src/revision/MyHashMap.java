package revision;

import java.util.ArrayList;
import java.util.Objects;

public class MyHashMap<K, V> {

    class HashNode<K, V> {
        private K key;
        private V value;
        private int hashCode;
        private HashNode<K, V> next;

        HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            next = null;
        }
    }

    private ArrayList<HashNode<K, V>> bucket;
    private int bucketCapacity;
    private int size;

    MyHashMap() {
        bucket = new ArrayList<>();
        size = 0;
        bucketCapacity = 3;
        for (int i = 0; i < bucketCapacity; i++) {
            bucket.add(null);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private int getHashCode(K key) {
        return Objects.hashCode(key);
    }

    private int getBucketIndex(K key) {
        int hashCode = getHashCode(key);
        int bucketIndex = hashCode % bucketCapacity;
        return bucketIndex < 0 ? bucketIndex * -1 : bucketIndex;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                current.value = value;
                return;
            }
            current = current.next;
        }

        HashNode<K, V> newNode = new HashNode<>(key, value, getHashCode(key));
        size++;
        if (head == null) {
            head = newNode;
        } else {
            head.next = newNode;
        }
        bucket.set(bucketIndex, head);

        if (size / bucketCapacity >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucket;
            bucket = new ArrayList<>();
            bucketCapacity = bucketCapacity * 2;
            size = 0;
            for (int i = 0; i < bucketCapacity; i++) {
                bucket.add(null);
            }
            for (HashNode<K, V> node : temp) {
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucket.get(bucketIndex);
        HashNode<K, V> current = head;
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                break;
            }
            prev = current;
            current = current.next;
        }

        if (current == null) {
            return null;
        }
        size--;
        if (prev != null) {
            prev.next = current.next;
        } else {
            head = current.next;
        }
        bucket.set(bucketIndex, head);
        return current.value;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("this", 1);
        map.put("isth", 10);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);
        System.out.println(map.size());
        System.out.println(map.remove("coder"));
        System.out.println(map.remove("coder"));
        System.out.println(map.size());
    }

}

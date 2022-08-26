package revision1;

import ds.CustomHashMap;

import java.util.ArrayList;
import java.util.Objects;

public class MyHashMapRevision1<K, V> {

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

    private int defaultCapacity;
    private int size;
    private ArrayList<HashNode<K, V>> bucketArray;

    MyHashMapRevision1() {
        defaultCapacity = 5;
        size = 0;
        bucketArray = new ArrayList<>();
        for (int i = 0; i < defaultCapacity; i++) {
            bucketArray.add(null);
        }
    }

    public int getHashCode(K key) {
        return Objects.hashCode(key);
    }

    public int getBucketIndex(K key) {
        int hashCode = getHashCode(key);
        int index = hashCode % defaultCapacity;
        return index < 0 ? index * -1 : index;
    }

    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> current = head;
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                current.value = value;
                return;
            }
            prev = current;
            current = current.next;
        }
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value, getHashCode(key));
        if (head == null) {
            head = newNode;
        } else {
            prev.next = newNode;
        }
        bucketArray.set(bucketIndex, head);

        if ((1.0 * size) / defaultCapacity >= 0.7) {
            int newCapacity = 2 * defaultCapacity;
            ArrayList<HashNode<K, V>> temp = bucketArray;
            for (int i = 0; i < newCapacity; i++) {
                bucketArray.add(null);
            }
            size = 0;
            for (HashNode<K, V> oldHashNode : temp) {
                HashNode<K, V> node = oldHashNode;
                while (node != null) {
                    put(node.key, node.value);
                    node = node.next;
                }
            }
        }
    }

    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
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
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> current = head;
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                break;
            }
            prev = current;
            current = current.next;
        }
        if (head == null) {
            return null;
        }
        size--;
        if (prev == null) {
            head = current.next;
        } else {
            prev.next = current.next;
        }
        bucketArray.set(bucketIndex, head);
        return current.value;
    }

    public static void main(String[] args) {
        MyHashMapRevision1<String, Integer> map = new MyHashMapRevision1<>();
        map.put("this", 1);
        map.put("isth", 10);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);

        System.out.println(map.get("this"));
        System.out.println(map.remove("isth"));
        System.out.println(map.get("isth"));
    }
}


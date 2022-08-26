package graph_revision_final;

import revision1.MyHashMapRevision1;

import java.util.ArrayList;
import java.util.Objects;

public class HashMapFinal<K, V> {

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

    HashMapFinal() {
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
        HashNode<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                current.value = value;
                return;
            }
            previous = current;
            current = current.next;
        }
        size++;
        HashNode<K, V> newNode = new HashNode<>(key, value, getHashCode(key));
        if (head == null) {
            head = newNode;
        } else {
            previous.next = newNode;
        }
        bucketArray.set(bucketIndex, head);

        if ((1.0 * size) / defaultCapacity >= 0.7) {
            ArrayList<HashNode<K, V>> temp = bucketArray;
            int newCapacity = defaultCapacity * 2;
            for (int i = 0; i < newCapacity; i++) {
                bucketArray.add(null);
            }
            size = 0;
            for (HashNode<K, V> hashNode : temp) {
                while (hashNode != null) {
                    put(hashNode.key, hashNode.value);
                    hashNode = hashNode.next;
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
        HashNode<K, V> previous = null;
        while (current != null) {
            if (current.key.equals(key) && current.hashCode == getHashCode(key)) {
                break;
            }
            previous = current;
            current = current.next;
        }
        if (current == null) {
            return null;
        }
        if (previous == null) {
            head = null;
        } else {
            previous.next = current.next;
        }
        size--;
        bucketArray.set(bucketIndex, head);
        return current.value;
    }

    public static void main(String[] args) {
        HashMapFinal<String, Integer> map = new HashMapFinal<>();
        map.put("this", 1);
        map.put("isth", 10);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);

        System.out.println(map.get("hi"));
        System.out.println(map.remove("coder"));
        System.out.println(map.get("isth"));
    }

}


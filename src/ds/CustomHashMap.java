package ds;

import java.util.ArrayList;
import java.util.Objects;

public class CustomHashMap<K, V> {

    class HashNode<K, V> {
        K key;
        V value;
        int hashCode;
        HashNode<K, V> next;

        HashNode(K key, V value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = null;
        }
    }

    private ArrayList<HashNode<K, V>> bucketArray;
    private int bucketCapacity;
    private int size;

    CustomHashMap() {
        bucketCapacity = 10;
        size = 0;
        bucketArray = new ArrayList<>();
        for (int i = 0; i < bucketCapacity; i++) {
            bucketArray.add(null);
        }
    }

    private int getHashCode(K k) {
        return Objects.hashCode(k);
    }

    private int getBucketIndex(K k) {
        int hashCode = getHashCode(k);
        int index = hashCode % bucketCapacity;
        return index < 0 ? index * -1 : index;
    }

    public void put(K k, V v) {
        int bucketIndex = getBucketIndex(k);
        int hashCode = getHashCode(k);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(k) && current.hashCode == hashCode) {
                current.value = v;
                return;
            }
            current = current.next;
        }
        size++;
        HashNode<K, V> newNode = new HashNode<>(k, v, hashCode);
        if (head == null) {
            head = newNode;
        } else {
            head.next = newNode;
        }
        bucketArray.set(bucketIndex, head);

        if ((1.0 * size) / bucketCapacity >= 0.7) {
            bucketCapacity = bucketCapacity * 2;
            ArrayList<HashNode<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            for (int i = 0; i < bucketCapacity; i++) {
                bucketArray.add(null);
            }

            for (HashNode<K, V> hashNode : temp) {
                while (hashNode != null) {
                    put(hashNode.key, hashNode.value);
                    hashNode = hashNode.next;
                }
            }

        }
    }

    public V get(K k) {
        int bucketIndex = getBucketIndex(k);
        HashNode<K, V> head = bucketArray.get(bucketIndex);
        HashNode<K, V> current = head;
        while (current != null) {
            if (current.key.equals(k) && getHashCode(k) == current.hashCode) {
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

        if (prev != null) {
            prev.next = current.next;
        } else {
            head = current.next;
        }
        bucketArray.set(bucketIndex, head);
        return current.value;
    }

    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("this", 1);
        map.put("isth", 10);
        map.put("coder", 2);
        map.put("this", 4);
        map.put("hi", 5);

        System.out.println(map.get("isth"));
        System.out.println(map.remove("isth"));
        System.out.println(map.get("isth"));
    }

}

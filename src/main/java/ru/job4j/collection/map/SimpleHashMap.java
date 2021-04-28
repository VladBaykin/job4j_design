package ru.job4j.collection.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private Node<K, V>[] table;
    private int size = 0;
    private int capacity = 16;
    private int modCount = 0;

    public SimpleHashMap() {
        table = new Node[capacity];
    }
    public SimpleHashMap(int size) {
        table = new Node[size];
    }

    public boolean insert(K key, V value) {
        if (table.length >= 0.75 * capacity) {
            resize();
        }
        int i = getIndex(key);
        if (table[i] == null ||
                (table[i].key == key || table[i].key.equals(key))) {
            table[i] = new Node<>(getHash(key), key, value, null);
            size++;
            modCount++;
            return true;
        }
        return false;
    }

    public V get(K key) {
        int i = getIndex(key);
        if (table[i] != null) {
            return table[i].value;
        }
        return null;
    }

    public boolean delete(K key) {
        int i = getIndex(key);
        if (table[i] != null) {
            table[i] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    private void resize() {
        capacity *= 2;
        Node<K, V>[] oldTab = table;
        table = new Node[capacity];
        for (Node<K, V> el : oldTab) {
            if (el != null) {
                int i = getHash(el.key);
                table[i] = el;
            }
        }
    }

    private int getIndex(K key) {
        return (table.length - 1) & getHash(key);
    }

    private int getHash(K key) {
        int h;
        return  (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static class Node<K, V> {
        int hash;
        K key;
        V value;
        Node<K, V> next;

        public Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private int count = 0;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return table[count++].key;
            }
        };
    }
}

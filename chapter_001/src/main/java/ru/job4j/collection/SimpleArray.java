package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container;
    private int size = 0;
    private int modCount = 0;

    public SimpleArray() {
        this.container = (T[]) new Object[10];
    }

    public SimpleArray(int size) {
        this.container = (T[]) new Object[size];
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return (T) container[index];
    }

    public void add(T model) {
        modCount++;
        if (container.length == size) {
            container = (T[]) grow();
        }
        container[size++] = model;
    }

    private Object[] grow() {
        return Arrays.copyOf(container, size * 2);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int count = 0;
            private final int expectedModCount  = modCount;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return container[count++];
            }
        };
    }
}

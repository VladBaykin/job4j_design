package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] array;
    private int sizeArray = 0;

    public SimpleArray(int size) {
        this.array = new Object[size];
    }

    public void add(T model) {
        array[sizeArray++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, sizeArray);
        array[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, sizeArray);
        System.arraycopy(array, index + 1, array, index, array.length - index - 1);
        array[sizeArray - 1] = null;
        sizeArray--;
    }

    public T get(int index) {
        Objects.checkIndex(index, sizeArray);
        return (T) array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                return point < sizeArray;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
            }
                return (T) array[point++];
            }
        };
    }
}

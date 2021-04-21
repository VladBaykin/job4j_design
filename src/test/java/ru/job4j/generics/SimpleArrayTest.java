package ru.job4j.generics;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleArrayTest {
    private SimpleArray<Integer> array;

    @Before
    public void init() {
        array = new SimpleArray<>(3);
        array.add(1);
        array.add(2);
        array.add(3);
    }

    @Test
    public void whenAdd() {
        assertEquals((Integer) 1, array.get(0));
        assertEquals((Integer) 2, array.get(1));
        assertEquals((Integer) 3, array.get(2));
    }

    @Test
    public void whenSet() {
        array.set(1, 4);
        assertEquals((Integer) 4, array.get(1));
    }

    @Test
    public void whenRemove() {
        array.remove(0);
        assertEquals((Integer) 2, array.get(0));
        assertEquals((Integer) 3, array.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenOutOfBound() {
        array.get(5);
    }
}
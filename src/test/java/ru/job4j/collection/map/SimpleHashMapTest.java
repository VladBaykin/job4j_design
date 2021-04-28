package ru.job4j.collection.map;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleHashMapTest {

    @Test
    public void whenInsertAndGet() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        assertEquals("first", map.get(1));
        assertEquals("second", map.get(2));
    }

    @Test
    public void whenInsertEquals() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(1, "second");
        assertEquals("second", map.get(1));
    }

    @Test
    public void whenDelete() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        assertTrue(map.delete(1));
        assertNull(map.get(1));
    }

    @Test
    public void whenDeleteFalse() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        assertFalse(map.delete(10));
    }

    @Test
    public void whenResize() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        map.insert(3, "second");
        map.insert(4, "second");
        map.insert(5, "second");
        map.insert(6, "second");
        map.insert(7, "second");
        map.insert(8, "second");
        map.insert(9, "second");
        map.insert(10, "second");
        map.insert(11, "second");
        map.insert(12, "second");
        map.insert(13, "second");
        map.insert(14, "last");
        assertEquals("first", map.get(1));
        assertEquals("last", map.get(14));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenNoSuchElement() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        Iterator<Integer> iterator = map.iterator();
        iterator.next();
    }

    @Test (expected = ConcurrentModificationException.class)
    public void whenConcModException() {
        SimpleHashMap<Integer, String> map = new SimpleHashMap<>();
        map.insert(1, "first");
        map.insert(2, "second");
        Iterator<Integer> iterator = map.iterator();
        map.delete(2);
        iterator.next();
    }
}
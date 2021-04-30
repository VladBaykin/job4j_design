package ru.job4j.collection.list;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void whenAddAndGet() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        assertEquals((Integer) 1, list.get(0));
        assertEquals((Integer) 2, list.get(1));
    }

    @Test
    public void whenAddThenIt() {
        SimpleLinkedList<Integer> array = new SimpleLinkedList<>();
        array.add(1);
        int rsl = array.iterator().next();
        assertEquals(1, rsl);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<Integer> array = new SimpleLinkedList<>();
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<Integer> array = new SimpleLinkedList<>();
        array.add(1);
        Iterator<Integer> it = array.iterator();
        array.add(2);
        it.next();
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetFromOutOfBoundThenExceptionThrown() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);
        list.get(2);
    }

    @Test
    public void whenGetIteratorTwiceThenEveryFromBegin() {
        List<Integer> list = new SimpleLinkedList<>();
        list.add(1);
        list.add(2);

        Iterator<Integer> first = list.iterator();
        assertTrue(first.hasNext());
        assertEquals((Integer) 1, first.next());
        assertTrue(first.hasNext());
        assertEquals((Integer) 2, first.next());
        assertFalse(first.hasNext());

        Iterator<Integer> second = list.iterator();
        assertTrue(second.hasNext());
        assertEquals((Integer) 1, second.next());
        assertTrue(second.hasNext());
        assertEquals((Integer) 2, second.next());
        assertFalse(second.hasNext());
    }
}
package ru.job4j.it;

import org.junit.Test;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class FlatMapTest {

    @Test
    public void whenDiffNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator(),
                List.of(2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertEquals((Integer) 1, flat.next());
        assertEquals((Integer) 2, flat.next());
        assertEquals((Integer) 3, flat.next());
    }

    @Test
    public void whenSeqNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1, 2, 3).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertEquals((Integer) 1, flat.next());
        assertEquals((Integer) 2, flat.next());
        assertEquals((Integer) 3, flat.next());
    }

    @Test
    public void whenMultiHasNext() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertTrue(flat.hasNext());
    }

    @Test
    public void whenHasNextFalse() {
        Iterator<Iterator<Integer>> data = List.of(
                List.of(1).iterator()
        ).iterator();
        FlatMap<Integer> flat = new FlatMap<>(data);
        assertEquals((Integer) 1, flat.next());
        assertFalse(flat.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenEmpty() {
        Iterator<Iterator<Object>> data = List.of(
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(data);
        flat.next();
    }

    /*@Test
    public void whenSeveralEmptyAndNotEmpty() {
        Iterator<Iterator<?>> it = List.of(
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                List.of(1).iterator()
        ).iterator();
        FlatMap flat = new FlatMap(it);
        assertTrue(flat.hasNext());
        assertEquals((Integer) 1, flat.next());
    }*/

    @Test
    public void whenSeveralEmptyThenReturnFalse() {
        Iterator<Iterator<Object>> it = List.of(
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator(),
                Collections.emptyIterator()
        ).iterator();
        FlatMap<Object> flat = new FlatMap<>(it);
        assertFalse(flat.hasNext());
    }
}
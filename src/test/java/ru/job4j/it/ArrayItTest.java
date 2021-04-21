package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class ArrayItTest {

    @Test
    public void whenMultiCallHasNextThenTrue() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        assertTrue(it.hasNext());
    }

    @Test
    public void whenReadSequence() {
        ArrayIt it = new ArrayIt(new int[] {1, 2, 3});
        assertEquals((Integer) 1, it.next());
        assertEquals((Integer) 2, it.next());
        assertEquals((Integer) 3, it.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        ArrayIt it = new ArrayIt(
                new int[] {}
        );
        it.next();
    }
}
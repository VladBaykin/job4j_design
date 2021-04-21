package ru.job4j.it;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class BackwardArrayItTest {

    @Test
    public void whenMultiCallHasNextThenTrue() {
        BackwardArrayIt it = new BackwardArrayIt(new int[] {1, 2, 3});
        assertTrue(it.hasNext());
    }

    @Test
    public void whenReadSequence() {
        BackwardArrayIt it = new BackwardArrayIt(new int[] {1, 2, 3});
        assertEquals((Integer) 3, it.next());
        assertEquals((Integer) 2, it.next());
        assertEquals((Integer) 1, it.next());
    }

    @Test(expected = NoSuchElementException.class)
    public void whenNextFromEmpty() {
        BackwardArrayIt it = new BackwardArrayIt(
                new int[] {}
        );
        it.next();
    }
}
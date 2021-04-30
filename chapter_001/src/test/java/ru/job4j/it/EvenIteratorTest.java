package ru.job4j.it;

import org.junit.Before;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class EvenIteratorTest {
    private Iterator<Integer> it;

    @Before
    public void setUp() {
        it = new EvenIterator(new int[] {1, 2, 3, 4, 5, 6, 7});
    }

    @Test(expected = NoSuchElementException.class)
    public void shouldReturnEvenNumbersSequentially() {
        assertTrue(it.hasNext());
        assertEquals((Integer) 2, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 4, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 6, it.next());
        assertFalse(it.hasNext());
        it.next();
    }

    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder() {
        assertTrue(it.hasNext());
        assertEquals((Integer) 2, it.next());
        assertEquals((Integer) 4, it.next());
        assertEquals((Integer) 6, it.next());
    }

    @Test
    public void  shouldReturnFalseIfNoAnyEvenNumbers() {
        it = new EvenIterator(new int[]{1});
        assertFalse(it.hasNext());
    }

    @Test
    public void allNumbersAreEven() {
        it = new EvenIterator(new int[] {2, 4, 6, 8});
        assertTrue(it.hasNext());
        assertEquals((Integer) 2, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 4, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 6, it.next());
        assertTrue(it.hasNext());
        assertEquals((Integer) 8, it.next());
    }
}
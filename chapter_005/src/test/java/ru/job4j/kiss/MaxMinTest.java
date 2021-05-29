package ru.job4j.kiss;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MaxMinTest {

    private List<Integer> list;

    @Before
    public void init() {
        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
    }

    @Test
    public void whenMax() {
        MaxMin maxMin = new MaxMin();
        Integer rsl = maxMin.max(list, Integer::compare);
        assertEquals(4, (int) rsl);
    }

    @Test
    public void whenMin() {
        MaxMin maxMin = new MaxMin();
        Integer rsl = maxMin.min(list, Integer::compare);
        assertEquals(1, (int) rsl);
    }
}
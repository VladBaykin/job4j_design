package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenDiff() {
        List<Analyze.User> previous = List.of(
                new Analyze.User(1, "Name1"),
                new Analyze.User(3, "Name3"),
                new Analyze.User(5, "Name5")
        );
        List<Analyze.User> current = List.of(
                new Analyze.User(1, "changed"),
                new Analyze.User(2, "Name2"),
                new Analyze.User(4, "Name4"),
                new Analyze.User(5, "Name5")
        );
        Analyze.Info result = Analyze.diff(previous, current);
        assertEquals(2, result.added);
        assertEquals(1, result.changed);
        assertEquals(1, result.deleted);
    }

    @Test
    public void whenCurrentNull() {
        List<Analyze.User> previous = List.of(
                new Analyze.User(1, "Name1"),
                new Analyze.User(2, "Name3")
        );
        List<Analyze.User> current = new ArrayList<>();
        Analyze.Info result = Analyze.diff(previous, current);
        assertEquals(0, result.added);
        assertEquals(0, result.changed);
        assertEquals(2, result.deleted);
    }

    @Test
    public void whenPreviousNull() {
        List<Analyze.User> previous = new ArrayList<>();
        List<Analyze.User> current = List.of(
                new Analyze.User(1, "Name1"),
                new Analyze.User(2, "Name2")
        );
        Analyze.Info result = Analyze.diff(previous, current);
        assertEquals(2, result.added);
        assertEquals(0, result.changed);
        assertEquals(0, result.deleted);
    }
}
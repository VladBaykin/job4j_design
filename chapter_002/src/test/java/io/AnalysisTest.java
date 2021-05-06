package io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AnalysisTest {

    @Test
    public void unavailable() {
        Analysis analyze = new Analysis();
        analyze.unavailable("./data/server.log", "./data/unavailable.csv");
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("./data/unavailable.csv"))) {
            lines = reader.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> expected = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        assertEquals(expected, lines);
    }
}
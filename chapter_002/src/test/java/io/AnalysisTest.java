package io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class AnalysisTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

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

    @Test
    public void whenUnavailable() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:01");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        Analysis analyze = new Analysis();
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        List<String> result;
        try (BufferedReader reader = new BufferedReader(new FileReader(target))) {
            result = reader.lines().collect(Collectors.toList());
        }
        List<String> expected = List.of("10:57:01;10:59:01", "11:01:02;11:02:02");
        assertEquals(expected, result);
    }
}
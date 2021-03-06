package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            values = reader.lines()
                    .filter(s -> !s.isEmpty() && !s.startsWith("#"))
                    .map(Config::getPair)
                    .collect(Collectors.toMap(str -> str[0], str -> str[1]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String[] getPair(String line) {
        String[] pair = line.split("=");
        if (pair.length != 2) {
            throw new IllegalArgumentException();
        }
        return pair;
    }

    public String value(String key) {
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}

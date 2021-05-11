package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            lines = load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        writeTarget(lines, target);
    }

    private List<String> load(BufferedReader reader) throws IOException {
        List<String> result = new ArrayList<>();
        String temp = "";
        boolean status = true;
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            if (line.isEmpty()) {
                line = reader.readLine();
            }
            String[] parts = line.split(" ");
            if (status && (parts[0].equals("400") || parts[0].equals("500"))) {
                temp = parts[1] + ";";
                status = false;
            } else if (!status && (parts[0].equals("200") || parts[0].equals("300"))) {
                result.add(temp + parts[1]);
                status = true;
            }
        }
        return result;
    }

    public void writeTarget(List<String> lines, String target) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            lines.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

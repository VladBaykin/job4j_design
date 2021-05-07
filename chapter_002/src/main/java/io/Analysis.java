package io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            List<String> lines = load(in);
            lines.forEach(out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}

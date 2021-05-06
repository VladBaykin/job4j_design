package io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            boolean status = true;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                if (line.isEmpty()) {
                    line = in.readLine();
                }
                String[] parts = line.split(" ");
                if (status && (parts[0].equals("400") || parts[0].equals("500"))) {
                    out.print(parts[1]);
                    status = false;
                } else if (!status && (parts[0].equals("200") || parts[0].equals("300"))) {
                    out.println(";" + parts[1]);
                    status = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

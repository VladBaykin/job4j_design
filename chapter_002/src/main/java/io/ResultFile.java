package io;

import java.io.FileOutputStream;
import java.util.Arrays;

public class ResultFile {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                table[i - 1][j - 1] = i * j;
            }
        }
        return table;
    }

    public static void main(String[] args) {
        int[][] array = multiple(9);
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int[] row : array) {
                out.write(Arrays.toString(row).getBytes());
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

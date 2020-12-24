package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        int[] array = new int[0];
        try (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
            array = in.lines().mapToInt(Integer::parseInt).toArray();
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        } if (array != null) {
            for (int j : array) {
                if (j % 2 == 0) {
                    System.out.println(j + " - четное");
                } else {
                    System.out.println(j + " - нечетное");
                }
            }
        }
    }
}

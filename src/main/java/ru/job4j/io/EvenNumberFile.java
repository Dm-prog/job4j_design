package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
            String str;
            while ((str = in.readLine()) != null) {
                if (Integer.parseInt(str) % 2 == 0) {
                    System.out.println(str + " - четное");
                } else {
                    System.out.println(str + " - нечетное");
                }
            }

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

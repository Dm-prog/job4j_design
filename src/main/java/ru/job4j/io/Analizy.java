package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Analizy {
    public void unavailable(String source, String target) {
        Stack<String> strings = new Stack<>();
        try (BufferedReader br = new BufferedReader(new FileReader(source));
             PrintWriter pw = new PrintWriter(new FileOutputStream(target))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                for (String s : words) {
                    if ((s.equals("400") || s.equals("500")) && strings.size() == 0) {
                        strings.push(words[1]);
                    }
                    if ((s.equals("200") || s.equals("300")) && strings.size() == 1) {
                        String rsl = strings.pop() + ";" + words[1] + ";";
                        pw.println(rsl);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Analizy().unavailable("server.log", "unavailable.csv");
    }
}

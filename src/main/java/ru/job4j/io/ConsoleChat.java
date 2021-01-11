package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    List<String> listWords = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void getBotAnswers() {
        File file = new File("botAnswer.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
            String str = reader.readLine();
            while (str != null) {
                listWords.add(str);
                str = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = listWords.get((int) (Math.random() * listWords.size()));
        System.out.println(s);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("path.txt"))) {
            writer.write(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop() {
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("path.txt"))) {
            boolean flag = true;
            String stop;
            while (flag) {
                stop = scanner.nextLine();
                if (stop.equals(CONTINUE)) {
                    writer.write(CONTINUE);
                    run();
                    flag = false;
                } else if (stop.equals(OUT)){
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        boolean flag = true;
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("path.txt"))) {
            while (flag) {
                botAnswers = scanner.nextLine();
                if (botAnswers.equals(STOP)) {
                    writer.write(STOP + System.lineSeparator());
                    stop();
                }
                if (!botAnswers.equals(OUT)) {
                    writer.write(botAnswers + System.lineSeparator());
                    getBotAnswers();
                } else {
                    writer.write(OUT);
                    flag = false;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchElementException noSuchElementException) {
            noSuchElementException.getMessage();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("", "");
        cc.run();
    }
}

package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ConsoleChat {
    private final String path;
    private String user;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> listWords = new ArrayList<>();
    private List<String> botAnswerList = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.user = botAnswers;
    }

    public void run() {
        boolean flag = true;
        try (Scanner scanner = new Scanner(System.in);
             BufferedWriter writer = new BufferedWriter(new FileWriter("path.txt"))) {
            while (flag) {
                user = scanner.nextLine();
                if (user.equals(STOP)) {
                    writer.write(STOP + System.lineSeparator());
                    boolean isStop = true;
                    String stop;
                    while (isStop) {
                        stop = scanner.nextLine();
                        if (stop.equals(CONTINUE)) {
                            writer.write(CONTINUE + System.lineSeparator());
                            isStop = false;
                        } else if (stop.equals(OUT)) {
                            return;
                        }
                    }
                }
                if (!user.equals(OUT)) {
                    if (!user.equals(STOP)) {
                        writer.write(user + System.lineSeparator());
                    }
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
                    writer.write(s + System.lineSeparator());
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

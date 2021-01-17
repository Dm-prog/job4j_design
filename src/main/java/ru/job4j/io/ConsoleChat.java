package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ConsoleChat {

    private String logChat;
    private String botAnswer;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private List<String> botAnswerList = new ArrayList<>();
    private List<String> userQuestionsList = new ArrayList<>();

    public ConsoleChat(String logChat, String botAnswer) {
        this.logChat = logChat;
        this.botAnswer = botAnswer;
    }

    public void getWriter(String command) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(logChat))) {
            userQuestionsList.add(command);
            for (String str : userQuestionsList) {
                writer.write(str + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String randomAnswer() {
        return botAnswerList.get((int) (Math.random() * botAnswerList.size()));
    }

    private void answerReader() throws IOException {
        botAnswerList = Files.readAllLines(Path.of(botAnswer));
    }

    public void run() throws IOException {
        answerReader();
        boolean flag = true;
        String user;
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                user = scanner.nextLine();
                if (user.equals(STOP)) {
                    userQuestionsList.add(STOP);
                    boolean isStop = true;
                    String stop;
                    while (isStop) {
                        stop = scanner.nextLine();
                        if (stop.equals(CONTINUE)) {
                            userQuestionsList.add(CONTINUE);
                            isStop = false;
                        } else if (stop.equals(OUT)) {
                            return;
                        }
                    }
                }
                if (!user.equals(OUT)) {
                    if (!user.equals(STOP)) {
                        userQuestionsList.add(user);
                    }

                    String botAnswer = randomAnswer();
                    System.out.printf("%s%n", botAnswer);
                    userQuestionsList.add(String.format("%s", botAnswer));
                } else {
                    userQuestionsList.add(OUT);
                    flag = false;
                }
            }
            getWriter("");
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("D:\\job4j - projects\\job4j_design\\log.txt",
                "D:\\job4j - projects\\job4j_design\\botAnswer.txt");
        cc.run();
    }
}

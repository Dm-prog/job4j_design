package test.task_1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    protected static final Map<String, List<String>> resultMap = new HashMap<>();
    protected static final Map<String, String> emailMap = new HashMap<>();

    static {
        System.out.println("input example : user1 -> xxx@ya.ru, foo@gmail.com, lol@mail.ru");
        System.out.println("for union emails input \"u\"");
        System.out.println("for exit input \"q\"");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();

            if ("u".equals(input)) {
                break;
            }

            if ("q".equals(input)) {
                return;
            }

            addUserEmails(input);
        }

        getUsersEmails();

        printResults();
    }

    public static void addUserEmails(String userStr) {

        final String key = userStr.substring(0, userStr.indexOf("->")).trim();
        final String listStr = userStr.substring(userStr.indexOf("->") + 2).trim();
        final List<String> listEmail = Arrays.asList(listStr.trim().split("\\s*,\\s*"));

        String foundUser = null;

        for (String email : listEmail) {
            if (emailMap.get(email) != null) {
                foundUser = emailMap.get(email);
            }
        }

        if (foundUser != null) {
            for (String email : listEmail) {
                emailMap.put(email, foundUser);
            }
        } else {
            for (String email : listEmail) {
                emailMap.put(email, key);
            }
        }

    }

    public static void getUsersEmails() {
        for (Map.Entry<String, String> entry : emailMap.entrySet()) {
            if (resultMap.get(entry.getValue()) == null) {
                List<String> emails = new ArrayList<>();
                emails.add(entry.getKey());
                resultMap.put(entry.getValue(), emails);
            } else {
                List<String> emails = resultMap.get(entry.getValue());
                emails.add(entry.getKey());
                resultMap.put(entry.getValue(), emails);
            }
        }
    }

    public static void printResults() {
        for (Map.Entry<String, List<String>> listEntry : resultMap.entrySet()) {
            System.out.println(listEntry.getKey() + " -> " + listEntry.getValue().stream()
                    .collect(Collectors.joining(",")));
        }
    }
}

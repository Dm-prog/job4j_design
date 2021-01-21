package ru.job4j.io.searcher;

import java.util.*;

public class Args {
    private Map<String, String> keys = new HashMap<>();
    private String[] args;

    public static void main(String[] args) {

    }

    public Args(String[] args) {
        this.args = args;
        validate();
    }

    private void validate() {
        List<String> strings = new ArrayList<>(Arrays.asList(args));
        strings.remove("-m");
        for (int i = 0; i < strings.size(); i++) {
            if (i % 2 == 0) {
                keys.put(strings.get(i).replace("-", ""), strings.get(i + 1));
            }
        }
        keys.put("m", "");
//        for (Map.Entry<String, String> entry : keys.entrySet()) {
//            System.out.println(entry.getKey() + " " + entry.getValue());
//        }
    }

    public String directory() {
        return keys.get("d");
    }

    public String fileName() {
        return keys.get("n");
    }

    public String mask() {
        return keys.get("m");
    }

    public String result() {
        return keys.get("o");
    }
}

package ru.job4j.io.searcher;

import java.util.HashMap;
import java.util.Map;

public class Args {
    private Map<String, String> keys = new HashMap<>();
    private final String[] args;

    public static void main(String[] args) {

    }

    public Args(String[] args) {
        this.args = args;
        validate();
    }

    private boolean validate() {
        for (String arg : args) {
            String[] line = arg.split("=");
            if (line.length != 2) {
                throw new IllegalArgumentException();
            }
            keys.put(line[0].replaceFirst("-", ""), line[1]);
        }
        return true;
    }

    public String directory() {
        return "d";
    }

    public String fileName() {
        return "n";
    }

    public String mask() {
        return "m";
    }

    public String result() {
        return "o";
    }
}

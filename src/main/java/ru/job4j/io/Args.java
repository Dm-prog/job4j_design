package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class Args {

    private final String[] args;
    private final Map<String, String> values = new HashMap<>();

    public Args(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        for (String arg : args) {
            String[] line = arg.split("=");
            if (line.length != 2) {
                throw new IllegalArgumentException();
            }
            values.put(line[0].replaceFirst("-", ""), line[1]);
        }
        return true;
    }

    public String directory() {
        return values.get("d");
    }

    public String fileName() {
        return values.get("n");
    }

    public String mask() {
        return values.get("m");
    }

    public String result() {
        return values.get("o");
    }
}

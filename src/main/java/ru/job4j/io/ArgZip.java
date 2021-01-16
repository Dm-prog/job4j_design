package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private final String[] args;
    private final Map<String, String> values = new HashMap<>();

    public ArgZip(String[] args) {
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

    public String exclude() {
        return values.get("e");
    }

    public String output() {
        return values.get("o");
    }
}

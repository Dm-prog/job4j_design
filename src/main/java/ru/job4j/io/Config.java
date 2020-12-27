package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            String line;
            while ((line = read.readLine()) != null) {
               String[] words = line.split("=");
               values.put(words[0], words[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
//        for (Map.Entry<String, String> entry : values.entrySet()) {
//            if (entry.getKey().equals(key)) {
//                return entry.getValue();
//            }
//        }
        if (values.get(key).equals(key)) {
            return values.get(key);
        }
        return null;
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}

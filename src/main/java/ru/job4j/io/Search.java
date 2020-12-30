package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Search {
    public static void main(String[] args) {
        Path start = Paths.get(".");
        search(start, "js").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) {
        SearchFiles searcher = new SearchFiles(p -> p.toFile().getName().endsWith(ext));
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }
}
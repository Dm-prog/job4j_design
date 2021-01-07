package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class SearchDuplicates extends SimpleFileVisitor<Path> {
    private Predicate<Path> predicate;
    private List<Path> paths;
    private Set<Path> set;

    public SearchDuplicates(Predicate<Path> predicate, List<Path> paths, Set<Path> set) {
        this.predicate = predicate;
        this.paths = paths;
        this.set = set;
    }

    public List<Path> getPaths() {
        return paths;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (predicate.test(file)) {
            paths.add(file);
        }
        for (Path path : paths) {
            if (path.toFile().length() == file.toFile().length()) {
                set.add(file);
            }
        }
        return FileVisitResult.CONTINUE;
    }
}


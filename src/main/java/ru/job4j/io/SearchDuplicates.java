package ru.job4j.io;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Set;

public class SearchDuplicates extends SimpleFileVisitor<Path> {
    private final List<FileProperty> dublicates;
    private final Set<FileProperty> set;


    public SearchDuplicates(List<FileProperty> dublicates, Set<FileProperty> set) {
        this.dublicates = dublicates;
        this.set = set;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        FileProperty fileProperty = new FileProperty(file.toFile().getName(), file.toFile().length());
        if (!set.contains(fileProperty)) {
            set.add(fileProperty);
        } else {
            dublicates.add(fileProperty);
        }
        return FileVisitResult.CONTINUE;
    }
}


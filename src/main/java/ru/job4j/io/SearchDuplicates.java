package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class SearchDuplicates extends SimpleFileVisitor<Path> {
    private final List<FileProperty> dublicates;
    private final Set<FileProperty> set;


    public SearchDuplicates(List<FileProperty> dublicates, Set<FileProperty> set) {
        this.dublicates = dublicates;
        this.set = set;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        for (FileProperty property : dublicates) {
            FileProperty fileProperty = new FileProperty();
            if (property.equals(fileProperty)) {
                dublicates.add(fileProperty);
            } else {
                set.add(fileProperty);
            }
        }
        return FileVisitResult.CONTINUE;
    }
}


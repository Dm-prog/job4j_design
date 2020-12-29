package ru.job4j.io;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("D:\\job4j - projects");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println("name : " + file.getName());
        System.out.println(String.format("size : %s", file.getTotalSpace()));
//        for (File subfile : file.listFiles()) {
//            System.out.println(subfile.getAbsoluteFile());
//        }
    }
}
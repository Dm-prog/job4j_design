package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        boolean bool = true;
        char ch = 'a';
        byte b = 1;
        float f = 3.4f;
        long l = 34;
        double d = 5.4;
        LOG.debug("User info name : {}, age : {}, bool : {}, ch : {}, b : {}," +
                "f : {}, l : {}, d : {}", name, age, bool, ch, b, f, l, d);
    }
}

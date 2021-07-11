package ru.job4j.io.serialization.xml;

import java.util.Arrays;

public class Bicycle {
    private final boolean sport;
    private final int speed;
    private final Passport passport;
    private final String[] wheels;

    public static void main(String[] args) {
        final Bicycle bicycle = new Bicycle(
                true,
                100,
                new Passport("11_1111"),
                "frontWheel", "rearWheel");
    }

    public Bicycle(boolean sport, int speed, Passport passport, String... wheels) {
        this.sport = sport;
        this.speed = speed;
        this.passport = passport;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Bicycle{"
                + "sport="
                + sport
                + ", speed="
                + speed
                + ", passport="
                + passport
                + ", wheels="
                + Arrays.toString(wheels)
                + '}';
    }
}

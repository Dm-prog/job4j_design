package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Bicycle {
    private final boolean sport;
    private final int speed;
    private final Passport passport;
    private final String[] wheels;

    public static void main(String[] args) {
        final Bicycle bicycle = new Bicycle(true, 100, new Passport("11_1111"), "frontWheel", "rearWheel");

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(bicycle));

        /* Модифицируем json-строку */
        final String bicyclJson =
                "{"
                        + "\"sport\":true,"
                        + "\"speed\":100,"
                        + "\"passport\":"
                        + "{"
                        + "\"passportDetails\":\"11_1111\""
                        + "},"
                        + "\"wheels\":"
                        + "[\"frontWheel\",\"rearWheel\"]"
                        + "}";
        final Bicycle bicycleMod = gson.fromJson(bicyclJson, Bicycle.class);
        System.out.println(bicycleMod);
    }

    public Bicycle(boolean sport, int speed, Passport passport, String... wheels) {
        this.sport = sport;
        this.speed = speed;
        this.passport = passport;
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Bicycle{" +
                "sport=" + sport +
                ", speed=" + speed +
                ", passport=" + passport +
                ", wheels=" + Arrays.toString(wheels) +
                '}';
    }
}

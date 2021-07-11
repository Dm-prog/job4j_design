package ru.job4j.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        final String bicycleJson =
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
        final Bicycle bicycleMod = gson.fromJson(bicycleJson, Bicycle.class);
        System.out.println(bicycleMod);

        //---------------------------------------------------------------------//

        /* JSONObject из json-строки строки */
        JSONObject jsonPassport = new JSONObject("{\"passportDetails\":\"11_1111\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("frontWheel");
        list.add("rearWheel");
        JSONArray jsonWheels = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Bicycle bicycle1 = new Bicycle(true, 80, new Passport("11_1111"), "frontWheel", "rearWheel");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sport", bicycle.isSport());
        jsonObject.put("speed", bicycle.getSpeed());
        jsonObject.put("passport", jsonPassport);
        jsonObject.put("wheels", jsonWheels);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(bicycle1).toString());
    }

    public Bicycle(boolean sport, int speed, Passport passport, String... wheels) {
        this.sport = sport;
        this.speed = speed;
        this.passport = passport;
        this.wheels = wheels;
    }

    public boolean isSport() {
        return sport;
    }

    public int getSpeed() {
        return speed;
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

package ru.job4j.design.srp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class JSONReport implements Report {

    private final Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        final Gson gson = new GsonBuilder().create();
        String json = gson.toJson(employees);
        return json;
    }
}

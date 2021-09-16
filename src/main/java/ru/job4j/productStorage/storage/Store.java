package ru.job4j.productStorage.storage;

import ru.job4j.productStorage.Food;

import java.util.List;

public interface Store {
    boolean add(Food item);
    List<Food> clear();
}

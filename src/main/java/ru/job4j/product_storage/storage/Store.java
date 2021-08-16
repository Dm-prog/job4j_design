package ru.job4j.product_storage.storage;

import ru.job4j.product_storage.Food;

import java.util.List;

public interface Store {
    boolean add(Food item);
    List<Food> clear();
}

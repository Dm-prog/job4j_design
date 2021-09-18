package ru.job4j.product.storage;

import ru.job4j.product.Food;

import java.util.List;

public interface Store {
    boolean add(Food item);
    List<Food> clear();
}

package ru.job4j.product_storage.storage;

import ru.job4j.product_storage.Food;

public interface Store {
    boolean add(Food item);
}

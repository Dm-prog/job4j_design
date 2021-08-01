package ru.job4j.product_storage;

import ru.job4j.product_storage.storage.Shop;
import ru.job4j.product_storage.storage.Store;
import ru.job4j.product_storage.storage.Trash;
import ru.job4j.product_storage.storage.Warehouse;

import java.util.List;

public class ControlQuality {

    private List<Food> containers;
    private Warehouse warehouse;
    private Shop shop;
    private Trash trash;

    void distribute(Food food) {
        if (warehouse.add(food)) {
            containers.add(food);
        }
        if (shop.add(food)) {
            containers.add(food);
        }
        if (trash.add(food)) {
            containers.add(food);
        }
    }
}

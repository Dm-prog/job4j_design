package ru.job4j.product_storage.storage;

import ru.job4j.product_storage.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> trashFoods = new ArrayList<>();
    private Food food;

    @Override
    public boolean add(Food item) {
        if (Double.compare(item.getLivedTimePercent(), 1) > 0) {
            trashFoods.add(item);
        } else if (Double.compare(item.getLivedTimePercent(), 0.75) > 0
                && Double.compare(item.getLivedTimePercent(), 1) < 0) {
            food.setDiscount(0.75);
        } else {
            return false;
        }
        return true;
    }
}

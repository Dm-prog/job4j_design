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
        } else {
            return false;
        }
        return true;
    }
}

package ru.job4j.product.storage;

import ru.job4j.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {

    private List<Food> trashFoods = new ArrayList<>();

    @Override
    public boolean add(Food item) {
        if (Double.compare(item.getLivedTimePercent(), 1) > 0) {
            trashFoods.add(item);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<Food> clear() {
        List<Food> copy = new ArrayList<>(trashFoods);
        trashFoods.clear();
        return copy;
    }
}

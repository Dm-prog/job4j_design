package ru.job4j.product.storage;

import ru.job4j.product.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {

    private List<Food> warehouseFoods = new ArrayList<>();

    @Override
    public boolean add(Food item) {
        if (Double.compare(item.getLivedTimePercent(), 0.25) < 0) {
            warehouseFoods.add(item);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<Food> clear() {
        List<Food> copy = new ArrayList<>(warehouseFoods);
        warehouseFoods.clear();
        return copy;
    }
}

package ru.job4j.product_storage.storage;

import ru.job4j.product_storage.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements Store {

    private List<Food> shopFoods = new ArrayList<>();
    private Food food;

    @Override
    public boolean add(Food item) {
        if (Double.compare(item.getLivedTimePercent(), 0.25) >= 0
                && Double.compare(item.getLivedTimePercent(), 0.75) <= 0) {
            shopFoods.add(item);
        } else if (Double.compare(item.getLivedTimePercent(), 0.75) > 0
                && Double.compare(item.getLivedTimePercent(), 1) < 0) {
            food.setDiscount(0.75);
            shopFoods.add(item);
        } else {
            return false;
        }
        return true;
    }

    @Override
    public List<Food> clear() {
        shopFoods.clear();
        return shopFoods;
    }
}

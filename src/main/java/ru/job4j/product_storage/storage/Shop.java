package ru.job4j.product_storage.storage;

import ru.job4j.product_storage.ControllQuality;
import ru.job4j.product_storage.Food;

import java.util.ArrayList;
import java.util.List;

public class Shop implements ControllQuality {

    private List<Food> shopFoods = new ArrayList<>();
    private Food food;

    @Override
    public void add(Food item) {
        if (Double.compare(item.getLivedTimePercent(), 0.25) >= 0
                && Double.compare(item.getLivedTimePercent(), 0.75) <= 0) {
            shopFoods.add(item);
        } else if (Double.compare(item.getLivedTimePercent(), 0.75) > 0
                && Double.compare(item.getLivedTimePercent(), 1) < 0) {
            food.setDiscount(0.75);
            shopFoods.add(item);
        }
    }
}

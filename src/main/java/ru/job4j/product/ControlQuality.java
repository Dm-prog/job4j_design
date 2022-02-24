package ru.job4j.product;

import ru.job4j.product.storage.Store;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    void distribute(Food food) {
        for (Store store : stores) {
            if (store.add(food)) {
                break;
            }
        }
    }

    public void resort() {


        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.clear());
        }

        for (Food food : foods) {
            distribute(food);
        }
    }
}

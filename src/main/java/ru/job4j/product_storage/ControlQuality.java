package ru.job4j.product_storage;

import ru.job4j.product_storage.storage.Store;

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
        List<Store> containersFood = new ArrayList<>();
        for (Store store : stores) {

        }
        for (Store food : containersFood) {

        }
    }
}

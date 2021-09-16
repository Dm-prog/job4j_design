package ru.job4j.productStorage;

import ru.job4j.productStorage.storage.Store;

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

        // собираем все продукты воедино, очищая при этом хранилища
        List<Food> foods = new ArrayList<>();
        for (Store store : stores) {
            foods.addAll(store.clear());
        }
        // заново распределяем продукты
        for (Food food : foods) {
            distribute(food);
        }
    }
}
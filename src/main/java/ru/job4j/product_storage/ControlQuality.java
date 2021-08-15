package ru.job4j.product_storage;

import ru.job4j.product_storage.storage.Shop;
import ru.job4j.product_storage.storage.Store;
import ru.job4j.product_storage.storage.Trash;
import ru.job4j.product_storage.storage.Warehouse;

import java.util.ArrayList;
import java.util.List;

public class ControlQuality {

    private List<Store> stores;
    private Warehouse warehouse;
    private Trash trash;
    private Shop shop;

    public ControlQuality(Warehouse warehouse, Trash trash, Shop shop) {
        this.warehouse = warehouse;
        this.trash = trash;
        this.shop = shop;
    }

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

    public void resort(Food food) {
        List<Food> containersFood = new ArrayList<>();
        containersFood.addAll(warehouse.getWarehouseFoods());
        containersFood.addAll(trash.getTrashFoods());
        containersFood.addAll(shop.getShopFoods());

        distribute(food);
    }
}

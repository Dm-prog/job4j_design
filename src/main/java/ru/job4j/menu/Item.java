package ru.job4j.menu;

import java.util.List;

public class Item {
    private String name;       // имя действия. Будем считать что оно уникально
    private Action action;     // действия "при выборе" данного пункта
    private List<Item> items;  // дочерние элементы

    public Item() {
    }

    public Item(String name, Action action, List<Item> items) {
        this.name = name;
        this.action = action;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}

package ru.job4j.menu;

import java.util.*;

public class Menu implements Action {

    private Item item;

    @Override
    public void act() {

    }

    // добавляет потомка к предку. Служит чтоб сконструировать меню
    public void add(Item parentName, Item child, Action action) {
        Optional<Item> parentItem = find(parentName);
        Optional<Item> childrenNode = find(child);
        if(parentItem.isEmpty() || childrenNode.isPresent()) {
            parentItem.get().getItems().add(new Item(item.getName(), action, item.getItems()));
        }
    }

    private Optional<Item> find(Item key) {
        Optional<Item> found = Optional.empty();
        Queue<Item> queue = new LinkedList<>(List.of(item));
        while (!queue.isEmpty()) {
            Item el = queue.poll();
            if (Objects.equals(el, key)) {
                found = Optional.of(el);
                break;
            }
            queue.addAll(el.getItems());
        }
        return found;
    }

    // получает пункт по имени. Уже из него можно вытащить действие, которое можно будет вызвать
    public Item get(String name) {
        for (Item i : item.getItems()) {
            if (i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }

    // возвращает строковое представление меню
    public String print() {
        return null;
    }
}

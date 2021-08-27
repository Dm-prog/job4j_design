package ru.job4j.menu;

import java.util.*;

public class Menu {

    private Item item;

    // добавляет потомка к предку. Служит чтоб сконструировать меню
    public void add(Item parentName, Item child, Action action) {
        Optional<Item> parentItem = find(parentName.getName());
        Optional<Item> childrenNode = find(child.getName());
        if(parentItem.isEmpty() || childrenNode.isPresent()) {
            parentItem.get().getItems().add(new Item(item.getName(), action, item.getItems()));
        }
    }

    private Optional<Item> find(String name) {
        Optional<Item> found = Optional.empty();
        Queue<Item> queue = new LinkedList<>(List.of(item));
        while (!queue.isEmpty()) {
            Item el = queue.poll();
            if (Objects.equals(el, name)) {
                found = Optional.of(el);
                break;
            }
            queue.addAll(el.getItems());
        }
        return found;
    }

    // получает пункт по имени. Уже из него можно вытащить действие, которое можно будет вызвать
    public Item get(String name) {
        Optional<Item> optional = find(name);
        return optional.orElse(null);
    }

    // возвращает строковое представление меню
    public String print(int lvl, StringBuilder out) {
        String prefix = "-".repeat(lvl);
        out.append(String.format("%sn", (prefix + " ").stripLeading()));
        item.getItems().forEach(c -> print(lvl + 1, out));
        return out.toString();
    }
}

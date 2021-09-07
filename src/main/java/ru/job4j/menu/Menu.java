package ru.job4j.menu;

import java.util.*;

public class Menu {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Action action = new StubAction();
        Item childElements1 = new Item("name1", action, Arrays.asList(new Item()));
        Item childElements2 = new Item("name2", action, Arrays.asList(new Item()));
        Item childElements3 = new Item("name3", action, Arrays.asList(new Item()));
        Item item = new Item("nameAction", action, Arrays.asList(
                childElements1, childElements2, childElements3
        ));
        menu.print(item);
    }

    private Item item;

    // добавляет потомка к предку. Служит чтоб сконструировать меню
    public void add(Item parentName, Item child) {
        Optional<Item> parentItem = find(parentName.getName());
        Optional<Item> childrenNode = find(child.getName());
        if(parentItem.isEmpty() || childrenNode.isPresent()) {
            parentItem.get().getItems().add(child);
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
    public void print(Item item) {
        for (int i = 0; i < item.getItems().size(); i++) {
            System.out.printf("%d. %s%n", i, item.getName());
        }
    }
}
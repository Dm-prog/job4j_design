package ru.job4j.menu;

import java.util.*;

public class Menu {

    public static void main(String[] args) {
        List<Item> itemsChild = new ArrayList<>();
        Item item = new Item("Something from the parent menu", new StubAction(), itemsChild);
        Menu menu = new Menu(item);

        menu.find(item.getName());
        menu.print(item);
    }

    private Item item;
    private int count = 0;

    public Menu(Item item) {
        this.item = item;
    }

    // добавляет потомка к предку. Служит чтоб сконструировать меню
    public void add(Item parentName, Item child) {
        Optional<Item> parentItem = find(parentName.getName());
        Optional<Item> childrenItem = find(child.getName());
        if (parentItem.isEmpty() || childrenItem.isPresent()) {
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
        count++;
        System.out.printf("%d. %s%n", count, item.getName());
        for (int i = 0; i < item.getItems().size(); i++) {
            print(item.getItems().get(i));
        }
    }
}



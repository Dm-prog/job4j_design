package ru.job4j.menu;

import java.util.*;

public class Menu {

    public static void main(String[] args) {
        Item parentItem1 = new Item();
        parentItem1.setName("1");
        Item parentItem2 = new Item();
        parentItem2.setName("2");
        Item parentItem3 = new Item();
        parentItem3.setName("3");

        List<Item> itemsChild = new ArrayList<>();
        itemsChild.add(new Item());
        itemsChild.add(new Item());
        itemsChild.add(new Item());
        Item item = new Item("1", new StubAction(), itemsChild);
        Menu menu = new Menu(item);

        menu.add(parentItem1, item.getItems().get(0));
        menu.find(item.getName());
        menu.print(item);
    }

    private Item item;

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
        for (int i = 0; i < item.getItems().size(); i++) {
            System.out.printf("%d. %s%n", i, item.getName());
            print(item);
        }
    }
}

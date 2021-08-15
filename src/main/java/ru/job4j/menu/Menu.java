package ru.job4j.menu;

public class Menu implements Action {

    private Item item;

    @Override
    public void act() {

    }

    // добавляет потомка к предку. Служит чтоб сконструировать меню
    public void add(String parentName, Item child) {
        if (child.getItems().isEmpty() || (!child.getItems().contains(parentName))) {
            child.getItems().add(child);
        }
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
        return item.getItems().toString();
    }
}

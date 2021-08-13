package ru.job4j.menu;

public class Menu implements Action<Integer, String>{
    private PrintMenu printMenu;

    @Override
    public boolean add(Integer number, String item) {
        printMenu.print(number, item);
        return false;
    }

    @Override
    public boolean get(Integer number) {
        return false;
    }

    @Override
    public boolean delete(String item) {
        return false;
    }

    @Override
    public boolean update(String item) {
        return false;
    }
}

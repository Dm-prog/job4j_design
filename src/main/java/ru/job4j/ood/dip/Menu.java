package ru.job4j.ood.dip;

/**
 * Третий пример нарушения Dependency Inversion Principle.
 */
public class Menu {
    PrintMenu printMenu = new PrintMenu();
    public void save() {
        printMenu.print();
    }
}

package ru.job4j.ood.srp;
/*
Третий пример нарушения Single Responsibility Principle
 */

public class Invoice {
    public double calculateTotal() {
        return 0.0;
    }

    public void printInvoice() {
    }

    public void saveToFile(String filename) {
    }
}

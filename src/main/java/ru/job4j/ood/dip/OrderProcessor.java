package ru.job4j.ood.dip;

/**
 * Второй пример нарушения Dependency Inversion Principle.
 */
public class OrderProcessor {
    SaveProcessor saveProcessor = new SaveProcessor();
    public void process() {
        saveProcessor.save();
    }
}

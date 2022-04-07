package ru.job4j.ood.dip;


public class OrderProcessor {
    SaveProcessor saveProcessor = new SaveProcessor();
    public void process() {
        saveProcessor.save();
    }
}

package ru.job4j.parking;

public class Truck implements Vehicle {

    private int truckSize;

    @Override
    public int size() {
        return truckSize;
    }
}

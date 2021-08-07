package ru.job4j.parking;

public class Truck implements Vehicle {

    private int truckSize;

    public Truck(int truckSize) {
        this.truckSize = truckSize;
    }

    @Override
    public int size() {
        return truckSize;
    }
}

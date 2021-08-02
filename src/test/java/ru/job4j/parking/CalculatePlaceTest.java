package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculatePlaceTest {
    private Vehicle vehicle;
    private CalculatePlace calculatePlace;

    @Test
    public void whenTruckAdd() {
        int sizeTruck = vehicle.size(2);
        boolean truckAdd = calculatePlace.add(vehicle);
        assertThat(sizeTruck, is(truckAdd));
    }

    @Test
    public void whenCarAdd() {
        int sizeCar = vehicle.size(1);
        boolean carAdd = calculatePlace.add(vehicle);
        assertThat(sizeCar, is(carAdd));
    }
}
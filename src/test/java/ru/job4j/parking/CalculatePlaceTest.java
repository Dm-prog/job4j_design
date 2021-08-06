package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculatePlaceTest {
    private Vehicle vehicle;
    private Truck truck;
    private Car car;
    private CalculatePlace calculatePlace;

    @Test
    public void whenTruckIsParkedInPlacesForCar() {
        boolean add = calculatePlace.add(vehicle);
        assertThat(add, is(true));
    }
}
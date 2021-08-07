package ru.job4j.parking;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CalculatePlaceTest {

    @Test
    public void whenTruckIsParkedInPlacesForCar() {
        Truck truck = new Truck(2);
        CalculatePlace calculatePlace = new CalculatePlace(1, 10);
        assertThat(calculatePlace.add(truck), is(true));
    }

    @Test
    public void whenTruckIsParkedInPlacesForTruck() {
        Truck truck = new Truck(2);
        CalculatePlace calculatePlace = new CalculatePlace(10, 10);
        assertThat(calculatePlace.add(truck), is(true));
    }

    @Test
    public void whenNoParkingSpaceForTruck() {
        Truck truck = new Truck(3);
        CalculatePlace calculatePlace = new CalculatePlace(2, 2);
        assertThat(calculatePlace.add(truck), is(false));
    }
}
package ru.job4j.parking;

public class CalculatePlace implements Parking {

    private Car car;
    private Truck truck;
    private int truckPlaces;
    private int carPlaces;

    public int getTruckPlaces() {
        return truckPlaces;
    }

    public int getCarPlaces() {
        return carPlaces;
    }

    public void setTruckPlaces(int truckPlaces) {
        this.truckPlaces = truckPlaces;
    }

    public void setCarPlaces(int carPlaces) {
        this.carPlaces = carPlaces;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        while (carPlaces >= 1 && truckPlaces >= 1) {
            if (vehicle.size() == 1) {
                carPlaces--;
                return true;
            } else if (vehicle.size() > 1) {
                if (truckPlaces >= truck.size()) {
                    truckPlaces--;
                    return true;
                }
            } else {
                carPlaces -= truck.size();
                return true;
            }
        }
        return false;
    }
}


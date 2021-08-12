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

    public CalculatePlace(int truckPlaces, int carPlaces) {
        this.truckPlaces = truckPlaces;
        this.carPlaces = carPlaces;
    }

    @Override
    public boolean add(Vehicle vehicle) {
        while (carPlaces >= 1 && truckPlaces >= 1) {
            if (vehicle.size() == 1) {
                carPlaces--;
                return true;
            } else if (vehicle.size() > 1) {
                if (truckPlaces >= vehicle.size()) {
                    truckPlaces--;
                    return true;
                } else if (carPlaces >= vehicle.size()) {
                    carPlaces -= vehicle.size();
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}


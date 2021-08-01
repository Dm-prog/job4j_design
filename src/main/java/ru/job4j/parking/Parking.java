package ru.job4j.parking;

public class Parking {
    private int numberOfPlacesInRow;
    private int countOfRow;
    private int numberOfPlaces = countOfRow * numberOfPlacesInRow;
    private boolean freePlace;

    public int getNumberOfPlacesInRow() {
        return numberOfPlacesInRow;
    }

    public void setNumberOfPlacesInRow(int numberOfPlacesInRow) {
        this.numberOfPlacesInRow = numberOfPlacesInRow;
    }

    public int getCountOfRow() {
        return countOfRow;
    }

    public void setCountOfRow(int countOfRow) {
        this.countOfRow = countOfRow;
    }

    public int getNumberOfPlaces() {
        return numberOfPlaces;
    }

    public void setNumberOfPlaces(int numberOfPlaces) {
        this.numberOfPlaces = numberOfPlaces;
    }

    public boolean isFreePlace() {
        return freePlace;
    }

    public void setFreePlace(boolean freePlace) {
        this.freePlace = freePlace;
    }
}

package ru.job4j.io.serialization.json;

public class Passport {
    private final String passportDetails;

    public Passport(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    @Override
    public String toString() {
        return "Passport{"
                + "passportDetails='"
                + passportDetails
                + '\''
                + '}';
    }
}

package ru.job4j.io.serialization.xml;

public class Passport {
    private String passportDetails;

    public Passport(String passportDetails) {
        this.passportDetails = passportDetails;
    }

    public Passport() {
    }

    public String getPassportDetails() {
        return passportDetails;
    }

    public void setPassportDetails(String passportDetails) {
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

package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "bicycle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bicycle {

    @XmlAttribute
    private boolean sport;

    @XmlAttribute
    private int speed;

    private Passport passport;

    @XmlElementWrapper(name = "wheels")
    @XmlElement(name = "wheel")
    private String[] wheels;

    public Bicycle() {
    }

    public Bicycle(boolean sport, int speed, Passport passport, String... wheels) {
        this.sport = sport;
        this.speed = speed;
        this.passport = passport;
        this.wheels = wheels;
    }

    public boolean isSport() {
        return sport;
    }

    public void setSport(boolean sport) {
        this.sport = sport;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public String[] getWheels() {
        return wheels;
    }

    public void setWheels(String[] wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Bicycle{"
                + "sport="
                + sport
                + ", speed="
                + speed
                + ", passport="
                + passport
                + ", wheels="
                + Arrays.toString(wheels)
                + '}';
    }
}

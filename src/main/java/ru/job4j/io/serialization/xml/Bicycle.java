package ru.job4j.io.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "bicycle")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bicycle {

    @XmlAttribute
    private final boolean sport;

    @XmlAttribute
    private final int speed;

    private final Passport passport;

    @XmlElementWrapper(name = "wheels")
    @XmlElement(name = "wheel")
    private final String[] wheels;

    public Bicycle(boolean sport, int speed, Passport passport, String... wheels) {
        this.sport = sport;
        this.speed = speed;
        this.passport = passport;
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

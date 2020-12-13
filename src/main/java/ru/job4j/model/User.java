package ru.job4j.model;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2000,Calendar.JANUARY,15);

        User user1 = new User("Иван", 5, calendar);
        User user2 = new User("Иван", 5, calendar);

        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        System.out.println(map.size());

    }

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", children=" + children +
                ", birthday=" + birthday +
                '}';
    }
}

package ru.job4j.design.srp;

import java.util.List;
import java.util.function.Predicate;

public interface Report {
    String generate(Predicate<Employee> filter);
    List<Employee> sortSalary(List<Employee> employee);
    double convertRusToUsa(double salary);
}

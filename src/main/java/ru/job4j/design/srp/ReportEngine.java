package ru.job4j.design.srp;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;
import java.util.function.Predicate;

public class ReportEngine implements Report {

    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }

    public List<Employee> sortSalary(List<Employee> employee) {
        employee.sort(Comparator.comparing(Employee::getSalary).reversed());
        return employee;
    }

    public double convertRusToUsa(double salary) {
        final double currencyExchangeRate = 72.17;
        return salary / currencyExchangeRate;
    }
}

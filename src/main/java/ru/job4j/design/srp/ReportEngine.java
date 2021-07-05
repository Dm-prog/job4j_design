package ru.job4j.design.srp;

import java.util.Comparator;
import java.util.List;
import java.util.StringJoiner;
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

    public String parse(List<Employee> employees) {
        StringJoiner html = new StringJoiner(System.lineSeparator());

        html.add("<!DOCTYPE html>");
        html.add("<html>");
        html.add("<head>");
        html.add("<meta charset=\"UTF-8\">");
        html.add("<title>Employees</title>");
        html.add("</head>");
        html.add("<body>");

        html.add("<table>");
        html.add("<tr>");
        html.add("<th>Name</th>");
        html.add("<th>Hired</th>");
        html.add("<th>Fired</th>");
        html.add("<th>Salary</th>");
        html.add("</tr>");

        for (Employee employee : employees) {
            html.add("<tr>");
            html.add(String.format("<td>%s</td>", employee.getName()));
            html.add(String.format("<td>%s</td>", DateFormatter.format(employee.getHired())));
            html.add(String.format("<td>%s</td>", DateFormatter.format(employee.getFired())));
            html.add(String.format("<td>%s</td>", employee.getSalary()));
            html.add("</tr>");
        }

        html.add("</table>");
        html.add("</body>");
        html.add("</html>");

        return html.toString();
    }
}

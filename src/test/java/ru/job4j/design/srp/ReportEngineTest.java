package ru.job4j.design.srp;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ReportEngineTest {

    @Test
    public void whenOldGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportEngine(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }

    @Test
    public void whenProgrammingDepartment() {
        MemStore store = new MemStore();
        ReportEngine engine = new ReportEngine(store);
        Calendar now = Calendar.getInstance();
        Employee employee1 = new Employee("Boris", now, now, 200);
        Employee employee2 = new Employee("Alexandr", now, now, 200);
        Employee employee3 = new Employee("Oleg", now, now, 200);
        List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
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
        assertThat(engine.parse(employees), is(html.toString()));
    }

    @Test
    public void whenHRDepartment() {
        Store store = new MemStore();
        ReportEngine engine = new ReportEngine(store);
        Employee e1 = new Employee("Ivan", 150);
        Employee e2 = new Employee("Elena", 170);
        Employee e3 = new Employee("Boris", 160);

        List<Employee> employees = new ArrayList<>();
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        List<Employee> expected = engine.sortSalary(employees);
        assertThat(expected, is(Arrays.asList(e2, e3, e1)));
    }

    @Test
    public void whenAccountingDepartment() {
        Store store = new MemStore();
        ReportEngine engine = new ReportEngine(store);
        double expected = engine.convertRusToUsa(3608.5);
        assertThat(expected, is(50.0));
    }
}
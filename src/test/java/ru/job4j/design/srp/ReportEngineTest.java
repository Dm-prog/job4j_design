package ru.job4j.design.srp;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
        //assertThat();
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
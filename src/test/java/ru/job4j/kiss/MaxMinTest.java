package ru.job4j.kiss;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MaxMinTest {

    @Test
    public void max() {
        MaxMin maxMin = new MaxMin();
        List<String> list = Arrays.asList("A", "B", "C");
        String rsl = maxMin.max(list, String::compareTo);
        String expected = "C";
        assertThat(expected, is(rsl));
    }

    @Test
    public void min() {
        MaxMin maxMin = new MaxMin();
        List<Integer> list = Arrays.asList(10, 20, 30);
        Integer rsl = maxMin.min(list, Integer::compareTo);
        Integer expected = 10;
        assertThat(expected, is(rsl));
    }
}
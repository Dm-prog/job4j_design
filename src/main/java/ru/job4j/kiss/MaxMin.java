package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = i -> i < 0;
        return find(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate =  i -> i > 0;
        return find(value, comparator, predicate);
    }

    public <T> T find(List<T> value, Comparator<T> comparator,
                      Predicate<Integer> func) {
        T rezult = value.get(0);
        for (T val : value) {
            if (func.test(comparator.compare(rezult, val))) {
                rezult = val;
            }
        }
        return rezult;
    }
}
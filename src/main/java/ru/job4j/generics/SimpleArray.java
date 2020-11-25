package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    int[] values = new int[5];

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    public void add(T model) {
        for (int t : values) {
            if (Objects.checkIndex(t, values.length) == 0) {
                t = (int) model;
            }
        }
    }

    public void set(int index, T model) {
        for (int i = 0; i < values.length; i++) {
            if (Objects.checkIndex(values[i], values.length) == index) {
                values[i] = (int) model;
            }
        }
    }

    public void remove(int index) {
        int[] copyValue = new int[5];
        for (int i = 0; i < values.length; i++) {
            if (Objects.checkIndex(values[i], values.length) == index) {
                System.arraycopy(values, index, copyValue, 0, values.length);
            }
        }
    }

    public int get(int index) {
        return index;
    }
}


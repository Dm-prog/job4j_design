package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    Object[] values = new Object[5];
    Object[] copyValues = new Object[values.length - 1];

    @Override
    public Iterator<T> iterator() {
        for (int i = 0; i < values.length; i++) {

        }
        return null;
    }

    public void add(T model) {
        for (Object o : values) {
            if (o == null) {
                o = model;
            }
        }
    }

    public void set(int index, T model) {
        for (int i = 0; i < values.length; i++) {
            if (Objects.checkIndex(index, values.length) < values.length) {
                values[index] = model;
            }
        }
    }

    public void remove(int index) {
        for (int i = index; i < values.length; i++) {
            if (Objects.checkIndex(index, values.length) < values.length) {
                if (i == index) {
                    values[i] = null;
                    for (int k = i + 1; k < values.length; k++) {
                        values[k - 1] = values[k];
                    }
                    values[values.length - 1] = null;
                    break;
                }
            }
        }
        System.arraycopy(values, 0, copyValues, 0, values.length - 1);
        values = copyValues;
    }

    public int get(int index) {
        for (int i = 0; i < values.length; i++) {
            if (i == index) {
                return index;
            }
        }
        return 0;
    }
}


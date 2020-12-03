package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    Object[] values = new Object[5];
    int count = 0;

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    public void add(T model) {
        values[count++] = model;
    }

    public void set(int index, T model) {
        if (Objects.checkIndex(index, values.length) <= values.length) {
            values[index] = model;
        }
    }

    public void remove(int index) {
        Object[] copyValues = new Object[values.length - 1];
        if (Objects.checkIndex(index, values.length) <= values.length) {
            if (count == index) {
                values[count] = null;
                for (int k = count + 1; k < values.length; k++) {
                    values[k - 1] = values[k];
                }
                values[values.length - 1] = null;
            }
        }
        System.arraycopy(values, 0, copyValues, 0, values.length - 1);
        values = copyValues;
    }

    public int get(int index) {
        return index;
    }
}


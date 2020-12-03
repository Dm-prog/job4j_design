package ru.job4j.generics;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] values = new Object[5];
    private int count = 0;

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
        Objects.checkIndex(index, count);
        values[index] = model;

    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        System.arraycopy(values, index + 1, values, index, count - index);
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) values[index];
    }
}


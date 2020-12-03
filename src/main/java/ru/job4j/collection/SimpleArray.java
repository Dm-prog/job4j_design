package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private final Object[] container = new Object[10];
    private int modCount = 0;
    private int count = 0;

    public T get(int index) {
        if (Objects.checkIndex(index, count) <= container.length) {
            return (T) container[index];
        }
        return null;
    }

    public void add(T model) {
        container[count++] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        int expectedModCount = modCount;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                    if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException();
                    }
                return false;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return (T) container[modCount++];
            }
        };
    }
}

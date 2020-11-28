package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private static int modCount = 0;
    private static int expectedModCount = 0;
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
        for (int i = 0; i < container.length; i++) {
            expectedModCount++;
            if (modCount > container.length) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
        }
        return (Iterator<T>) Arrays.stream(container).iterator();
    }
}

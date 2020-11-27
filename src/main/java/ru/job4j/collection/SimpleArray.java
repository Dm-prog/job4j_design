package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private static int modCount = 0;
    private static int expectedModCount = 0;

    public T get(int index) {
        if (Objects.checkIndex(modCount, container.length) <= index) {
            return (T) container[index];
        }
        return null;
    }

    public void add(T model) {
        Object[] copyContainer = new Object[container.length + 1];
        container[modCount++] = model;
        if (container.length == modCount) {
            System.arraycopy(container, 0, copyContainer, 0, container.length);
            container = copyContainer;
        }
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

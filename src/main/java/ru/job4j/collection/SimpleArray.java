package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private static int modCount = 0;
    private static int expectedModCount = 0;

    public T get(int index) {
        if (Objects.checkIndex(index, container.length) == index) {
            return (T) container[index];
        }
        return null;
    }

    public void add(T model) {
        Object[] copyContainer = new Object[container.length + 1];
        System.arraycopy(container, 0, copyContainer, 0, container.length);
        copyContainer[container.length] = model;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        for (Iterator<T> it = (Iterator<T>) Arrays.stream(container).iterator(); it.hasNext(); ) {
            expectedModCount++;
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
        }
        if (expectedModCount != modCount) {
            throw new ConcurrentModificationException();
        }
        return (Iterator<T>) Arrays.stream(container).iterator();
    }
}

package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> simpleArray = new SimpleArray<>();

    public void add(E e) {
        simpleArray.add(e);

    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}

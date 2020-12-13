package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {
    private SimpleArray<E> simpleArray = new SimpleArray<>();

    public void add(E e) {
        if (!contains(e)) {
            simpleArray.add(e);
        }
    }

    public boolean contains(E value) {
        boolean rsl = false;
        for (E e : simpleArray) {
            if (value.equals(e)) {
                rsl = true;
                break;
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        return simpleArray.iterator();
    }
}

package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class Conteiner<E> implements Iterable<E> {
    private Node<E> node;
    private int modCount;
    private int size;

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            final int expectedModCount = modCount;
            int position;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return position < size;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = node.value;
                node = node.next;
                position++;
                return value;
            }
        };
    }

    private static class Node<E> {
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(E value) {
        Node<E> node = new Node<E>(value, null);
        if (this.node == null) {
            this.node = node;
            size++;
            return;
        }
        Node<E> tail = this.node;
        while (tail.next != null) {
            tail = tail.next;
            size--;
        }
        tail.next = node;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        int count = 0;
        Node<E> find = this.node;
        while (count < size) {
            find = find.next;
            count++;
        }
        return find.value;
    }
}

package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        } else {
            Node<T> oldFirst = this.head;
            this.head = this.head.next;
            oldFirst.next = null;
            return oldFirst.value;
        }
    }

    public T deleteLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            T value = head.value;
            head = null;
            return value;
        }
        Node<T> prev = head;
        Node<T> current = head.next;
        while (current.next != null) {
            prev = current;
            current = current.next;
        }
        T value = prev.next.value;
        prev.next = null;

        return value;
    }

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
    }

    public void revert() {
        if (head == null || head.next == null) {
            return;
        }
        Node<T> first = head;
        Node<T> next = head.next;
        Node<T> prev;

        while (next != null) {
            prev = head;
            head = next;
            next = next.next;
            head.next = prev;
        }
        first.next = null;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        T value;
        Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}

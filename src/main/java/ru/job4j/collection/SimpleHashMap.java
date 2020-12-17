package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterator<K> {
    private final Map<K, V> map = new HashMap<>();
    private final Iterator<K> cursor = Collections.emptyIterator();
    private Node<K, V>[] storage;
    private int count = 0; // количество элементов в мапе
    private static final float LOAD_FACTOR = 0.75f;

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    //Создать хэш функцию, которая принимает ключ типа K и возвращает key.hashCode() & storage.length
    public int hashFunction(K key) {
        return key.hashCode() & storage.length;
    }

    @Override
    public boolean hasNext() {
        for (K key : map.keySet()) {
            if (key != null) {
                return true;
            }
        }
        return false;
    }

    @Override
    public K next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return cursor.next();
    }

    public boolean insert(K key, V value) {
        if (storage.length * 0.75 > 12) {
            storage = Arrays.copyOf(storage, storage.length * 2);
        }
        return true;
    }

    public V get(K key) {
        return null;
    }

    public static class Node<K, V> {
        private K key;
        private V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }
    }
}

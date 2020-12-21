package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> implements Iterable<K> {
    private Node<K, V>[] storage = new Node[16];
    private int count = 0;
    private int modCount;
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

    private int hashFunction(K key) {
        return key.hashCode() % storage.length;
    }

    public boolean insert(K key, V value) {
        if (count >= ((int) LOAD_FACTOR * storage.length)) {
            grow();
        }
        int hash = hashFunction(key); // получаем позицию в таблице
        boolean result = false; // пока мы не вставили результат false
        if (storage[hash] == null) { // проверяем занято ли место
            // место свободно
            storage[hash] = new Node<>(key, value); // делаем вставку
            count++; // число элементов увеличилось
            modCount++; // коллекцию мы изменили, а значит число модификаций увеличилось
            result = true; // нам удалось вставить
        }
        return result;
    }

    public V get(K key) {
        int index = hashFunction(key);
        if (storage[index] == null || !storage[index].getKey().equals(key)) {
            return null;
        }
        return storage[index].getValue();
    }

    public boolean delete(K key) {
        int index = hashFunction(key);
        if (storage[index] == null || !storage[index].getKey().equals(key)) {
            return false;
        }
        storage[index] = null;
        count--;
        modCount++;
        return true;
    }

    public Node<K, V>[] grow() {
        Node<K, V>[] newTable = new Node[storage.length * 2];
        storage = newTable;
        return storage;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                for (int i = point; i < storage.length; i++) {
                    if (storage[i] != null) {
                        point = i;
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
                return storage[point++].getKey();
            }
        };
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

        public V getValue() {
            return value;
        }
    }
}

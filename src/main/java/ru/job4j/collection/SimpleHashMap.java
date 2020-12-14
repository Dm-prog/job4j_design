package ru.job4j.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimpleHashMap<K, V> implements Iterator<K> {
    Map<K, V> map = new HashMap<>();

    public static String binary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append(num % 2 == 0 ? 0 : 1);
            sb.append((i + 1) % 8 == 0 ? " " : "");
            num /= 2;
        }
        return sb.reverse().toString();
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public K next() {
        return null;
    }

    public boolean insert(K key, V value) {
        return true;
    }

    public V get(K key) {
        return null;
    }
}

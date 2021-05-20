package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {

    }

    public V get(K key) {
        SoftReference<V> file = cache.get(key);
        if (file == null || file.get() == null) {
            return load(key);
        }
        V rsl = file.get();
        if (rsl == null) {
            rsl = load(key);
        }
        return rsl;
    }

    protected abstract V load(K key);

}
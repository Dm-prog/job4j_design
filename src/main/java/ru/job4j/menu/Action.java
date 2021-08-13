package ru.job4j.menu;

public interface Action<K, V> {
    boolean add(K number, V item);
    boolean get(K number);
    boolean delete(V item);
    boolean update(V item);
}

package com.company;

public interface ISHM<K, V> {
    Object get(K key);
    void put(K key, V val);
    void remove(K key);
}

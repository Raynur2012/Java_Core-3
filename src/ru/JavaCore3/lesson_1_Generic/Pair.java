package ru.JavaCore3.lesson_1_Generic;

public class Pair<K,V> {//класс содержащий ключ и значение, связанные пары значений. Их может быть больше
    private K key;
    private V value;

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

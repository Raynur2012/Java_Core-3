package ru.JavaCore3.lesson_1_Generic;

public class Container<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public Container(T obj) {
        this.obj = obj;
    }
}

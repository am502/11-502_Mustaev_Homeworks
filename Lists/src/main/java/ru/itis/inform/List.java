package ru.itis.inform;

public interface List<T> {
    void add(T element);
    void remove(T element);
    void show();
    Iterator<T> iterator();
    void append(LinkedList<T> list);
}
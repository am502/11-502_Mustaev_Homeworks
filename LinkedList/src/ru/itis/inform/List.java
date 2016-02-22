package ru.itis.inform;

public interface List<T> {
    void add(T element);
    void remove(T element);
    Iterator<T> iterator();
}
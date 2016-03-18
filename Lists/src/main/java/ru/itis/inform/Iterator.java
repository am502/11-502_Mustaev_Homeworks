package ru.itis.inform;

public interface Iterator<T> {
    boolean hasNext();
    boolean hasPrevious();
    T next();
    T previous();
    T peekNext();
    T peekPrevious();
    void insert(T element);
}
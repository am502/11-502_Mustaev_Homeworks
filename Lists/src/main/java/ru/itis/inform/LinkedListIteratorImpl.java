package ru.itis.inform;

class LinkedListIteratorImpl<T> implements Iterator<T> {

    Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

    public T previous() {
        return current.getPrevious().getValue();
    }

    public void insert(T element) {
        Node<T> newNode = new Node(element);
        newNode.setNext(current);
        this.current.getPrevious().setNext(newNode);
        this.current.setPrevious(newNode);
    }
    public T peekNext() {
        return current.getNext().getValue();
    }

    public T peekPrevious() {
        return current.getPrevious().getValue();
    }
}
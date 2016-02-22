package ru.itis.inform;

class LinkedListIteratorImpl<T> implements Iterator<T> {

    Node<T> current;

    public LinkedListIteratorImpl(Node<T> first) {
        this.current = first;
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public T next() {
        T value = current.getValue();
        current = current.getNext();
        return value;
    }

    @Override
    public T previous() {
        return current.getPrevious().getValue();
    }

    @Override
    public void insert(T element) {
        Node<T> newNode = new <T>Node(element);
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
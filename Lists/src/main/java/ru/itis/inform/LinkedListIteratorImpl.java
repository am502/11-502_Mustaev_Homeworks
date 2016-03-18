package ru.itis.inform;

public class LinkedListIteratorImpl<T> implements Iterator<T> {

    private Node<T> current;

    public LinkedListIteratorImpl(Node<T> head) {
        this.current = head;
    }

    public Node<T> getCurrentNode() {
        return current;
    }

    public boolean hasNext() {
        return current != null;
    }

    public T peekNext() {
        return current.getData();
    }

    public boolean hasPrevious() {
        return this.current.getPrevious() != null;
    }

    public T peekPrevious() {
        return current.getPrevious().getData();
    }

    public T next() {
        T value = current.getData();
        Node<T> f = current;
        this.current = f.getNext();
        return value;
    }

    public T previous() {
        if (current.getPrevious() != null) {
            Node<T> f = this.current;
            T value = f.getPrevious().getData();
            this.current = f.getPrevious();
            return value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public void insert(T element) {
        Node<T> f = this.current;
        Node<T> insertNode = new Node<T>(element);

        insertNode.setPrevious(f.getPrevious());
        insertNode.setNext(f);
        f.getPrevious().setNext(insertNode);
        f.setPrevious(insertNode);

        current = f.getPrevious();
    }
}
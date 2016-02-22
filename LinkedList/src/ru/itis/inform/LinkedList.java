package ru.itis.inform;

public class LinkedList<T> implements List<T> {
    private Node<T> first;

    private int count;

    public LinkedList() {
        this.first = null;
        this.count = 0;
    }

    public void add(T element) {
        Node newNode = new Node<T>(element);
        newNode.setPrevious(null);
        if (first == null) {
            this.first = newNode;
        } else {
            newNode.setNext(first);
            first.setPrevious(newNode);
            this.first = newNode;
        }
        this.count++;
    }
    public void remove(T element) {
        Node node = first;
        for (int i = 0; i < count ; i++) {
            if (i == 0 && node.getValue() == element) {
                this.first = node.getNext();
                return;
            }
            if (node.getNext().getValue() == element) {
                if (i == 0) {
                    first = node;
                    return;
                } else if (i == count - 1) {
                    node.setNext(null);
                    return;
                } else {
                    node.setNext(node.getNext().getNext());
                    return;
                }
            }
            node = node.getNext();
        }
        this.count--;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIteratorImpl<T>(this.first);
    }

    public void show() {
        Node node = first;
        while (node.getNext() != null) {
            System.out.print(node.getValue() + ", ");
            node = node.getNext();
        }
        System.out.print(node.getValue());
    }
}
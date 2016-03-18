package ru.itis.inform;

public class Node<T> {
    Node<T> next;
    Node<T> previous;
    T data;

    public Node(T element){
        this.data = element;
    }

    public T getData(){
        return data;
    }

    public Node<T> getNext(){
        return next;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Node<T> getPrevious() {
        return previous;
    }
}
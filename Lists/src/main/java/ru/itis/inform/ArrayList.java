package ru.itis.inform;

public class ArrayList<T> {

    private Object elements[];

    private int count = 0;
    public ArrayList(int length) {
        elements = new Object[length];
    }

    public void add(T element) {
        this.elements[count] = element;
        count++;
    }

    public int getCount(){
        return count;
    }

    public T get(int index) {
        if (index > elements.length|| index < 0)
            throw new IndexOutOfBoundsException();
        else return (T) elements[index];
    }

    public void set(int index, T element){
        this.elements[index] = element;
    }


    public LinkedList toLinkedList() {
        LinkedList result = new LinkedList();
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                LinkedList element;

                if(elements[i] instanceof LinkedList) {
                    element = (LinkedList) elements[i];
                } else {
                    element = new LinkedList();
                    element.add(elements[i]);
                }

                if (result.getHead() == null) {
                    result = element;
                } else {
                    result.append(element);
                }
            }
        }
        return result;
    }
}
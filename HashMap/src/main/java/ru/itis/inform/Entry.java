package ru.itis.inform;

public class Entry {
    private String key;
    private int value;
    private int hash;
    private Entry next;

    public Entry(String key, int value){
        this.key = key;
        this.value = value;
        this.hash = key.hashCode();
    }

    public Entry getNext(){
        return next;
    }

    public void setNext(Entry next){
        this.next = next;
    }

    public String getKey(){
        return key;
    }

    public int getValue(){
        return value;
    }
}
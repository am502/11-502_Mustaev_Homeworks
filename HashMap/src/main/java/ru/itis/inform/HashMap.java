package ru.itis.inform;

public class HashMap {
    private static final double LOAD_FACTOR = 0.75;
    private static final int DEFAULT_SIZE = 16;
    private int size;
    private Entry[] entry;
    private int count;

    public HashMap() {
        init(DEFAULT_SIZE);
    }

    public HashMap(int size) {
        init(size);
    }

    private void init(int size) {
        this.entry = new Entry[size];
        this.size = size;
    }

    private int index(int h){
        return h & (size - 1);
    }

    public void put(String key, int value) {
        int index = index(key.hashCode());
        Entry en = new Entry(key, value);

        if (entry[index] == null) {
            entry[index] = en;
            count++;
        }
        else {
            en.setNext(entry[index]);
            entry[index] = en;
            count++;
        }

        if(count >= threshold()){
            resize(2 * size);
        }
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            Entry en = entry[i];
            if(en == null)
                System.out.println("--");
            else{
                while (en != null) {
                    System.out.print(en.getKey() + " ");
                    en = en.getNext();
                }
                System.out.println();
            }
        }
    }

    private int threshold(){
        double a = LOAD_FACTOR * size;
        return (int) a;
    }

    private void resize(int newSize) {
        Entry[] newTable = entry;
        this.size = newSize;
        this.count = 0;
        entry = new Entry[newSize];
        for (int i = 0; i < newTable.length; i++) {
            Entry en = newTable[i];
            while (en != null) {
                put(en.getKey(), en.getValue());
                en = en.getNext();
            }
        }
    }

    public int get(String key){
        Entry en = entry[index(key.hashCode())];
        while(en.getKey() != key){
            en = en.getNext();
        }
        return en.getValue();
    }
}

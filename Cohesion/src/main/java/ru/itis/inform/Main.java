package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        Sets s = new SetsArrayImpl(4);

        s.add(0, 1);
        s.add(1, 2);
        s.add(1, 3);
        s.add(3, 4);
        s.add(0, 3);

        s.show();
    }
}
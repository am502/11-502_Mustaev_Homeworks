package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        Sets s = new SetsArrayImpl(11);

        s.add(3, 4);
        s.add(4, 9);
        s.add(8, 0);
        s.add(2, 3);
        s.add(5, 6);
        s.add(2, 9);
        s.add(5, 9);
        s.add(7, 3);
        s.add(4, 8);
        s.add(5, 6);
        s.add(0, 2);
        s.add(6, 1);

        s.show();
    }
}

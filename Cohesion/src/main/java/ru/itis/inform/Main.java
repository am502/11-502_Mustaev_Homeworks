package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        Sets s1 = new SetsArrayImpl(11);

        s1.add(3, 4);
        s1.add(4, 9);
        s1.add(8, 0);
        s1.add(2, 3);
        s1.add(5, 6);
        s1.add(2, 9);
        s1.add(5, 9);
        s1.add(7, 3);
        s1.add(4, 8);
        s1.add(5, 6);
        s1.add(0, 2);
        s1.add(6, 1);

        s1.show();

        System.out.println();

        int n = 11;

        SetArrayWithLinksImpl s2 = new SetArrayWithLinksImpl(n);

        s2.union(3, 4);
        s2.union(4, 9);
        s2.union(8, 0);
        s2.union(2, 3);
        s2.union(5, 6);
        s2.union(2, 9);
        s2.union(5, 9);
        s2.union(7, 3);
        s2.union(4, 8);
        s2.union(5, 6);
        s2.union(0, 2);
        s2.union(6, 1);

        for (int i = 0; i <= n; i++) {
            System.out.println(s2.find(i));
        }

        s2.showSet();
    }
}

package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();

        int array[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.show();

//        System.out.println(tree.sumator());
    }
}

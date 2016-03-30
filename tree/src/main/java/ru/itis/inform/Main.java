package ru.itis.inform;

import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        BinarySearchTreeImpl tree = new BinarySearchTreeImpl();

        int array[] = {8, 10, 14, 1, 13, 6, 4, 7, 3};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }

        tree.show();

        System.out.println(tree.isBinarySearchTree());

        System.out.println(tree.sumator());

        System.out.println("\n"+"-------------"+"\n");

        tree.change();

        tree.show();

        System.out.println(tree.isBinarySearchTree());

        System.out.println(tree.sumator());
    }
}

package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        RBtree tree = new RBtree();
        RBtree tree1 = new RBtree();

        int array[] = {1, 2, 3 ,4 ,5 ,6 ,7  ,8 , 9, 10};
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i], 0);
            tree1.insertNotRB(array[i], 0);
        }

        tree1.show();
        System.out.println("RB:");
        tree.show();
    }
}
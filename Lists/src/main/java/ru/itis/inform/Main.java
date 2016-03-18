package ru.itis.inform;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> list1 = new LinkedList<Integer>();

        list1.add(5);
        list1.add(29);
        list1.add(4);
        list1.add(5);

        list1 = LinkedList.mergeSort(list1);

        list1.show();

        System.out.println();

        LinkedList<Integer> list2 = new LinkedList<Integer>();

        list2.add(25);
        list2.add(90);
        list2.add(500);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(-3);

        list2 = LinkedList.mergeSort(list2);

        list2.show();

        System.out.println();

        LinkedList<Integer> result = LinkedList.merge(list1, list2);

        result.show();
    }
}

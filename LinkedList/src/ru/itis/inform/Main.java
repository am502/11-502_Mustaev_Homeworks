package ru.itis.inform;

public class Main {
    public static void main(String[] args){
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(5);
        list.add(10);
        list.add(18);
        list.add(16);
        list.add(999);

        list.show();

        System.out.println();

        list.remove(10);
        list.remove(16);
        list.remove(18);

        list.show();

        System.out.println();

        Iterator<Integer> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
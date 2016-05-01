package ru.itis.inform;

public class Main {
    public static void main(String[] args) {
        HashMap hm = new HashMap();

        hm.put("d", 1);
        hm.put("abcd", 2);
        hm.put("zxxcc", 3);
        hm.put("jjj", 4);
        hm.put("koll", 5);
        hm.put("231231sdfsf", 6);
        hm.put("dfggggggg", 7);
        hm.put("hhhjj", 8);
        hm.put("mjkl", 9);
        hm.put("bbbbb", 10);
        hm.put("acvv", 11);

        hm.show();

        System.out.println("=========================================");

        hm.put("acv", 12);

        hm.show();

        System.out.println(hm.get("hhhjj"));
    }
}

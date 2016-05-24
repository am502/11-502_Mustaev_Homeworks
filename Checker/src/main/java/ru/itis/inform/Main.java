package ru.itis.inform;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.next();
        Checker c = new Checker();
        System.out.println(c.check(s));
    }
}

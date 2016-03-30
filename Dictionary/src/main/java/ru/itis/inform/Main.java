package ru.itis.inform;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Dictionary d = new Dictionary("Dictionary");

        System.out.println("Dictionary: " + "( numLen1 = " + d.numLen1() + " )");

        d.show();

        System.out.println("\n" + "Unique: ");

        d.showUnique();

        System.out.println("\n" + "Ready dictionary: ");

        d.delete("sobaka");

        d.delete("kot");

        d.show();

        d.insert("chelovek", "human");

        String g = "ya bistriy i dobriy chelovek";

        System.out.println("\n" + "Translated text: " + "\n" + d.translate(g));

    }
}

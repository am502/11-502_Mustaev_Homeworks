package ru.itis.inform;

import java.io.*;
import java.util.*;

public class Reader {

    public LinkedList<Pair> reader(String filename) throws FileNotFoundException {
        LinkedList<Pair> list = new LinkedList<Pair>();

        Scanner scn = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\Dictionary\\src\\\\Input\\" + filename + ".txt"));

        while(scn.hasNext()){

            String k = scn.next();
            String v = scn.next();

            list.add(new Pair(k, v));
        }

        scn.close();

        return list;
    }
}

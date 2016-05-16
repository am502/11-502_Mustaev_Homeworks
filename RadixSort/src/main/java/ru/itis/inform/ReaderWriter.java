package ru.itis.inform;

import java.io.*;
import java.util.*;

public class ReaderWriter {
    public void write() throws IOException {
        Random rand = new Random();
        int k = 100;

        for (int i = 1; i <= 20; i++) {
            File file = new File("C:\\Users\\HP\\IdeaProjects\\RadixSort\\src\\input\\input" + i + ".txt");
            file.createNewFile();

            PrintWriter pw = new PrintWriter(file);

            for (int j = 0; j < k; j++)
                pw.print(rand.nextInt(1000) + " ");

            k += 100;
            pw.close();
        }
    }

    public void clear() throws  IOException{
        for (int i = 1; i <= 20; i++) {
            File file = new File("C:\\Users\\HP\\IdeaProjects\\RadixSort\\src\\input\\input" + i + ".txt");
            file.delete();
        }
    }

    public int[] read(int []a, int i) throws FileNotFoundException {
        Scanner scn = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\RadixSort\\src\\input\\input" + i + ".txt"));

        int k = 0;

        while(scn.hasNext()) {
            a[k] = scn.nextInt();
            k++;
        }

        scn.close();

        return a;
    }
}

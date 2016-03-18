package ru.itis.inform;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException{
        HumansReaderWriter read = new HumansReaderWriter();

        LinkedList<Human> list = read.readHumans();

        LexSorter sorter = new LexSorter();

        LinkedList<Human> result = sorter.LexSort(list);

        read.writeHumans(result);
    }
}

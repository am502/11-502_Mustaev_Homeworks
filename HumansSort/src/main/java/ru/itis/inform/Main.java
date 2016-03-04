package ru.itis.inform;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        HumansReaderWriter read = new HumansReaderWriter();

        LinkedList<Human> list = read.readHumans();

        HumanSorter sorter = new HumanSorter();

        LinkedList<Human> result = sorter.sort(list);


        read.writeHumans(result);
    }
}

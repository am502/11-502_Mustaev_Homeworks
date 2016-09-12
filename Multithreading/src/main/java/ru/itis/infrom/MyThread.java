package ru.itis.infrom;

import ru.itis.inform.*;
import java.io.*;

public class MyThread implements Runnable {
    private int name;
    public void setName(int name){
        this.name = name;
    }

    public void run(){
        HumansReaderWriter read = new HumansReaderWriter();
        HumanSorter sorter = new HumanSorter();

        try {
            LinkedList<Human> list1 = read.readHumans("Human" + name);
            LinkedList<Human> result1 = sorter.sort(list1);
            read.writeHumans(result1, "HumanSorted" + name);
        }
        catch (IOException e){
            System.out.println("Not found");
        }
    }
}

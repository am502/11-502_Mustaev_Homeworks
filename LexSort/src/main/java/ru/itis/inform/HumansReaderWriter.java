package ru.itis.inform;

import java.io.*;
import java.util.Scanner;

public class HumansReaderWriter {
    Scanner scn;
    public LinkedList<Human> readHumans() throws FileNotFoundException {
        LinkedList<Human> humans = new LinkedList<Human>();
        scn = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\LexSort\\src\\Human.txt"));

        while(scn.hasNext()){
            String name = scn.nextLine();
            Human h = new Human(name);
            humans.add(h);
        }
        scn.close();
        return humans;
    }

    public void writeHumans(LinkedList human) throws FileNotFoundException{
        PrintWriter scn = new PrintWriter(new File("C:\\Users\\HP\\IdeaProjects\\LexSort\\src\\HumanSorted.txt"));
        Iterator iter = human.iterator();

        while(iter.hasNext()){
            scn.println(iter.peekNext().toString()+ " ");
            iter.next();
        }
        scn.close();
    }
}

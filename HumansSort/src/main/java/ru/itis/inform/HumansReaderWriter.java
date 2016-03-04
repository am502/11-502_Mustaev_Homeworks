package ru.itis.inform;

import java.io.*;

import java.util.Scanner;

import javax.swing.*;

public class HumansReaderWriter {
    Scanner scn;
    public LinkedList<Human> readHumans() throws FileNotFoundException {
        LinkedList<Human> humans = new LinkedList<Human>();
        scn = new Scanner(new File("C:\\Users\\HP\\IdeaProjects\\HumansSort\\src\\Humans.txt"));

        while(scn.hasNext()){
            int age = scn.nextInt();
            String name = scn.nextLine();
            Human h = new Human(age, name);
        }
        scn.close();
        return humans;
    }
    public void writeHumans(LinkedList<Human> human) throws FileNotFoundException {
        PrintWriter scn = new PrintWriter(new File("C:\\Users\\HP\\IdeaProjects\\HumansSort\\src\\HumansSort\\src\\HumansSorted.txt"));
        Iterator<Human> iter = human.iterator();
        while (iter.hasNext()) {
            scn.println(iter.peekNext()+" ");
            iter.next();
        }
        scn.close();
    }
}
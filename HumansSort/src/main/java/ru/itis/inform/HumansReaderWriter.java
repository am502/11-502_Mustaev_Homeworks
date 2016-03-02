package ru.itis.inform;

import java.io.*;

import java.util.LinkedList;

import java.util.Scanner;

import Lists.*;

import javax.swing.*;

public class HumansReaderWriter {
    Scanner scn;
    public LinkedList<Human> readHumans(String fileName) {
        LinkedList<Human> humans = new LinkedList<Human>();

        try{
            scn = new Scanner(new File("C:\\Users\\Артур\\IdeaProjects\\HumansSort\\src\\Humans.txt");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "File not found");
        }

        while(scn.hasNext()){
            int age = scn.nextInt();
            String name = scn.nextLine();
            Human h = new Human(age, name);
        }
        scn.close();

        return humans;
    }
    public void writeHumans(String fileName, LinkedList<Human> humanLinkedList) throws FileNotFoundException {
        PrintWriter p = new PrintWriter(new File("C:\\Users\\Артур\\IdeaProjects\\HumansSort\\src\\HumansSorted.txt"));
        Iterator<Human> iter = humanLinkedList.iterator();
        while (iter.hasNext()) {
            p.println(iter.peekNext().toString() + " ");
            iter.next();
        }
        p.close();
    }
}
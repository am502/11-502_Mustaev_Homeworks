package ru.itis.inform;

import java.io.*;
import java.util.*;

public class Dictionary {
    public LinkedList<Pair> list = new LinkedList<Pair>();

    Reader read = new Reader();

    public Dictionary(String filename) throws FileNotFoundException {
        list = read.reader(filename);
    }

    public void show(){
        Iterator<Pair> it = list.iterator();
        while(it.hasNext())
            System.out.println(it.next().toString());
    }

    public void insert(String k, String v){
        list.add(new Pair(k, v));
    }

    public void delete(String k){
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getK().equals(k)) {
                list.remove(i);
                i = 0;
            }
        }
    }

    public Set unique(){
        LinkedList<Pair> list1 = new LinkedList<Pair>();
        for(int i = 0; i < list.size(); i++)
            list1.add(list.get(i));

        for(int i = 0; i < list1.size(); i++){
            for(int j = i + 1; j < list1.size(); j++){
                if(list1.get(j).getK().equals(list1.get(i).getK())){
                    list1.remove(j);
                    j = i;
                }
            }
        }

        HashSet<Pair> set = new HashSet<Pair>(list1);
        return set;
    }

    public void showUnique(){
        Iterator<Pair> it = unique().iterator();
        while(it.hasNext())
            System.out.println(it.next().toString());
    }

    public int numLen1(){
        int num = 0;
        for(int i = 0; i < list.size(); i++){
            if(Math.abs(list.get(i).getK().length() - list.get(i).getV().length()) <= 1)
                num++;
        }

        return num;
    }

    public String translate(String text){
        char[] scn = text.toCharArray();
        String sum = "";
        String check = "";

        for(int i = 0; i < scn.length; i++){
            if(scn[i] == ' '){
                check = translateWord(check);
                sum += check + " ";
                check = "";
                if(i != scn.length - 1)
                    i++;
            }

            if(i == scn.length - 1) {
                check += scn[i];
                check = translateWord(check);
                sum += check + " ";
            }

            check += scn[i];
        }

        return sum;
    }

    public String translateWord(String k){
        String v = k;

        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getK().equals(k))
                v = list.get(i).getV();
        }

        return v;
    }
}

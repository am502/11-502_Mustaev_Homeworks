package ru.itis.inform;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Point> arrayOfPoints = new ArrayList<Point>();

        arrayOfPoints.add(new Point(-1, 0));
        arrayOfPoints.add(new Point(12, 4));
        arrayOfPoints.add(new Point(3, 6));
        arrayOfPoints.add(new Point(4, 1));
        arrayOfPoints.add(new Point(5, -2));
        arrayOfPoints.add(new Point(8, 0));
        arrayOfPoints.add(new Point(6, 6));
        arrayOfPoints.add(new Point(7, -2));
        arrayOfPoints.add(new Point(5, -6));
        arrayOfPoints.add(new Point(7, 5));
        arrayOfPoints.add(new Point(1, 5));
        arrayOfPoints.add(new Point(0, 4));

        QuickHull p = new QuickHull();

        ArrayList<Point> a = p.QuickHull(arrayOfPoints);

        for(int i = 0; i < a.size(); i++){
            System.out.println(a.get(i).toString());
        }
    }
}
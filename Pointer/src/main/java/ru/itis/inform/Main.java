package ru.itis.inform;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ArrayList<Point> arrayOfPoints = new ArrayList<Point>();

        arrayOfPoints.add(new Point(0, 0));
        arrayOfPoints.add(new Point(1, 3));
        arrayOfPoints.add(new Point(2, 6));
        arrayOfPoints.add(new Point(4, 1));
        arrayOfPoints.add(new Point(5, -2));
        arrayOfPoints.add(new Point(8, 0));
        arrayOfPoints.add(new Point(6, 7));
        arrayOfPoints.add(new Point(7, -2));

//        Sort convexHull = new Sort();
//
//        ArrayList<Point> nop = convexHull.ConvexHull(arrayOfPoints);

        Fast_Hull fast = new Fast_Hull();

        ArrayList<Point> nop = fast.Fast_Hull(arrayOfPoints);

        for(int i = 0; i < nop.size(); i++){
            System.out.println(nop.get(i).toString());
        }
    }
}

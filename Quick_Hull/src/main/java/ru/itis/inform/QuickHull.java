package ru.itis.inform;

import java.util.ArrayList;

public class QuickHull {
    public ArrayList<Point> QuickHull(ArrayList<Point> array){
        int indexOfLeft = find_left(array);
        int indexOfRight = find_right(array);

        Point left = array.get(indexOfLeft);
        Point right = array.get(indexOfRight);

        array.remove(left);
        array.remove(right);

        ArrayList<Point> S1 = S1(array, left, right);
        ArrayList<Point> S2 = S2(array, left, right);

        ArrayList<Point> result = new ArrayList<Point>();

        result.add(left);

        QuickHullAlg(S1, left, right, result);

        result.add(right);

        QuickHullAlg(S2, right, left, result);

        return result;
    }

    public int find_left(ArrayList<Point> array){
        Point left = array.get(0);

        int min = array.get(0).getX();

        int indexoOfLeft = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() < min) {
                min = array.get(i).getX();
                left = array.get(i);
                indexoOfLeft = i;
            }
        }

        return indexoOfLeft;
    }

    public int find_right(ArrayList<Point> array){
        Point right = array.get(0);

        int max = array.get(0).getX();

        int indexoOfRight = 0;

        for(int i = 0; i < array.size(); i++) {
            if (array.get(i).getX() > max) {
                max = array.get(i).getX();
                right = array.get(i);
                indexoOfRight = i;
            }
        }

        return indexoOfRight;
    }

    public int separator(Point left, Point p, Point right){
        int l = right.x - left.x;
        int m = right.y - left.y;

        int result = p.x * m - left.x * m - ( p.y * l - left.y * l);

        return result;
    }

    public double square(Point left, Point current, Point right){
        return Math.abs(0.5*((left.x - right.x)*(current.y - right.y) - (current.x - right.x)*(left.y - right.y)));
    }

    public int triangle_belong(Point p1, Point p2, Point p3, Point p) {
        int check = -1;

        double sign1 = (p1.x - p.x) * (p2.y - p1.y) - (p2.x - p1.x) * (p1.y - p.y);
        double sign2 = (p2.x - p.x) * (p3.y - p2.y) - (p3.x - p2.x) * (p2.y - p.y);
        double sign3 = (p3.x - p.x) * (p1.y - p3.y) - (p1.x - p3.x) * (p3.y - p.y);

        if(sign1 > 0 && sign2 > 0 && sign3 > 0 || sign1 < 0 && sign2 < 0 && sign3 < 0)
            check = 1;
        else if(sign1 == 0 || sign2 == 0 || sign3 == 0)
            check = 0;

        return check;

        // if 1 then inside, if 0 then on a side, if -1 not belongs
    }

    public ArrayList<Point> S1(ArrayList<Point> array, Point left, Point right){
        ArrayList<Point> S1 = new ArrayList<Point>();

        for(int i = 0; i < array.size(); i++){
            if(separator(left, array.get(i), right) < 0)
                S1.add(array.get(i));
        }

        return S1;
    }

    public ArrayList<Point> S2(ArrayList<Point> array, Point left, Point right){
        ArrayList<Point> S2 = new ArrayList<Point>();

        for(int i = 0; i < array.size(); i++){
            if(separator(left, array.get(i), right) > 0)
                S2.add(array.get(i));
        }

        return S2;
    }

    public void QuickHullAlg(ArrayList<Point> S, Point left, Point right, ArrayList<Point> result){

        if(S.size() == 0)
            return;

        double max_square = square(left, S.get(0), right);

        Point current = S.get(0);

        int indexOfMax = 0;

        for(int i = 0; i < S.size(); i++) {
            if (square(left, S.get(i), right) > max_square) {
                max_square = square(left, S.get(i), right);
                current = S.get(i);
                indexOfMax = i;
            }
//            else if (square(left, S.get(i), right) == max_square/* && S.get(i).x < current.x*/) {
//                max_square = square(left, S.get(i), right);
//                current = S.get(i);
//                indexOfMax = i;
//            }
        }

        Point top = S.get(indexOfMax);

        for(int i = 0; i < S.size(); i++){
            if(triangle_belong(left, right, current, S.get(i)) >= 0)
                S.remove(i);
        }

        ArrayList<Point> S1 = S1(S, left, top);

        ArrayList<Point> S2 = S2(S, right, top);

        QuickHullAlg(S1, left, right, result);

        result.add(top);

        QuickHullAlg(S2, top, right, result);
    }
}



